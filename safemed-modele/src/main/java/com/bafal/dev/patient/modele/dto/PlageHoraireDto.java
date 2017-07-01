package com.bafal.dev.patient.modele.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.StatutPlageHoraire;

public class PlageHoraireDto extends BaseDto {

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date jour;

	@DateTimeFormat(pattern = "HH:mm")
	private Date heureDebut;

	@DateTimeFormat(pattern = "HH:mm")
	private Date heureFin;

	private boolean actif;

	private StatutPlageHoraire statut;

    private String informations;

	private Long idAgenda;

	private List<RendezVousDto> rendezVous;

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public StatutPlageHoraire getStatut() {
		return statut;
	}

	public void setStatut(StatutPlageHoraire statut) {
		this.statut = statut;
	}

	public String getInformations() {
        return informations;
    }

    public void setInformations(String informations) {
        this.informations = informations;
    }

	public Long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Date getJour() {
		return jour;
	}

	public void setJour(Date jour) {
		this.jour = jour;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public List<RendezVousDto> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVousDto> rendezVous) {
		this.rendezVous = rendezVous;
	}

}
