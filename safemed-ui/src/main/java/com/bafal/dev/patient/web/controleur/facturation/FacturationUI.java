package com.bafal.dev.patient.web.controleur.facturation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.web.commun.util.JspPage;

@Configurable
@Controller
@RequestMapping("facturation")
public class FacturationUI {



    /**
     * Permet d'afficher le nouveau formulaire patient
     * 
     * @param model le modele
     * @param request la requete Http
     * @return le nom du path Spring à afficher
     */
	@RequestMapping(value = "", method = RequestMethod.GET)
    public String afficher(Model model, HttpServletRequest request) {
		return JspPage.FACTURATION_FORM;
    }

}
