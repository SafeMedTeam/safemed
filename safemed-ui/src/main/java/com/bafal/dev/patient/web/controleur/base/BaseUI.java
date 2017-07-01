package com.bafal.dev.patient.web.controleur.base;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.web.commun.util.SafeMedSecurityUtils;

public abstract class BaseUI {

	public static final String REDIRECT = "redirect:";

	public static final String SESSION_PATIENT_KEY = "patient";
	public static final String SESSION_DOSSIER_KEY = "dossier";
	public static final String SESSION_PERSONNEL_KEY = "personnel";
	public static final String SESSION_RV_KEY = "rv";
	public static final String SESSION_NOTE_KEY = "note";

	public static final String APP_JSON = "application/json";


	/**
	 * Mettre a jour les informations d'audit
	 * 
	 * @param dto
	 *            le dto
	 */
	public void setAuditInfos(BaseDto dto) {
		if (dto.isSerialized()) {
			dto.setDateModification(DME.now());
			dto.setModifiePar(SafeMedSecurityUtils.getCurrentUser());
		} else {
			dto.setDateCreation(DME.now());
			dto.setCreePar(SafeMedSecurityUtils.getCurrentUser());
		}
	}

}
