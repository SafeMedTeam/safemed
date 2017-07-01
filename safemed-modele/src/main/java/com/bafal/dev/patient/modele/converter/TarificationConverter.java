package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.TarificationDto;
import com.bafal.dev.patient.modele.entite.Tarification;


public class TarificationConverter {

	public static Tarification fromDto(TarificationDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Tarification entity = new Tarification();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setVersion(dto.getVersion());
		entity.setCodeServiceOffert(dto.getCodeServiceOffert());
		entity.setDateEcheance(dto.getDateEcheance());
		entity.setDateEntreeEnVigueur(dto.getDateEntreeEnVigueur());
		entity.setNomServiceOffert(dto.getNomServiceOffert());
		entity.setPrixBase(dto.getPrixBase());
		entity.setPrixParUnite(dto.getPrixParUnite());
		entity.setStatut(dto.getStatut());
		entity.setTaxeApplicable(dto.getTaxeApplicable());

		return entity;
	}

	public static TarificationDto toDto(Tarification entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		TarificationDto dto = new TarificationDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setVersion(entity.getVersion());
		dto.setCodeServiceOffert(entity.getCodeServiceOffert());
		dto.setDateEcheance(entity.getDateEcheance());
		dto.setDateEntreeEnVigueur(entity.getDateEntreeEnVigueur());
		dto.setNomServiceOffert(entity.getNomServiceOffert());
		dto.setPrixBase(entity.getPrixBase());
		dto.setPrixParUnite(entity.getPrixParUnite());
		dto.setStatut(entity.getStatut());
		dto.setTaxeApplicable(entity.getTaxeApplicable());

		return dto;
	}

	public static List<TarificationDto> toDtos(List<Tarification> entities) {
		List<TarificationDto> dtos = new ArrayList<TarificationDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(TarificationConverter.toDto(entity)));
		return dtos;
	}

	public static List<Tarification> fromDtos(List<TarificationDto> dtos) {
		List<Tarification> entities = new ArrayList<Tarification>();
		DME.safeListe(dtos).forEach(dto -> entities.add(TarificationConverter.fromDto(dto)));
		return entities;
	}
}
