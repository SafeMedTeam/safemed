package com.bafal.dev.patient.modele.base.enumeration;

public enum StatutTraitement implements CodeEnum {

        TRAITE("Traité"),
        EN_TRAITEMENT("En traitement"),
        SANS_RESULTAT("Sans Résultat"),
        AUTRE("Autre");

    private final String nom;

    private StatutTraitement(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
