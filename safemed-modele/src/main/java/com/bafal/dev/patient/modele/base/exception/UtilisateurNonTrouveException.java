package com.bafal.dev.patient.modele.base.exception;

public class UtilisateurNonTrouveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UtilisateurNonTrouveException() {
		super();
	}

	public UtilisateurNonTrouveException(String message) {
		super(message);
	}

	public UtilisateurNonTrouveException(Throwable cause) {
		super(cause);
	}

}
