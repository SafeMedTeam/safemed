package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.entite.Chambre;

public interface ChambreDao extends JpaRepository<Chambre, Long> {

    List<Chambre> findByNombreLitDisponibleGreaterThanEqual(Integer nombreLitDisponible);

}
