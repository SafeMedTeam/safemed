package com.bafal.dev.patient.web.controleur.accueil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.controleur.base.BaseUI;


@Controller
public class DashboardUI extends BaseUI {

	@RequestMapping(value = { "/", "/accueil" }, method = RequestMethod.GET)
    public String accueil(HttpServletRequest request, HttpServletResponse response, Model model) {
		// TODO REdirect to chngement mot de passe si lindicateur est a true
		// TODO Ici Load les infos du dashboard
		// TODO Chargement des taches de luser connecte
		// TODO charmenet des RV du jour
        return JspPage.DASHBOARD;
    }

}
