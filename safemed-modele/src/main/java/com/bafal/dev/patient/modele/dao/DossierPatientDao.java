package com.bafal.dev.patient.modele.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.bafal.dev.patient.modele.entite.DossierPatient;

@Transactional
public interface DossierPatientDao
		extends JpaRepository<DossierPatient, Long>, JpaSpecificationExecutor<DossierPatient> {

	DossierPatient findByNumeroDossier(String noDossier);

}
