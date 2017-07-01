package com.bafal.dev.patient.modele.dto;

import java.util.Date;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class InfoSecuSocialeDto extends BaseDto {

    private String noSecuSociale;

    private String typeCaisse;


    private String nomCaisse;

    private String contratMutuelle;

    private boolean cmu;

    private Date dateEcheance;

    private Long idPatient;

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
