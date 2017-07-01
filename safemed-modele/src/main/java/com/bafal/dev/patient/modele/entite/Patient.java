package com.bafal.dev.patient.modele.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.Civilite;
import com.bafal.dev.patient.modele.base.enumeration.StatutMatrimonial;
import com.bafal.dev.patient.modele.base.enumeration.TypePieceIdentite;

@Entity
@Table(name = "PATIENT")
public class Patient extends BaseEntite {

    private static final long serialVersionUID = -7956908318795185753L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MATRICULE", length = 255, unique = true, nullable = false)
	private String noDossier;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUT_MATRIMONIAL", length = 3)
    private StatutMatrimonial statutMatrimonial;

    @Column(name = "PRENOM_PERE", length = 50)
    private String prenomPere;

    @Column(name = "PRENOM_MERE", length = 50)
    private String prenomMere;

    @Column(name = "NOM_MERE", length = 50)
    private String nomMere;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE_PIECE_IDENTITE", length = 3)
    private TypePieceIdentite typePieceIdentite;

    @Column(name = "NUM_PIECE_IDENTITE", length = 20)
    private String numeroPieceIdentite;

    @Column(name = "PROFESSION", length = 100)
    private String profession;

	@Version
	@Column(name = "VERSION")
	private int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

    @Column(name = "ACTIF")
    private boolean actif;

    @Column(name = "PRENOM", length = 100, nullable = false)
    private String prenom;

    @Column(name = "NOM", length = 100, nullable = false)
    private String nom;

    @Column(name = "TELEPHONE", length = 20)
    private String telephone;

    @Column(name = "COURRIEL", unique = true, length = 50)
    private String courriel;

    @Column(name = "CIVILITE", length = 10)
    @Enumerated(EnumType.STRING)
    private Civilite civilite;

    @Column(name = "DATE_NAISS", nullable = true)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateNaissance;

    @Column(name = "ADRESSE", length = 200)
    private String adresse;

    @Column(name = "VILLE", length = 100)
    private String ville;

    @Column(name = "CODE_POSTAL", length = 15)
    private String codePostal;

    @Column(name = "PROVINCE", length = 50)
    private String province;

    @Column(name = "PAYS", length = 100)
    private String pays;


	@Column(name = "CREE_PAR", length = 100)
	private String creePar;

	@Column(name = "DATE_CREATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation;

	@Column(name = "MODIFIE_PAR", length = 100)
	private String modifiePar;

	@Column(name = "DATE_MODIF")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModification;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PATIENT")
	@Fetch(FetchMode.SUBSELECT)
	private List<PersonneContact> personnesContact;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PATIENT")
	@Fetch(FetchMode.SUBSELECT)
	private List<InfoSecuSociale> infoSecuSociales;



	public String getCreePar() {
		return creePar;
	}

	public void setCreePar(String creePar) {
		this.creePar = creePar;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getModifiePar() {
		return modifiePar;
	}

	public void setModifiePar(String modifiePar) {
		this.modifiePar = modifiePar;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

    @Override
    public Long getId() {
        return id;
    }


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

    public void setId(Long id) {
        this.id = id;
    }

	public List<PersonneContact> getPersonnesContact() {
		return personnesContact;
	}

	public void setPersonnesContact(List<PersonneContact> personnesContact) {
		this.personnesContact = personnesContact;
	}

	public List<InfoSecuSociale> getInfoSecuSociales() {
		return infoSecuSociales;
	}

	public void setInfoSecuSociales(List<InfoSecuSociale> infoSecuSociales) {
		this.infoSecuSociales = infoSecuSociales;
	}

}
