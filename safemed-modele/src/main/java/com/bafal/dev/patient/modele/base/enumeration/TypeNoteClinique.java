package com.bafal.dev.patient.modele.base.enumeration;

public enum TypeNoteClinique implements CodeEnum {

        URGENCE("Urgence"),
        CONSULTATION("Consultation"),
        HOSPITALISATION("Hospitalisation"),
        AUTRE("Autre");

    private final String nom;

    private TypeNoteClinique(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
