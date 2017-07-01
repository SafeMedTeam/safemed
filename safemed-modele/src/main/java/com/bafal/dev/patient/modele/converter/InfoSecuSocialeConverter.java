package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.InfoSecuSocialeDto;
import com.bafal.dev.patient.modele.entite.InfoSecuSociale;


public class InfoSecuSocialeConverter {

	public static InfoSecuSociale fromDto(InfoSecuSocialeDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		InfoSecuSociale entity = new InfoSecuSociale();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());

		entity.setCmu(dto.isCmu());
		entity.setContratMutuelle(dto.getContratMutuelle());
		entity.setIdPatient(dto.getIdPatient());
		entity.setNomCaisse(dto.getNomCaisse());
		entity.setNoSecuSociale(dto.getContratMutuelle());
		entity.setTypeCaisse(dto.getTypeCaisse());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static InfoSecuSocialeDto toDto(InfoSecuSociale entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		InfoSecuSocialeDto dto = new InfoSecuSocialeDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());

		dto.setCmu(entity.isCmu());
		dto.setContratMutuelle(entity.getContratMutuelle());
		dto.setIdPatient(entity.getIdPatient());
		dto.setNomCaisse(entity.getNomCaisse());
		dto.setNoSecuSociale(entity.getContratMutuelle());
		dto.setTypeCaisse(entity.getTypeCaisse());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<InfoSecuSocialeDto> toDtos(List<InfoSecuSociale> entities) {
		List<InfoSecuSocialeDto> dtos = new ArrayList<InfoSecuSocialeDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(InfoSecuSocialeConverter.toDto(entity)));
		return dtos;
	}

	public static List<InfoSecuSociale> fromDtos(List<InfoSecuSocialeDto> dtos) {
		List<InfoSecuSociale> entities = new ArrayList<InfoSecuSociale>();
		DME.safeListe(dtos).forEach(dto -> entities.add(InfoSecuSocialeConverter.fromDto(dto)));
		return entities;
	}
}
