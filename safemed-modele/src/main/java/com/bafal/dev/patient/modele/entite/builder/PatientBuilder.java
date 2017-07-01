package com.bafal.dev.patient.modele.entite.builder;

import java.util.Date;

import com.bafal.dev.patient.modele.entite.Patient;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static Patient build() {

        Patient patient = new Patient();

        patient.setDateCreation(new Date());
        patient.setActif(Boolean.TRUE);

        return patient;

    }
}
