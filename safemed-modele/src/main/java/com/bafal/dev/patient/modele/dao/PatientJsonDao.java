package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bafal.dev.patient.modele.entite.PatientJson;

public interface PatientJsonDao extends JpaRepository<PatientJson, Long> {

	@Query("SELECT p FROM PatientJson p WHERE p.nomComplet like :motCle OR p.noDossier like :motCle OR p.telephone like :motCle OR p.courriel like :motCle ")
	List<PatientJson> rechercherParMotCle(@Param("motCle") String motCle);
}
