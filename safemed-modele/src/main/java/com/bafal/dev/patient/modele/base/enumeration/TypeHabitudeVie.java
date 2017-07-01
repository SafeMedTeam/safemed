package com.bafal.dev.patient.modele.base.enumeration;

public enum TypeHabitudeVie implements CodeEnum {

        TABAC("Tabac"),
        ALCOOL("En traitement"),
        DEPENDANCE("Dépendance"),
        ALIMENTATION("Alimentation");

    private final String nom;

    private TypeHabitudeVie(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
