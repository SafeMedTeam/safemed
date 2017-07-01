package com.bafal.dev.patient.modele.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.UniteTemperature;
import com.bafal.dev.patient.modele.base.util.DME;

public class SignesVitauxDto extends BaseDto {


    // pression = PS/PDias
    private Integer pressionSystolique;

    private Integer pressionDiastolique;

    private Double temperature;

    private UniteTemperature uniteTemperature;

    private Integer pulsation;

    private Double respiration;

    private Double taille;

    private Double poids;

    private Double imc;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date datePrise;

    private String note;

	private Long idNote;

    public Integer getPressionSystolique() {
        return pressionSystolique;
    }

    public void setPressionSystolique(Integer pressionSystolique) {
        this.pressionSystolique = pressionSystolique;
    }

    public Integer getPressionDiastolique() {
        return pressionDiastolique;
    }

    public void setPressionDiastolique(Integer pressionDiastolique) {
        this.pressionDiastolique = pressionDiastolique;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public UniteTemperature getUniteTemperature() {
        return uniteTemperature;
    }

    public void setUniteTemperature(UniteTemperature uniteTemperature) {
        this.uniteTemperature = uniteTemperature;
    }

    public Integer getPulsation() {
        return pulsation;
    }

    public void setPulsation(Integer pulsation) {
        this.pulsation = pulsation;
    }

    public Double getRespiration() {
        return respiration;
    }

    public void setRespiration(Double respiration) {
        this.respiration = respiration;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public Double getPoids() {
        return poids;
    }

    public void setPoids(Double poids) {
        this.poids = poids;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public Date getDatePrise() {
        return datePrise;
    }

    public void setDatePrise(Date datePrise) {
        this.datePrise = datePrise;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	/**
	 * Calcul de l'indice de masse corporelle. IMC
	 * 
	 * <pre>
	 * IMC = poids / Math.sqrt(taille (en m))
	 * </pre>
	 * 
	 * @return
	 */
    public Double calculerIMC() {
        if (DME.isNull(poids) || DME.isNull(taille)) {
            return null;
        }
        return poids / Math.sqrt(taille);
    }

}
