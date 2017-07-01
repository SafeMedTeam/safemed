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

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.UniteTemperature;
import com.bafal.dev.patient.modele.base.util.DME;

@Entity
@Table(name = "SIGNES_VITAUX")
public class SignesVitaux extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = -8693530393904835512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "PRESSION_SYST", length = 3)
    // pression = PS/PDias
    private Integer pressionSystolique;

    @Column(name = "PRESSION_DIAST", length = 3)
    private Integer pressionDiastolique;

    @Column(name = "TEMPERATURE")
    private Double temperature;

    @Column(name = "UNITE_TEMPERATURE")
    @Enumerated(EnumType.STRING)
    private UniteTemperature uniteTemperature;

    @Column(name = "PULSATION")
    private Integer pulsation;

    @Column(name = "RESPIRATION")
    private Double respiration;

    @Column(name = "TAILLE", length = 3, scale = 2)
    private Double taille;

    @Column(name = "POIDS", length = 3, scale = 2)
    private Double poids;

    @Column(name = "IMC", scale = 2)
    private Double imc;

    @Column(name = "DATE_PRISE")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date datePrise;

    @Column(name = "NOTE", length = 500)
    private String note;

	@Column(name = "ID_NOTE", insertable = false, updatable = false)
	private Long idNote;

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

    public Integer getPressionSystolique() {
        return pressionSystolique;
    }

    public void setPressionSystolique(Integer pressionSystolique) {
        this.pressionSystolique = pressionSystolique;
    }

    public Integer getPressionDiastolique() {
        return pressionDiastolique;
    }

    public void setPressionDiastolique(Integer pressionDiastolique) {
        this.pressionDiastolique = pressionDiastolique;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public UniteTemperature getUniteTemperature() {
        return uniteTemperature;
    }

    public void setUniteTemperature(UniteTemperature uniteTemperature) {
        this.uniteTemperature = uniteTemperature;
    }

    public Integer getPulsation() {
        return pulsation;
    }

    public void setPulsation(Integer pulsation) {
        this.pulsation = pulsation;
    }

    public Double getRespiration() {
        return respiration;
    }

    public void setRespiration(Double respiration) {
        this.respiration = respiration;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public Date getDatePrise() {
        return datePrise;
    }

    public void setDatePrise(Date datePrise) {
        this.datePrise = datePrise;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	/**
	 * Calcul de l'indice de masse corporelle. IMC
	 * 
	 * <pre>
	 * IMC = poids / Math.sqrt(taille (en m))
	 * </pre>
	 * 
	 * @return
	 */
    public Double calculerIMC() {
        if (DME.isNull(poids) || DME.isNull(taille)) {
            return null;
        }
        return poids / Math.sqrt(taille);
    }

}
