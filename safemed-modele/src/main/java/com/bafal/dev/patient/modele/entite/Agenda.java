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

import com.bafal.dev.patient.modele.base.entite.BaseEntite;

@Entity
@Table(name = "AGENDA")
public class Agenda extends BaseEntite {



	/**
	 * 
	 */
	private static final long serialVersionUID = 8427608703330889205L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

	@Column(name = "NOM", length = 100)
	private String nom;



	@JoinColumn(name = "ID_UTILISATEUR", nullable = false)
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	private Utilisateur utilisateur;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_AGENDA")
	@Fetch(FetchMode.SUBSELECT)
	private List<PlageHoraire> plagesHoraires;

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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<PlageHoraire> getPlagesHoraires() {
		return plagesHoraires;
	}

	public void setPlagesHoraires(List<PlageHoraire> plagesHoraires) {
		this.plagesHoraires = plagesHoraires;
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
