package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.AgendaDto;
import com.bafal.dev.patient.modele.entite.Agenda;


public class AgendaConverter {

	public static Agenda fromDto(AgendaDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Agenda entity = new Agenda();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setVersion(dto.getVersion());
		entity.setNom(entity.getNom());
		entity.setPlagesHoraires(PlageHoraireConverter.fromDtos(dto.getPlagesHoraires()));

		return entity;
	}

	public static AgendaDto toDto(Agenda entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AgendaDto dto = new AgendaDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setVersion(entity.getVersion());
		dto.setNom(entity.getNom());
		dto.setPlagesHoraires(PlageHoraireConverter.toDtos(entity.getPlagesHoraires()));

		return dto;
	}

	public static List<AgendaDto> toDtos(List<Agenda> entities) {
		List<AgendaDto> dtos = new ArrayList<AgendaDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AgendaConverter.toDto(entity)));
		return dtos;
	}

	public static List<Agenda> fromDtos(List<AgendaDto> dtos) {
		List<Agenda> entities = new ArrayList<Agenda>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AgendaConverter.fromDto(dto)));
		return entities;
	}
}
