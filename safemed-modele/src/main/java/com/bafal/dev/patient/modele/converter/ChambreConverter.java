package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.ChambreDto;
import com.bafal.dev.patient.modele.entite.Chambre;


public class ChambreConverter {

	public static Chambre fromDto(ChambreDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Chambre entity = new Chambre();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setCategChambre(dto.getCategChambre());
		entity.setCodeChambre(dto.getCodeChambre());
		entity.setLocalisation(dto.getLocalisation());
		entity.setNoChambre(dto.getNoChambre());
		entity.setNombreLitDisponible(dto.getNombreLitDisponible());
		entity.setNombreLitTotal(dto.getNombreLitTotal());
		entity.setPrixUnitaire(dto.getPrixUnitaire());
		entity.setNotesCliniques(NoteCliniqueConverter.fromDtos(dto.getNotesCliniques()));
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static ChambreDto toDto(Chambre entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		ChambreDto dto = new ChambreDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setCategChambre(entity.getCategChambre());
		dto.setCodeChambre(entity.getCodeChambre());
		dto.setLocalisation(entity.getLocalisation());
		dto.setNoChambre(entity.getNoChambre());
		dto.setNombreLitDisponible(entity.getNombreLitDisponible());
		dto.setNombreLitTotal(entity.getNombreLitTotal());
		dto.setPrixUnitaire(entity.getPrixUnitaire());
		dto.setNotesCliniques(NoteCliniqueConverter.toDtos(entity.getNotesCliniques()));
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<ChambreDto> toDtos(List<Chambre> entities) {
		List<ChambreDto> dtos = new ArrayList<ChambreDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(ChambreConverter.toDto(entity)));
		return dtos;
	}

	public static List<Chambre> fromDtos(List<ChambreDto> dtos) {
		List<Chambre> entities = new ArrayList<Chambre>();
		DME.safeListe(dtos).forEach(dto -> entities.add(ChambreConverter.fromDto(dto)));
		return entities;
	}
}
