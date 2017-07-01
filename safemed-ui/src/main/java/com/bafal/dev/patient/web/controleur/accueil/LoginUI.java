package com.bafal.dev.patient.web.controleur.accueil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.web.commun.util.JspPage;

/**
 * Controleur de la page de connexion/déconnexion
 * 
 * @author bafall
 *
 */
@Controller
public class LoginUI {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String connexion(HttpServletRequest request, HttpServletResponse response, Model model) {
		return JspPage.LOGIN;
    }

}
