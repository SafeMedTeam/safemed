package com.bafal.dev.patient.modele.entite.builder;

import com.bafal.dev.patient.modele.entite.PersonneContact;

public class CorrespondantBuilder {

    private CorrespondantBuilder() {
    }

    public static PersonneContact build() {
        return new PersonneContact();

    }

}
