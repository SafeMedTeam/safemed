package com.bafal.dev.patient.modele.entite.antecedent;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ANTECEDENT_CHIRURGICAL")
@DiscriminatorValue(value = "CHIRU")
public class AntecedentChirurgical extends Antecedent {

    /**
     * 
     */
    private static final long serialVersionUID = 1579702894991712196L;

}
