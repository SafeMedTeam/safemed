package com.bafal.dev.patient.modele.base.exception;

public class SafeMedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SafeMedException() {
		super();
	}

	public SafeMedException(String message) {
		super(message);
	}

	public SafeMedException(Throwable cause) {
		super(cause);
	}

	public SafeMedException(String message, Throwable cause) {
		super(message, cause);
	}
}
