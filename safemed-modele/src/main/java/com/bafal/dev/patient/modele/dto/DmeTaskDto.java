package com.bafal.dev.patient.modele.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.PrioriteTask;
import com.bafal.dev.patient.modele.base.enumeration.StatutTask;
import com.bafal.dev.patient.modele.base.util.DmeConstante;

public class DmeTaskDto extends BaseDto {

	private Long idAssignateur;

	@NotNull(message = DmeConstante.MANDATORY_FIELD)
	private Long idAssigne;

	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
	private String sujet;

	private String description;

	private StatutTask statut;

	private PrioriteTask priorite;

	private Integer pourcentageComplete;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dateDebut;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dateEcheance;

	public Long getIdAssignateur() {
		return idAssignateur;
	}

	public void setIdAssignateur(Long idAssignateur) {
		this.idAssignateur = idAssignateur;
	}

	public Long getIdAssigne() {
		return idAssigne;
	}

	public void setIdAssigne(Long idAssigne) {
		this.idAssigne = idAssigne;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatutTask getStatut() {
		return statut;
	}

	public void setStatut(StatutTask statut) {
		this.statut = statut;
	}

	public PrioriteTask getPriorite() {
		return priorite;
	}

	public void setPriorite(PrioriteTask priorite) {
		this.priorite = priorite;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public Integer getPourcentageComplete() {
		return pourcentageComplete;
	}

	public void setPourcentageComplete(Integer pourcentageComplete) {
		this.pourcentageComplete = pourcentageComplete;
	}

	public static DmeTaskDto build() {
		DmeTaskDto dto = new DmeTaskDto();
		dto.setStatut(StatutTask.PAS_COMMENCE);
		dto.setPriorite(PrioriteTask.NORMAL);
		dto.setPourcentageComplete(Integer.valueOf(0));
		return dto;
	}

}
