package com.bafal.dev.patient.web.controleur.agenda;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bafal.dev.patient.modele.base.enumeration.StatutRV;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.base.util.DmeConstante;
import com.bafal.dev.patient.modele.dto.RendezVousDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Controller
@RequestMapping(DmeURL.AGENDA_SCHEDULE_RV)
@SessionAttributes(AgendaRvUI.RV_SESSION_KEY)
public class AgendaRvUI extends BaseUI {

	public static final String RV_SESSION_KEY = "rv";


	@RequestMapping(value = DmeURL.FORM)
	public String afficher(@RequestParam String debut, @RequestParam String fin, Model model,
			HttpServletRequest request) {
		RendezVousDto dto = new RendezVousDto();
		Date dateDebut = DME.parseDate(debut, DmeConstante.FORMAT_DDMMYYYY_HHMM);
		Date dateFin = DME.parseDate(fin, DmeConstante.FORMAT_DDMMYYYY_HHMM);
		dto.setJour(dateDebut);
		dto.setHeureDebut(dateDebut);
		dto.setHeureFin(dateFin);
		dto.setDuree(DME.getDuree(dateDebut, dateFin));
		dto.setStatut(StatutRV.PLANIFIE);
		model.addAttribute(RV_SESSION_KEY, dto);
		return JspPage.FRAGMENT_RV;
	}
	
	@RequestMapping(value = DmeURL.GET)
	public String get(@RequestParam String rvId, Model model, HttpServletRequest request) {
		RendezVousDto dto = DmeCRUD.getServiceAgenda().getRv(Long.valueOf(rvId));
		model.addAttribute(RV_SESSION_KEY, dto);
		return JspPage.FRAGMENT_RV;
    }

	
	@RequestMapping(value = DmeURL.SUBMIT, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute(RV_SESSION_KEY) RendezVousDto dto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JspPage.FRAGMENT_RV;
		}
		setAuditInfos(dto);
		DmeCRUD.getServiceAgenda().enregistrerRv(dto);
		return JspPage.FRAGMENT_RV;
	}

}
