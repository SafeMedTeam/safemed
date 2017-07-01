package com.bafal.dev.patient.modele.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ChangementMotDePasseDto {

	@NotEmpty
	private String motdePasseActuel;
	@NotEmpty
	private String nouveauMotdePasse;
	@NotEmpty
	private String confirmationMotdePasse;
	public String getMotdePasseActuel() {
		return motdePasseActuel;
	}
	public void setMotdePasseActuel(String motdePasseActuel) {
		this.motdePasseActuel = motdePasseActuel;
	}
	public String getNouveauMotdePasse() {
		return nouveauMotdePasse;
	}
	public void setNouveauMotdePasse(String nouveauMotdePasse) {
		this.nouveauMotdePasse = nouveauMotdePasse;
	}
	public String getConfirmationMotdePasse() {
		return confirmationMotdePasse;
	}
	public void setConfirmationMotdePasse(String confirmationMotdePasse) {
		this.confirmationMotdePasse = confirmationMotdePasse;
	}
	
	
}
