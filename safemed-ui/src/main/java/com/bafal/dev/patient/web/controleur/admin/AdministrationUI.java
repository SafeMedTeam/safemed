package com.bafal.dev.patient.web.controleur.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Controller
@RequestMapping("/admin")
public class AdministrationUI extends BaseUI {

	@RequestMapping(value = "")
	public String acceder(Model model, HttpServletRequest request) {
		return JspPage.ADMIN_HOME;
    }

}
