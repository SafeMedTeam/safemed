package com.bafal.dev.patient.modele.base.enumeration;

public enum TypeChirurgie implements CodeEnum {

        APPE("Appendicite"),
        VBIL("Vésicule biliaire"),
        AUTR("Autre");

    private final String nom;

    private TypeChirurgie(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
