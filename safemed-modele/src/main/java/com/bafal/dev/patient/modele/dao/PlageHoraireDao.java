package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.base.enumeration.StatutPlageHoraire;
import com.bafal.dev.patient.modele.entite.PlageHoraire;

public interface PlageHoraireDao extends JpaRepository<PlageHoraire, Long> {

	List<PlageHoraire> findByStatut(StatutPlageHoraire statut);

}
