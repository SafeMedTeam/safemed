package com.bafal.dev.patient.modele.entite;

import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;

@Entity
@Table(name = "CHAMBRE")
public class Chambre extends BaseEntite {

    /**
     * 
     */
    private static final long serialVersionUID = 7227151159160847327L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "CODE_CHAMBRE", length = 50, unique = true, nullable = false)
    private String codeChambre;

    @Column(name = "CATEG_CHAMBRE", length = 50)
    private String categChambre;

    @Column(name = "NO_CHAMBRE", length = 10)
    private String noChambre;

    @Column(name = "LOCALISATION", length = 100)
    private String localisation;

    @Column(name = "PRIX_CHAMBRE", scale = 2)
    private BigDecimal prixUnitaire;

    @Column(name = "NB_LIT_TOTAL")
    private Integer nombreLitTotal;

    @Column(name = "NB_LIT_DISPO")
    private Integer nombreLitDisponible;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CHAMBRE", nullable = false)
    @Fetch(FetchMode.SUBSELECT)
	private List<NoteClinique> notesCliniques;

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

    public String getCodeChambre() {
        return codeChambre;
    }

    public void setCodeChambre(String codeChambre) {
        this.codeChambre = codeChambre;
    }

    public String getCategChambre() {
        return categChambre;
    }

    public void setCategChambre(String categChambre) {
        this.categChambre = categChambre;
    }

    public String getNoChambre() {
        return noChambre;
    }

    public void setNoChambre(String noChambre) {
        this.noChambre = noChambre;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Integer getNombreLitTotal() {
        return nombreLitTotal;
    }

    public void setNombreLitTotal(Integer nombreLitTotal) {
        this.nombreLitTotal = nombreLitTotal;
    }

    public Integer getNombreLitDisponible() {
        return nombreLitDisponible;
    }

    public void setNombreLitDisponible(Integer nombreLitDisponible) {
        this.nombreLitDisponible = nombreLitDisponible;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public List<NoteClinique> getNotesCliniques() {
		return notesCliniques;
	}

	public void setNotesCliniques(List<NoteClinique> notesCliniques) {
		this.notesCliniques = notesCliniques;
	}

}
