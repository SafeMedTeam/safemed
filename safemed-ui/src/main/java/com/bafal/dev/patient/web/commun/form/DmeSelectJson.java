package com.bafal.dev.patient.web.commun.form;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.util.DME;

/**
 * Classe Json pour les Remote Select Recherche utilisateurs ou Patients par
 * motCle et populer Input associe
 * 
 * @author bfall
 *
 */
public class DmeSelectJson implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<? extends BaseDto> liste = new ArrayList<>();

	private int total;

	public List<? extends BaseDto> getListe() {
		return liste;
	}

	public void setListe(List<? extends BaseDto> liste) {
		this.liste = liste;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public static DmeSelectJson build(List<? extends BaseDto> listeJson) {
		DmeSelectJson select = new DmeSelectJson();
		select.setListe(listeJson);
		select.setTotal(DME.isEmpty(listeJson) ? 0 : listeJson.size());
		return select;
	}

}
