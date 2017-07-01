package com.bafal.dev.patient.modele.base.enumeration;

public enum UniteTemperature implements CodeEnum {

        C("C"),
        F("F");

    private final String nom;

    private UniteTemperature(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
