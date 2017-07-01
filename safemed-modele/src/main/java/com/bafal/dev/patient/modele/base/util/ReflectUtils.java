package com.bafal.dev.patient.modele.base.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Classe qui offre des facilite pour l utilisation du package Reflect de java.
 * 
 */
public abstract class ReflectUtils {

    public static Object getFieldValue(Field field, Object objet) throws IllegalAccessException {
        field.setAccessible(true);
        return field.get(objet);
    }

    public static Object getFieldValue(String fieldName, Object objet) throws IllegalAccessException,
        NoSuchFieldException {
        Field field = getField(fieldName, objet.getClass());

        field.setAccessible(true);
        return field.get(objet);
    }

    /**
     * Méthode qui permet de modifier une valeur d'un champ d'une objet peut importe que
     * ce champ soit dans une super classe ou non.
     * 
     * @param fieldName le nom de l'attribut à récupérer.
     * @param clazz la classe qui contient l'attribut en question.
     * @return l'objet Field récupérer de la classe passée en paramètre.
     */
    public static void setFieldValue(String fieldName, Object objet, Object value) throws IllegalArgumentException,
        IllegalAccessException {
        Field field = getField(fieldName, objet.getClass());
        field.setAccessible(true);
        field.set(objet, value);
    }

    /**
     * Méthode qui permet de retourner la liste de tous les champs déclarés dans un objet
     * et dans tous ses parents jusqu'à la classe Object.
     * 
     * @param clazz la classe pour lequel on récupère les objets {@link Field}.
     * @return un tableau de tous les {@link Field} déclarés dans la hiérarchie de l'objet
     *         passé en paramètre.
     */
    public static Field[] getAllFields(Class<?> clazz) {
        List<Field> list = new ArrayList<Field>();
        getAllFields(clazz, list);
        return list.toArray(new Field[list.size()]);
    }

    /**
     * Méthode qui permet de retourner la liste de toutes les {@link Annotation} déclarés
     * dans un objet et dans tous ses parents jusqu'à la classe Object.
     * 
     * @param clazz la classe pour lequel on récupère les objets {@link Annotation}.
     * @return un tableau de tous les {@link Annotation} déclarés dans la hiérarchie de
     *         l'objet passé en paramètre.
     */
    public static Annotation[] getAllAnnotations(Class<?> clazz) {
        List<Annotation> list = new ArrayList<Annotation>();
        getAllAnnotations(clazz, list);
        return list.toArray(new Annotation[list.size()]);
    }

    /**
     * Méthode récursive utilisée pour populer une liste avec tous les attributs d'une
     * classe.
     * 
     * @param clazz la classe pour lequel on récupère les objets {@link Field}.
     * @param list une liste de tous les {@link Field} déclarés dans la hiérarchie de
     *            l'objet passé en paramètre.
     */
    private static void getAllFields(Class<?> clazz, List<Field> list) {
        list.addAll(Arrays.asList(clazz.getDeclaredFields()));
        if (!clazz.getSuperclass().equals(Object.class)) {
            getAllFields(clazz.getSuperclass(), list);
        }
    }

    /**
     * Méthode qui permet de récupérer toutes les annotations qui sont déclarées sur une
     * classe en particulier.
     * <p>
     * Cette méthode est récursive et navigue dans l'héritage de la classe afin de
     * récupérer les annotations.
     * 
     * @param clazz la classe pour lequel on récupère la hiérarchie d'annotations.
     * @return une {@link List} de toutes les annotations que possède la classe passée en
     *         paramètre.
     */
    private static List<Annotation> getAllAnnotations(Class<?> clazz, List<Annotation> list) {
        if (!ArrayUtils.isEmpty(clazz.getAnnotations())) {
            list.addAll(Arrays.asList(clazz.getAnnotations()));
        }
        if (!clazz.getSuperclass().equals(Object.class)) {
            getAllAnnotations(clazz.getSuperclass(), list);
        }
        return list;
    }

    /**
     * Méthode qui permet de récupérer un objet {@link Field} d'une classe peut importe
     * que ce champ soit dans une super classe ou non.
     * 
     * @param fieldName le nom de l'attribut à récupérer.
     * @param clazz la classe qui contient l'attribut en question.
     * @return l'objet Field récupérer de la classe passée en paramètre.
     */
    public static Field getField(String fieldName, Class<?> clazz) {
        Field result = null;
        Field[] fields = getAllFields(clazz);

        for (Field field : fields) {
            if (field.getName().equals(fieldName)) {
                result = field;
                break;
            }
        }
        return result;
    }

    /**
     * Méthode qui permet de retourner la liste de tous les champs déclarés dans une class
     * <code>classObjet</code> et dans tous ses parents jusqu'à la classe Object du type
     * <code>classField</code>.
     * 
     * @param classObjet la classe pour lequel on récupère les champs.
     * @param classField classe des champs
     * @return une liste de tous les {@link Field} déclarés dans la hiérarchie de la
     *         classe <code>classObjet</code> du type <code>classField</code>.
     */
    public static List<Field> getAllFields(Class<?> classObjet, Class<?> classField) {
        List<Field> ret = new ArrayList<Field>();
        Field[] fields = getAllFields(classObjet);
        for (Field field : fields) {
            if (classField.isAssignableFrom(field.getType())) {
                ret.add(field);
            }
        }
        return ret;
    }

    /**
     * Retourne les propriétés de la hiérarchie de la classe en paramètre étant annotées
     * avec l'annotation passée en paramètre.
     * 
     * @param clazz une classe.
     * @param annotation une annotation.
     * @return un tableau de {@link Field}.
     */
    public static Field[] getFields(Class<?> clazz, Class<? extends Annotation> annotation) {
        List<Field> fields = new ArrayList<Field>();
        Class<?> currentClass = clazz;
        while (currentClass != null && !currentClass.equals(Object.class)) {
            for (Field field : currentClass.getDeclaredFields()) {
                if (field.isAnnotationPresent(annotation) && !fields.contains(field)) {
                    fields.add(field);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return fields.toArray(new Field[fields.size()]);
    }

    /**
     * Permet d'obtenir le nom d'un getter à partir du nom d'une propriété.
     * 
     * @param propertyName
     * @return
     */
    public static String fieldToGetterName(String propertyName) {
        return "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
    }

    /**
     * Methode qui valide l 'attribut isprimitive de la classe et qui s assure que l'objet
     * n est pas un objet qui wrap un primitif.
     * 
     * @param clazz La classe a analyser
     * @return true si la class est primitive ou est un wrapper de primitif
     */
    public static boolean isPrimitive(Class<?> clazz) {
        Class<?> primitifWraper[] =
            { Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class,
                Double.class, Void.class, String.class, Date.class, Timestamp.class };

        return clazz.isPrimitive() || Arrays.asList(primitifWraper).indexOf(clazz) != -1;
    }
}
