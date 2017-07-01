package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.DossierPatientDto;
import com.bafal.dev.patient.modele.entite.DossierPatient;


public class DossierPatientConverter {

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
		entity.setDateOuverture(dto.getDateOuverture());
		entity.setNumeroDossier(dto.getNumeroDossier());
		entity.setObservations(dto.getObservations());
		entity.setPatient(PatientConverter.fromDto(dto.getPatient()));
		entity.setAllergies(AllergieConverter.fromDtos(dto.getAllergies()));
		entity.setAntecedents(AntecedentPersonnelConverter.fromDtos(dto.getAntecedents()));
		entity.setAntecedentsFamiliaux(AntecedentFamilialConverter.fromDtos(dto.getAntecedentsFamiliaux()));
		entity.setAntecedentsObstetricaux(AntecedentObstetricalConverter.fromDtos(dto.getAntecedentsObstetricaux()));
		entity.setHabitudesVie(HabitudeVieConverter.fromDtos(dto.getHabitudesVie()));
		entity.setMedications(MedicationConverter.fromDtos(dto.getMedications()));
		entity.setNotesCliniques(NoteCliniqueConverter.fromDtos(dto.getNotesCliniques()));
		entity.setRendezVous(RendezVousConverter.fromDtos(dto.getRendezVous()));
		entity.setVersion(dto.getVersion());

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
		dto.setDateOuverture(entity.getDateOuverture());
		dto.setNumeroDossier(entity.getNumeroDossier());
		dto.setObservations(entity.getObservations());
		dto.setPatient(PatientConverter.toDto(entity.getPatient()));
		dto.setAllergies(AllergieConverter.toDtos(entity.getAllergies()));
		dto.setAntecedents(AntecedentPersonnelConverter.toDtos(entity.getAntecedents()));
		dto.setAntecedentsFamiliaux(AntecedentFamilialConverter.toDtos(entity.getAntecedentsFamiliaux()));
		dto.setAntecedentsObstetricaux(AntecedentObstetricalConverter.toDtos(entity.getAntecedentsObstetricaux()));
		dto.setHabitudesVie(HabitudeVieConverter.toDtos(entity.getHabitudesVie()));
		dto.setMedications(MedicationConverter.toDtos(entity.getMedications()));
		dto.setNotesCliniques(NoteCliniqueConverter.toDtos(entity.getNotesCliniques()));
		dto.setRendezVous(RendezVousConverter.toDtos(entity.getRendezVous()));
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<DossierPatientDto> toDtos(List<DossierPatient> entities) {
		List<DossierPatientDto> dtos = new ArrayList<DossierPatientDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(DossierPatientConverter.toDto(entity)));
		return dtos;
	}
}
