package com.bafal.dev.patient.modele.filtre;

import java.util.Date;

import com.bafal.dev.patient.modele.base.annotation.FiltreBetweenDebut;
import com.bafal.dev.patient.modele.base.annotation.FiltreBetweenFin;
import com.bafal.dev.patient.modele.base.annotation.FiltreDefaut;
import com.bafal.dev.patient.modele.base.annotation.FiltreLike;
import com.bafal.dev.patient.modele.base.annotation.Wildcard;
import com.bafal.dev.patient.modele.base.enumeration.StringTypeComparaison;
import com.bafal.dev.patient.modele.base.enumeration.WildcardLocation;
import com.bafal.dev.patient.modele.base.filtre.BaseFiltre;

public class PatientFiltre extends BaseFiltre {

    private static final long serialVersionUID = -711514177677136956L;

    @FiltreDefaut
    private Long id;

	@FiltreLike(field = "noDossier", stringComparaisonType = StringTypeComparaison.LIKE)
	@Wildcard(location = WildcardLocation.FIN)
	private String noDossier;

	@FiltreLike(field = "prenom", stringComparaisonType = StringTypeComparaison.LIKE)
	@Wildcard(location = WildcardLocation.DEBUT_FIN)
    private String prenom;

	@FiltreLike(field = "nom", stringComparaisonType = StringTypeComparaison.LIKE)
	@Wildcard(location = WildcardLocation.DEBUT_FIN)
    private String nom;

    @FiltreDefaut
    private String telephone;

    @FiltreDefaut
    private String adresse;

    @FiltreDefaut
    private String codePostal;

    @FiltreDefaut
    private String civilite;

    @FiltreDefaut
    private String ville;

    private Date dateNaissance;

    @FiltreBetweenDebut(fieldDebut = "dateCreation")
    private Date dateDebut;

    @FiltreBetweenFin(fieldFin = "dateCreation")
    private Date dateFin;

    @FiltreDefaut
    private String courriel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNoDossier() {
		return noDossier;
	}

	public void setNoDossier(String noDossier) {
		this.noDossier = noDossier;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
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

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

}
