package com.bafal.dev.patient.modele.dto;

import javax.validation.constraints.Pattern;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.util.DmeConstante;

public class ResetMotDePasseDto extends BaseDto {

	@Pattern(regexp = EMAIL_REGEX, message = DmeConstante.MSG_FORMAT_COURRIEL)
	private String courriel;

	@Pattern(regexp = EMAIL_REGEX, message = DmeConstante.MSG_FORMAT_COURRIEL)
	private String confirmation;

	private String nouveauMotDePasse;

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getNouveauMotDePasse() {
		return nouveauMotDePasse;
	}

	public void setNouveauMotDePasse(String nouveauMotDePasse) {
		this.nouveauMotDePasse = nouveauMotDePasse;
	}

}
