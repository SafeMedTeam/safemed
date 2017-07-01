package com.bafal.dev.patient.modele.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class MedicationDto extends BaseDto {

    private String nomMedicament;

	@DateTimeFormat(style = "dd/MM/yyyy")
    private Date dateDebut;

	@DateTimeFormat(style = "dd/MM/yyyy")
    private Date dateFin;

    private String efficacite;

    private String posologie;

    private String effetIndesirable;

    private String note;

	private Long idDossier;


    public String getNomMedicament() {
        return nomMedicament;
    }

    public void setNomMedicament(String nomMedicament) {
        this.nomMedicament = nomMedicament;
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

    public String getEfficacite() {
        return efficacite;
    }

    public void setEfficacite(String efficacite) {
        this.efficacite = efficacite;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public String getEffetIndesirable() {
        return effetIndesirable;
    }

    public void setEffetIndesirable(String effetIndesirable) {
        this.effetIndesirable = effetIndesirable;
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
