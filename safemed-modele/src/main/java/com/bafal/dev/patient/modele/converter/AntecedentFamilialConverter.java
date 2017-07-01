package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentFamilialDto;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentFamilial;

public class AntecedentFamilialConverter {

	public static AntecedentFamilial fromDto(AntecedentFamilialDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		AntecedentFamilial entity = (AntecedentFamilial) AntecedentConverter.fromDto(dto);
		return entity;
	}

	public static AntecedentFamilialDto toDto(AntecedentFamilial entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AntecedentFamilialDto dto = (AntecedentFamilialDto) AntecedentConverter.toDto(entity);
		return dto;
	}

	public static List<AntecedentFamilialDto> toDtos(List<AntecedentFamilial> entities) {
		List<AntecedentFamilialDto> dtos = new ArrayList<AntecedentFamilialDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AntecedentFamilialConverter.toDto(entity)));
		return dtos;
	}

	public static List<AntecedentFamilial> fromDtos(List<AntecedentFamilialDto> dtos) {
		List<AntecedentFamilial> entities = new ArrayList<AntecedentFamilial>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AntecedentFamilialConverter.fromDto(dto)));
		return entities;
	}

}
