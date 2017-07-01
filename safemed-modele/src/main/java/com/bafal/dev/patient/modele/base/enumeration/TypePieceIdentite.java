package com.bafal.dev.patient.modele.base.enumeration;

public enum TypePieceIdentite implements CodeEnum {

        ADN("Acte de naissance"),
        PRT("Passeport"),
        CIN("Carte d'identité nationale"),
        CAM("Carte d'assurance maladie"),
        PCN("Permis de conduire");

    private final String nom;

    private TypePieceIdentite(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
