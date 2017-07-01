package com.bafal.dev.patient.modele.base.exception;

public class SafeMedFileNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SafeMedFileNotFoundException() {
		super();
	}

	public SafeMedFileNotFoundException(String message) {
		super(message);
	}

	public SafeMedFileNotFoundException(Throwable cause) {
		super(cause);
	}

}
