package com.bafal.dev.patient.web.controleur.base;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bafal.dev.patient.web.commun.form.Erreur;
import com.bafal.dev.patient.web.commun.util.JspPage;


/**
 * Controleur de la page des erreurs 
 * 
 * @author bafall
 *
 */
@Controller
public class ErreurUI implements ErrorController {

	@Autowired
	private ErrorAttributes errorAttributes;

	/*
	 * @Value("${debug}") private boolean debug;
	 */

	@RequestMapping(value = "/error")
	public String erreur(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("erreur", Erreur.build(1, getErrorAttributes(request, Boolean.TRUE)));
		return JspPage.ERREUR;
    }

	@Override
	public String getErrorPath() {
		return "/error";
	}

	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean stackTraceInclus) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return errorAttributes.getErrorAttributes(requestAttributes, stackTraceInclus);
	}

}
