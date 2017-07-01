package com.bafal.dev.patient.modele.base.dto;

import java.util.Date;

public abstract class BaseDto {

	public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";

	protected Long id;

	private String creePar;

	private Date dateCreation;

	private String modifiePar;

	private Date dateModification;

	private int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isSerialized() {
		return getId() != null;
	}

	public boolean isNotSerialized() {
		return !isSerialized();
	}

	public String getCreePar() {
		return creePar;
	}

	public void setCreePar(String creePar) {
		this.creePar = creePar;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getModifiePar() {
		return modifiePar;
	}

	public void setModifiePar(String modifiePar) {
		this.modifiePar = modifiePar;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
