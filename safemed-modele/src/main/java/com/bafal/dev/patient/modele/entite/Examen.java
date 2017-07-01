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

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;

@Entity
@Table(name = "EXAMEN")
public class Examen extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = 9090281403790104820L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

	@Column(name = "CODE_EXAMEN", length = 50)
	private String codeExamen;

    @Column(name = "TYPE_EXAMEN", length = 50)
    private String typeExamen;

	@Column(name = "PRESCRIPTEUR", length = 150)
	private String medecinPrescripteur;

    @Column(name = "DATE_EXAMEN")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dateExamen;

    @Column(name = "OBSERVATIONS", length = 500)
    private String observations;

    @Column(name = "PRIX_EXAMEN", scale = 2)
    private Double prixExamen;

	@Column(name = "ID_NOTE", insertable = false, updatable = false)
	private Long idNote;

    @Column(name = "ID_LABO", insertable = false, updatable = false)
    private Long idLaboratoire;

	@Column(name = "LIEU_EXAMEN", length = 150)
	private String lieuRealisationExamen;

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

    public String getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(String typeExamen) {
        this.typeExamen = typeExamen;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Double getPrixExamen() {
        return prixExamen;
    }

    public void setPrixExamen(Double prixExamen) {
        this.prixExamen = prixExamen;
    }


	public String getCodeExamen() {
		return codeExamen;
	}

	public void setCodeExamen(String codeExamen) {
		this.codeExamen = codeExamen;
	}

	public String getMedecinPrescripteur() {
		return medecinPrescripteur;
	}

	public void setMedecinPrescripteur(String medecinPrescripteur) {
		this.medecinPrescripteur = medecinPrescripteur;
	}

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	public String getLieuRealisationExamen() {
		return lieuRealisationExamen;
	}

	public void setLieuRealisationExamen(String lieuRealisationExamen) {
		this.lieuRealisationExamen = lieuRealisationExamen;
	}

	public Long getIdLaboratoire() {
        return idLaboratoire;
    }

    public void setIdLaboratoire(Long idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
