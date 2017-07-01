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

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;

@Entity
@Table(name = "INFO_SECU_SOCIALE")
public class InfoSecuSociale extends BaseEntite {

    private static final long serialVersionUID = 2313344065267834137L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "NO_SECU_SOCIALE", length = 20)
    private String noSecuSociale;

    @Column(name = "TYPE_CAISSE", length = 50)
    private String typeCaisse;

    @NotEmpty
    @Column(name = "NOM_CAISSE", length = 50)
    private String nomCaisse;

    @NotEmpty
    @Column(name = "CONTRAT", length = 50)
    private String contratMutuelle;

    @Column(name = "IND_CMU")
    private boolean cmu;

    @Column(name = "DATE_ECHEANCE_SECU")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateEcheance;

    @Column(name = "ID_PATIENT", insertable = false, updatable = false)
    private Long idPatient;

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

    public String getNoSecuSociale() {
        return noSecuSociale;
    }

    public void setNoSecuSociale(String noSecuSociale) {
        this.noSecuSociale = noSecuSociale;
    }

    public String getTypeCaisse() {
        return typeCaisse;
    }

    public void setTypeCaisse(String typeCaisse) {
        this.typeCaisse = typeCaisse;
    }

    public String getNomCaisse() {
        return nomCaisse;
    }

    public void setNomCaisse(String nomCaisse) {
        this.nomCaisse = nomCaisse;
    }

    public String getContratMutuelle() {
        return contratMutuelle;
    }

    public void setContratMutuelle(String contratMutuelle) {
        this.contratMutuelle = contratMutuelle;
    }

    public boolean isCmu() {
        return cmu;
    }

    public void setCmu(boolean cmu) {
        this.cmu = cmu;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
