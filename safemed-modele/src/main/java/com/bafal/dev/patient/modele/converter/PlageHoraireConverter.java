package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.PlageHoraireDto;
import com.bafal.dev.patient.modele.entite.PlageHoraire;


public class PlageHoraireConverter {

	public static PlageHoraire fromDto(PlageHoraireDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		PlageHoraire entity = new PlageHoraire();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setActif(dto.isActif());
		entity.setStatut(dto.getStatut());
		entity.setIdAgenda(dto.getIdAgenda());
		entity.setInformations(dto.getInformations());
		entity.setVersion(dto.getVersion());
		entity.setJour(dto.getJour());
		entity.setHeureDebut(dto.getHeureDebut());
		entity.setHeureFin(dto.getHeureFin());
		entity.setRendezVous(RendezVousConverter.fromDtos(dto.getRendezVous()));

		return entity;
	}

	public static PlageHoraireDto toDto(PlageHoraire entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		PlageHoraireDto dto = new PlageHoraireDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setActif(entity.isActif());
		dto.setStatut(entity.getStatut());
		dto.setIdAgenda(entity.getIdAgenda());
		dto.setInformations(entity.getInformations());
		dto.setVersion(entity.getVersion());
		dto.setJour(entity.getJour());
		dto.setHeureDebut(entity.getHeureDebut());
		dto.setHeureFin(entity.getHeureFin());
		dto.setRendezVous(RendezVousConverter.toDtos(entity.getRendezVous()));

		return dto;
	}

	public static List<PlageHoraireDto> toDtos(List<PlageHoraire> entities) {
		List<PlageHoraireDto> dtos = new ArrayList<PlageHoraireDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(PlageHoraireConverter.toDto(entity)));
		return dtos;
	}

	public static List<PlageHoraire> fromDtos(List<PlageHoraireDto> dtos) {
		List<PlageHoraire> entities = new ArrayList<PlageHoraire>();
		DME.safeListe(dtos).forEach(dto -> entities.add(PlageHoraireConverter.fromDto(dto)));
		return entities;
	}
}
