package com.bafal.dev.patient.modele.base.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe Utilitaire de journalisation pour Educa
 * 
 * @author bfall
 *
 */
public final class SafeMedLogger {


	public enum Level {
		DEBUG, INFO, ERROR, WARN, TRACE;
	}

	public static void log(Class<?> clazz, String message) {
		SafeMedLogger.log(clazz, message, Level.DEBUG);
	}

	public static void log(Class<?> clazz, String message, Level level) {
		Logger log = SafeMedLogger.getLogInstance(clazz);
		if (Level.DEBUG.equals(level)) {
			log.debug(message);
		} else if (Level.INFO.equals(level)) {
			log.info(message);
		} else if (Level.ERROR.equals(level)) {
			log.error(message);
		}
	}

	public static void error(Class<?> clazz, String message, Throwable e) {
		SafeMedLogger.getLogInstance(clazz).error(message, e);
	}

	private static Logger getLogInstance(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}


}
