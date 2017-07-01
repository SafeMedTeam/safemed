package com.bafal.dev.patient.modele.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.StatutNote;
import com.bafal.dev.patient.modele.base.enumeration.TypeNoteClinique;

@Entity
@Table(name = "NOTE_CLINIQUE")
public class NoteClinique extends BaseEntite {

    /**
     * 
     */
	private static final long serialVersionUID = 5587764877381427563L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

	@Column(name = "TYPE_NOTE", length = 20)
    @Enumerated(EnumType.STRING)
	private TypeNoteClinique type;

	@Column(name = "STATUT", length = 20)
    @Enumerated(EnumType.STRING)
	private StatutNote statut;

	@Column(name = "RAISON_VISITE", length = 100)
	private String raisonVisite;

    @Column(name = "HISTOIRE_MALADIE", length = 500)
    private String histoireMaladie;

	@Column(name = "DETAIL_CONSULTATION", length = 700)
	private String detailConsultation;

	@Column(name = "EXAMEN_PHYSIQUE", length = 700)
	private String examenPhysique;

    @Column(name = "CONCLUSION", length = 500)
    private String conclusion;

    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;

    @Column(name = "DATE_FIN")
	@Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;

	@Column(name = "ID_DOSSIER", insertable = false, updatable = false)
	private Long idDossier;

    @Column(name = "ID_PERS_MED", insertable = false, updatable = false)
    private Long idPersonnelMedical;

    @Column(name = "ID_CHAMBRE", insertable = false, updatable = false)
    private Long idChambre;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NOTE", nullable = false)
	@Fetch(FetchMode.SUBSELECT)
	@OrderBy("id DESC")
	private List<SignesVitaux> signesVitaux;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VISITE", nullable = false)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id DESC")
    private List<Examen> examens;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NOTE", nullable = false)
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("id DESC")
    private List<Fichier> fichiers;

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

	public String getDetailConsultation() {
		return detailConsultation;
	}

	public void setDetailConsultation(String detailConsultation) {
		this.detailConsultation = detailConsultation;
	}

	public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}

	public Long getIdPersonnelMedical() {
        return idPersonnelMedical;
    }

    public void setIdPersonnelMedical(Long idPersonnelMedical) {
        this.idPersonnelMedical = idPersonnelMedical;
    }

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public List<Examen> getExamens() {
        return examens;
    }

    public void setExamens(List<Examen> examens) {
        this.examens = examens;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public StatutNote getStatut() {
		return statut;
    }

	public void setStatut(StatutNote statut) {
		this.statut = statut;
    }

    public String getHistoireMaladie() {
        return histoireMaladie;
    }

    public void setHistoireMaladie(String histoireMaladie) {
        this.histoireMaladie = histoireMaladie;
    }

	public List<SignesVitaux> getSignesVitaux() {
        return signesVitaux;
    }

	public void setSignesVitaux(List<SignesVitaux> signesVitaux) {
        this.signesVitaux = signesVitaux;
    }

    public List<Fichier> getFichiers() {
        return fichiers;
    }

    public void setFichiers(List<Fichier> fichiers) {
        this.fichiers = fichiers;
    }

	public TypeNoteClinique getType() {
		return type;
	}

	public void setType(TypeNoteClinique type) {
		this.type = type;
	}

	public String getRaisonVisite() {
		return raisonVisite;
	}

	public void setRaisonVisite(String raisonVisite) {
		this.raisonVisite = raisonVisite;
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

	public String getExamenPhysique() {
		return examenPhysique;
	}

	public void setExamenPhysique(String examenPhysique) {
		this.examenPhysique = examenPhysique;
	}

}
