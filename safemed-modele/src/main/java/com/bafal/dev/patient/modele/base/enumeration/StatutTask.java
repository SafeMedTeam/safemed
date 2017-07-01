package com.bafal.dev.patient.modele.base.enumeration;

public enum StatutTask implements CodeEnum {

	PAS_COMMENCE("Pas Commencée"),
	EN_COURS("En Cours"),
	ATTENTE_QLQUN("En attente de quelqu'un d'autre"),
	REPORTE("Reportée"),
	COMPLET("Completée");

    private final String nom;

    private StatutTask(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
