package com.bafal.dev.patient.modele.base.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.AnnotationException;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.bafal.dev.patient.modele.base.annotation.FiltreBetween;
import com.bafal.dev.patient.modele.base.annotation.FiltreBetweenDebut;
import com.bafal.dev.patient.modele.base.annotation.FiltreBetweenFin;
import com.bafal.dev.patient.modele.base.annotation.FiltreDefaut;
import com.bafal.dev.patient.modele.base.annotation.FiltreLike;
import com.bafal.dev.patient.modele.base.annotation.Jointure;
import com.bafal.dev.patient.modele.base.annotation.Wildcard;
import com.bafal.dev.patient.modele.base.enumeration.Operateur;
import com.bafal.dev.patient.modele.base.filtre.BaseFiltre;

public class CritereBuilder {

    // example : CritereBuilder.getCriteria(DetachedCriteria.forClass(classe), filtre);
    private static final String WILDCARD = "%";

    public CritereBuilder() {
        // TODO Auto-generated constructor stub
    }

    public static DetachedCriteria getCriteria(DetachedCriteria criteria, BaseFiltre filtre)
        throws IllegalArgumentException, IllegalAccessException {

        if (filtre != null) {
            appliquerFiltre(criteria, filtre);
        }

        return criteria;
    }

    private static void appliquerFiltre(DetachedCriteria criteria, BaseFiltre filtre) throws IllegalAccessException {

        Field[] fields = ReflectUtils.getAllFields(filtre.getClass());
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(FiltreDefaut.class)) {
                appliquerFiltreDefaut(criteria, field, filtre);
            } else if (field.isAnnotationPresent(FiltreLike.class)) {
                appliquerFiltreLike(criteria, field, filtre);
            } else if (field.isAnnotationPresent(FiltreBetweenDebut.class)) {
                appliquerFiltreBetweenDebut(criteria, field, filtre);
            } else if (field.isAnnotationPresent(FiltreBetween.class)) {
                appliquerFiltreBetween(criteria, field, filtre);
            }
        }

    }

    private static void appliquerFiltreBetweenDebut(DetachedCriteria criteria, Field fieldBegin, BaseFiltre filtre)
        throws IllegalAccessException {
        Field fieldEnd = null;
        FiltreBetweenDebut betweenBegin = fieldBegin.getAnnotation(FiltreBetweenDebut.class);

        // On trouve le betweenEnd qui fit avec le betweenbegin passee en parametre dans
        // les fields.
        Field[] fields = ReflectUtils.getAllFields(filtre.getClass());
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(FiltreBetweenFin.class)) {
                FiltreBetweenFin betweenEnd = field.getAnnotation(FiltreBetweenFin.class);
                if (betweenBegin.fieldDebut().equals(betweenEnd.fieldFin())) {
                    fieldEnd = field;
                    break;
                }
            }
        }

        if (fieldEnd == null)
            throw new AnnotationException("Annotation BetweenBegin sans annotation BetweenEnd");

        Object begin = ReflectUtils.getFieldValue(fieldBegin, filtre);
        Object end = ReflectUtils.getFieldValue(fieldEnd, filtre);

        if (begin != null && end == null) {
            criteria.add(Restrictions.ge(betweenBegin.fieldDebut(), begin));
        } else if (begin == null && end != null) {
            criteria.add(Restrictions.le(betweenBegin.fieldDebut(), end));
        } else if (begin != null && end != null) {
            criteria.add(Restrictions.between(betweenBegin.fieldDebut(), begin, end));
        }
    }

    // @Between(beginField = "dateDebut", endField = "dateFin")
    private static void appliquerFiltreBetween(DetachedCriteria criteria, Field field, BaseFiltre filtre)
        throws IllegalAccessException {
        Object fieldValue = ReflectUtils.getFieldValue(field, filtre);

        if (fieldValue != null) {
            FiltreBetween annotation = field.getAnnotation(FiltreBetween.class);
            criteria.add(Restrictions.le(annotation.fieldDebut(), fieldValue));
            criteria.add(Restrictions.or(Restrictions.isNull(annotation.fieldDebut()),
                Restrictions.ge(annotation.fieldFin(), fieldValue)));
        }

    }

    private static void appliquerFiltreLike(DetachedCriteria criteria, Field field, BaseFiltre filtre)
        throws IllegalAccessException {
        FiltreLike stringLike = field.getAnnotation(FiltreLike.class);

        Object value = ReflectUtils.getFieldValue(field, filtre);
        if (value != null && !StringUtils.isBlank((String) value)) {

            value = applyWildcard(field, filtre);
            String nomField = StringUtils.isBlank(stringLike.field()) ? field.getName() : stringLike.field();

            // on applique le type de comparaison
            switch (stringLike.stringComparaisonType()) {
            case EQ:
                criteria.add(Restrictions.eq(nomField, value));
                break;
            case LIKE:
                criteria.add(Restrictions.like(nomField, value));
                break;
            default:
                criteria.add(Restrictions.eq(nomField, value));
            }

        }
    }

    private static void appliquerFiltreDefaut(DetachedCriteria criteria, Field field, BaseFiltre filtre)
        throws HibernateException, IllegalAccessException {
        FiltreDefaut filtreDefaut = field.getAnnotation(FiltreDefaut.class);
        Object value = ReflectUtils.getFieldValue(field, filtre);

        if (value != null) {

            Criterion criterion = null;
            String nomField = StringUtils.isBlank(filtreDefaut.field()) ? field.getName() : filtreDefaut.field();

            if (value instanceof List && !((List<?>) value).isEmpty()) {
                criterion = Restrictions.in(nomField, ((List<?>) value).toArray());
                if ((Operateur.NE).equals(filtreDefaut.operateur())) {
                    criterion = Restrictions.not(criterion);
                }
            } else if (value instanceof BaseFiltre) {
                if (field.isAnnotationPresent(Jointure.class)) {
                    Jointure joinType = field.getAnnotation(Jointure.class);
                    // example : @JoinType(type = CriteriaSpecification.LEFT_JOIN)
                    appliquerFiltre(criteria.createCriteria(nomField, joinType.type()), (BaseFiltre) value);
                } else {
                    appliquerFiltre(criteria.createCriteria(nomField), (BaseFiltre) value);
                }
            } else if (value instanceof Date) {
                value = ReflectUtils.getFieldValue(field, filtre);
                criterion = appliquerOperator(nomField, value, filtreDefaut.operateur());
            } else if (value instanceof String) {
                if (!StringUtils.isBlank((String) value)) {
                    value = applyWildcard(field, filtre);
                    criterion = appliquerOperator(nomField, value, filtreDefaut.operateur());
                }
            } else {
                criterion = appliquerOperator(nomField, value, filtreDefaut.operateur());
            }

            criteria.add(criterion);

        }
    }

    private static Criterion appliquerOperator(String nomField, Object value, Operateur operator) {
        switch (operator) {
        case LT:
            return Restrictions.lt(nomField, value);
        case LE:
            return Restrictions.le(nomField, value);
        case EQ:
            return Restrictions.eq(nomField, value);
        case IEQ:
            return Restrictions.eq(nomField, value).ignoreCase();
        case GE:
            return Restrictions.ge(nomField, value);
        case GT:
            return Restrictions.gt(nomField, value);
        case NE:
            return Restrictions.ne(nomField, value);
        default:
            break;
        }
        return null;
    }

    public static String applyWildcard(Field field, BaseFiltre filter) throws IllegalAccessException {
        Object value = ReflectUtils.getFieldValue(field, filter);
        String stringValue = (String) value;

        if (field.isAnnotationPresent(Wildcard.class)) {
            Validate.isInstanceOf(String.class, value,
                "L'annotation Wildcard ne peut être configurer que sur des champs de type String.");

            if (value != null) {
                Wildcard annotation = field.getAnnotation(Wildcard.class);
                switch (annotation.location()) {
                case DEBUT:
                    stringValue = WILDCARD + stringValue;
                    break;
                case DEBUT_FIN:
                    stringValue = WILDCARD + stringValue + WILDCARD;
                    break;
                case FIN:
                    stringValue = stringValue + WILDCARD;
                    break;
                default:
                }
            }
        }

        return stringValue;
    }

}
