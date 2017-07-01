package com.bafal.dev.patient.modele.base.enumeration;

public enum StatutPlageHoraire implements CodeEnum {

	DISPO("Disponible", "dispoForRv", "#8fdf82"),
	FERIE("Jour férié", "jourFerie", "#ff9f89"),
	VAC("Vacances", "jourDeVacances", "#ff9f89"),
	AUTRE("Autre raison", "autreR", "#ff9f89");

    private final String nom;

	private final String contrainteId;

	private final String couleur;

	private StatutPlageHoraire(String nom, String contrainteId, String couleur) {
        this.nom = nom;
        this.contrainteId = contrainteId;
        this.couleur = couleur;
    }

    @Override
    public String getNom() {
        return nom;
    }

	public String getContrainteId() {
		return contrainteId;
	}

	public String getCouleur() {
		return couleur;
	}

}
