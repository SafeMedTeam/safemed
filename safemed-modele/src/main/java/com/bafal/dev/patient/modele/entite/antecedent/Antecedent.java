package com.bafal.dev.patient.modele.entite.antecedent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.LienParente;
import com.bafal.dev.patient.modele.base.enumeration.Sexe;
import com.bafal.dev.patient.modele.base.enumeration.TypeAntecedent;
import com.bafal.dev.patient.modele.base.enumeration.TypeChirurgie;
import com.bafal.dev.patient.modele.base.enumeration.TypeMaladie;

@Entity
@Table(name = "ANTECEDENT")
@Inheritance
@DiscriminatorColumn(name = "TYPE")
public class Antecedent extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = -6513880335881939725L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TYPE", length = 5, insertable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private TypeAntecedent type;

    @Column(name = "TYPE_MALADIE", length = 10)
    @Enumerated(EnumType.STRING)
    private TypeMaladie maladie;

    @Column(name = "MALADIE_AUTRE", length = 50)
    private String maladieAutre;

    @Column(name = "DATE_APPARITION")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateApparition;

    @Column(name = "DATE_RESOLUTION")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateResolution;

    @Column(name = "STABILITE")
    private boolean stabilite;

    @Column(name = "TRAITE")
    private boolean traite;

    @Column(name = "HOSPITALISATION")
    private boolean hospitalisation;

    // FAMILIAUX

    @Column(name = "PERSONNE", length = 100)
    private String personne;

    @Column(name = "LIEN_PARENTE", length = 10)
    @Enumerated(EnumType.STRING)
    private LienParente lienParente;

    // GROSSESSE

    @Column(name = "DATE_NAISS_ENFANT")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissanceEnfant;

    @Column(name = "SEXE", length = 1)
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

    @Column(name = "SANTE_ENFANT", length = 100)
    private String santeEnfant;

    @Column(name = "HISTOIRE_GROSSESSE", length = 200)
    private String histoireGrossesseAccouchement;

    // CHIRURGIE

    @Column(name = "TYPE_CHIRURGIE", length = 5)
    @Enumerated(EnumType.STRING)
    private TypeChirurgie typeChirurgie;

    @Column(name = "CHIRURGIE_AUTRE", length = 50)
    private String chirurgieAutre;

    @Column(name = "DATE_CHIRURGIE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateChirurgie;

    @Column(name = "RAISON", length = 200)
    private String raison;

    @Column(name = "SEQUELLES", length = 200)
    private String sequelles;

    @Column(name = "HOPITAL_CHIRURGIEN", length = 100)
    private String hopitalOuChirurgien;

    // COMMUN

    @Column(name = "NOTE", length = 500)
    private String note;

	@Column(name = "ID_DOSSIER", insertable = false, updatable = false)
	private Long idDossier;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeAntecedent getType() {
        return type;
    }

    public void setType(TypeAntecedent type) {
        this.type = type;
    }

    public TypeMaladie getMaladie() {
        return maladie;
    }

    public void setMaladie(TypeMaladie maladie) {
        this.maladie = maladie;
    }

    public String getMaladieAutre() {
        return maladieAutre;
    }

    public void setMaladieAutre(String maladieAutre) {
        this.maladieAutre = maladieAutre;
    }

    public Date getDateApparition() {
        return dateApparition;
    }

    public void setDateApparition(Date dateApparition) {
        this.dateApparition = dateApparition;
    }

    public Date getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(Date dateResolution) {
        this.dateResolution = dateResolution;
    }

    public boolean isStabilite() {
        return stabilite;
    }

    public void setStabilite(boolean stabilite) {
        this.stabilite = stabilite;
    }

    public boolean isTraite() {
        return traite;
    }

    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    public boolean isHospitalisation() {
        return hospitalisation;
    }

    public void setHospitalisation(boolean hospitalisation) {
        this.hospitalisation = hospitalisation;
    }

    public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

    public LienParente getLienParente() {
        return lienParente;
    }

    public void setLienParente(LienParente lienParente) {
        this.lienParente = lienParente;
    }

    public Date getDateNaissanceEnfant() {
        return dateNaissanceEnfant;
    }

    public void setDateNaissanceEnfant(Date dateNaissanceEnfant) {
        this.dateNaissanceEnfant = dateNaissanceEnfant;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getSanteEnfant() {
        return santeEnfant;
    }

    public void setSanteEnfant(String santeEnfant) {
        this.santeEnfant = santeEnfant;
    }

    public String getHistoireGrossesseAccouchement() {
        return histoireGrossesseAccouchement;
    }

    public void setHistoireGrossesseAccouchement(String histoireGrossesseAccouchement) {
        this.histoireGrossesseAccouchement = histoireGrossesseAccouchement;
    }

    public TypeChirurgie getTypeChirurgie() {
        return typeChirurgie;
    }

    public void setTypeChirurgie(TypeChirurgie typeChirurgie) {
        this.typeChirurgie = typeChirurgie;
    }

    public String getChirurgieAutre() {
        return chirurgieAutre;
    }

    public void setChirurgieAutre(String chirurgieAutre) {
        this.chirurgieAutre = chirurgieAutre;
    }

    public Date getDateChirurgie() {
        return dateChirurgie;
    }

    public void setDateChirurgie(Date dateChirurgie) {
        this.dateChirurgie = dateChirurgie;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getSequelles() {
        return sequelles;
    }

    public void setSequelles(String sequelles) {
        this.sequelles = sequelles;
    }

    public String getHopitalOuChirurgien() {
        return hopitalOuChirurgien;
    }

    public void setHopitalOuChirurgien(String hopitalOuChirurgien) {
        this.hopitalOuChirurgien = hopitalOuChirurgien;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}



}
