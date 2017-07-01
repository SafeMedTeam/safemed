package com.bafal.dev.patient.modele.entite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.Civilite;

@Subselect("SELECT " //
		+ "    Pat.ID, " //
		+ "    Pat.CIVILITE," //
		+ "    Pat.PRENOM, " //
		+ "    Pat.NOM," //
		+ "    Pat.DATE_NAISS, " //
		+ "    Pat.MATRICULE, " //
		+ "    Pat.COURRIEL, " //
		+ "    Pat.TELEPHONE, " //
		+ "    concat(if(Pat.CIVILITE ='MR', 'M.', 'Mme'),' ', Pat.PRENOM,' ', Pat.NOM) AS NOM_COMPLET " //
		+ "FROM safemed.PATIENT Pat " //
		+ "ORDER BY Pat.NOM " //
)
@Immutable
@Entity
public class PatientJson extends BaseEntite {

	/**
	 * 
	 */
	private static final long serialVersionUID = -486269894717132123L;

	@Id
    @Column(name = "ID")
    private Long id;


	@Column(name = "PRENOM")
    private String prenom;

	@Column(name = "NOM")
    private String nom;

	@Column(name = "CIVILITE")
    @Enumerated(EnumType.STRING)
    private Civilite civilite;

	@Column(name = "MATRICULE")
	private String noDossier;

	@Column(name = "NOM_COMPLET")
	private String nomComplet;

	@Column(name = "COURRIEL")
	private String courriel;

	@Column(name = "TELEPHONE")
	private String telephone;

	@Column(name = "DATE_NAISS")
	private Date dateNaissance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getNoDossier() {
		return noDossier;
	}

	public void setNoDossier(String noDossier) {
		this.noDossier = noDossier;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


}
