package com.bafal.dev.patient.modele.base.enumeration;

public enum Civilite implements CodeEnum {

        MR("Mr"),
        MME("Mme");

    private final String nom;

    private Civilite(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
