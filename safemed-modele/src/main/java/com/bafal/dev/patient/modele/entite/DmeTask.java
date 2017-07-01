package com.bafal.dev.patient.modele.entite;

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
import com.bafal.dev.patient.modele.base.enumeration.PrioriteTask;
import com.bafal.dev.patient.modele.base.enumeration.StatutTask;

@Entity
@Table(name = "DME_TASK")
public class DmeTask extends BaseEntite {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4586988974191389434L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

	@Column(name = "ID_ASSIGNATEUR")
	private Long idAssignateur;

	@Column(name = "ID_ASSIGNE")
	private Long idAssigne;

	@Column(name = "SUJET", length = 200)
	private String sujet;

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	@Column(name = "STATUT", length = 25)
	private StatutTask statut;

	@Column(name = "PRIORITE", length = 25)
	private PrioriteTask priorite;

	@Column(name = "POURCENTAGE_COMPLET")
	private Integer pourcentageComplete;

	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;

	@Column(name = "DATE_ECHEANCE")
	@Temporal(TemporalType.TIMESTAMP)
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdAssignateur() {
		return idAssignateur;
	}

	public void setIdAssignateur(Long idAssignateur) {
		this.idAssignateur = idAssignateur;
	}

	public Long getIdAssigne() {
		return idAssigne;
	}

	public void setIdAssigne(Long idAssigne) {
		this.idAssigne = idAssigne;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatutTask getStatut() {
		return statut;
	}

	public void setStatut(StatutTask statut) {
		this.statut = statut;
	}

	public PrioriteTask getPriorite() {
		return priorite;
	}

	public void setPriorite(PrioriteTask priorite) {
		this.priorite = priorite;
	}

	public Integer getPourcentageComplete() {
		return pourcentageComplete;
	}

	public void setPourcentageComplete(Integer pourcentageComplete) {
		this.pourcentageComplete = pourcentageComplete;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
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

}
