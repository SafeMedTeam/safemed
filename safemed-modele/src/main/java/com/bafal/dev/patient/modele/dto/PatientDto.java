package com.bafal.dev.patient.modele.dto;

import java.time.Period;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.Civilite;
import com.bafal.dev.patient.modele.base.enumeration.StatutMatrimonial;
import com.bafal.dev.patient.modele.base.enumeration.TypePieceIdentite;
import com.bafal.dev.patient.modele.base.util.DmeConstante;
import com.bafal.dev.patient.modele.base.util.DME;

public class PatientDto extends BaseDto {

	private String noDossier;

    private StatutMatrimonial statutMatrimonial;

    private String prenomPere;

    private String prenomMere;

    private String nomMere;

    private TypePieceIdentite typePieceIdentite;

    private String numeroPieceIdentite;

    private String profession;

    private boolean actif;

	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
	@Size(min = 2, max = 100)
    private String prenom;

	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
	@Size(min = 2, max = 100)
    private String nom;

	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    private String telephone;

	@Pattern(regexp = EMAIL_REGEX, message = DmeConstante.MSG_FORMAT_COURRIEL)
    private String courriel;

	@NotNull(message = DmeConstante.MANDATORY_FIELD)
    private Civilite civilite;

	@Past(message = DmeConstante.MSG_PAST_DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissance;

    private String adresse;

    private String ville;

    private String codePostal;

    private String province;

    private String pays;

	private List<PersonneContactDto> personnesContact;

	private List<InfoSecuSocialeDto> infoSecuSociales;



	public String getNoDossier() {
		return noDossier;
	}

	public void setNoDossier(String noDossier) {
		this.noDossier = noDossier;
	}

	public StatutMatrimonial getStatutMatrimonial() {
        return statutMatrimonial;
    }

    public void setStatutMatrimonial(StatutMatrimonial statutMatrimonial) {
        this.statutMatrimonial = statutMatrimonial;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public String getPrenomMere() {
        return prenomMere;
    }

    public void setPrenomMere(String prenomMere) {
        this.prenomMere = prenomMere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public TypePieceIdentite getTypePieceIdentite() {
        return typePieceIdentite;
    }

    public void setTypePieceIdentite(TypePieceIdentite typePieceIdentite) {
        this.typePieceIdentite = typePieceIdentite;
    }

    public String getNumeroPieceIdentite() {
        return numeroPieceIdentite;
    }

    public void setNumeroPieceIdentite(String numeroPieceIdentite) {
        this.numeroPieceIdentite = numeroPieceIdentite;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
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

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }


	public Integer getAge() {
		if (getDateNaissance() != null) {
			return DME.getPeriode(getDateNaissance()).getYears();
		}
		return null;
	}

	public String getAgeAffichable() {
		Period periode = DME.getPeriode(getDateNaissance());

		if (periode == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder();

		if (periode.getMonths() >= 10) {
			builder.append("Bientôt ");
			builder.append(periode.getYears() + 1);
			builder.append(" ans");
		} else {
			if (periode.getYears() > 0) {
				builder.append(periode.getYears());
				builder.append(" ans ");
			}
			if (periode.getMonths() > 0) {
				builder.append(periode.getMonths());
				builder.append(" mois");
			}
		}
		return builder.toString();
	}

	public String getNomComplet() {
		StringBuilder builder = new StringBuilder();
		builder.append(prenom);
		builder.append(" ");
		builder.append(nom);
		return builder.toString();
	}

	public List<PersonneContactDto> getPersonnesContact() {
		return personnesContact;
	}

	public void setPersonnesContact(List<PersonneContactDto> personnesContact) {
		this.personnesContact = personnesContact;
	}

	public List<InfoSecuSocialeDto> getInfoSecuSociales() {
		return infoSecuSociales;
	}

	public void setInfoSecuSociales(List<InfoSecuSocialeDto> infoSecuSociales) {
		this.infoSecuSociales = infoSecuSociales;
	}

}
