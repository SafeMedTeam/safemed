package com.bafal.dev.patient.modele.base.enumeration;

public enum StatutNote implements CodeEnum {

        A_COMPLETER("A compléter"),
        TERMINEE("Terminée"),
	EN_COURS("En Redaction"),
        ANNULEE("Annulée");

    private final String nom;

    private StatutNote(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
