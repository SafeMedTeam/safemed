package com.bafal.dev.patient.web.configuration.intercepteur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bafal.dev.patient.modele.base.exception.UtilisateurNonTrouveException;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.util.SafeMedSecurityUtils;

@Component
public class DmeAuthIntercepteur extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (getDtoCurrent().isDoitChangerMdp()) {
			// TODO ICI LE CODE
			response.sendRedirect("/personnel/profil/changemdp/form");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	public UtilisateurDto getDtoCurrent() {
		return DmeCRUD.getServiceUtilisateur().getUtilisateur(SafeMedSecurityUtils.getCurrentUser())
				.orElseThrow(() -> new UtilisateurNonTrouveException("L'utilisateur n'existe pas"));
	}
}
