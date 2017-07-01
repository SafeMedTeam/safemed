package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.RoleDto;
import com.bafal.dev.patient.modele.entite.Role;

public class RoleConverter {

	public static Role fromDto(RoleDto dto) {
		if (DME.isNull(dto)) {
			return new Role();
		}

		Role entity = new Role();
		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setCode(dto.getCode());
		entity.setDescription(dto.getDescription());
		entity.setNom(dto.getNom());
		entity.setVersion(dto.getVersion());
		entity.setPrivileges(PrivilegeConverter.fromDtos(dto.getPrivileges()));

		return entity;
	}

	public static RoleDto toDto(Role entity) {
		if (DME.isNull(entity)) {
			return new RoleDto();
		}

		RoleDto dto = new RoleDto();
		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setCode(entity.getCode());
		dto.setDescription(entity.getDescription());
		dto.setNom(entity.getNom());
		dto.setVersion(entity.getVersion());
		dto.setPrivileges(PrivilegeConverter.toDtos(entity.getPrivileges()));

		return dto;
	}

	public static List<Role> fromDtos(List<RoleDto> dtos) {
		List<Role> entities = new ArrayList<Role>();
		DME.safeListe(dtos).forEach(dto -> entities.add(RoleConverter.fromDto(dto)));
		return entities;
	}

	public static List<RoleDto> toDtos(List<Role> entities) {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(RoleConverter.toDto(entity)));
		return dtos;
	}

}
