package com.bafal.dev.patient.web.commun.util;

import com.bafal.dev.patient.modele.dto.PatientDto;

public class UIVisibility {

	public static boolean showModeAjoutCaisse() {
        return Boolean.FALSE;
    }

	public static boolean showModeAjoutCorrespondant() {

        return Boolean.FALSE;
    }
	
	public static boolean canViewAdministration() {
        return Boolean.FALSE;
    }
	
	public static boolean canEditAdministration() {
        return Boolean.FALSE;
    }

	public static boolean showPatientModeEdition(PatientDto patient){
		return patient.isSerialized();
	}
}
