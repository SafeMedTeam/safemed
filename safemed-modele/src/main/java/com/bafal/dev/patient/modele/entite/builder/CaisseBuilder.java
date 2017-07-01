package com.bafal.dev.patient.modele.entite.builder;

import com.bafal.dev.patient.modele.entite.InfoSecuSociale;

public class CaisseBuilder {

    private CaisseBuilder() {
    }

    public static InfoSecuSociale build() {
        InfoSecuSociale caisse = new InfoSecuSociale();
        return caisse;
    }

}
