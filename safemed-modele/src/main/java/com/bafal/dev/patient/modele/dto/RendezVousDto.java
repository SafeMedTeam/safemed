package com.bafal.dev.patient.modele.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.StatutRV;
import com.bafal.dev.patient.modele.base.enumeration.TypeRendezVous;

public class RendezVousDto extends BaseDto {


    private String notesRv;

	private List<TypeRendezVous> typesRv;

    private String autreTypeRv;

    private boolean dejaPatient;

    private String prenom;

    private String nom;

    private String telephone;

    private String courriel;

	private Long idDossier;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date jour;

	@DateTimeFormat(pattern = "HH:mm")
	private Date heureDebut;

	@DateTimeFormat(pattern = "HH:mm")
	private Date heureFin;

	private Long duree;

	private Long idPlage;

	private String noConfirmation;

	private StatutRV statut;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatutRV getStatut() {
		return statut;
	}

	public void setStatut(StatutRV statut) {
		this.statut = statut;
	}

	public String getNoConfirmation() {
		return noConfirmation;
	}

	public void setNoConfirmation(String noConfirmation) {
		this.noConfirmation = noConfirmation;
	}

	public String getNotesRv() {
        return notesRv;
    }

    public void setNotesRv(String notesRv) {
        this.notesRv = notesRv;
    }

	public List<TypeRendezVous> getTypesRv() {
		return typesRv;
	}

	public void setTypesRv(List<TypeRendezVous> typesRv) {
		this.typesRv = typesRv;
	}

    public String getAutreTypeRv() {
        return autreTypeRv;
    }

    public void setAutreTypeRv(String autreTypeRv) {
        this.autreTypeRv = autreTypeRv;
    }

    public boolean isDejaPatient() {
        return dejaPatient;
    }

    public void setDejaPatient(boolean dejaPatient) {
        this.dejaPatient = dejaPatient;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	public Long getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(Long idDossier) {
		this.idDossier = idDossier;
	}


    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
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

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

	public Long getIdPlage() {
		return idPlage;
	}

	public void setIdPlage(Long idPlage) {
		this.idPlage = idPlage;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
}
