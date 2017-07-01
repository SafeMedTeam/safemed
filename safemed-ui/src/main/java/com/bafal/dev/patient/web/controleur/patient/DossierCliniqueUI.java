package com.bafal.dev.patient.web.controleur.patient;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;

@Configurable
@Controller
@RequestMapping(DmeURL.DSSR_CLINIQUE)
@SessionAttributes(DossierCliniqueUI.PATIENT_SESSION_KEY)
public class DossierCliniqueUI {

    public static final String PATIENT_SESSION_KEY = "patient";

	@RequestMapping(value = "note", method = RequestMethod.GET)
	public String note(Model model, HttpServletRequest request) {
		// model.addAttribute(PATIENT_SESSION_KEY, null);
		return JspPage.NOTE_CLINIQUE;
	}

    /**
	 * Permet d'afficher le nouveau formulaire patient
	 * 
	 * @param model
	 *            le modele
	 * @param request
	 *            la requete Http
	 * @param noDossier
	 *            le numero du dossier patient
	 * @return le nom du path Spring à afficher
	 */
	@RequestMapping(value = "{noDossier}")
	public String afficherSommaire(@PathVariable("noDossier") String noDossier, Model model,
			HttpServletRequest request) {
		model.addAttribute(PATIENT_SESSION_KEY, DmeCRUD.getServicePatient().getDossierPatient(noDossier));
		return JspPage.SOMMAIRE_CLINIQUE;
    }


}
