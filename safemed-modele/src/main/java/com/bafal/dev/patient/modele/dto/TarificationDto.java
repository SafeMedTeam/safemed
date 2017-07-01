package com.bafal.dev.patient.modele.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class TarificationDto extends BaseDto {


	private String codeServiceOffert;

	private String nomServiceOffert;

	private BigDecimal prixBase;

	private BigDecimal prixParUnite;

	private BigDecimal taxeApplicable;

	private String statut;

	private Date dateEntreeEnVigueur;

	private Date dateEcheance;


	public String getCodeServiceOffert() {
		return codeServiceOffert;
	}

	public void setCodeServiceOffert(String codeServiceOffert) {
		this.codeServiceOffert = codeServiceOffert;
	}

	public String getNomServiceOffert() {
		return nomServiceOffert;
	}

	public void setNomServiceOffert(String nomServiceOffert) {
		this.nomServiceOffert = nomServiceOffert;
	}

	public BigDecimal getPrixBase() {
		return prixBase;
	}

	public void setPrixBase(BigDecimal prixBase) {
		this.prixBase = prixBase;
	}

	public BigDecimal getPrixParUnite() {
		return prixParUnite;
	}

	public void setPrixParUnite(BigDecimal prixParUnite) {
		this.prixParUnite = prixParUnite;
	}

	public BigDecimal getTaxeApplicable() {
		return taxeApplicable;
	}

	public void setTaxeApplicable(BigDecimal taxeApplicable) {
		this.taxeApplicable = taxeApplicable;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateEntreeEnVigueur() {
		return dateEntreeEnVigueur;
	}

	public void setDateEntreeEnVigueur(Date dateEntreeEnVigueur) {
		this.dateEntreeEnVigueur = dateEntreeEnVigueur;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

}
