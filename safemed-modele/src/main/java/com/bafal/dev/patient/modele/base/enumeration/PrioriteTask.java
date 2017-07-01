package com.bafal.dev.patient.modele.base.enumeration;

public enum PrioriteTask implements CodeEnum {

	BAS("Bas"), NORMAL("Normal"), HAUT("Haute importante");

    private final String nom;

    private PrioriteTask(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
