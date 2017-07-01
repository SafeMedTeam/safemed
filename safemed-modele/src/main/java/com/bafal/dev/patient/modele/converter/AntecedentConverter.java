package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.builder.AntecedentBuilder;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentDto;
import com.bafal.dev.patient.modele.entite.antecedent.Antecedent;


public class AntecedentConverter {

	public static Antecedent fromDto(AntecedentDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Antecedent entity = AntecedentBuilder.build(dto.getType());

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		
		entity.setChirurgieAutre(dto.getChirurgieAutre());
		entity.setDateApparition(dto.getDateApparition());
		entity.setDateChirurgie(dto.getDateChirurgie());
		entity.setDateNaissanceEnfant(dto.getDateNaissanceEnfant());
		entity.setDateResolution(dto.getDateResolution()); 
		entity.setHistoireGrossesseAccouchement(dto.getHistoireGrossesseAccouchement());
		entity.setHopitalOuChirurgien(dto.getHopitalOuChirurgien());
		entity.setHospitalisation(dto.isHospitalisation());
		entity.setIdDossier(dto.getIdDossier());
		entity.setLienParente(dto.getLienParente());
		entity.setMaladie(dto.getMaladie());
		entity.setMaladieAutre(dto.getMaladieAutre());
		entity.setNote(dto.getNote());
		entity.setPersonne(dto.getPersonne());
		entity.setRaison(dto.getRaison());
		entity.setSanteEnfant(dto.getSanteEnfant());
		entity.setSequelles(dto.getSequelles());
		entity.setSexe(dto.getSexe());
		entity.setStabilite(dto.isStabilite());
		entity.setTraite(dto.isTraite());
		entity.setType(dto.getType());
		entity.setTypeChirurgie(dto.getTypeChirurgie());
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static AntecedentDto toDto(Antecedent entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		AntecedentDto dto = AntecedentBuilder.buildDto(entity.getType());

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setChirurgieAutre(entity.getChirurgieAutre());
		dto.setDateApparition(entity.getDateApparition());
		dto.setDateChirurgie(entity.getDateChirurgie());
		dto.setDateNaissanceEnfant(entity.getDateNaissanceEnfant());
		dto.setDateResolution(entity.getDateResolution());
		dto.setHistoireGrossesseAccouchement(entity.getHistoireGrossesseAccouchement());
		dto.setHopitalOuChirurgien(entity.getHopitalOuChirurgien());
		dto.setHospitalisation(entity.isHospitalisation());
		dto.setIdDossier(entity.getIdDossier());
		dto.setLienParente(entity.getLienParente());
		dto.setMaladie(entity.getMaladie());
		dto.setMaladieAutre(entity.getMaladieAutre());
		dto.setNote(entity.getNote());
		dto.setPersonne(entity.getPersonne());
		dto.setRaison(entity.getRaison());
		dto.setSanteEnfant(entity.getSanteEnfant());
		dto.setSequelles(entity.getSequelles());
		dto.setSexe(entity.getSexe());
		dto.setStabilite(entity.isStabilite());
		dto.setTraite(entity.isTraite());
		dto.setType(entity.getType());
		dto.setTypeChirurgie(entity.getTypeChirurgie());
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<AntecedentDto> toDtos(List<Antecedent> entities) {
		List<AntecedentDto> dtos = new ArrayList<AntecedentDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(AntecedentConverter.toDto(entity)));
		return dtos;
	}

	public static List<Antecedent> fromDtos(List<AntecedentDto> dtos) {
		List<Antecedent> entities = new ArrayList<Antecedent>();
		DME.safeListe(dtos).forEach(dto -> entities.add(AntecedentConverter.fromDto(dto)));
		return entities;
	}
}
