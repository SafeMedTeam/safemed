package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.SignesVitauxDto;
import com.bafal.dev.patient.modele.entite.SignesVitaux;


public class SignesVitauxConverter {

	public static SignesVitaux fromDto(SignesVitauxDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		SignesVitaux entity = new SignesVitaux();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setDatePrise(dto.getDatePrise());
		entity.setIdNote(dto.getIdNote());
		entity.setImc(dto.getImc());
		entity.setNote(dto.getNote());
		entity.setPoids(dto.getPoids());
		entity.setPressionDiastolique(dto.getPressionDiastolique());
		entity.setPressionSystolique(dto.getPressionSystolique());
		entity.setPulsation(dto.getPulsation());
		entity.setRespiration(dto.getRespiration());
		entity.setTaille(dto.getTaille());
		entity.setTemperature(dto.getTemperature());
		entity.setUniteTemperature(dto.getUniteTemperature());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static SignesVitauxDto toDto(SignesVitaux entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		SignesVitauxDto dto = new SignesVitauxDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setDatePrise(entity.getDatePrise());
		dto.setIdNote(entity.getIdNote());
		dto.setImc(entity.getImc());
		dto.setNote(entity.getNote());
		dto.setPoids(entity.getPoids());
		dto.setPressionDiastolique(entity.getPressionDiastolique());
		dto.setPressionSystolique(entity.getPressionSystolique());
		dto.setPulsation(entity.getPulsation());
		dto.setRespiration(entity.getRespiration());
		dto.setTaille(entity.getTaille());
		dto.setTemperature(entity.getTemperature());
		dto.setUniteTemperature(entity.getUniteTemperature());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<SignesVitauxDto> toDtos(List<SignesVitaux> entities) {
		List<SignesVitauxDto> dtos = new ArrayList<SignesVitauxDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(SignesVitauxConverter.toDto(entity)));
		return dtos;
	}

	public static List<SignesVitaux> fromDtos(List<SignesVitauxDto> dtos) {
		List<SignesVitaux> entities = new ArrayList<SignesVitaux>();
		DME.safeListe(dtos).forEach(dto -> entities.add(SignesVitauxConverter.fromDto(dto)));
		return entities;
	}
}
