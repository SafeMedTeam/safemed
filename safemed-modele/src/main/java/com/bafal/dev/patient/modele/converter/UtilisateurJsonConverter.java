package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.UtilisateurJsonDto;
import com.bafal.dev.patient.modele.entite.UtilisateurJson;




public class UtilisateurJsonConverter {

	public static UtilisateurJson fromDto(UtilisateurJsonDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		UtilisateurJson entity = new UtilisateurJson();

		entity.setId(dto.getId());
		entity.setCivilite(dto.getCivilite());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setFonction(dto.getFonction());
		entity.setIdService(dto.getIdService());
		entity.setNomService(dto.getNomService());

		return entity;
	}

	public static UtilisateurJsonDto toDto(UtilisateurJson entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		UtilisateurJsonDto dto = new UtilisateurJsonDto();

		dto.setId(entity.getId());
		dto.setCivilite(entity.getCivilite());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		dto.setFonction(entity.getFonction());
		dto.setIdService(entity.getIdService());
		dto.setNomService(entity.getNomService());

		return dto;
	}

	public static List<UtilisateurJsonDto> toDtos(List<UtilisateurJson> entities) {
		List<UtilisateurJsonDto> dtos = new ArrayList<UtilisateurJsonDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(UtilisateurJsonConverter.toDto(entity)));
		return dtos;
	}

	public static List<UtilisateurJson> fromDtos(List<UtilisateurJsonDto> dtos) {
		List<UtilisateurJson> entities = new ArrayList<UtilisateurJson>();
		DME.safeListe(dtos).forEach(dto -> entities.add(UtilisateurJsonConverter.fromDto(dto)));
		return entities;
	}
}
