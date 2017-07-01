package com.bafal.dev.patient.modele.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.bafal.dev.patient.modele.base.enumeration.StringTypeComparaison;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FiltreLike {

    String field();

    StringTypeComparaison stringComparaisonType();

}
