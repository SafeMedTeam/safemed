package com.bafal.dev.patient.modele.entite;

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
		+ "    Users.ID, " //
		+ "    Users.CIVILITE," //
		+ "    Users.PRENOM, " //
		+ "    Users.NOM," //
		+ "    Users.FONCTION, " //
		+ "     concat(if(Users.CIVILITE ='MR', 'M.', 'Mme'),' ', Users.PRENOM,' ', Users.NOM) AS NOM_COMPLET, " //
		+ "   Users.ID_SERVICE, " //
		+ "    (SELECT Service.NOM_SERVICE " //
		+ "        FROM safemed.SERVICE_MEDICAL Service " //
		+ "        WHERE Service.ID = Users.ID_SERVICE) AS NOM_SERVICE " //
		+ "FROM safemed.UTILISATEUR Users " //
		+ "ORDER BY Users.NOM " //
)
@Immutable
@Entity
public class UtilisateurJson extends BaseEntite {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3911737698660516794L;

	@Id
    @Column(name = "ID")
    private Long id;

	@Column(name = "FONCTION")
    private String fonction;

	@Column(name = "PRENOM")
    private String prenom;

	@Column(name = "NOM")
    private String nom;

	@Column(name = "CIVILITE")
    @Enumerated(EnumType.STRING)
    private Civilite civilite;

	@Column(name = "ID_SERVICE")
    Long idService;

	@Column(name = "NOM_SERVICE")
	private String nomService;

	@Column(name = "NOM_COMPLET")
	private String nomComplet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
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

	public Long getIdService() {
		return idService;
	}

	public void setIdService(Long idService) {
		this.idService = idService;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

}
