package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.base.enumeration.CodePrivilege;
import com.bafal.dev.patient.modele.entite.Privilege;


public interface PrivilegeDao extends JpaRepository<Privilege, Long> {

	Privilege findByCode(CodePrivilege code);

	List<Privilege> findByCodeIn(List<CodePrivilege> codes);
}
