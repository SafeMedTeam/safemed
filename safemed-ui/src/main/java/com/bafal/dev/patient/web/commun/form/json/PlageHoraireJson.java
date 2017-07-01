package com.bafal.dev.patient.web.commun.form.json;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlageHoraireJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonProperty("title")
	private String titre;

	private String url;

	@JsonProperty("start")
	private Date dateDebut;

	@JsonProperty("end")
	private Date dateFin;

	@JsonProperty("allDay")
	private boolean touteLaJournee;

	private String color;

	private String textColor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isTouteLaJournee() {
		return touteLaJournee;
	}

	public void setTouteLaJournee(boolean touteLaJournee) {
		this.touteLaJournee = touteLaJournee;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}


}
