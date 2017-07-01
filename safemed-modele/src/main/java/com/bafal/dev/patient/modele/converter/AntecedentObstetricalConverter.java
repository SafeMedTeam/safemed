package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentObstetricalDto;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentObstetrical;

public class AntecedentObstetricalConverter {

	public static AntecedentObstetrical fromDto(AntecedentObstetricalDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		AntecedentObstetrical entity = (AntecedentObstetrical) AntecedentConverter.fromDto(dto);
		return entity;
	}

	public static AntecedentObstetricalDto toDto(AntecedentObstetrical entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AntecedentObstetricalDto dto = (AntecedentObstetricalDto) AntecedentConverter.toDto(entity);
		return dto;
	}

	public static List<AntecedentObstetricalDto> toDtos(List<AntecedentObstetrical> entities) {
		List<AntecedentObstetricalDto> dtos = new ArrayList<AntecedentObstetricalDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AntecedentObstetricalConverter.toDto(entity)));
		return dtos;
	}

	public static List<AntecedentObstetrical> fromDtos(List<AntecedentObstetricalDto> dtos) {
		List<AntecedentObstetrical> entities = new ArrayList<AntecedentObstetrical>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AntecedentObstetricalConverter.fromDto(dto)));
		return entities;
	}

}
