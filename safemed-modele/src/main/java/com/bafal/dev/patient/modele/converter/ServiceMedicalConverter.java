package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.ServiceMedicalDto;
import com.bafal.dev.patient.modele.entite.ServiceMedical;


public class ServiceMedicalConverter {

	public static ServiceMedical fromDto(ServiceMedicalDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		ServiceMedical entity = new ServiceMedical();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setCodeService(dto.getCodeService());
		entity.setDescription(dto.getDescription());
		entity.setNomService(dto.getNomService());
		entity.setPersonnels(UtilisateurConverter.fromDtos(dto.getPersonnels()));
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static ServiceMedicalDto toDto(ServiceMedical entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		ServiceMedicalDto dto = new ServiceMedicalDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setCodeService(entity.getCodeService());
		dto.setDescription(entity.getDescription());
		dto.setNomService(entity.getNomService());
		dto.setPersonnels(UtilisateurConverter.toDtos(entity.getPersonnels()));
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<ServiceMedicalDto> toDtos(List<ServiceMedical> entities) {
		List<ServiceMedicalDto> dtos = new ArrayList<ServiceMedicalDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(ServiceMedicalConverter.toDto(entity)));
		return dtos;
	}

	public static List<ServiceMedical> fromDtos(List<ServiceMedicalDto> dtos) {
		List<ServiceMedical> entities = new ArrayList<ServiceMedical>();
		DME.safeListe(dtos).forEach(dto -> entities.add(ServiceMedicalConverter.fromDto(dto)));
		return entities;
	}
}
