package com.bafal.dev.patient.modele.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bafal.dev.patient.modele.base.enumeration.WildcardLocation;

/**
 * Annotation permettant de manipuler une valeur de type String afin d'y ajouter une ou
 * plusieurs Wildcard.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Wildcard {

    /**
	 * Le type de Wildcard à appliquer sur la valeur.
	 * <p>
	 * 
	 */
    WildcardLocation location() default WildcardLocation.AUCUN;
}
