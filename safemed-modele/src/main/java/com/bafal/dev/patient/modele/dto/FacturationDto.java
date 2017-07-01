package com.bafal.dev.patient.modele.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class FacturationDto extends BaseDto {

	private Long idPatient;

	private BigDecimal montantPaye;

	private BigDecimal montantTotal;

	private String statut;

	@DateTimeFormat(style = "dd/MM/yyyy")
	private Date dateFacturation;

	private String note;

	private String medecinExecutant;

	private List<TarificationDto> servicesFactures;

	public Long getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Long idPatient) {
		this.idPatient = idPatient;
	}

	public BigDecimal getMontantPaye() {
		return montantPaye;
	}

	public void setMontantPaye(BigDecimal montantPaye) {
		this.montantPaye = montantPaye;
	}

	public BigDecimal getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(BigDecimal montantTotal) {
		this.montantTotal = montantTotal;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<TarificationDto> getServicesFactures() {
		return servicesFactures;
	}

	public void setServicesFactures(List<TarificationDto> servicesFactures) {
		this.servicesFactures = servicesFactures;
	}

	public String getMedecinExecutant() {
		return medecinExecutant;
	}

	public void setMedecinExecutant(String medecinExecutant) {
		this.medecinExecutant = medecinExecutant;
	}

}
