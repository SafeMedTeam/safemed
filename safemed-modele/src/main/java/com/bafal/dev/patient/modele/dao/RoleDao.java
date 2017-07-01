package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.entite.Role;


public interface RoleDao extends JpaRepository<Role, Long> {

	Role findByCode(String code);

	List<Role> findByCodeIn(List<String> codes);
}
