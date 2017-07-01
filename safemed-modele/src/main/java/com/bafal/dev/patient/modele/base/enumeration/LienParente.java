package com.bafal.dev.patient.modele.base.enumeration;

public enum LienParente implements CodeEnum {

        PERE("Père"),
        MERE("Mère"),
        FRERE("Frère"),
        SOEUR("Soeur"),
        CONJOINT("Conjoint(e)"),
        ENFANT("Enfant"),
        AUTRE("Autre");

    private final String nom;

    private LienParente(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
