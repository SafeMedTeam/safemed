package com.bafal.dev.patient.modele.converter;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.NoteCliniqueDto;
import com.bafal.dev.patient.modele.entite.NoteClinique;


public class NoteCliniqueConverter {

	public static NoteClinique fromDto(NoteCliniqueDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		NoteClinique entity = new NoteClinique();

		entity.setId(dto.getId());
		entity.setCreePar(dto.getCreePar());
		entity.setDateCreation(dto.getDateCreation());
		entity.setModifiePar(dto.getModifiePar());
		entity.setDateModification(dto.getDateModification());
		entity.setConclusion(dto.getConclusion());
		entity.setDateDebut(dto.getDateDebut());
		entity.setDateFin(dto.getDateFin());
		entity.setDetailConsultation(dto.getDetailConsultation());
		entity.setExamenPhysique(dto.getExamenPhysique());
		entity.setHistoireMaladie(dto.getHistoireMaladie());
		entity.setIdChambre(dto.getIdChambre());
		entity.setIdDossier(dto.getIdDossier());
		entity.setIdPersonnelMedical(dto.getIdPersonnelMedical());
		entity.setRaisonVisite(dto.getRaisonVisite());
		entity.setStatut(dto.getStatut());
		entity.setType(dto.getType());
		entity.setSignesVitaux(SignesVitauxConverter.fromDtos(dto.getSignesVitaux()));
		entity.setExamens(ExamenConverter.fromDtos(dto.getExamens()));
		entity.setFichiers(FichierConverter.fromDtos(dto.getFichiers()));
		entity.setVersion(dto.getVersion());

		return entity;
	}

	public static NoteCliniqueDto toDto(NoteClinique entity) {
		if (DME.isNull(entity)) {
			return null;
		}
		NoteCliniqueDto dto = new NoteCliniqueDto();

		dto.setId(entity.getId());
		dto.setCreePar(entity.getCreePar());
		dto.setDateCreation(entity.getDateCreation());
		dto.setModifiePar(entity.getModifiePar());
		dto.setDateModification(entity.getDateModification());
		dto.setConclusion(entity.getConclusion());
		dto.setDateDebut(entity.getDateDebut());
		dto.setDateFin(entity.getDateFin());
		dto.setDetailConsultation(entity.getDetailConsultation());
		dto.setExamenPhysique(entity.getExamenPhysique());
		dto.setHistoireMaladie(entity.getHistoireMaladie());
		dto.setIdChambre(entity.getIdChambre());
		dto.setIdDossier(entity.getIdDossier());
		dto.setIdPersonnelMedical(entity.getIdPersonnelMedical());
		dto.setRaisonVisite(entity.getRaisonVisite());
		dto.setStatut(entity.getStatut());
		dto.setType(entity.getType());
		dto.setSignesVitaux(SignesVitauxConverter.toDtos(entity.getSignesVitaux()));
		dto.setExamens(ExamenConverter.toDtos(entity.getExamens()));
		dto.setFichiers(FichierConverter.toDtos(entity.getFichiers()));
		dto.setVersion(entity.getVersion());

		return dto;
	}

	public static List<NoteCliniqueDto> toDtos(List<NoteClinique> entities) {
		List<NoteCliniqueDto> dtos = new ArrayList<NoteCliniqueDto>();
		DME.safeListe(entities).forEach(entity -> dtos.add(NoteCliniqueConverter.toDto(entity)));
		return dtos;
	}

	public static List<NoteClinique> fromDtos(List<NoteCliniqueDto> dtos) {
		List<NoteClinique> entities = new ArrayList<NoteClinique>();
		DME.safeListe(dtos).forEach(dto -> entities.add(NoteCliniqueConverter.fromDto(dto)));
		return entities;
	}
}
