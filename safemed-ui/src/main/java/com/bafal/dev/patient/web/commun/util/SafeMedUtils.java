package com.bafal.dev.patient.web.commun.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bafal.dev.patient.modele.base.enumeration.CouleurEvenement;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.AgendaSchedulerDto;
import com.bafal.dev.patient.modele.dto.PlageHoraireDto;
import com.bafal.dev.patient.web.commun.form.DmeEvent;
import com.bafal.dev.patient.web.commun.form.json.PlageHoraireJson;
import com.bafal.dev.patient.web.commun.menu.ItemEnfant;
import com.bafal.dev.patient.web.commun.menu.MenuItem;

public class SafeMedUtils {

    public static List<MenuItem> trierListeMenu(List<MenuItem> menus) {
        return menus.stream().sorted().collect(Collectors.toList());
    }

    /**
     * Retourne la liste des items de la barre de navigation en PIV_HAUT
     * 
     * @param menuActif URL du menu à activer
     * @return la liste des menus
     */
    public static List<MenuItem> getMenus(String menuActif) {
        return getMenus().stream().map(m -> {
            m.setActive(false);
            if (menuActif.equals(m.getUrl())) {
                m.setActive(true);
            }
            // }
            return m;
        }).sorted().collect(Collectors.toList());
    }

    /**
     * 
     * @param menusEnfant
     * @param menuActif
     * @return
     */
    public static List<ItemEnfant> getMenusEnfant(List<ItemEnfant> menusEnfant, String menuActif) {
        return menusEnfant.stream().map(m -> {
            m.setActive(false);
            if (menuActif.equals(m.getUrl())) {
                m.setActive(true);
            }
            return m;
        }).sorted().collect(Collectors.toList());
    }

    /**
     * Retourne la liste exhaustive des items de la barre de navigation
     * 
     * @return la liste exhaustive des items
     */
    public static List<MenuItem> getMenus() {
		return null;
    }

	public static List<PlageHoraireJson> toJson(List<PlageHoraireDto> seances) {
		List<PlageHoraireJson> jsonListe = new ArrayList<PlageHoraireJson>();
		DME.safeListe(seances).forEach(seance -> jsonListe.add(toJson(seance)));
		return jsonListe;
	}

	public static PlageHoraireJson toJson(PlageHoraireDto dto) {
		if (DME.isNull(dto)) {
			return null;
		}
		PlageHoraireJson seance = new PlageHoraireJson();

		seance.setId(dto.getId());
		seance.setColor(CouleurEvenement.BLUE.getCode());
		seance.setTextColor(CouleurEvenement.WHITE.getCode());
		// seance.setDateDebut(dto.getDateDebut());
		// seance.setDateFin(dto.getDateFin());
		seance.setTitre("...");

		return seance;
	}

	public static List<DmeEvent> toDmeEvents(AgendaSchedulerDto dto) {
		List<DmeEvent> eventList = new ArrayList<>();
		dto.getPlagesUneSemaine().forEach(plage -> eventList.add(toDmeEvent(plage))); 
		return eventList;
	}

	public static DmeEvent toDmeEvent(PlageHoraireDto dto) {
		DmeEvent event = new DmeEvent();
		event.setColor(dto.getStatut().getCouleur());
		event.setDateDebut(dto.getHeureDebut());
		event.setDateFin(dto.getHeureFin());
		event.setRendering("background");
		event.setId(dto.getStatut().getContrainteId());
		return event;
	}


}
