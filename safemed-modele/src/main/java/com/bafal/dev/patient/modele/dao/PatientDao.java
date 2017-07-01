package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bafal.dev.patient.modele.entite.Patient;

@Transactional
public interface PatientDao extends JpaRepository<Patient, Long>, JpaSpecificationExecutor<Patient> {

    public static final String REQUETE_PURGE_PATIENT = "UPDATE Patient p SET p.actif = :active "
			+ " WHERE p.noDossier = :numdossier ";

    List<Patient> findByActifTrueOrderByDateCreationDesc();

    @Modifying(clearAutomatically = true)
    @Query(REQUETE_PURGE_PATIENT)
    void setPurgePatient(@Param("active") boolean actif, @Param("numdossier") String matricule);

    Patient findByNoDossier(String matricule);

	@Query("SELECT p FROM Patient p WHERE p.noDossier = (:code)")
	Patient findByMatriculeFetchDossiers(@Param("code") String matricule);

    Long countByNoDossierStartingWith(String debutMatricule);
}
