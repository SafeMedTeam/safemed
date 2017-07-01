package com.bafal.dev.patient.modele.entite;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;

@Entity
@Table(name = "FACTURATION")
public class Facturation extends BaseEntite {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5634631156402392246L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

	@Column(name = "ID_PATIENT", insertable = false, updatable = false)
	private Long idPatient;

	@Column(name = "MONTANT_PAYE", scale = 2)
	private BigDecimal montantPaye;

	@Column(name = "MONTANT_TOTAL", scale = 2)
	private BigDecimal montantTotal;

	@Column(name = "STATUT", length = 50)
	private String statut;

	@Column(name = "MEDECIN_EXECUTANT", length = 100)
	private String medecinExecutant;

	@Column(name = "DATE_FACTURATION")
	@Temporal(TemporalType.DATE)
	private Date dateFacturation;

	@Column(name = "NOTE", length = 500)
	private String note;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "SERVICE_FACTURE", joinColumns = @JoinColumn(name = "FACTURE_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "TARIF_ID", referencedColumnName = "ID"))
	private List<Tarification> servicesFactures;

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

	public List<Tarification> getServicesFactures() {
		return servicesFactures;
	}

	public void setServicesFactures(List<Tarification> servicesFactures) {
		this.servicesFactures = servicesFactures;
	}

	public String getMedecinExecutant() {
		return medecinExecutant;
	}

	public void setMedecinExecutant(String medecinExecutant) {
		this.medecinExecutant = medecinExecutant;
	}

}
