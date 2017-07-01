package com.bafal.dev.patient.modele.service;

import java.util.List;

import com.bafal.dev.patient.modele.entite.DomaineValeur;

public interface ServicePilotage {

	/**
	 * La cle du domaine de valeur des pays
	 */
	public static final String CLE_DOMAINE_PAYS = "PAYS";
	
	/**
	 * Retourne la liste des domaines de valeur PAYS 
	 * @return la liste des pays 
	 */
	List<DomaineValeur> getListePays();
	
	/**
	 * retourne la liste de domaines valeur dont la clé est passée en parametres
	 * @param cleDomaine la cle du domaine valeur 
	 * @return la liste s
	 */
	List<DomaineValeur> getListeDomaineValeur(String cleDomaine);
}
