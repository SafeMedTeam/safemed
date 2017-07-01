package com.bafal.dev.patient.modele.base.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.Validate;
import org.hibernate.AnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.bafal.dev.patient.modele.base.annotation.FiltreBetweenDebut;
import com.bafal.dev.patient.modele.base.annotation.FiltreBetweenFin;
import com.bafal.dev.patient.modele.base.annotation.FiltreDefaut;
import com.bafal.dev.patient.modele.base.annotation.FiltreLike;
import com.bafal.dev.patient.modele.base.annotation.Wildcard;
import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.Operateur;
import com.bafal.dev.patient.modele.base.filtre.BaseFiltre;

public class SpecificationCritereBuilder<T extends BaseEntite> {

    private Logger LOG = LoggerFactory.getLogger(SpecificationCritereBuilder.class);

    private static final String WILDCARD = "%";

    public SpecificationCritereBuilder() {
    }

    /**
     * WHERE CLAUSE générique pour effectuer une recherche par filtre dans la base. Le
     * filtre doit etendre la classe {@link BaseFiltre}
     * 
     * @param filtre Le filtre
     * @return la spécification de la clause where
     */
    public Specification<T> whereClause(BaseFiltre filtre) {
        return new Specification<T>() {

            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Field[] fields = ReflectUtils.getAllFields(filtre.getClass());
                Predicate predicat = null;
                try {
                    for (int i = 0; i < fields.length; i++) {
                        Field field = fields[i];
                        if (field.isAnnotationPresent(FiltreDefaut.class)) {

                            predicat = appliquerFiltreDefaut(predicat, field, filtre, root, cb);

                        } else if (field.isAnnotationPresent(FiltreLike.class)) {

                            predicat = appliquerFiltreLike(predicat, field, filtre, root, cb);

                        } else if (field.isAnnotationPresent(FiltreBetweenDebut.class)) {

                            predicat = appliquerFiltreBetweenDebut(predicat, field, filtre, root, cb);
                        }
                    }
                } catch (IllegalAccessException e) {
                    LOG.error(e.getMessage(), e);
                }
                return predicat;
            }

        };

    }

    /**
     * Ajoute un and Predicate au prédicat
     * 
     * @param cb le critereBuilder
     * @param predicat le predicat
     * @param autrePredicat l'autre prédicat
     * @return le prédicat qui en découle
     */
    private Predicate addPredicat(CriteriaBuilder cb, Predicate predicat, Predicate autrePredicat) {
        return predicat == null ? autrePredicat : cb.and(predicat, autrePredicat);
    }

    /**
     * Filtre à appliquer aux champs avec l'annotation {@link FiltreDefaut}
     * <p>
     * Applique le filtre par défaut
     * 
     * @param predicat le prédicat
     * @param field le champ à filtrer lors de la recherche
     * @param filtre le filtre de recherche
     * @param root l'entite root
     * @param cb le critere builders
     * @return le prédicat qui en découle
     * @throws IllegalAccessException
     */
    private Predicate appliquerFiltreDefaut(Predicate predicat, Field field, BaseFiltre filtre, Root<T> root,
        CriteriaBuilder cb) throws IllegalAccessException {
        FiltreDefaut filtreDefaut = field.getAnnotation(FiltreDefaut.class);
        Object value = ReflectUtils.getFieldValue(field, filtre);

        if (value != null) {

            String nomField = DME.isEmpty(filtreDefaut.field()) ? field.getName() : filtreDefaut.field();

            if (value instanceof List && DME.isNotEmpty((List<?>) value)) {
                predicat = addPredicat(cb, predicat, root.get(nomField).in(value));
                if (Operateur.NE.equals(filtreDefaut.operateur())) {
                    predicat = addPredicat(cb, predicat, cb.not(root.get(nomField).in(value)));
                }
            } else if (value instanceof String) {
                if (DME.isNotBlank((String) value)) {
                    value = appliquerWildcard(field, filtre);
                    predicat =
                        addPredicat(cb, predicat, appliquerPredicat(root, cb, nomField, value, filtreDefaut.operateur()));
                }
            } else {
                predicat =
                    addPredicat(cb, predicat, appliquerPredicat(root, cb, nomField, value, filtreDefaut.operateur()));
            }

        }

        return predicat;
    }

    /**
     * Filtre à appliquer aux champs avec l'annotation {@link FiltreBetweenDebut}
     * <p>
     * Applique le filtre Between Debut et Fin
     * 
     * @param predicat le predicat
     * @param fieldDebut
     * @param filtre
     * @param root
     * @param cb
     * @return
     * @throws IllegalAccessException
     */
    private Predicate appliquerFiltreBetweenDebut(Predicate predicat, Field fieldDebut, BaseFiltre filtre,
        Root<T> root, CriteriaBuilder cb) throws IllegalAccessException {
        Field fieldFin = null;
        FiltreBetweenDebut betweenDebut = fieldDebut.getAnnotation(FiltreBetweenDebut.class);

        Field[] fields = ReflectUtils.getAllFields(filtre.getClass());
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (field.isAnnotationPresent(FiltreBetweenFin.class)) {
                FiltreBetweenFin betweenFin = field.getAnnotation(FiltreBetweenFin.class);
                if (betweenDebut.fieldDebut().equals(betweenFin.fieldFin())) {
                    fieldFin = field;
                    break;
                }
            }
        }

        if (fieldFin == null) {
            throw new AnnotationException("Annotation BetweenDebut sans annotation BetweenFin");
        }

        Object begin = ReflectUtils.getFieldValue(fieldDebut, filtre);
        Object end = ReflectUtils.getFieldValue(fieldFin, filtre);
        if (begin != null && end == null) {
            predicat =
                addPredicat(cb, predicat, appliquerPredicat(root, cb, betweenDebut.fieldDebut(), begin, Operateur.GE));
        } else if (begin == null && end != null) {
            predicat =
                addPredicat(cb, predicat, appliquerPredicat(root, cb, betweenDebut.fieldDebut(), end, Operateur.LE));
        } else if (begin != null && end != null) {
            cb.between(root.get(betweenDebut.fieldDebut()), (Date) begin, (Date) end);
            predicat =
                addPredicat(cb, predicat, cb.between(root.get(betweenDebut.fieldDebut()), (Date) begin, (Date) end));
        }
        return predicat;
    }

    /**
     * Filtre à appliquer aux champs avec l'annotation {@link FiltreLike}
     * <p>
     * Applique le filtre "Like" dans un champ de type {@link String}
     * 
     * @param predicat le predicat à retourner
     * @param field le champ à filtrer
     * @param filtre le filtre de recherche
     * @param root l'entité root
     * @param cb le critere builder
     * @return le predicat
     * @throws IllegalAccessException
     */
    private Predicate appliquerFiltreLike(Predicate predicat, Field field, BaseFiltre filtre, Root<T> root,
        CriteriaBuilder cb) throws IllegalAccessException {
        FiltreLike stringLike = field.getAnnotation(FiltreLike.class);

        Object value = ReflectUtils.getFieldValue(field, filtre);
        if (DME.isNotEmpty(value)) {

            value = appliquerWildcard(field, filtre);
            String nomField = DME.isBlank(stringLike.field()) ? field.getName() : stringLike.field();

            switch (stringLike.stringComparaisonType()) {
            case EQ:
                predicat = addPredicat(cb, predicat, appliquerPredicat(root, cb, nomField, value, Operateur.EQ));
                break;
            case LIKE:
                predicat = addPredicat(cb, predicat, appliquerPredicat(root, cb, nomField, value, Operateur.LIKE));
                break;
            default:
                predicat = addPredicat(cb, predicat, appliquerPredicat(root, cb, nomField, value, Operateur.EQ));
            }

        }

        return predicat;
    }

    /**
     * Permet d'appliquer un prédicat en fonction de l'operateur en parametres
     * 
     * @param root l'entité root
     * @param cb le critere Builder
     * @param nomField le nom du champ à filtrer
     * @param valeurField la valeur du champ
     * @param operator l'opérateur du prédicat
     * @return
     */
    private Predicate appliquerPredicat(Root<T> root, CriteriaBuilder cb, String nomField, Object valeurField,
        Operateur operator) {
        switch (operator) {
        case LT:
            return cb.lt(root.get(nomField), (Number) valeurField);
        case LE:
            return cb.le(root.get(nomField), (Number) valeurField);
        case EQ:
            return cb.equal(root.get(nomField), valeurField);
        case GE:
            return cb.ge(root.get(nomField), (Number) valeurField);
        case GT:
            return cb.gt(root.get(nomField), (Number) valeurField);
        case NE:
            return cb.notEqual(root.get(nomField), valeurField);
        case LIKE:
            return cb.like(root.get(nomField), (String) valeurField);
        default:
            break;
        }
        return null;
    }

    /**
     * Permet d'appliquer le wildcard % % sur le champs de recherche
     * 
     * @param field le champs à filtrer lors de la recherche
     * @param filtre le filtre de recherche
     * @return le champs avec les wildcards ajoutés
     * @throws IllegalAccessException
     */
    public String appliquerWildcard(Field field, BaseFiltre filtre) throws IllegalAccessException {
        Object valeurField = ReflectUtils.getFieldValue(field, filtre);
        String valeurToString = (String) valeurField;

        if (field.isAnnotationPresent(Wildcard.class)) {
            Validate.isInstanceOf(String.class, valeurField,
                "L'annotation Wildcard ne peut être configurer que sur des champs de type String.");

            if (DME.isNotEmpty(valeurField)) {
                Wildcard annotation = field.getAnnotation(Wildcard.class);
                switch (annotation.location()) {
                case DEBUT:
                    valeurToString = WILDCARD + valeurToString;
                    break;
                case DEBUT_FIN:
                    valeurToString = WILDCARD + valeurToString + WILDCARD;
                    break;
                case FIN:
                    valeurToString = valeurToString + WILDCARD;
                    break;
                default:
                }
            }
        }

        return valeurToString;
    }
}
