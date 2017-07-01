package com.bafal.dev.patient.modele.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bafal.dev.patient.modele.base.enumeration.StatutPlageHoraire;
import com.bafal.dev.patient.modele.converter.PlageHoraireConverter;
import com.bafal.dev.patient.modele.converter.RendezVousConverter;
import com.bafal.dev.patient.modele.dao.PlageHoraireDao;
import com.bafal.dev.patient.modele.dao.RendezVousDao;
import com.bafal.dev.patient.modele.dto.PlageHoraireDto;
import com.bafal.dev.patient.modele.dto.RendezVousDto;
import com.bafal.dev.patient.modele.service.ServiceAgenda;

@Service
public class ServiceAgendaImpl implements ServiceAgenda {

	@Autowired
	private PlageHoraireDao daoPlage;
	
	@Autowired
	private RendezVousDao daoRv;

	@Override
	public List<PlageHoraireDto> getListePlagesHorairesNonDisponibles() {
		return PlageHoraireConverter.toDtos(daoPlage.findByStatut(StatutPlageHoraire.VAC));
	}

	@Override
	public List<PlageHoraireDto> getListePlagesHorairesDisponibles() {
		return PlageHoraireConverter.toDtos(daoPlage.findByStatut(StatutPlageHoraire.DISPO));
	}

	@Override
	public List<PlageHoraireDto> getListePlagesHorairesDisponiblesParMedecin(String codeUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RendezVousDto> getListeRVaVenirParMedecin(String codeUtilisateur) {
		return null;// RendezVousConverter.toDtos(daoRv.findByPlageIdPersonnel());
	}

	@Override
	public List<RendezVousDto> getListeRVduJour(Date dateDuJour) {
		// return
		// RendezVousConverter.toDtos(daoRv.findByPlageDateDebutBetween(DME.getDateJour00h00(dateDuJour),
		// DME.getDateJour23h59(dateDuJour)));
		return null;
	}

	@Override
	public List<RendezVousDto> getListeRVduJourParMedecin(String codeUtilisateur, Date dateDuJour) {
		return null;
	}

	@Override
	public void ajouterLotPlagesHoraires(List<PlageHoraireDto> plages) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RendezVousDto> getListeRVaVenirParPatient(Long idDossierPatient) {
		return null;// RendezVousConverter.toDtos(daoRv.findByIdDossier(idDossierPatient));
	}

	@Override
	public RendezVousDto getRv(Long id) {
		return RendezVousConverter.toDto(daoRv.findOne(id));
	}

	@Override
	public RendezVousDto enregistrerRv(RendezVousDto dto) {
		return RendezVousConverter.toDto(daoRv.save(RendezVousConverter.fromDto(dto)));
	}

}
