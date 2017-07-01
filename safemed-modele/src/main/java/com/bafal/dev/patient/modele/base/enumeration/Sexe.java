package com.bafal.dev.patient.modele.base.enumeration;

public enum Sexe implements CodeEnum {

        M("Masculin"),
        F("Féminin");

    private final String nom;

    private Sexe(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
