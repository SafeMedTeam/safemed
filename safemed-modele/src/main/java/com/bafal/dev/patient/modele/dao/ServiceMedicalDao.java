package com.bafal.dev.patient.modele.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.base.enumeration.CodeService;
import com.bafal.dev.patient.modele.entite.ServiceMedical;

public interface ServiceMedicalDao extends JpaRepository<ServiceMedical, Long> {

    ServiceMedical findOneByCodeService(CodeService codeService);
}
