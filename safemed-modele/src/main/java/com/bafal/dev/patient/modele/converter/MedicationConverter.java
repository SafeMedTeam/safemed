package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.MedicationDto;
import com.bafal.dev.patient.modele.entite.Medication;


public class MedicationConverter {

	public static Medication fromDto(MedicationDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Medication entity = new Medication();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setDateDebut(dto.getDateDebut());
		entity.setDateFin(dto.getDateFin());
		entity.setEffetIndesirable(dto.getEffetIndesirable());
		entity.setEfficacite(dto.getEfficacite());
		entity.setIdDossier(dto.getIdDossier());
		entity.setNomMedicament(dto.getNomMedicament());
		entity.setNote(dto.getNote());
		entity.setPosologie(dto.getPosologie());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static MedicationDto toDto(Medication entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		MedicationDto dto = new MedicationDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setDateDebut(entity.getDateDebut());
		dto.setDateFin(entity.getDateFin());
		dto.setEffetIndesirable(entity.getEffetIndesirable());
		dto.setEfficacite(entity.getEfficacite());
		dto.setIdDossier(entity.getIdDossier());
		dto.setNomMedicament(entity.getNomMedicament());
		dto.setNote(entity.getNote());
		dto.setPosologie(entity.getPosologie());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<MedicationDto> toDtos(List<Medication> entities) {
		List<MedicationDto> dtos = new ArrayList<MedicationDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(MedicationConverter.toDto(entity)));
		return dtos;
	}

	public static List<Medication> fromDtos(List<MedicationDto> dtos) {
		List<Medication> entities = new ArrayList<Medication>();
		DME.safeListe(dtos).forEach(dto -> entities.add(MedicationConverter.fromDto(dto)));
		return entities;
	}
}
