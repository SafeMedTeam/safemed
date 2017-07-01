package com.bafal.dev.patient.modele.entite.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DomaineValeurPK implements Serializable{

	private static final long serialVersionUID = 7784321911337066786L;
	
	@Column(name="DOM_CLE", length=50)
	private String cleDomaine;
	@Column(name="VALEUR", length=50)
	private String valeur;
	
	public DomaineValeurPK(){
		super();
	}
	
	public DomaineValeurPK(String cleDomaine, String valeur) {
		super();
		this.cleDomaine = cleDomaine;
		this.valeur = valeur;
	}
	
	public String getCleDomaine() {
		return cleDomaine;
	}
	public void setCleDomaine(String cleDomaine) {
		this.cleDomaine = cleDomaine;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}	

}
