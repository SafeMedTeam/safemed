package com.bafal.dev.patient.web.controleur.personnel;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bafal.dev.patient.modele.dto.DmeTaskDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.form.validateur.TaskValidateur;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.commun.util.TypeMenu;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Configurable
@Controller
@RequestMapping(DmeURL.PERSONNEL_TASK)
@SessionAttributes("task")
public class PersonnelTaskUI extends BaseUI {

	@Autowired
	private TaskValidateur validateur;

	@InitBinder("task")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validateur);
	}


    /**
	 * Permet d'afficher le profil
	 * 
	 * @param model
	 *            le modele
	 * @param request
	 *            la requete Http
	 * @return le nom du path Spring à afficher
	 */
	@RequestMapping(value = "form")
	public String afficher(Model model, HttpServletRequest request) {
		model.addAttribute("task", DmeTaskDto.build());
		return JspPage.FRAGMENT_TASK;
	}

	@RequestMapping(value = "get")
	public String get(@RequestParam String taskId, Model model, HttpServletRequest request) {
		DmeTaskDto dto = DmeCRUD.getServiceUtilisateur().getTask(Long.valueOf(taskId));
		model.addAttribute("task", dto);
		return JspPage.FRAGMENT_TASK;
    }


	@RequestMapping(value = DmeURL.SUBMIT, method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("task") DmeTaskDto dto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JspPage.FRAGMENT_TASK;
		}
		setAuditInfos(dto);
		DmeCRUD.getServiceUtilisateur().enregistrerTask(dto);
		return JspPage.FRAGMENT_TASK;
	}


	/**
	 * Réinitialise le formulaire en cours de saisie
	 * 
	 * @return le nom du path Spring à afficher
	 */
	@RequestMapping(value = DmeURL.SUBMIT, params = { "annuler" })
    public String resetFormulaire() {
        return REDIRECT + TypeMenu.URL_PATIENT_NOUVEAU;
    }

}
