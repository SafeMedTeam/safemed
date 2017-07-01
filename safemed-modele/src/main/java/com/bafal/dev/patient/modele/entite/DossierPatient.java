package com.bafal.dev.patient.modele.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentFamilial;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentObstetrical;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentPersonnel;

@Entity
@Table(name = "DOSSIER_PATIENT")
public class DossierPatient extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = -5634446371733918301L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

	@Column(name = "NO_DOSSIER", length = 100, unique = true)
	private String numeroDossier;

    @Column(name = "OBSERVATIONS", length = 500)
    private String observations;

	@Column(name = "DATE_OUVERTURE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOuverture;

	@JoinColumn(name = "ID_PATIENT", nullable = false)
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	private Patient patient;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
    @Fetch(FetchMode.SUBSELECT)
	private List<NoteClinique> notesCliniques;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<RendezVous> rendezVous;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<AntecedentPersonnel> antecedents;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<AntecedentFamilial> antecedentsFamiliaux;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<AntecedentObstetrical> antecedentsObstetricaux;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<Allergie> allergies;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOSSIER", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<HabitudeVie> habitudesVie;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PATIENT", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	private List<Medication> medications;

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

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<NoteClinique> getNotesCliniques() {
		return notesCliniques;
	}

	public void setNotesCliniques(List<NoteClinique> notesCliniques) {
		this.notesCliniques = notesCliniques;
	}

	public List<RendezVous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public List<AntecedentPersonnel> getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(List<AntecedentPersonnel> antecedents) {
		this.antecedents = antecedents;
	}

	public List<AntecedentFamilial> getAntecedentsFamiliaux() {
		return antecedentsFamiliaux;
	}

	public void setAntecedentsFamiliaux(List<AntecedentFamilial> antecedentsFamiliaux) {
		this.antecedentsFamiliaux = antecedentsFamiliaux;
	}

	public List<AntecedentObstetrical> getAntecedentsObstetricaux() {
		return antecedentsObstetricaux;
	}

	public void setAntecedentsObstetricaux(List<AntecedentObstetrical> antecedentsObstetricaux) {
		this.antecedentsObstetricaux = antecedentsObstetricaux;
	}

	public List<Allergie> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergie> allergies) {
		this.allergies = allergies;
	}

	public List<HabitudeVie> getHabitudesVie() {
		return habitudesVie;
	}

	public void setHabitudesVie(List<HabitudeVie> habitudesVie) {
		this.habitudesVie = habitudesVie;
	}

	public List<Medication> getMedications() {
		return medications;
	}

	public void setMedications(List<Medication> medications) {
		this.medications = medications;
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
