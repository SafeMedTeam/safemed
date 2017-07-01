package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentPersonnelDto;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentPersonnel;

public class AntecedentPersonnelConverter {

	public static AntecedentPersonnel fromDto(AntecedentPersonnelDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		AntecedentPersonnel entity = (AntecedentPersonnel) AntecedentConverter.fromDto(dto);
		return entity;
	}

	public static AntecedentPersonnelDto toDto(AntecedentPersonnel entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AntecedentPersonnelDto dto = (AntecedentPersonnelDto) AntecedentConverter.toDto(entity);
		return dto;
	}

	public static List<AntecedentPersonnelDto> toDtos(List<AntecedentPersonnel> entities) {
		List<AntecedentPersonnelDto> dtos = new ArrayList<AntecedentPersonnelDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AntecedentPersonnelConverter.toDto(entity)));
		return dtos;
	}

	public static List<AntecedentPersonnel> fromDtos(List<AntecedentPersonnelDto> dtos) {
		List<AntecedentPersonnel> entities = new ArrayList<AntecedentPersonnel>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AntecedentPersonnelConverter.fromDto(dto)));
		return entities;
	}

}
