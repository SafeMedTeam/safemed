package com.bafal.dev.patient.modele.entite.embeddable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.enumeration.Civilite;
import com.bafal.dev.patient.modele.base.util.DmeConstante;

@Embeddable
public class Identite {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Size(min = 2, max = 100)
    @Column(name = "PRENOM", length = 100, nullable = false)
    private String prenom;

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Size(min = 2, max = 100)
    @Column(name = "NOM", length = 100, nullable = false)
    private String nom;

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Column(name = "TELEPHONE", length = 20)
    private String telephone;

    @Pattern(regexp = EMAIL_REGEX, message = DmeConstante.MSG_FORMAT_COURRIEL)
    @Column(name = "COURRIEL", unique = true, length = 50)
    private String courriel;

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Column(name = "CIVILITE", length = 10)
    @Enumerated(EnumType.STRING)
    private Civilite civilite;

    @Past(message = DmeConstante.MSG_PAST_DATE)
    @Column(name = "DATE_NAISS", nullable = true)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissance;

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

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

}
