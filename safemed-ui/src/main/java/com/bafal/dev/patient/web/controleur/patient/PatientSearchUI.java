package com.bafal.dev.patient.web.controleur.patient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.modele.filtre.PatientFiltre;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Controller
@Configurable
@RequestMapping(DmeURL.PATIENT_SEARCH)
public class PatientSearchUI extends BaseUI {

	private static final String PATIENT_SEARCH_SESSION_KEY = "patient_search_liste";

	@RequestMapping(value = DmeURL.LISTE, method = RequestMethod.GET)
	public String listerPatients(HttpServletRequest request, HttpServletResponse response, Model model) {

		model.addAttribute("filtrePatient", new PatientFiltre());
		request.getSession().setAttribute(PATIENT_SEARCH_SESSION_KEY,
				DmeCRUD.getServicePatient().rechercher(new PatientFiltre()));
		return JspPage.PATIENT_LISTE;
	}

	@RequestMapping(value = DmeURL.RESULTAT, method = RequestMethod.POST)
	public String createAccount(@ModelAttribute("filtrePatient") PatientFiltre filtre, HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute(PATIENT_SEARCH_SESSION_KEY, DmeCRUD.getServicePatient().rechercher(filtre));
		return JspPage.PATIENT_LISTE;
	}

}
