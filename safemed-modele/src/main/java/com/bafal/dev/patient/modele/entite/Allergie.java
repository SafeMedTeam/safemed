package com.bafal.dev.patient.modele.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.Severite;

@Entity
@Table(name = "ALLERGIE")
public class Allergie extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = 8575902623988534634L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NOM_MEDICAMENT", length = 100)
    private String nomMedicamentOuProduit;

    @Column(name = "TYPE_REACTION", length = 100)
    private String typeReaction;

    @Column(name = "EFFET_IMMEDIAT")
    private boolean effetImmediat;

    @Column(name = "EFFET_RETARDE")
    private boolean effetRetarde;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEVERITE", length = 10)
    private Severite severite;

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

    public String getNomMedicamentOuProduit() {
        return nomMedicamentOuProduit;
    }

    public void setNomMedicamentOuProduit(String nomMedicamentOuProduit) {
        this.nomMedicamentOuProduit = nomMedicamentOuProduit;
    }

    public String getTypeReaction() {
        return typeReaction;
    }

    public void setTypeReaction(String typeReaction) {
        this.typeReaction = typeReaction;
    }

    public boolean isEffetImmediat() {
        return effetImmediat;
    }

    public void setEffetImmediat(boolean effetImmediat) {
        this.effetImmediat = effetImmediat;
    }

    public boolean isEffetRetarde() {
        return effetRetarde;
    }

    public void setEffetRetarde(boolean effetRetarde) {
        this.effetRetarde = effetRetarde;
    }

    public Severite getSeverite() {
        return severite;
    }

    public void setSeverite(Severite severite) {
        this.severite = severite;
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
