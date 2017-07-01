package com.bafal.dev.patient.web.configuration.intercepteur;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bafal.dev.patient.modele.base.util.DME;

@Component
public class DmeMaintenanceIntercepteur extends HandlerInterceptorAdapter {

	private Date debutMaintenance;
	private Date finMaintenance;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO LORS DES MAINTENANCES DU SITE
		// DATE DEBUT DATE FIN
		if (DME.isBetween(DME.now(), debutMaintenance, finMaintenance)) {
			// Maintenancerediriger vers la page de maintenance
			response.sendRedirect("/dme/maintenance");
			// TODO Pour le momemt parce que le code nexiste pas encore il faut
			// le changer a false
			return Boolean.TRUE;
		} else {
			return Boolean.TRUE;
		}
	}

}
