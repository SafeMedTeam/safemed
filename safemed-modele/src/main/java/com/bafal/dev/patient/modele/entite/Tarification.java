package com.bafal.dev.patient.modele.entite;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;

@Entity
@Table(name = "TARIFICATION")
public class Tarification extends BaseEntite {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5634631156402392246L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

	@Column(name = "CODE_SERVICE", length = 50)
	private String codeServiceOffert;

	@Column(name = "NOM_SERVICE", length = 100)
	private String nomServiceOffert;

	@Column(name = "PRIX_BASE", scale = 2)
	private BigDecimal prixBase;

	@Column(name = "PRIX_PAR_UNITE", scale = 2)
	private BigDecimal prixParUnite;

	@Column(name = "TAXE", scale = 2)
	private BigDecimal taxeApplicable;

	@Column(name = "STATUT", length = 50)
	private String statut;

	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.DATE)
	private Date dateEntreeEnVigueur;

	@Column(name = "DATE_ECHEANCE")
	@Temporal(TemporalType.DATE)
	private Date dateEcheance;

	@Column(name = "CREE_PAR", length = 100)
	private String creePar;

	@Column(name = "DATE_CREATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	@Column(name = "MODIFIE_PAR", length = 100)
	private String modifiePar;

	@Column(name = "DATE_MODIF")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;

	@Version
	@Column(name = "VERSION")
	private int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
