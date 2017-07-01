package com.bafal.dev.patient.web.controleur.accueil;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bafal.dev.patient.modele.dto.AgendaSchedulerDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;
import com.bafal.dev.patient.web.commun.form.DmeEvent;
import com.bafal.dev.patient.web.commun.form.DmeSelectJson;
import com.bafal.dev.patient.web.commun.util.DmeURL;
import com.bafal.dev.patient.web.commun.util.SafeMedUtils;
import com.bafal.dev.patient.web.controleur.base.BaseUI;

@Controller
@RequestMapping(DmeURL.JSON)
public class JsonUI extends BaseUI {

	@RequestMapping(value = "task/utilisateurs", method = RequestMethod.GET, produces = APP_JSON)
	public @ResponseBody DmeSelectJson loadUtilisateursJson(@RequestParam String motCle, HttpServletRequest request) {
		return DmeSelectJson.build(DmeCRUD.getServiceUtilisateur().rechercherUtilisateursJsonParMotCle(motCle));
	}

	@RequestMapping(value = "task/patients", method = RequestMethod.GET, produces = APP_JSON)
	public @ResponseBody DmeSelectJson loadPatientsJson(@RequestParam String motCle, HttpServletRequest request) {
		return DmeSelectJson.build(DmeCRUD.getServicePatient().rechercherPatientJsonParMotCle(motCle));
	}

	@RequestMapping(value = "agenda/schedule/semainedispo", method = RequestMethod.GET, produces = APP_JSON)
	public @ResponseBody List<DmeEvent> loadAgendaUneSemaineJson(HttpServletRequest request) {
		return SafeMedUtils.toDmeEvents(AgendaSchedulerDto.buildDefaultSemaine());
	}

}
