package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.PrivilegeDto;
import com.bafal.dev.patient.modele.entite.Privilege;

public class PrivilegeConverter {

	public static Privilege fromDto(PrivilegeDto dto) {
		if (DME.isNull(dto)) {
			return new Privilege();
		}

		Privilege entity = new Privilege();
		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setCode(dto.getCode());
		entity.setDescription(dto.getDescription());
		entity.setNom(dto.getNom());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static PrivilegeDto toDto(Privilege entity) {
		if (DME.isNull(entity)) {
			return new PrivilegeDto();
		}

		PrivilegeDto dto = new PrivilegeDto();
		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setCode(entity.getCode());
		dto.setDescription(entity.getDescription());
		dto.setNom(entity.getNom());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<Privilege> fromDtos(List<PrivilegeDto> dtos) {
		List<Privilege> entities = new ArrayList<Privilege>();
		DME.safeListe(dtos).forEach(dto -> entities.add(PrivilegeConverter.fromDto(dto)));
		return entities;
	}

	public static List<PrivilegeDto> toDtos(List<Privilege> entities) {
		List<PrivilegeDto> dtos = new ArrayList<PrivilegeDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(PrivilegeConverter.toDto(entity)));
		return dtos;
	}

}
