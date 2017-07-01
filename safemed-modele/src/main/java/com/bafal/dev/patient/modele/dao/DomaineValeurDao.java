package com.bafal.dev.patient.modele.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bafal.dev.patient.modele.entite.DomaineValeur;
import com.bafal.dev.patient.modele.entite.embeddable.DomaineValeurPK;

public interface DomaineValeurDao extends JpaRepository<DomaineValeur, DomaineValeurPK> {

	 List<DomaineValeur> findAllByIdCleDomaineOrderByOrdreTriAsc(String cleDomaine);
	 
	 List<DomaineValeur> findAllByIdCleDomaine(String cleDomaine);
	 
}
