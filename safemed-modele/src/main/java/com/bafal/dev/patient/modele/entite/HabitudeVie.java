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
import com.bafal.dev.patient.modele.base.enumeration.Dependance;
import com.bafal.dev.patient.modele.base.enumeration.Frequence;
import com.bafal.dev.patient.modele.base.enumeration.TypeHabitudeVie;

@Entity
@Table(name = "HABITUDE_VIE")
public class HabitudeVie extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = 8970734344818471737L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "TYPE_HABITUDE", length = 15)
    @Enumerated(EnumType.STRING)
    private TypeHabitudeVie type;

    @Column(name = "FREQUENCE", length = 10)
    @Enumerated(EnumType.STRING)
    private Frequence frequence;

    @Column(name = "DUREE")
    private String duree;

    @Column(name = "DEPENDANCE", length = 10)
    @Enumerated(EnumType.STRING)
    private Dependance dependance;

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

    public TypeHabitudeVie getType() {
        return type;
    }

    public void setType(TypeHabitudeVie type) {
        this.type = type;
    }

    public Frequence getFrequence() {
        return frequence;
    }

    public void setFrequence(Frequence frequence) {
        this.frequence = frequence;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Dependance getDependance() {
        return dependance;
    }

    public void setDependance(Dependance dependance) {
        this.dependance = dependance;
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
