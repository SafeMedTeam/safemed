package com.bafal.dev.patient.modele.dto;

import java.util.ArrayList;
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
import com.bafal.dev.patient.modele.base.util.DmeConstante;
import com.bafal.dev.patient.modele.base.util.DME;

public class UtilisateurDto extends BaseDto {

	@NotNull(message = DmeConstante.MANDATORY_FIELD)
	private Civilite civilite;

	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
	@Size(min = 2, max = 100)
	private String nom;

	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
	@Size(min = 2, max = 100)
	private String prenom;

	private String motDePasse;

	private String confirmationMotDePasse;

	@Pattern(regexp = EMAIL_REGEX, message = DmeConstante.MSG_FORMAT_COURRIEL)
	@NotEmpty(message = DmeConstante.MANDATORY_FIELD)
	private String courriel;

	@Past(message = DmeConstante.MSG_PAST_DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateNaissance;

	private String codeUtilisateur;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateDebutActivite;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFinActivite;

    private String fonction;

    private boolean doitChangerMdp;

    private boolean profilComplet;

    private String telephone;

    private String adresse;

    private String ville;

    private String codePostal;

    private String province;

    private String pays;

	private Long idService;

	private List<NoteCliniqueDto> noteCliniques;

	private List<RoleDto> roles;

	private List<DmeTaskDto> taches;

	private String[] codeRoles;

	private String nomService;

    public UtilisateurDto() {
		roles = new ArrayList<>();
    }

	public String getCodeUtilisateur() {
		return codeUtilisateur;
	}

	public void setCodeUtilisateur(String codeUtilisateur) {
		this.codeUtilisateur = codeUtilisateur;
	}

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateDebutActivite() {
        return dateDebutActivite;
    }

    public void setDateDebutActivite(Date dateDebutActivite) {
        this.dateDebutActivite = dateDebutActivite;
    }

    public Date getDateFinActivite() {
        return dateFinActivite;
    }

    public void setDateFinActivite(Date dateFinActivite) {
        this.dateFinActivite = dateFinActivite;
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

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

	public List<NoteCliniqueDto> getNoteCliniques() {
		return noteCliniques;
	}

	public void setNoteCliniques(List<NoteCliniqueDto> noteCliniques) {
		this.noteCliniques = noteCliniques;
	}

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	public boolean isDoitChangerMdp() {
        return doitChangerMdp;
    }

    public void setDoitChangerMdp(boolean doitChangerMdp) {
        this.doitChangerMdp = doitChangerMdp;
    }

    public boolean isProfilComplet() {
        return profilComplet;
    }

    public void setProfilComplet(boolean profilComplet) {
        this.profilComplet = profilComplet;
    }

	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}

	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}

	public String getNomComplet() {
		StringBuilder builder = new StringBuilder();
		if (DME.isNotNull(civilite)) {
			builder.append(civilite.getNom());
		}
		if (DME.isNotBlank(prenom)) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(prenom);
		}
		if (DME.isNotBlank(nom)) {
			if (builder.length() > 0) {
				builder.append(" ");
			}
			builder.append(nom);
		}
		return builder.toString();
	}

	public List<DmeTaskDto> getTaches() {
		return taches;
	}

	public void setTaches(List<DmeTaskDto> taches) {
		this.taches = taches;
	}


	public String[] getCodeRoles() {
		return codeRoles;
	}

	public void setCodeRoles(String[] codeRoles) {
		this.codeRoles = codeRoles;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

}
