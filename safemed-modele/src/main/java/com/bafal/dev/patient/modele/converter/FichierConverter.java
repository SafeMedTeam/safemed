package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.FichierDto;
import com.bafal.dev.patient.modele.entite.Fichier;


public class FichierConverter {

	public static Fichier fromDto(FichierDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Fichier entity = new Fichier();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setDateAjout(dto.getDateAjout());
		entity.setFichier(dto.getFichier());
		entity.setIdNote(dto.getIdNote());
		entity.setNomFichier(dto.getNomFichier());
		entity.setNote(dto.getNote());
		entity.setVolume(dto.getVolume());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static FichierDto toDto(Fichier entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		FichierDto dto = new FichierDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setDateAjout(entity.getDateAjout());
		dto.setFichier(entity.getFichier());
		dto.setIdNote(entity.getIdNote());
		dto.setNomFichier(entity.getNomFichier());
		dto.setNote(entity.getNote());
		dto.setVolume(entity.getVolume());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<FichierDto> toDtos(List<Fichier> entities) {
		List<FichierDto> dtos = new ArrayList<FichierDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(FichierConverter.toDto(entity)));
		return dtos;
	}

	public static List<Fichier> fromDtos(List<FichierDto> dtos) {
		List<Fichier> entities = new ArrayList<Fichier>();
		DME.safeListe(dtos).forEach(dto -> entities.add(FichierConverter.fromDto(dto)));
		return entities;
	}
}
