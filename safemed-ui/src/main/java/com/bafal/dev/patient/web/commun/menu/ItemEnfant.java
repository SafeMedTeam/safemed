package com.bafal.dev.patient.web.commun.menu;

/**
 * Objet d'item du menu de la barre de navigation
 * 
 * @author bafall
 *
 */
public class ItemEnfant implements Comparable<ItemEnfant> {

    private int ordreTri;
    private String nom;
    private String url;
    private boolean active;
    private String cssClasse;

    public ItemEnfant() {
    }

    public int getOrdreTri() {
        return ordreTri;
    }

    public void setOrdreTri(int ordreTri) {
        this.ordreTri = ordreTri;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int compareTo(ItemEnfant menu) {
        return ordreTri - menu.getOrdreTri();
    }

    public String getCssClasse() {
        return cssClasse;
    }

    public void setCssClasse(String cssClasse) {
        this.cssClasse = cssClasse;
    }

}
