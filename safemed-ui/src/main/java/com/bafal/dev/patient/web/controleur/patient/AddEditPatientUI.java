package com.bafal.dev.patient.web.controleur.patient;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bafal.dev.patient.modele.dto.PatientDto;
import com.bafal.dev.patient.modele.entite.DomaineValeur;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.DmeUIDGeneratorUtils;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.commun.util.TypeMenu;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Configurable
@Controller
@RequestMapping(DmeURL.PATIENT_EDIT)
@SessionAttributes(AddEditPatientUI.PATIENT_SESSION_KEY)
public class AddEditPatientUI extends BaseUI {

    public static final String PATIENT_SESSION_KEY = "patient";


    @ModelAttribute("pays")
    public List<DomaineValeur> getPays() {
        return DmeCRUD.getServicePilotage().getListePays();
    }

    /**
     * Permet d'afficher le nouveau formulaire patient
     * 
     * @param model le modele
     * @param request la requete Http
     * @return le nom du path Spring à afficher
     */
	@RequestMapping(value = DmeURL.NOUVEAU, method = RequestMethod.GET)
    public String afficher(Model model, HttpServletRequest request) {
		model.addAttribute(PATIENT_SESSION_KEY, new PatientDto());
		return JspPage.PATIENT_FORM;
    }

    /**
     * Permet d'afficher le nouveau formulaire patient
     * 
     * @param model le modele
     * @param request la requete Http
     * @return le nom du path Spring à afficher
     */
	@RequestMapping(value = DmeURL.PATH_NODOSSIER)
	public String editer(@PathVariable("noDossier") String noDossier, Model model, HttpServletRequest request) {
		model.addAttribute(PATIENT_SESSION_KEY, DmeCRUD.getServicePatient().getPatientParNoDossier(noDossier));
		return JspPage.PATIENT_FORM;
    }

    /**
     * Permet de sauvegarder l'ajout d'un patient en BD.
     * <p>
     * En cas d'erreur, on retourne le formulaire en cours de modification avec les
     * messages d'erreurs.
     * <p>
     * C'est à ce moment que le numéro de dossier du patient est généré.
     * 
     * @param patientWrapper le wrapper du patient
     * @param bindingResult les erreurs dans le formulaire
     * @param status le statut de la session
     * @return le nom du path Spring à afficher
     */
	@RequestMapping(value = DmeURL.SUBMIT, method = RequestMethod.POST)
	public String createAccount(@Valid @ModelAttribute("patient") PatientDto dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JspPage.PATIENT_FORM;
		}
		majPatient(dto);
		DmeCRUD.getServicePatient().enregistrer(dto);
		return REDIRECT + DmeURL.DSSR_CLINIQUE + "/" + dto.getNoDossier();
	}


	private void majPatient(PatientDto dto) {
		if (dto.isNotSerialized()) {
			dto.setNoDossier(DmeUIDGeneratorUtils.genererPatientNoDossierUID(dto));
			dto.setActif(Boolean.TRUE);
		}
		this.setAuditInfos(dto);
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

	/*
	 * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = { "save" },
	 * method = RequestMethod.POST) public String
	 * save(@ModelAttribute(PATIENT_SESSION_KEY) @Valid PatientWrapper wrapper,
	 * BindingResult bindingResult, SessionStatus status) { if
	 * (bindingResult.hasFieldErrors()) {
	 * LOGGER.debug("Erreurs présentes dans le contexte!"); return JSP_PATIENT;
	 * } else { if (DME.isBlank(wrapper.getEntite().getMatricule())) {
	 * wrapper.getEntite().setMatricule(UIDGeneratorUtils.genererPatientUID(
	 * wrapper.getEntite())); } //
	 * SafeMedCRUD.getServicePatient().enregistrer(wrapper.getEntite());
	 * status.setComplete(); return REDIRECT + TypeMenu.URL_PATIENT_SOMMAIRE +
	 * "/" + wrapper.getEntite().getMatricule(); }
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = {
	 * "annulerCorrespondant" }) public String
	 * annulerCorrespondant(@ModelAttribute(PATIENT_SESSION_KEY) PatientWrapper
	 * patientWrapper, HttpServletRequest request) { WrapperUtils
	 * .annulerCorrespondant(patientWrapper,
	 * Integer.valueOf(request.getParameter("annulerCorrespondant"))); return
	 * JSP_PATIENT; }
	 */



	/*
	 * @RequestMapping(value = "{codePatient}/detail") public String
	 * detailPatient(@PathVariable("codePatient") String codePatient, Model
	 * model, HttpServletRequest request) {
	 * 
	 * model.addAttribute(PATIENT_SESSION_KEY,
	 * PatientWrapperBuilder.wrap(null));
	 * request.getSession().setAttribute("menus",
	 * SafeMedUtils.getMenus(TypeMenu.URL_PATIENT_LISTE)); return
	 * JSP_DETAIL_PATIENT;
	 * 
	 * }
	 */

    /*
     * @RequestMapping(value = "/search", method = RequestMethod.GET) public String
     * rechercherPatient(HttpServletRequest request, HttpServletResponse response, Model
     * model, Pageable pageable) { model.addAttribute("filtre", filtre);
     * model.addAttribute("filtreavance", filtre); setPagination(model, filtre, pageable);
     * 
     * return "formulaire/search"; }
     */

    /*
     * private void setPagination(Model model, Pageable pageable) { pageable = new
     * PageRequest(pageable.getPageNumber() - 1, pageable.getPageSize());
     * PageWrapper<Patient> wrapper = new
     * PageWrapper<Patient>(ModeleCrud.getServicePatient().rechercher(filtre, pageable),
     * "/search"); model.addAttribute("page", wrapper); }
     */

    /*
     * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = { "editCorrespondant"
     * }) public String editCorrespondant(@ModelAttribute(PATIENT_SESSION_KEY)
     * PatientWrapper patientWrapper, HttpServletRequest request) {
     * WrapperUtils.editCorrespondant(patientWrapper,
     * Integer.valueOf(request.getParameter("editCorrespondant"))); return JSP_PATIENT; }
     * 
     * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = { "editCaisse" })
     * public String editCaisse(@ModelAttribute(PATIENT_SESSION_KEY) PatientWrapper
     * patientWrapper, HttpServletRequest request) {
     * WrapperUtils.editCaisse(patientWrapper,
     * Integer.valueOf(request.getParameter("editCaisse"))); return JSP_PATIENT; }
     * 
     * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = {
     * "ajouterCorrespondant" }) public String
     * ajouterCorrespondant(@ModelAttribute(PATIENT_SESSION_KEY) PatientWrapper
     * patientWrapper) { WrapperUtils.ajouterCorrespondant(patientWrapper); return
     * JSP_PATIENT; }
     * 
     * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = { "ajouterCaisse" },
     * method = RequestMethod.POST) public String
     * ajouterCaisse(@ModelAttribute(PATIENT_SESSION_KEY) PatientWrapper patientWrapper,
     * Model model, HttpServletRequest request, SessionStatus status) {
     * 
     * WrapperUtils.ajouterCaisse(patientWrapper); // status.setComplete(); return
     * JSP_PATIENT; }
     * 
     * @RequestMapping(value = TypeMenu.URL_PATIENT_SUBMIT, params = "annulerCaisse")
     * public String annulerCaisse(@ModelAttribute(PATIENT_SESSION_KEY) PatientWrapper
     * patientWrapper, HttpServletRequest request) {
     * WrapperUtils.annulerCaisse(patientWrapper,
     * Integer.valueOf(request.getParameter("annulerCaisse"))); return JSP_PATIENT; }
     */

}
