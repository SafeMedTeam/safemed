package com.bafal.dev.patient.web.controleur.personnel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bafal.dev.patient.modele.dto.PatientDto;
import com.bafal.dev.patient.modele.entite.DomaineValeur;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.commun.util.SafeMedSecurityUtils;
import com.bafal.dev.patient.web.commun.util.TypeMenu;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Configurable
@Controller
@RequestMapping(DmeURL.PERSONNEL)
@SessionAttributes(PersonnelUI.PERSONNEL_SESSION_KEY)
public class PersonnelUI extends BaseUI {

	public static final String PERSONNEL_SESSION_KEY = "user";


    @ModelAttribute("pays")
    public List<DomaineValeur> getPays() {
        return DmeCRUD.getServicePilotage().getListePays();
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
	@RequestMapping(value = DmeURL.PROFIL)
	public String profil(Model model, HttpServletRequest request) {
		model.addAttribute(PERSONNEL_SESSION_KEY,
				DmeCRUD.getServiceUtilisateur().getUtilisateur(SafeMedSecurityUtils.getCurrentUser()).get());
		return JspPage.PERSONNEL_PROFIL;
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
	public String createAccount(@Valid @ModelAttribute(PERSONNEL_SESSION_KEY) PatientDto dto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JspPage.PATIENT_FORM;
		}
		DmeCRUD.getServicePatient().enregistrer(dto);
		return REDIRECT + DmeURL.DSSR_CLINIQUE + "/" + dto.getNoDossier();
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
