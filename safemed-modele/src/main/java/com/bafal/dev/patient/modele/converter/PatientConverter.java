package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.PatientDto;
import com.bafal.dev.patient.modele.entite.Patient;


public class PatientConverter {

	public static Patient fromDto(PatientDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Patient entity = new Patient();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());

		entity.setCivilite(dto.getCivilite());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setDateNaissance(dto.getDateNaissance());
		entity.setNoDossier(dto.getNoDossier());
		entity.setPrenomPere(dto.getPrenomPere());
		entity.setPrenomMere(dto.getPrenomMere());
		entity.setNomMere(dto.getNomMere());
		entity.setCourriel(dto.getCourriel());
		entity.setTelephone(dto.getTelephone());
		entity.setActif(dto.isActif());
		entity.setAdresse(dto.getAdresse());
		entity.setCodePostal(dto.getCodePostal());
		entity.setNumeroPieceIdentite(dto.getNumeroPieceIdentite());
		entity.setPays(dto.getPays());
		entity.setProfession(dto.getProfession());
		entity.setProvince(dto.getProvince());
		entity.setStatutMatrimonial(dto.getStatutMatrimonial());
		entity.setTypePieceIdentite(dto.getTypePieceIdentite());
		entity.setVille(dto.getVille());
		entity.setPersonnesContact(PersonneContactConverter.fromDtos(dto.getPersonnesContact())); 
		entity.setInfoSecuSociales(InfoSecuSocialeConverter.fromDtos(dto.getInfoSecuSociales()));
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static PatientDto toDto(Patient entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		PatientDto dto = new PatientDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());

		dto.setCivilite(entity.getCivilite());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		dto.setDateNaissance(entity.getDateNaissance());
		dto.setNoDossier(entity.getNoDossier());
		dto.setPrenomPere(entity.getPrenomPere());
		dto.setPrenomMere(entity.getPrenomMere());
		dto.setNomMere(entity.getNomMere());
		dto.setCourriel(entity.getCourriel());
		dto.setTelephone(entity.getTelephone());
		dto.setActif(entity.isActif());
		dto.setAdresse(entity.getAdresse());
		dto.setCodePostal(entity.getCodePostal());
		dto.setNumeroPieceIdentite(entity.getNumeroPieceIdentite());
		dto.setPays(entity.getPays());
		dto.setProfession(entity.getProfession());
		dto.setProvince(entity.getProvince());
		dto.setStatutMatrimonial(entity.getStatutMatrimonial());
		dto.setTypePieceIdentite(entity.getTypePieceIdentite());
		dto.setVille(entity.getVille());
		dto.setPersonnesContact(PersonneContactConverter.toDtos(entity.getPersonnesContact()));
		dto.setInfoSecuSociales(InfoSecuSocialeConverter.toDtos(entity.getInfoSecuSociales()));
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<PatientDto> toDtos(List<Patient> entities) {
		List<PatientDto> dtos = new ArrayList<PatientDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(PatientConverter.toDto(entity)));
		return dtos;
	}
}
