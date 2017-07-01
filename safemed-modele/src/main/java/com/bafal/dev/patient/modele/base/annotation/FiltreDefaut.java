package com.bafal.dev.patient.modele.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bafal.dev.patient.modele.base.enumeration.Operateur;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FiltreDefaut {

    /**
     * Le nom de l'attribut de l'entité avec lequel on doit faire le parallèle avec
     * l'attribut annoté.
     * 
     * @return le nom de l'attribut de l'entité.
     */
    String field() default "";

    /**
     * Énumération qui permet de spécifier quel type d'opération poser en tant que
     * comportement par défaut.
     * 
     * @return Énumération qui permet de spécifier quel type d'opération poser en tant que
     *         comportement par défaut.
     */
    Operateur operateur() default Operateur.EQ;
}
