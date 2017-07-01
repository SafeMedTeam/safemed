package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.HabitudeVieDto;
import com.bafal.dev.patient.modele.entite.HabitudeVie;


public class HabitudeVieConverter {

	public static HabitudeVie fromDto(HabitudeVieDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		HabitudeVie entity = new HabitudeVie();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setDependance(dto.getDependance());
		entity.setDuree(dto.getDuree());
		entity.setFrequence(dto.getFrequence());
		entity.setIdDossier(dto.getIdDossier());
		entity.setNote(dto.getNote());
		entity.setType(dto.getType());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static HabitudeVieDto toDto(HabitudeVie entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		HabitudeVieDto dto = new HabitudeVieDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setDependance(entity.getDependance());
		dto.setDuree(entity.getDuree());
		dto.setFrequence(entity.getFrequence());
		dto.setIdDossier(entity.getIdDossier());
		dto.setNote(entity.getNote());
		dto.setType(entity.getType());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<HabitudeVieDto> toDtos(List<HabitudeVie> entities) {
		List<HabitudeVieDto> dtos = new ArrayList<HabitudeVieDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(HabitudeVieConverter.toDto(entity)));
		return dtos;
	}

	public static List<HabitudeVie> fromDtos(List<HabitudeVieDto> dtos) {
		List<HabitudeVie> entities = new ArrayList<HabitudeVie>();
		DME.safeListe(dtos).forEach(dto -> entities.add(HabitudeVieConverter.fromDto(dto)));
		return entities;
	}
}
