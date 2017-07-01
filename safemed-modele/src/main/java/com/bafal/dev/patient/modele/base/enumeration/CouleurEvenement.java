package com.bafal.dev.patient.modele.base.enumeration;

public enum CouleurEvenement {

	GREEN("Vert", "#1ABB9C"),
	ORANGE("Orange", "#EE753F"),
	RED("Rouge", "#E74C3C"),
	PURPLE("Pourpe", "#9B59B6"),
	BLUE("Bleu", "#3498DB"),
	DARK("Foncé", "#34495E"),
	SKY_BLUE("Bleu ciel", "#50C1CF"),
	WHITE("Blanc", "#FFF");

	private String nom;

	private String code;

	private CouleurEvenement(String nom, String code) {
		this.nom = nom;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

}
