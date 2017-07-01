package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.DmeTaskDto;
import com.bafal.dev.patient.modele.entite.DmeTask;


public class DmeTaskConverter {

	public static DmeTask fromDto(DmeTaskDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		DmeTask entity = new DmeTask();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setDateDebut(dto.getDateDebut());
		entity.setDateEcheance(dto.getDateEcheance());
		entity.setDescription(dto.getDescription());
		entity.setIdAssignateur(dto.getIdAssignateur());
		entity.setIdAssigne(dto.getIdAssigne());
		entity.setPourcentageComplete(dto.getPourcentageComplete());
		entity.setPriorite(dto.getPriorite());
		entity.setStatut(dto.getStatut());
		entity.setSujet(dto.getSujet()); 
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static DmeTaskDto toDto(DmeTask entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		DmeTaskDto dto = new DmeTaskDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setDateDebut(entity.getDateDebut());
		dto.setDateEcheance(entity.getDateEcheance());
		dto.setDescription(entity.getDescription());
		dto.setIdAssignateur(entity.getIdAssignateur());
		dto.setIdAssigne(entity.getIdAssigne());
		dto.setPourcentageComplete(entity.getPourcentageComplete());
		dto.setPriorite(entity.getPriorite());
		dto.setStatut(entity.getStatut());
		dto.setSujet(entity.getSujet());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<DmeTaskDto> toDtos(List<DmeTask> entities) {
		List<DmeTaskDto> dtos = new ArrayList<DmeTaskDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(DmeTaskConverter.toDto(entity)));
		return dtos;
	}

	public static List<DmeTask> fromDtos(List<DmeTaskDto> dtos) {
		List<DmeTask> entities = new ArrayList<DmeTask>();
		DME.safeListe(dtos).forEach(dto -> entities.add(DmeTaskConverter.fromDto(dto)));
		return entities;
	}
}
