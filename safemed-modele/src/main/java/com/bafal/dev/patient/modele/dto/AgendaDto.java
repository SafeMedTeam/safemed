package com.bafal.dev.patient.modele.dto;

import java.util.List;

import com.bafal.dev.patient.modele.base.dto.BaseDto;


public class AgendaDto extends BaseDto {




	private String nom;



	private UtilisateurDto utilisateur;

	private List<PlageHoraireDto> plagesHoraires;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public UtilisateurDto getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(UtilisateurDto utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<PlageHoraireDto> getPlagesHoraires() {
		return plagesHoraires;
	}

	public void setPlagesHoraires(List<PlageHoraireDto> plagesHoraires) {
		this.plagesHoraires = plagesHoraires;
	}



}
