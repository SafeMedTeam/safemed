package com.bafal.dev.patient.modele.base.enumeration;

public enum TypeRendezVous implements CodeEnum {

	EXAMEN_ANNUEL("Examen annuel"),
	ACCIDENT_TR("Accident de travail"),
	CONSULT("Consultation"),
	CYTO("Cytologie"),
	DEPIST("Dépistatge"),
	RS_EXAMEN("Résultats d'examens"),
	SUIVI("Visite de suivi"),
	SUIVI_PEDI("Suivi pédiatrique"),
	VACCIN("Vaccination"),
	AUTRE("Autre");

    private final String nom;

    private TypeRendezVous(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
