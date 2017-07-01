package com.bafal.dev.patient.modele.base.enumeration;

public enum StatutMatrimonial implements CodeEnum {

        CLB("Célibataire"),
        MAR("Marié(e)"),
        DVC("Divorcé(e)"),
        VOF("Voeuf / Voeuve"),
        CDF("Conjoint(e) de fait");

    private final String nom;

    private StatutMatrimonial(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
