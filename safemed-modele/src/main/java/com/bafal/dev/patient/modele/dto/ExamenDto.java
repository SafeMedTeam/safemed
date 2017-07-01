package com.bafal.dev.patient.modele.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class ExamenDto extends BaseDto {

	private String codeExamen;

    private String typeExamen;

	private String medecinPrescripteur;

	@DateTimeFormat(style = "dd/MM/yyyy HH:mm")
    private Date dateExamen;

    private String observations;

    private Double prixExamen;

	private Long idNote;

    private Long idLaboratoire;

	private String lieuRealisationExamen;


    public String getTypeExamen() {
        return typeExamen;
    }

    public void setTypeExamen(String typeExamen) {
        this.typeExamen = typeExamen;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Double getPrixExamen() {
        return prixExamen;
    }

    public void setPrixExamen(Double prixExamen) {
        this.prixExamen = prixExamen;
    }


	public String getCodeExamen() {
		return codeExamen;
	}

	public void setCodeExamen(String codeExamen) {
		this.codeExamen = codeExamen;
	}

	public String getMedecinPrescripteur() {
		return medecinPrescripteur;
	}

	public void setMedecinPrescripteur(String medecinPrescripteur) {
		this.medecinPrescripteur = medecinPrescripteur;
	}

	public Long getIdNote() {
		return idNote;
	}

	public void setIdNote(Long idNote) {
		this.idNote = idNote;
	}

	public String getLieuRealisationExamen() {
		return lieuRealisationExamen;
	}

	public void setLieuRealisationExamen(String lieuRealisationExamen) {
		this.lieuRealisationExamen = lieuRealisationExamen;
	}

	public Long getIdLaboratoire() {
        return idLaboratoire;
    }

    public void setIdLaboratoire(Long idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

}
