package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.PersonneContactDto;
import com.bafal.dev.patient.modele.entite.PersonneContact;


public class PersonneContactConverter {

	public static PersonneContact fromDto(PersonneContactDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		PersonneContact entity = new PersonneContact();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());

		entity.setCivilite(dto.getCivilite());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setCourriel(dto.getCourriel());
		entity.setTelephone(dto.getTelephone());
		entity.setLienParente(dto.getLienParente());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static PersonneContactDto toDto(PersonneContact entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		PersonneContactDto dto = new PersonneContactDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());

		dto.setCivilite(entity.getCivilite());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		dto.setCourriel(entity.getCourriel());
		dto.setTelephone(entity.getTelephone());
		dto.setLienParente(entity.getLienParente());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<PersonneContactDto> toDtos(List<PersonneContact> entities) {
		List<PersonneContactDto> dtos = new ArrayList<PersonneContactDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(PersonneContactConverter.toDto(entity)));
		return dtos;
	}

	public static List<PersonneContact> fromDtos(List<PersonneContactDto> dtos) {
		List<PersonneContact> entities = new ArrayList<PersonneContact>();
		DME.safeListe(dtos).forEach(dto -> entities.add(PersonneContactConverter.fromDto(dto)));
		return entities;
	}
}
