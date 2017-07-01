package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.entite.UtilisateurJson;

public interface UtilisateurJsonDao extends JpaRepository<UtilisateurJson, Long> {

	List<UtilisateurJson> findByNomCompletContaining(String motCle);
}
