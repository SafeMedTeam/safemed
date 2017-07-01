package com.bafal.dev.patient.modele.entite.antecedent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ANTECEDENT_PERSONNEL")
@DiscriminatorValue(value = "PERSO")
public class AntecedentPersonnel extends Antecedent {

    /**
     * 
     */
    private static final long serialVersionUID = -6813277775825214240L;

}
