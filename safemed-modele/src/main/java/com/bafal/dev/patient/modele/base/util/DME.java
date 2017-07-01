package com.bafal.dev.patient.modele.base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.bafal.dev.patient.modele.base.logger.SafeMedLogger;

/**
 * Utilitaire DME
 * 
 * @author bfall
 *
 */
public class DME {

    public static boolean isNull(Object objet) {
        return objet == null;
    }

    public static boolean isNotNull(Object objet) {
        return !isNull(objet);
    }

    public static boolean isBlank(String valeur) {
        return StringUtils.isBlank(valeur);
    }

    public static boolean isNotBlank(String valeur) {
        return !DME.isBlank(valeur);
    }

    public static boolean isEmpty(List<?> liste) {
        return CollectionUtils.isEmpty(liste);
    }

    public static boolean isNotEmpty(List<?> liste) {
        return !DME.isEmpty(liste);
    }

    public static <T> List<T> safeListe(List<T> liste) {
        return DME.isEmpty(liste) ? Collections.emptyList() : liste;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> boolean isEmpty(T objet) {

        if (objet instanceof Collection) {
            return DME.isEmpty((List<T>) objet);
        } else if (objet instanceof String) {
            return DME.isBlank((String) objet);
        }
        return objet == null;
    }

    public static <T extends Object> boolean isNotEmpty(T objet) {
        return !DME.isEmpty(objet);
    }

	/**
	 * Normalise une chaine de caracteres : enleve les accents, retire les
	 * tirets et les apostrophes
	 * 
	 * @param chaine
	 * @return
	 */
	public static String normaliserChaine(String chaine) {
		if (DME.isBlank(chaine)) {
			return "";
		}
		return StringUtils.stripAccents(chaine).replaceAll(" ", "").replaceAll("'", "").replaceAll("-", "")
				.toLowerCase();
	}

    public static Date now() {
		return new Date();
    }

	/**
	 * Retourne la periode entre la date en entree et aujourd'hui
	 * 
	 * @param date
	 * @return
	 */
	public static Period getPeriode(Date date) {
		return DME.getPeriode(date, DME.now());
    }

	/**
	 * Retourne la {@link Period} entre 2 dates
	 * 
	 * @param debut
	 * @param fin
	 * @return
	 */
	public static Period getPeriode(Date debut, Date fin) {
		if (debut == null || fin == null) {
			return null;
		}

		return Period.between(DME.toLocalDate(debut), DME.toLocalDate(fin));
	}

	/**
	 * Retourne l'intervalle de temps (en minutes) qui separent les deux dates
	 * en entree
	 * 
	 * @param debut
	 * @param fin
	 * @return
	 */
	public static Long getDuree(Date debut, Date fin) {
		if (debut == null || fin == null) {
			return null;
		}
		return Duration.between(DME.toInstant(debut), DME.toInstant(fin)).toMinutes();
	}

	public static <T> List<T> asList(@SuppressWarnings("unchecked") T... liste) {
		if (liste == null || liste.length == 0) {
			return new ArrayList<T>();
		}
		return new ArrayList<T>(Arrays.asList(liste));
	}

	public static String format(Date date) {
		return new SimpleDateFormat(DmeConstante.FORMAT_DDMMMYYYY_KKMM).format(date);
	}

	public static String format(Date date, String format) {
		return date == null ? null : new SimpleDateFormat(format).format(date);
	}

	public static Date parseDate(String date, String format) {
		try {
			return new SimpleDateFormat(format).parse(date);
		} catch (ParseException e) {
			SafeMedLogger.error(DME.class, "Erreur parsing Date", e);
			return null;
		}
	}

	public static boolean equals(Object obj1, Object obj2) {
		if (DME.isNull(obj1)) {
			return Boolean.FALSE;
		}
		return obj1.equals(obj2);
	}

	public static boolean notEquals(Object obj1, Object obj2) {
		if (DME.isNull(obj1)) {
			return Boolean.FALSE;
		}
		return obj1.equals(obj2);
	}

	/**
	 * 
	 * @param date
	 * @param debut
	 * @param fin
	 * @return
	 */
	public static boolean isBetween(Date date, Date debut, Date fin) {
		if (date == null) {
			return Boolean.FALSE;
		}

		return date.after(debut) && date.before(fin);
	}
	
	/**
	 * Ajuste la date en entree pour se positionner a Minuit
	 * 
	 * @param dateJour
	 * @return
	 */
	public static Date getDateJour00h00(Date dateJour) {
		return Date.from(DME.toLocalDate(dateJour).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Ajuste la date en entree pour se positionner a 23h59
	 * 
	 * @param dateJour
	 * @return
	 */
	public static Date getDateJour23h59(Date dateJour) {
		return Date.from(DME.toLocalDateTime(dateJour).withHour(23).withMinute(59).withSecond(59)
				.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Icremente la date en entree d'une semaine
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime incrementeSemaine(LocalDateTime date) {
		if (date == null) {
			return null;
		}
		return date.plusWeeks(1);
	}

	/**
	 * Convertit un {@link Instant} en Date
	 * 
	 * @param instant
	 * @return
	 */
	public static Date dateFrom(Instant instant) {
		if (instant == null) {
			return null;
		}
		return Date.from(instant);
	}

	/**
	 * Convertit un {@link LocalDate} en Date
	 * 
	 * @param localDate
	 * @return
	 */
	public static Date dateFrom(LocalDate localDate) {
		if (localDate == null) {
			return null;
		}
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Convertit un {@link LocalDateTime} en Date
	 * 
	 * @param ldt
	 * @return
	 */
	public static Date dateFrom(LocalDateTime ldt) {
		if (ldt == null) {
			return null;
		}
		return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Convertit une date en {@link LocalDate}
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate toLocalDate(Date date) {
		if (date == null) {
			return null;
		}
		return DME.toLocalDateTime(date).toLocalDate();
	}

	/**
	 * Convertit une date en {@link Instant}
	 * 
	 * @param date
	 * @return
	 */
	public static Instant toInstant(Date date) {
		if (date == null) {
			return null;
		}
		return Instant.ofEpochMilli(date.getTime());
	}

	/**
	 * Convertit une date en {@link LocalDateTime}
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		if (date == null) {
			return null;
		}
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
	}

}
