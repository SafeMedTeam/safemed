package com.bafal.dev.patient.modele.dto;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.CodePrivilege;
import com.bafal.dev.patient.modele.base.util.DME;


public class PrivilegeDto extends BaseDto {


	private CodePrivilege code;

	private String nom;

	private String description;

	public CodePrivilege getCode() {
		return code;
	}

	public void setCode(CodePrivilege code) {
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

	@Override
	public String toString() {
		return DME.isNull(this.getCode()) ? "" : this.getCode().name();
	}

}
