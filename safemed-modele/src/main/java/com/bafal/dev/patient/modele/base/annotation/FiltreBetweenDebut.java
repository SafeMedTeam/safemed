package com.bafal.dev.patient.modele.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FiltreBetweenDebut {

    /**
     * le nom de l'attribut de l'entité qui représente la borne de début de l'intervalle
     * de recherche.
     * 
     * @return le nom de l'attribut de l'entité qui représente la borne de début de
     *         l'intervalle de recherche.
     */
    String fieldDebut();

}
