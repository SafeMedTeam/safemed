package com.bafal.dev.patient.web.controleur.agenda;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bafal.dev.patient.modele.dto.PlageHoraireDto;
import com.bafal.dev.patient.web.commun.form.json.PlageHoraireJson;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.commun.util.SafeMedUtils;

@Controller
@RequestMapping(DmeURL.AGENDA)
public class AgendaUI {

	@RequestMapping(value = { "", "rv" }, method = RequestMethod.GET)
	public String acceder(HttpServletRequest request, HttpServletResponse response, Model model) {
		return JspPage.AGENDA;
	}

	@RequestMapping(value = "patient", method = RequestMethod.GET)
	public String agendaPatient(HttpServletRequest request, HttpServletResponse response, Model model) {
		return JspPage.AGENDA_PATIENT;
	}

	@RequestMapping(value = "json/plages", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<PlageHoraireJson> loadClassesJson(HttpServletRequest request) {
		return SafeMedUtils.toJson(new ArrayList<PlageHoraireDto>());
	}

	@RequestMapping(value = "patient/{noDossier}")
	public String editer(@PathVariable("noDossier") String noDossier, Model model, HttpServletRequest request) {
		return JspPage.PATIENT_FORM;
	}

}
