package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.PatientJsonDto;
import com.bafal.dev.patient.modele.entite.PatientJson;




public class PatientJsonConverter {

	public static PatientJson fromDto(PatientJsonDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		PatientJson entity = new PatientJson();

		entity.setId(dto.getId());
		entity.setCivilite(dto.getCivilite());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setNomComplet(dto.getNomComplet());
		entity.setNoDossier(dto.getNoDossier());
		entity.setTelephone(dto.getTelephone());
		entity.setCourriel(dto.getCourriel());
		entity.setDateNaissance(dto.getDateNaissance());
		return entity;
	}

	public static PatientJsonDto toDto(PatientJson entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		PatientJsonDto dto = new PatientJsonDto();

		dto.setId(entity.getId());
		dto.setCivilite(entity.getCivilite());
		dto.setNom(entity.getNom());
		dto.setNomComplet(entity.getNomComplet());
		dto.setPrenom(entity.getPrenom());
		dto.setNoDossier(entity.getNoDossier());
		dto.setTelephone(entity.getTelephone());
		dto.setCourriel(entity.getCourriel());
		dto.setDateNaissance(entity.getDateNaissance());

		return dto;
	}

	public static List<PatientJsonDto> toDtos(List<PatientJson> entities) {
		List<PatientJsonDto> dtos = new ArrayList<PatientJsonDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(PatientJsonConverter.toDto(entity)));
		return dtos;
	}

	public static List<PatientJson> fromDtos(List<PatientJsonDto> dtos) {
		List<PatientJson> entities = new ArrayList<PatientJson>();
		DME.safeListe(dtos).forEach(dto -> entities.add(PatientJsonConverter.fromDto(dto)));
		return entities;
	}
}
