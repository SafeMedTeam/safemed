package com.bafal.dev.patient.modele.base.enumeration;

public enum StatutRV implements CodeEnum {

	PLANIFIE("Planifié"),
	SALLE_ATTENTE("En salle d'attente"),
	EN_CONSULT("En Consultation"),
	VU("Vu"),
	ANNULE("Annulé"),
	ABS_EXCUSE("Absence excusée"),
	ABS_NON_EXCUSE("Absence non excusée");

    private final String nom;

    private StatutRV(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
