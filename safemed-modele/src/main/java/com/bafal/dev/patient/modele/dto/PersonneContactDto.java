package com.bafal.dev.patient.modele.dto;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.Civilite;
import com.bafal.dev.patient.modele.base.enumeration.LienParente;


public class PersonneContactDto extends BaseDto {

    private String prenom;

    private String nom;

    private String telephone;

    private String courriel;

    private Civilite civilite;

    private Long idPatient;

    private LienParente lienParente;

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

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
    }


    public LienParente getLienParente() {
        return lienParente;
    }

    public void setLienParente(LienParente lienParente) {
        this.lienParente = lienParente;
    }

}
