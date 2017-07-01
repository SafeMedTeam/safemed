package com.bafal.dev.patient.web.controleur.patient;

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
import org.springframework.web.bind.support.SessionStatus;

import com.bafal.dev.patient.modele.filtre.PatientFiltre;
import com.bafal.dev.patient.web.commun.util.SafeMedUtils;
import com.bafal.dev.patient.web.commun.util.TypeMenu;

@Configurable
@Controller
@RequestMapping(TypeMenu.URL_PATIENT)
@SessionAttributes(NoteCliniqueUI.PATIENT_SESSION_KEY)
public class NoteCliniqueUI {

    public static final String PATIENT_SESSION_KEY = "patient";
    private static final String REDIRECT = "redirect:";

    public static final String JSP_PATIENT = "patient/accueil/search";
    public static final String JSP_DETAIL_PATIENT = "patient/detail";

    public static final String SESSION_RESULTS_KEY = "search_result_patient";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String accueil(Model model, HttpServletRequest request) {
        model.addAttribute(PATIENT_SESSION_KEY, new PatientFiltre());
        model.addAttribute(SESSION_RESULTS_KEY, null);
        request.getSession().setAttribute("menus", SafeMedUtils.getMenus(TypeMenu.URL_PATIENT));
        return JSP_PATIENT;
    }

    @RequestMapping(value = "liste", params = { "reset" }, method = RequestMethod.POST)
    public String reset() {
        return "redirect:" + TypeMenu.URL_PATIENT;
    }

    @RequestMapping(value = "liste", params = { "save" }, method = RequestMethod.POST)
    public String save(@ModelAttribute(PATIENT_SESSION_KEY) @Valid PatientFiltre filtre, BindingResult bindingResult,
        HttpServletRequest request, SessionStatus status) {

        // status.setComplete();
        return JSP_PATIENT;
    }

}
