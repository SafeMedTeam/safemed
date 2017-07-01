package com.bafal.dev.patient.modele.base.enumeration;

public enum TypeAntecedent implements CodeEnum {

        PERSO("Personnel"),
        OBSTE("Obstétrical"),
        FAMIL("Familial"),
        CHIRU("Chirurgical");

    private final String nom;

    private TypeAntecedent(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
