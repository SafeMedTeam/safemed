package com.bafal.dev.patient.modele.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentFamilialDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentObstetricalDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentPersonnelDto;

public class DossierPatientDto extends BaseDto {

	private String numeroDossier;

    private String observations;

	@DateTimeFormat(style = "dd/MM/yyyy HH:mm")
	private Date dateOuverture;

	private PatientDto patient;

	private List<NoteCliniqueDto> notesCliniques;

	private List<RendezVousDto> rendezVous;

	private List<AntecedentPersonnelDto> antecedents;

	private List<AntecedentFamilialDto> antecedentsFamiliaux;

	private List<AntecedentObstetricalDto> antecedentsObstetricaux;

	private List<AllergieDto> allergies;

	private List<HabitudeVieDto> habitudesVie;

	private List<MedicationDto> medications;

	public String getNumeroDossier() {
		return numeroDossier;
	}

	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public PatientDto getPatient() {
		return patient;
	}

	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}

	public List<NoteCliniqueDto> getNotesCliniques() {
		return notesCliniques;
	}

	public void setNotesCliniques(List<NoteCliniqueDto> notesCliniques) {
		this.notesCliniques = notesCliniques;
	}

	public List<RendezVousDto> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<RendezVousDto> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public List<AntecedentPersonnelDto> getAntecedents() {
		return antecedents;
	}

	public void setAntecedents(List<AntecedentPersonnelDto> antecedents) {
		this.antecedents = antecedents;
	}

	public List<AntecedentFamilialDto> getAntecedentsFamiliaux() {
		return antecedentsFamiliaux;
	}

	public void setAntecedentsFamiliaux(List<AntecedentFamilialDto> antecedentsFamiliaux) {
		this.antecedentsFamiliaux = antecedentsFamiliaux;
	}

	public List<AntecedentObstetricalDto> getAntecedentsObstetricaux() {
		return antecedentsObstetricaux;
	}

	public void setAntecedentsObstetricaux(List<AntecedentObstetricalDto> antecedentsObstetricaux) {
		this.antecedentsObstetricaux = antecedentsObstetricaux;
	}

	public List<AllergieDto> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<AllergieDto> allergies) {
		this.allergies = allergies;
	}

	public List<HabitudeVieDto> getHabitudesVie() {
		return habitudesVie;
	}

	public void setHabitudesVie(List<HabitudeVieDto> habitudesVie) {
		this.habitudesVie = habitudesVie;
	}

	public List<MedicationDto> getMedications() {
		return medications;
	}

	public void setMedications(List<MedicationDto> medications) {
		this.medications = medications;
	}

}
