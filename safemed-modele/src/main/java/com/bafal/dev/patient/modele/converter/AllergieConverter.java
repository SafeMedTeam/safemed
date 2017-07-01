package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.AllergieDto;
import com.bafal.dev.patient.modele.entite.Allergie;


public class AllergieConverter {

	public static Allergie fromDto(AllergieDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Allergie entity = new Allergie();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setEffetImmediat(dto.isEffetImmediat());
		entity.setEffetRetarde(dto.isEffetRetarde());
		entity.setIdDossier(dto.getIdDossier());
		entity.setNomMedicamentOuProduit(dto.getNomMedicamentOuProduit());
		entity.setNote(dto.getNote());
		entity.setSeverite(dto.getSeverite());
		entity.setTypeReaction(dto.getTypeReaction());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static AllergieDto toDto(Allergie entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AllergieDto dto = new AllergieDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setEffetImmediat(entity.isEffetImmediat());
		dto.setEffetRetarde(entity.isEffetRetarde());
		dto.setIdDossier(entity.getIdDossier());
		dto.setNomMedicamentOuProduit(entity.getNomMedicamentOuProduit());
		dto.setNote(entity.getNote());
		dto.setSeverite(entity.getSeverite());
		dto.setTypeReaction(entity.getTypeReaction());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<AllergieDto> toDtos(List<Allergie> entities) {
		List<AllergieDto> dtos = new ArrayList<AllergieDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AllergieConverter.toDto(entity)));
		return dtos;
	}

	public static List<Allergie> fromDtos(List<AllergieDto> dtos) {
		List<Allergie> entities = new ArrayList<Allergie>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AllergieConverter.fromDto(dto)));
		return entities;
	}
}
