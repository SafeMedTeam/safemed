package com.bafal.dev.patient.modele.dto;

import java.util.Arrays;
import java.util.Date;

import com.bafal.dev.patient.modele.base.dto.BaseDto;


public class FichierDto extends BaseDto {

    private String nomFichier;

    private byte[] fichier;

    private Double volume;

    private Date dateAjout;

    private String note;

	private Long idNote;

    public String getNomFichier() {
        return nomFichier;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public byte[] getFichier() {
        return fichier;
    }

	public void setFichier(byte[] nouveauFichier) {
		if (nouveauFichier == null) {
			this.fichier = new byte[0];
		} else {
			this.fichier = Arrays.copyOf(nouveauFichier, nouveauFichier.length);
		}
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
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

}
