package com.bafal.dev.patient.modele.base.enumeration;

public enum Frequence implements CodeEnum {

        REG("Régulier"),
        RAR("Rarement"),
        OCC("Occasionnel");

    private final String nom;

    private Frequence(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
