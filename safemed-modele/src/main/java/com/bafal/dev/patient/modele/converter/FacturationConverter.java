package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.FacturationDto;
import com.bafal.dev.patient.modele.entite.Facturation;


public class FacturationConverter {

	public static Facturation fromDto(FacturationDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Facturation entity = new Facturation();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setVersion(dto.getVersion());
		entity.setDateFacturation(dto.getDateFacturation());
		entity.setIdPatient(dto.getIdPatient());
		entity.setMontantPaye(dto.getMontantPaye());
		entity.setMontantTotal(dto.getMontantTotal());
		entity.setNote(dto.getNote());
		entity.setStatut(dto.getStatut());
		entity.setMedecinExecutant(dto.getMedecinExecutant());
		entity.setServicesFactures(TarificationConverter.fromDtos(dto.getServicesFactures()));

		return entity;
	}

	public static FacturationDto toDto(Facturation entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		FacturationDto dto = new FacturationDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setVersion(entity.getVersion());
		dto.setDateFacturation(entity.getDateFacturation());
		dto.setIdPatient(entity.getIdPatient());
		dto.setMontantPaye(entity.getMontantPaye());
		dto.setMontantTotal(entity.getMontantTotal());
		dto.setNote(entity.getNote());
		dto.setStatut(entity.getStatut());
		dto.setMedecinExecutant(entity.getMedecinExecutant());
		dto.setServicesFactures(TarificationConverter.toDtos(entity.getServicesFactures()));

		return dto;
	}

	public static List<FacturationDto> toDtos(List<Facturation> entities) {
		List<FacturationDto> dtos = new ArrayList<FacturationDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(FacturationConverter.toDto(entity)));
		return dtos;
	}

	public static List<Facturation> fromDtos(List<FacturationDto> dtos) {
		List<Facturation> entities = new ArrayList<Facturation>();
		DME.safeListe(dtos).forEach(dto -> entities.add(FacturationConverter.fromDto(dto)));
		return entities;
	}
}
