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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import com.bafal.dev.patient.modele.base.entite.BaseEntite;
import com.bafal.dev.patient.modele.base.enumeration.Civilite;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur extends BaseEntite {

    private static final long serialVersionUID = -4053616422391926300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

	@Column(name = "CODE_UTILISATEUR", length = 255)
    private String codeUtilisateur;

    @Column(name = "MOT_DE_PASSE", length = 62, updatable = false)
    private String motDePasse;

    @Column(name = "DATE_DEBUT_ACTIF")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateDebutActivite;

    @Column(name = "DATE_FIN_ACTIF")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFinActivite;

    @Column(name = "FONCTION", length = 100)
    private String fonction;

    @Column(name = "DOIT_CHANGER_MDP")
    private boolean doitChangerMdp;

    @Column(name = "PROFIL_COMPLET")
    private boolean profilComplet;

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

    @Column(name = "ID_SERVICE", insertable = false, updatable = false)
    Long idService;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERS_MED")
    @Fetch(FetchMode.SUBSELECT)
	private List<NoteClinique> noteCliniques;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_ASSIGNE")
	@Fetch(FetchMode.SUBSELECT)
	private List<DmeTask> taches;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLE_PAR_USER", joinColumns = @JoinColumn(name = "UTILISATEUR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
	private List<Role> roles;

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
	
	@Formula(" (SELECT se.NOM_SERVICE FROM safemed.SERVICE_MEDICAL se WHERE se.ID = ID_SERVICE) ")
	private String nomService;

	@Version
	@Column(name = "VERSION")
	private int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

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

    public Utilisateur() {
    }

    @Override
    public Long getId() {
        return id;
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


	public List<NoteClinique> getNoteCliniques() {
		return noteCliniques;
	}

	public void setNoteCliniques(List<NoteClinique> noteCliniques) {
		this.noteCliniques = noteCliniques;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
        this.id = id;
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

	public List<DmeTask> getTaches() {
		return taches;
	}

	public void setTaches(List<DmeTask> taches) {
		this.taches = taches;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

}
