package com.bafal.dev.patient.modele.dto;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.Severite;


public class AllergieDto extends BaseDto {

    private String nomMedicamentOuProduit;

    private String typeReaction;

    private boolean effetImmediat;

    private boolean effetRetarde;

    private Severite severite;

    private String note;

	private Long idDossier;


    public String getNomMedicamentOuProduit() {
        return nomMedicamentOuProduit;
    }

    public void setNomMedicamentOuProduit(String nomMedicamentOuProduit) {
        this.nomMedicamentOuProduit = nomMedicamentOuProduit;
    }

    public String getTypeReaction() {
        return typeReaction;
    }

    public void setTypeReaction(String typeReaction) {
        this.typeReaction = typeReaction;
    }

    public boolean isEffetImmediat() {
        return effetImmediat;
    }

    public void setEffetImmediat(boolean effetImmediat) {
        this.effetImmediat = effetImmediat;
    }

    public boolean isEffetRetarde() {
        return effetRetarde;
    }

    public void setEffetRetarde(boolean effetRetarde) {
        this.effetRetarde = effetRetarde;
    }

    public Severite getSeverite() {
        return severite;
    }

    public void setSeverite(Severite severite) {
        this.severite = severite;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}



}
