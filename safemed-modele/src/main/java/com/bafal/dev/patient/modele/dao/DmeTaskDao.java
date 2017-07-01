package com.bafal.dev.patient.modele.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.entite.DmeTask;

public interface DmeTaskDao extends JpaRepository<DmeTask, Long> {

}
