package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.RendezVousDto;
import com.bafal.dev.patient.modele.entite.RendezVous;


public class RendezVousConverter {

	public static RendezVous fromDto(RendezVousDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		RendezVous entity = new RendezVous();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setAutreTypeRv(dto.getAutreTypeRv());
		entity.setCourriel(dto.getCourriel());
		entity.setDejaPatient(dto.isDejaPatient());
		entity.setIdDossier(dto.getIdDossier());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setNotesRv(dto.getNotesRv());
		entity.setTelephone(dto.getTelephone());
		entity.setTypesRv(dto.getTypesRv());
		entity.setNoConfirmation(dto.getNoConfirmation());
		entity.setStatut(dto.getStatut());
		entity.setVersion(dto.getVersion());
		entity.setJour(entity.getJour());
		entity.setHeureDebut(entity.getHeureDebut());
		entity.setDuree(dto.getDuree());
		entity.setIdPlage(dto.getIdPlage());
		entity.setDescription(dto.getDescription());

		return entity;
	}

	public static RendezVousDto toDto(RendezVous entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		RendezVousDto dto = new RendezVousDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setAutreTypeRv(entity.getAutreTypeRv());
		dto.setCourriel(entity.getCourriel());
		dto.setDejaPatient(entity.isDejaPatient());
		dto.setIdDossier(entity.getIdDossier());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		dto.setNotesRv(entity.getNotesRv());
		dto.setTelephone(entity.getTelephone());
		dto.setTypesRv(entity.getTypesRv());
		dto.setNoConfirmation(entity.getNoConfirmation());
		dto.setStatut(entity.getStatut());
		dto.setVersion(entity.getVersion());
		dto.setJour(entity.getJour());
		dto.setHeureDebut(entity.getHeureDebut());
		dto.setDuree(entity.getDuree());
		dto.setIdPlage(entity.getIdPlage());
		dto.setDescription(entity.getDescription());

		return dto;
	}

	public static List<RendezVousDto> toDtos(List<RendezVous> entities) {
		List<RendezVousDto> dtos = new ArrayList<RendezVousDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(RendezVousConverter.toDto(entity)));
		return dtos;
	}

	public static List<RendezVous> fromDtos(List<RendezVousDto> dtos) {
		List<RendezVous> entities = new ArrayList<RendezVous>();
		DME.safeListe(dtos).forEach(dto -> entities.add(RendezVousConverter.fromDto(dto)));
		return entities;
	}
}
