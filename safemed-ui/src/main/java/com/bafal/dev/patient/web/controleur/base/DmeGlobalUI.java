package com.bafal.dev.patient.web.controleur.base;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bafal.dev.patient.modele.base.exception.SafeMedFileNotFoundException;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.SafeMedSecurityUtils;

@ControllerAdvice
public class DmeGlobalUI {

	private static final String CURRENT_USER = "CURRENT_USER";

	@ModelAttribute(CURRENT_USER)
	public UtilisateurDto getDtoCurrent() {
		return DmeCRUD.getServiceUtilisateur().getUtilisateur(SafeMedSecurityUtils.getCurrentUser()).orElse(null);
	}

	@ExceptionHandler(SafeMedFileNotFoundException.class)
	public String handleSafeMedFileNotFoundException() {
		return "errors/404";
	}


}
