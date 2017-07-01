package com.bafal.dev.patient.modele.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.StatutNote;
import com.bafal.dev.patient.modele.base.enumeration.TypeNoteClinique;

public class NoteCliniqueDto extends BaseDto {

	private TypeNoteClinique type;

	private StatutNote statut;

	private String raisonVisite;

    private String histoireMaladie;

	private String detailConsultation;

	private String examenPhysique;

    private String conclusion;

	@DateTimeFormat(style = "dd/MM/yyyy HH:mm")
    private Date dateDebut;

	@DateTimeFormat(style = "dd/MM/yyyy HH:mm")
    private Date dateFin;

	private Long idDossier;

    private Long idPersonnelMedical;

    private Long idChambre;

	private List<SignesVitauxDto> signesVitaux;

    private List<ExamenDto> examens;

    private List<FichierDto> fichiers;

	public String getDetailConsultation() {
		return detailConsultation;
	}

	public void setDetailConsultation(String detailConsultation) {
		this.detailConsultation = detailConsultation;
	}

	public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
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

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}

	public Long getIdPersonnelMedical() {
        return idPersonnelMedical;
    }

    public void setIdPersonnelMedical(Long idPersonnelMedical) {
        this.idPersonnelMedical = idPersonnelMedical;
    }

    public Long getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public List<ExamenDto> getExamens() {
        return examens;
    }

    public void setExamens(List<ExamenDto> examens) {
        this.examens = examens;
    }

	public StatutNote getStatut() {
		return statut;
    }

	public void setStatut(StatutNote statut) {
		this.statut = statut;
    }

    public String getHistoireMaladie() {
        return histoireMaladie;
    }

    public void setHistoireMaladie(String histoireMaladie) {
        this.histoireMaladie = histoireMaladie;
    }

	public List<SignesVitauxDto> getSignesVitaux() {
        return signesVitaux;
    }

	public void setSignesVitaux(List<SignesVitauxDto> signesVitaux) {
        this.signesVitaux = signesVitaux;
    }

    public List<FichierDto> getFichiers() {
        return fichiers;
    }

    public void setFichiers(List<FichierDto> fichiers) {
        this.fichiers = fichiers;
    }

	public TypeNoteClinique getType() {
		return type;
	}

	public void setType(TypeNoteClinique type) {
		this.type = type;
	}

	public String getRaisonVisite() {
		return raisonVisite;
	}

	public void setRaisonVisite(String raisonVisite) {
		this.raisonVisite = raisonVisite;
	}

	public String getExamenPhysique() {
		return examenPhysique;
	}

	public void setExamenPhysique(String examenPhysique) {
		this.examenPhysique = examenPhysique;
	}

}
