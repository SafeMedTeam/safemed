package com.bafal.dev.patient.modele.entite;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import com.bafal.dev.patient.modele.entite.embeddable.DomaineValeurPK;

@Configurable
@Entity
@Table(name = "DOMAINE_VALEUR")
public class DomaineValeur {

    @EmbeddedId
    private DomaineValeurPK id;
    @Column(name = "ORDRE_TRI")
    private Integer ordreTri;
    @Column(name = "CODE")
    private Integer code;
    @Column(name = "VALEUR_AUTRE", length = 50)
    private String autreValeur;
    @Column(name = "DESCRIPTION_FR", length = 300)
    private String descriptionFrancais;
    @Column(name = "DESCRIPTION_EN", length = 300)
    private String descriptionAnglais;

    public DomaineValeurPK getId() {
        return id;
    }

    public void setId(DomaineValeurPK id) {
        this.id = id;
    }

    public Integer getOrdreTri() {
        return ordreTri;
    }

    public void setOrdreTri(Integer ordreTri) {
        this.ordreTri = ordreTri;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getAutreValeur() {
        return autreValeur;
    }

    public void setAutreValeur(String autreValeur) {
        this.autreValeur = autreValeur;
    }

    public String getDescriptionFrancais() {
        return descriptionFrancais;
    }

    public void setDescriptionFrancais(String descriptionFrancais) {
        this.descriptionFrancais = descriptionFrancais;
    }

    public String getDescriptionAnglais() {
        return descriptionAnglais;
    }

    public void setDescriptionAnglais(String descriptionAnglais) {
        this.descriptionAnglais = descriptionAnglais;
    }

}
