package com.bafal.dev.patient.modele.dto;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.bafal.dev.patient.modele.base.enumeration.StatutPlageHoraire;
import com.bafal.dev.patient.modele.base.util.DME;

public class AgendaSchedulerDto {

	List<PlageHoraireDto> plagesUneSemaine = new ArrayList<>(14);

	private Date debutOccurence;

	private Date finOccurence;

	public List<PlageHoraireDto> getPlagesUneSemaine() {
		return plagesUneSemaine;
	}

	public void setPlagesUneSemaine(List<PlageHoraireDto> plagesUneSemaine) {
		this.plagesUneSemaine = plagesUneSemaine;
	}

	public Date getDebutOccurence() {
		return debutOccurence;
	}

	public void setDebutOccurence(Date debutOccurence) {
		this.debutOccurence = debutOccurence;
	}

	public Date getFinOccurence() {
		return finOccurence;
	}

	public void setFinOccurence(Date finOccurence) {
		this.finOccurence = finOccurence;
	}

	public static AgendaSchedulerDto buildDefaultSemaine() {
		return AgendaSchedulerDto.build(DME.now());
	}

	public static AgendaSchedulerDto build(Date dateOccurence) {
		AgendaSchedulerDto scheduler = new AgendaSchedulerDto();
		scheduler.setDebutOccurence(AgendaSchedulerDto.getLundiDebutSchedule(dateOccurence));
		List<PlageHoraireDto> plages = new ArrayList<>();
		for (DayOfWeek day : DayOfWeek.values()) {
			plages.addAll(buildJourDeSemaine(scheduler.getDebutOccurence(), day));
		}
		scheduler.setPlagesUneSemaine(plages);
		return scheduler;
	}

	public static List<PlageHoraireDto> buildJourDeSemaine(Date date, DayOfWeek jourDeSemaine) {
		List<PlageHoraireDto> plageUnJour = new ArrayList<>();
		// AVANT MIDI
		plageUnJour.add(buildPlageAvantMidi(date, jourDeSemaine));
		// APRES-MIDI
		plageUnJour.add(buildPlageApresMidi(date, jourDeSemaine));

		return plageUnJour;
	}

	protected static PlageHoraireDto buildPlageAvantMidi(Date date, DayOfWeek jourDeSemaine) {
		PlageHoraireDto dto = new PlageHoraireDto();
		dto.setActif(Boolean.TRUE);
		dto.setStatut(StatutPlageHoraire.DISPO);
		Date jour = AgendaSchedulerDto.ajusterDateJourSchedule(date, jourDeSemaine);
		dto.setJour(jour);
		dto.setHeureDebut(applyHeureMinute(jour, 8, 0)); // De 08h
		dto.setHeureFin(applyHeureMinute(jour, 12, 0)); // A 12h
		
		return dto;
	}

	protected static PlageHoraireDto buildPlageApresMidi(Date date, DayOfWeek jourDeSemaine) {
		PlageHoraireDto dto = new PlageHoraireDto();
		dto.setActif(Boolean.TRUE);
		dto.setStatut(StatutPlageHoraire.DISPO);
		Date jour = AgendaSchedulerDto.ajusterDateJourSchedule(date, jourDeSemaine);
		dto.setJour(jour);
		dto.setHeureDebut(applyHeureMinute(jour, 13, 0)); // De 13h
		dto.setHeureFin(applyHeureMinute(jour, 18, 0)); // A 18h

		return dto;
	}

	protected static Date applyHeureMinute(Date jour, int heure, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(jour);
		cal.set(Calendar.HOUR_OF_DAY, heure);
		cal.set(Calendar.MINUTE, minute);
		return cal.getTime();
	}

	private static Date ajusterDateJourSchedule(Date date, DayOfWeek jourDeSemaine) {
		if (date == null || jourDeSemaine.equals(DayOfWeek.MONDAY)) {
			return date;
		}
		return DME.dateFrom(DME.toLocalDateTime(date).with(TemporalAdjusters.next(jourDeSemaine)));
	}

	private static Date getLundiDebutSchedule(Date date) {
		if (date == null) {
			return null;
		}
		LocalDate localDate = DME.toLocalDate(date);
		DayOfWeek jour = localDate.getDayOfWeek();
		switch (jour) {
			case MONDAY:
				return date;
			case FRIDAY:
			case SATURDAY:
			case SUNDAY:
				return DME.dateFrom(localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
			default:
				break;
		}
		return DME.dateFrom(localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)));
	}

	/**
	 * Obtenir le lundi précédent de la date passée en paramètre.
	 * </p>
	 * 
	 * @param date
	 *            la date dont on veut obtenir le lundi précédent
	 * @return la date du lundi précédent la date passée
	 */
	public static Date getLundiPourUneDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		int jour = calendar.get(Calendar.DAY_OF_WEEK);

		if (jour == Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, -6);
		}

		if ((jour != Calendar.SUNDAY) && (jour != Calendar.MONDAY)) {
			int jourDiffAvecLundi = jour - 2;
			calendar.add(Calendar.DATE, -jourDiffAvecLundi);
		}

		return calendar.getTime();
	}


}
