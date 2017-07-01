package com.bafal.dev.patient.modele.base.enumeration;

public enum Dependance implements CodeEnum {

        ALCOOL("Alcool"),
        JEUX("Jeux"),
        DROGUE("Drogue");

    private final String nom;

    private Dependance(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
