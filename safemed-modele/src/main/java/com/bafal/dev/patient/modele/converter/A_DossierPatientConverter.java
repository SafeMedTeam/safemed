package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.DossierPatientDto;
import com.bafal.dev.patient.modele.entite.DossierPatient;


public class A_DossierPatientConverter {

	public static DossierPatient fromDto(DossierPatientDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		DossierPatient entity = new DossierPatient();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());

		return entity;
	}

	public static DossierPatientDto toDto(DossierPatient entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		DossierPatientDto dto = new DossierPatientDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());

		return dto;
	}

	public static List<DossierPatientDto> toDtos(List<DossierPatient> entities) {
		List<DossierPatientDto> dtos = new ArrayList<DossierPatientDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(A_DossierPatientConverter.toDto(entity)));
		return dtos;
	}

	public static List<DossierPatient> fromDtos(List<DossierPatientDto> dtos) {
		List<DossierPatient> entities = new ArrayList<DossierPatient>();
		DME.safeListe(dtos).forEach(dto -> entities.add(A_DossierPatientConverter.fromDto(dto)));
		return entities;
	}
}
