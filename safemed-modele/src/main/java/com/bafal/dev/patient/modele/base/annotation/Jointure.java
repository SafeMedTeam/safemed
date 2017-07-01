package com.bafal.dev.patient.modele.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.sql.JoinType;

/**
 * Lorsque'un sous objet (de type RsipaFilter) fait partit du filtre de recherche, il est
 * possible de spécifié la relation qui sera fait avec la table en lien avec cet objet.
 * Par defaut un inner join est fait. Le type doit provenir CriteriaSpecification.
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Jointure {

    /**
     * Value qui provient de l'interface CriteriaSpecification
     * 
     * @return Le int qui represente la bonne jonction.
     */
    JoinType type();
}
