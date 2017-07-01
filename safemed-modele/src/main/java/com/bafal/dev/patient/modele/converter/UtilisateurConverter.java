package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.entite.Utilisateur;




public class UtilisateurConverter {

	public static Utilisateur fromDto(UtilisateurDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		Utilisateur entity = new Utilisateur();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());

		entity.setCivilite(dto.getCivilite());
		entity.setNom(dto.getNom());
		entity.setPrenom(dto.getPrenom());
		entity.setDateNaissance(dto.getDateNaissance());
		entity.setCourriel(dto.getCourriel());
		entity.setTelephone(dto.getTelephone());
		entity.setAdresse(dto.getAdresse());
		entity.setCodePostal(dto.getCodePostal());
		entity.setPays(dto.getPays());
		entity.setProvince(dto.getProvince());
		entity.setVille(dto.getVille());
		entity.setCodeUtilisateur(dto.getCodeUtilisateur());
		entity.setDateDebutActivite(dto.getDateDebutActivite());
		entity.setDateFinActivite(dto.getDateFinActivite());
		entity.setDoitChangerMdp(dto.isDoitChangerMdp());
		entity.setFonction(dto.getFonction());
		entity.setIdService(dto.getIdService());
		entity.setMotDePasse(dto.getMotDePasse());
		// entity.setNoteCliniques(NoteCliniqueConverter.fromDtos(dto.getNoteCliniques()));
		// entity.setPlagesHoraires(PlageHoraireConverter.fromDtos(dto.getPlagesHoraires()));
		entity.setRoles(RoleConverter.fromDtos(dto.getRoles()));
		entity.setTaches(DmeTaskConverter.fromDtos(dto.getTaches()));
		entity.setVersion(dto.getVersion());
		entity.setNomService(dto.getNomService());

		return entity;
	}

	public static UtilisateurDto toDto(Utilisateur entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		UtilisateurDto dto = new UtilisateurDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());

		dto.setCivilite(entity.getCivilite());
		dto.setNom(entity.getNom());
		dto.setPrenom(entity.getPrenom());
		dto.setDateNaissance(entity.getDateNaissance());
		dto.setCourriel(entity.getCourriel());
		dto.setTelephone(entity.getTelephone());
		dto.setAdresse(entity.getAdresse());
		dto.setCodePostal(entity.getCodePostal());
		dto.setPays(entity.getPays());
		dto.setProvince(entity.getProvince());
		dto.setVille(entity.getVille());
		dto.setCodeUtilisateur(entity.getCodeUtilisateur());
		dto.setDateDebutActivite(entity.getDateDebutActivite());
		dto.setDateFinActivite(entity.getDateFinActivite());
		dto.setDoitChangerMdp(entity.isDoitChangerMdp());
		dto.setFonction(entity.getFonction());
		dto.setIdService(entity.getIdService());
		dto.setMotDePasse(entity.getMotDePasse());
		// dto.setNoteCliniques(NoteCliniqueConverter.toDtos(entity.getNoteCliniques()));
		// dto.setPlagesHoraires(PlageHoraireConverter.toDtos(entity.getPlagesHoraires()));
		dto.setRoles(RoleConverter.toDtos(entity.getRoles()));
		dto.setTaches(DmeTaskConverter.toDtos(entity.getTaches()));
		dto.setVersion(entity.getVersion());
		dto.setNomService(entity.getNomService());

		return dto;
	}

	public static List<UtilisateurDto> toDtos(List<Utilisateur> entities) {
		List<UtilisateurDto> dtos = new ArrayList<UtilisateurDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(UtilisateurConverter.toDto(entity)));
		return dtos;
	}

	public static List<Utilisateur> fromDtos(List<UtilisateurDto> dtos) {
		List<Utilisateur> entities = new ArrayList<Utilisateur>();
		DME.safeListe(dtos).forEach(dto -> entities.add(UtilisateurConverter.fromDto(dto)));
		return entities;
	}
}
