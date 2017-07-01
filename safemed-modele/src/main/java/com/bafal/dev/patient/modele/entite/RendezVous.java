package com.bafal.dev.patient.modele.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.StatutRV;
import com.bafal.dev.patient.modele.base.enumeration.TypeRendezVous;

@Entity
@Table(name = "RENDEZVOUS")
public class RendezVous extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = 335765888041863645L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

	@Column(name = "JOUR")
	@Temporal(TemporalType.DATE)
	private Date jour;

	@Column(name = "HEURE_DEBUT")
	@Temporal(TemporalType.TIME)
	private Date heureDebut;

	@Column(name = "DUREE")
	private Long duree;

    @Column(name = "RV_NOTES", length = 500)
    private String notesRv;

	@ElementCollection(targetClass = TypeRendezVous.class)
	@CollectionTable(name = "TYPE_RV", joinColumns = @JoinColumn(name = "RV_ID"))
	@Enumerated(EnumType.STRING)
	List<TypeRendezVous> typesRv;

    @Column(name = "RV_TYPE_AUTRE", length = 100)
    private String autreTypeRv;

    /**
     * Si la personne ayant pris le rendez-vous est deja patient le rendez-vous va etre
     * associé a l'objet Patient sinon on rentre les infos
     */
    @Column(name = "DEJA_PATIENT")
    private boolean dejaPatient;

    @Column(name = "PRENOM", length = 100)
    private String prenom;

    @Column(name = "NOM", length = 100)
    private String nom;

    @Column(name = "TELEPHONE", length = 20)
    private String telephone;

    @Column(name = "COURRIEL", length = 100)
    private String courriel;

	@Column(name = "ID_DOSSIER", insertable = false, updatable = false)
	private Long idDossier;

	@Column(name = "ID_PLAGE", nullable = false)
	private Long idPlage;

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

	@Column(name = "STATUT", length = 30)
	@Enumerated(EnumType.STRING)
	private StatutRV statut;

	@Column(name = "DESCRIPTION", length = 500)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatutRV getStatut() {
		return statut;
	}

	public void setStatut(StatutRV statut) {
		this.statut = statut;
	}

	private String noConfirmation;

	public String getNoConfirmation() {
		return noConfirmation;
	}

	public void setNoConfirmation(String noConfirmation) {
		this.noConfirmation = noConfirmation;
	}

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

    public String getNotesRv() {
        return notesRv;
    }

    public void setNotesRv(String notesRv) {
        this.notesRv = notesRv;
    }

	public List<TypeRendezVous> getTypesRv() {
		return typesRv;
	}

	public void setTypesRv(List<TypeRendezVous> typesRv) {
		this.typesRv = typesRv;
	}

	public String getAutreTypeRv() {
        return autreTypeRv;
    }

    public void setAutreTypeRv(String autreTypeRv) {
        this.autreTypeRv = autreTypeRv;
    }

    public boolean isDejaPatient() {
        return dejaPatient;
    }

    public void setDejaPatient(boolean dejaPatient) {
        this.dejaPatient = dejaPatient;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

	public Long getIdPlage() {
		return idPlage;
	}

	public void setIdPlage(Long idPlage) {
		this.idPlage = idPlage;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

}
