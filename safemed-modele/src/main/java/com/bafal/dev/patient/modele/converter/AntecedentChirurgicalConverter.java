package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentChirurgicalDto;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentChirurgical;

public class AntecedentChirurgicalConverter {

	public static AntecedentChirurgical fromDto(AntecedentChirurgicalDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		AntecedentChirurgical entity = (AntecedentChirurgical) AntecedentConverter.fromDto(dto);
		return entity;
	}

	public static AntecedentChirurgicalDto toDto(AntecedentChirurgical entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AntecedentChirurgicalDto dto = (AntecedentChirurgicalDto) AntecedentConverter.toDto(entity);
		return dto;
	}

	public static List<AntecedentChirurgicalDto> toDtos(List<AntecedentChirurgical> entities) {
		List<AntecedentChirurgicalDto> dtos = new ArrayList<AntecedentChirurgicalDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AntecedentChirurgicalConverter.toDto(entity)));
		return dtos;
	}

	public static List<AntecedentChirurgical> fromDtos(List<AntecedentChirurgicalDto> dtos) {
		List<AntecedentChirurgical> entities = new ArrayList<AntecedentChirurgical>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AntecedentChirurgicalConverter.fromDto(dto)));
		return entities;
	}

}
