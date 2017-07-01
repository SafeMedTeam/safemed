package com.bafal.dev.patient.web.controleur.accueil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.modele.dto.ResetMotDePasseDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.email.ServiceNotification;
import com.bafal.dev.patient.web.commun.form.validateur.ResetValidateur;
import com.bafal.dev.patient.web.commun.util.DmeUIDGeneratorUtils;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;

/**
 * Controleur de la page de reset
 * 
 * @author bafall
 *
 */
@Controller
@RequestMapping(DmeURL.RESET)
public class ResetUI {

	private static final String MODEL_RESET_KEY = "resetForm";

	@Autowired
	public ServiceNotification serviceNotification;
	@Autowired
	private ResetValidateur validateur;

	@InitBinder(MODEL_RESET_KEY)
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validateur);
	}

	@RequestMapping(value = "form", method = RequestMethod.GET)
    public String acceder(HttpServletRequest request, HttpServletResponse response, Model model) {
        // TODO code a venir
		model.addAttribute(MODEL_RESET_KEY, new ResetMotDePasseDto());
		return JspPage.RESET;
    }
	
	@RequestMapping(value = DmeURL.SUBMIT, method = RequestMethod.POST)
	public String reset(@Valid @ModelAttribute(MODEL_RESET_KEY) ResetMotDePasseDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JspPage.RESET;
		}
		dto.setNouveauMotDePasse(DmeUIDGeneratorUtils.genererMotDePasse());
		DmeCRUD.getServiceUtilisateur().resetPassword(dto);
		this.envoyerResetNotification(dto);
		return "redirect:" + DmeURL.LOGIN;
	}

	private void envoyerResetNotification(ResetMotDePasseDto dto) {
		// TODO Email
		serviceNotification.envoyerNotificationResetMDP(dto, "resetMDPTemplate.html");
	}

}
