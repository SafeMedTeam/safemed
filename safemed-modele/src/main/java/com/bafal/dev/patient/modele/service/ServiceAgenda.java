package com.bafal.dev.patient.modele.service;

import java.util.Date;
import java.util.List;

import com.bafal.dev.patient.modele.dto.PlageHoraireDto;
import com.bafal.dev.patient.modele.dto.RendezVousDto;

public interface ServiceAgenda {

	/**
	 * Retourne la liste des plages horaires deja prises
	 * @return la liste des plages horaires non disponibles
	 */ 
	List<PlageHoraireDto> getListePlagesHorairesNonDisponibles();

	List<PlageHoraireDto> getListePlagesHorairesDisponibles();

	List<PlageHoraireDto> getListePlagesHorairesDisponiblesParMedecin(String codeUtilisateur);

	List<RendezVousDto> getListeRVaVenirParMedecin(String codeUtilisateur);

	List<RendezVousDto> getListeRVduJour(Date dateDuJour);

	List<RendezVousDto> getListeRVduJourParMedecin(String codeUtilisateur, Date dateDuJour);

	void ajouterLotPlagesHoraires(List<PlageHoraireDto> plages);

	List<RendezVousDto> getListeRVaVenirParPatient(Long idDossierPatient);

	RendezVousDto getRv(Long id);

	RendezVousDto enregistrerRv(RendezVousDto dto);

}
