package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.ExamenDto;
import com.bafal.dev.patient.modele.entite.Examen;


public class ExamenConverter {

	public static Examen fromDto(ExamenDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Examen entity = new Examen();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setCodeExamen(dto.getCodeExamen());
		entity.setDateExamen(dto.getDateExamen());
		entity.setIdNote(dto.getIdNote());
		entity.setLieuRealisationExamen(dto.getLieuRealisationExamen());
		entity.setMedecinPrescripteur(dto.getMedecinPrescripteur());
		entity.setObservations(dto.getObservations());
		entity.setPrixExamen(dto.getPrixExamen());
		entity.setTypeExamen(dto.getTypeExamen());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static ExamenDto toDto(Examen entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		ExamenDto dto = new ExamenDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setCodeExamen(entity.getCodeExamen());
		dto.setDateExamen(entity.getDateExamen());
		dto.setIdNote(entity.getIdNote());
		dto.setLieuRealisationExamen(entity.getLieuRealisationExamen());
		dto.setMedecinPrescripteur(entity.getMedecinPrescripteur());
		dto.setObservations(entity.getObservations());
		dto.setPrixExamen(entity.getPrixExamen());
		dto.setTypeExamen(entity.getTypeExamen());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<ExamenDto> toDtos(List<Examen> entities) {
		List<ExamenDto> dtos = new ArrayList<ExamenDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(ExamenConverter.toDto(entity)));
		return dtos;
	}

	public static List<Examen> fromDtos(List<ExamenDto> dtos) {
		List<Examen> entities = new ArrayList<Examen>();
		DME.safeListe(dtos).forEach(dto -> entities.add(ExamenConverter.fromDto(dto)));
		return entities;
	}
}
