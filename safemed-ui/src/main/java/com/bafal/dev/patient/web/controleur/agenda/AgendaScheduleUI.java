package com.bafal.dev.patient.web.controleur.agenda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;

@Controller
@RequestMapping(DmeURL.AGENDA_SCHEDULE)
public class AgendaScheduleUI {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String acceder(HttpServletRequest request, HttpServletResponse response, Model model) {
		return JspPage.AGENDA_SCHEDULE;
	}

	@RequestMapping(value = "scheduler", method = RequestMethod.GET)
	public String scheduleAgendaCreationRapide(HttpServletRequest request, HttpServletResponse response, Model model) {
		return JspPage.AGENDA_PATIENT;
	}

	@RequestMapping(value = "scheduler/copier", method = RequestMethod.GET)
	public String copierAgendaSemaineSurAutreSemaines(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		return JspPage.AGENDA_PATIENT;
	}

}
