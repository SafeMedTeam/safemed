package com.bafal.dev.patient.modele.entite.antecedent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ANTECEDENT_FAMILIAL")
@DiscriminatorValue(value = "FAMIL")
public class AntecedentFamilial extends Antecedent {

    /**
     * 
     */
    private static final long serialVersionUID = 199267330260274931L;

}
