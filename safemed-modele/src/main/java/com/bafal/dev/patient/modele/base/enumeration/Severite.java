package com.bafal.dev.patient.modele.base.enumeration;

public enum Severite implements CodeEnum {

        MODERE("Modéré"),
        GRAVE("Grave"),
        AUTRE("Autre");

    private final String nom;

    private Severite(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
