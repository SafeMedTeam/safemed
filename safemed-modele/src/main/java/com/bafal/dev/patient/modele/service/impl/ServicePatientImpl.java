package com.bafal.dev.patient.modele.service.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bafal.dev.patient.modele.base.logger.SafeMedLogger;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.base.util.DmeConstante;
import com.bafal.dev.patient.modele.base.util.SpecificationCritereBuilder;
import com.bafal.dev.patient.modele.converter.DossierPatientConverter;
import com.bafal.dev.patient.modele.converter.PatientConverter;
import com.bafal.dev.patient.modele.converter.PatientJsonConverter;
import com.bafal.dev.patient.modele.dao.DossierPatientDao;
import com.bafal.dev.patient.modele.dao.PatientDao;
import com.bafal.dev.patient.modele.dao.PatientJsonDao;
import com.bafal.dev.patient.modele.dto.ChambreDto;
import com.bafal.dev.patient.modele.dto.DossierPatientDto;
import com.bafal.dev.patient.modele.dto.NoteCliniqueDto;
import com.bafal.dev.patient.modele.dto.PatientDto;
import com.bafal.dev.patient.modele.dto.PatientJsonDto;
import com.bafal.dev.patient.modele.entite.DossierPatient;
import com.bafal.dev.patient.modele.entite.Patient;
import com.bafal.dev.patient.modele.filtre.PatientFiltre;
import com.bafal.dev.patient.modele.service.ServicePatient;

@Service
@Transactional
public class ServicePatientImpl implements ServicePatient {

    @Autowired
    private PatientDao daoPatient;

	@Autowired
	private PatientJsonDao daoJson;

	@Autowired
	private DossierPatientDao daoDossier;

    @Override
	public List<PatientDto> getListePatientsActif() {
		return PatientConverter.toDtos(daoPatient.findByActifTrueOrderByDateCreationDesc());
    }

    @Override
	public PatientDto enregistrer(PatientDto dto) {
		Validate.notNull(dto);
		if (dto.isNotSerialized()) {
			// TODO creer un dossier Patient vierge
			return creerPatient(dto);
        }
		return PatientConverter.toDto(daoPatient.save(PatientConverter.fromDto(dto)));
    }

	private PatientDto creerPatient(PatientDto dto) {
		Patient entity = daoPatient.save(PatientConverter.fromDto(dto));
		dto = PatientConverter.toDto(entity);
		this.enregistrerDossierClinique(dto.getNoDossier(), entity);
		return dto;
	}

	private void enregistrerDossierClinique(String noDossier, Patient patient) {
		DossierPatient dossier = new DossierPatient();
		dossier.setNumeroDossier(noDossier);
		dossier.setPatient(patient);
		dossier.setCreePar(patient.getCreePar());
		dossier.setDateOuverture(DME.now());
		dossier.setDateCreation(DME.now());
		daoDossier.save(dossier);
	}

	@Override
    public void purger(String codePatient) {
        daoPatient.setPurgePatient(false, codePatient);
    }

    @Override
    @Transactional
	public PatientDto getPatientParNoDossier(String noDossier) {
		Validate.notBlank(noDossier);
		return PatientConverter.toDto(daoPatient.findByNoDossier(noDossier));
    }

    @Override
	public List<ChambreDto> getListeChambreParNombreLitDisponible(Integer nombreLitDisponible) {
		// return
		// daoChambre.findByNombreLitDisponibleGreaterThanEqual(nombreLitDisponible);
		return null;
    }

    @Override
    public Long getNombrePatientsByNumeroDossier(String codePatient) {
        return daoPatient.countByNoDossierStartingWith(codePatient);
    }

    @Override
	public PatientDto getPatientCompletParCode(String codePatient) {
		return PatientConverter.toDto(daoPatient.findByMatriculeFetchDossiers(codePatient));
    }

	@Override
	public DossierPatientDto getDossierPatient(String noDossier) {
		return DossierPatientConverter.toDto(daoDossier.findByNumeroDossier(noDossier));
	}

	@Override
	public NoteCliniqueDto getNoteCliniqueEnRedaction(Long idNote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientDto> rechercher(PatientFiltre filtre) {
		SpecificationCritereBuilder<Patient> spec = new SpecificationCritereBuilder<Patient>();
		try {
			return PatientConverter.toDtos(daoPatient.findAll(spec.whereClause(filtre)));
		} catch (IllegalArgumentException e) {
			SafeMedLogger.log(ServicePatientImpl.class, e.getMessage(), SafeMedLogger.Level.ERROR);
		}

		return null;
	}

	@Override
	public List<PatientJsonDto> rechercherPatientJsonParMotCle(String motCle) {
		motCle = DME.isBlank(motCle) ? motCle : DmeConstante.WILDCARD + motCle + DmeConstante.WILDCARD;
		return PatientJsonConverter.toDtos(daoJson.rechercherParMotCle(motCle));
	}
}
