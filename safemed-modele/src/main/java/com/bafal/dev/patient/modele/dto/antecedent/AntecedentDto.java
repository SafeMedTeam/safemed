package com.bafal.dev.patient.modele.dto.antecedent;

import java.util.Date;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.LienParente;
import com.bafal.dev.patient.modele.base.enumeration.Sexe;
import com.bafal.dev.patient.modele.base.enumeration.TypeAntecedent;
import com.bafal.dev.patient.modele.base.enumeration.TypeChirurgie;
import com.bafal.dev.patient.modele.base.enumeration.TypeMaladie;

public class AntecedentDto extends BaseDto {

    private TypeAntecedent type;

    private TypeMaladie maladie;

    private String maladieAutre;

    private Date dateApparition;

    private Date dateResolution;

    private boolean stabilite;

    private boolean traite;

    private boolean hospitalisation;

    // FAMILIAUX

    private String personne;

    private LienParente lienParente;

    // GROSSESSE

    private Date dateNaissanceEnfant;

    private Sexe sexe;

    private String santeEnfant;

    private String histoireGrossesseAccouchement;

    // CHIRURGIE

    private TypeChirurgie typeChirurgie;

    private String chirurgieAutre;

    private Date dateChirurgie;

    private String raison;

    private String sequelles;

    private String hopitalOuChirurgien;

    // COMMUN

    private String note;

	private Long idDossier;


    public TypeAntecedent getType() {
        return type;
    }

    public void setType(TypeAntecedent type) {
        this.type = type;
    }

    public TypeMaladie getMaladie() {
        return maladie;
    }

    public void setMaladie(TypeMaladie maladie) {
        this.maladie = maladie;
    }

    public String getMaladieAutre() {
        return maladieAutre;
    }

    public void setMaladieAutre(String maladieAutre) {
        this.maladieAutre = maladieAutre;
    }

    public Date getDateApparition() {
        return dateApparition;
    }

    public void setDateApparition(Date dateApparition) {
        this.dateApparition = dateApparition;
    }

    public Date getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(Date dateResolution) {
        this.dateResolution = dateResolution;
    }

    public boolean isStabilite() {
        return stabilite;
    }

    public void setStabilite(boolean stabilite) {
        this.stabilite = stabilite;
    }

    public boolean isTraite() {
        return traite;
    }

    public void setTraite(boolean traite) {
        this.traite = traite;
    }

    public boolean isHospitalisation() {
        return hospitalisation;
    }

    public void setHospitalisation(boolean hospitalisation) {
        this.hospitalisation = hospitalisation;
    }

    public String getPersonne() {
        return personne;
    }

    public void setPersonne(String personne) {
        this.personne = personne;
    }

    public LienParente getLienParente() {
        return lienParente;
    }

    public void setLienParente(LienParente lienParente) {
        this.lienParente = lienParente;
    }

    public Date getDateNaissanceEnfant() {
        return dateNaissanceEnfant;
    }

    public void setDateNaissanceEnfant(Date dateNaissanceEnfant) {
        this.dateNaissanceEnfant = dateNaissanceEnfant;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getSanteEnfant() {
        return santeEnfant;
    }

    public void setSanteEnfant(String santeEnfant) {
        this.santeEnfant = santeEnfant;
    }

    public String getHistoireGrossesseAccouchement() {
        return histoireGrossesseAccouchement;
    }

    public void setHistoireGrossesseAccouchement(String histoireGrossesseAccouchement) {
        this.histoireGrossesseAccouchement = histoireGrossesseAccouchement;
    }

    public TypeChirurgie getTypeChirurgie() {
        return typeChirurgie;
    }

    public void setTypeChirurgie(TypeChirurgie typeChirurgie) {
        this.typeChirurgie = typeChirurgie;
    }

    public String getChirurgieAutre() {
        return chirurgieAutre;
    }

    public void setChirurgieAutre(String chirurgieAutre) {
        this.chirurgieAutre = chirurgieAutre;
    }

    public Date getDateChirurgie() {
        return dateChirurgie;
    }

    public void setDateChirurgie(Date dateChirurgie) {
        this.dateChirurgie = dateChirurgie;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public String getSequelles() {
        return sequelles;
    }

    public void setSequelles(String sequelles) {
        this.sequelles = sequelles;
    }

    public String getHopitalOuChirurgien() {
        return hopitalOuChirurgien;
    }

    public void setHopitalOuChirurgien(String hopitalOuChirurgien) {
        this.hopitalOuChirurgien = hopitalOuChirurgien;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}



}
