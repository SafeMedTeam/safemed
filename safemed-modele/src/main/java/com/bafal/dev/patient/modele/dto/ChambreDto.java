package com.bafal.dev.patient.modele.dto;

import java.math.BigDecimal;
import java.util.List;

import com.bafal.dev.patient.modele.base.dto.BaseDto;

public class ChambreDto extends BaseDto {

    private String codeChambre;

    private String categChambre;

    private String noChambre;

    private String localisation;

    private BigDecimal prixUnitaire;

    private Integer nombreLitTotal;

    private Integer nombreLitDisponible;

	private List<NoteCliniqueDto> notesCliniques;


    public String getCodeChambre() {
        return codeChambre;
    }

    public void setCodeChambre(String codeChambre) {
        this.codeChambre = codeChambre;
    }

    public String getCategChambre() {
        return categChambre;
    }

    public void setCategChambre(String categChambre) {
        this.categChambre = categChambre;
    }

    public String getNoChambre() {
        return noChambre;
    }

    public void setNoChambre(String noChambre) {
        this.noChambre = noChambre;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Integer getNombreLitTotal() {
        return nombreLitTotal;
    }

    public void setNombreLitTotal(Integer nombreLitTotal) {
        this.nombreLitTotal = nombreLitTotal;
    }

    public Integer getNombreLitDisponible() {
        return nombreLitDisponible;
    }

    public void setNombreLitDisponible(Integer nombreLitDisponible) {
        this.nombreLitDisponible = nombreLitDisponible;
    }

	public List<NoteCliniqueDto> getNotesCliniques() {
		return notesCliniques;
	}

	public void setNotesCliniques(List<NoteCliniqueDto> notesCliniques) {
		this.notesCliniques = notesCliniques;
	}


}
