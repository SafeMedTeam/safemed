package com.bafal.dev.patient.web.controleur.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.RoleDto;
import com.bafal.dev.patient.modele.dto.ServiceMedicalDto;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.email.ServiceNotification;
import com.bafal.dev.patient.web.commun.util.DmeUIDGeneratorUtils;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.JspPage;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Controller
@RequestMapping("/admin/personnel")
public class GestionUtilisateurUI extends BaseUI {

	@Autowired
	private ServiceNotification serviceNotification;

	@RequestMapping(value = "")
	public String adminUtilisateur(Model model, HttpServletRequest request) {
		return JspPage.ADMIN_USER;
	}

	@RequestMapping(value = "nouveau")
	public String nouvelUtilisateur(Model model, HttpServletRequest request) {
		model.addAttribute("utilisateur", new UtilisateurDto());
		return JspPage.ADMIN_USER_NOUVEAU;
	}

	@RequestMapping(value = DmeURL.LISTE)
	public String liste(Model model, HttpServletRequest request) {
		// model.addAttribute("utilisateur", new UtilisateurDto());
		return JspPage.ADMIN_USER_LISTE;
    }
	
	@RequestMapping(value = DmeURL.SUBMIT, method = RequestMethod.POST)
	public String createAccount(@Valid @ModelAttribute("utilisateur") UtilisateurDto dto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return JspPage.ADMIN_USER_NOUVEAU;
		}
		majUtilisateur(dto);
		DmeCRUD.getServiceUtilisateur().enregistrer(dto);
		serviceNotification.envoyerNotificationCreationCompte(dto, "creerCompteTemplate.html");
		return "redirect:/admin";
	}

	@ModelAttribute("listeRoles")
	public List<RoleDto> getListeRoles() {
		return DmeCRUD.getServiceUtilisateur().getListeRoles();
	}

	@ModelAttribute("services")
	public List<ServiceMedicalDto> getServices() {
		return DmeCRUD.getServiceUtilisateur().getListeServices();
	}

	public void majUtilisateur(UtilisateurDto dto) {
		dto.setDoitChangerMdp(Boolean.TRUE);
		dto.setProfilComplet(Boolean.FALSE);
		if (dto.getDateDebutActivite() == null) {
			dto.setDateDebutActivite(DME.now());
		}
		dto.setMotDePasse(DmeUIDGeneratorUtils.genererMotDePasse());
		dto.setCodeUtilisateur(DmeUIDGeneratorUtils.genererCodeUtilisateur(dto.getPrenom(), dto.getNom()));

		dto.setRoles(DmeCRUD.getServiceUtilisateur().getRoles(dto.getCodeRoles()));
		this.setAuditInfos(dto);
	}

}
