package com.bafal.dev.patient.modele.entite.antecedent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ANTECEDENT_OBSTETRICAL")
@DiscriminatorValue(value = "OBSTE")
public class AntecedentObstetrical extends Antecedent {

    /**
     * 
     */
    private static final long serialVersionUID = 1260283846036527154L;

}
