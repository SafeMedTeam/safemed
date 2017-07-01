package com.bafal.dev.patient.modele.dto;

import java.io.Serializable;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.Civilite;
import com.bafal.dev.patient.modele.base.util.DME;

public class UtilisateurJsonDto extends BaseDto implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fonction;

    private String prenom;

    private String nom;

    private Civilite civilite;

    Long idService;

	private String nomService;

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getNomComplet() {
		StringBuilder builder = new StringBuilder();
		if (DME.isNotNull(civilite)) {
			builder.append(civilite.getNom());
		}
		if (DME.isNotBlank(prenom)) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(prenom);
		}
		if (DME.isNotBlank(nom)) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(nom);
		}
		return builder.toString();
	}

}
