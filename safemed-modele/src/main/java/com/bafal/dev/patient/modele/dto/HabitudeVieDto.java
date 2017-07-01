package com.bafal.dev.patient.modele.dto;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.Dependance;
import com.bafal.dev.patient.modele.base.enumeration.Frequence;
import com.bafal.dev.patient.modele.base.enumeration.TypeHabitudeVie;

public class HabitudeVieDto extends BaseDto {

    private TypeHabitudeVie type;

    private Frequence frequence;

    private String duree;

    private Dependance dependance;

    private String note;

	private Long idDossier;

    public TypeHabitudeVie getType() {
        return type;
    }

    public void setType(TypeHabitudeVie type) {
        this.type = type;
    }

    public Frequence getFrequence() {
        return frequence;
    }

    public void setFrequence(Frequence frequence) {
        this.frequence = frequence;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Dependance getDependance() {
        return dependance;
    }

    public void setDependance(Dependance dependance) {
        this.dependance = dependance;
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
