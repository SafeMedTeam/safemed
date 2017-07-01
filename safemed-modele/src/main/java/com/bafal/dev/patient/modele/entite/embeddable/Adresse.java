package com.bafal.dev.patient.modele.entite.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

import com.bafal.dev.patient.modele.base.util.DmeConstante;

@Embeddable
public class Adresse {

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Column(name = "ADRESSE", length = 200)
    private String adresse;

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Column(name = "VILLE", length = 100)
    private String ville;

    @Column(name = "CODE_POSTAL", length = 15)
    private String codePostal;

    @Column(name = "PROVINCE", length = 50)
    private String province;

    @NotEmpty(message = DmeConstante.MANDATORY_FIELD)
    @Column(name = "PAYS", length = 100)
    private String pays;

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

}
