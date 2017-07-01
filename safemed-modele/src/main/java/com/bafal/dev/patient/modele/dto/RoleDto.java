package com.bafal.dev.patient.modele.dto;

import java.util.List;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class RoleDto extends BaseDto {



	private String code;

	private String nom;

	private String description;


	private List<PrivilegeDto> privileges;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PrivilegeDto> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<PrivilegeDto> privileges) {
		this.privileges = privileges;
	}

}
