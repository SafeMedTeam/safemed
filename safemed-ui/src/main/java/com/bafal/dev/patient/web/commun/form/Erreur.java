package com.bafal.dev.patient.web.commun.form;

import java.util.Map;

public class Erreur {

	public Integer statut;
	public String nom;
	public String message;
	public String timeStamp;
	public String trace;
	public String path;

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Erreur() {
		super();
	}

	public Erreur(int statut, Map<String, Object> errorAttributes) {
		this.statut = statut;
		this.nom = (String) errorAttributes.get("error");
		this.message = (String) errorAttributes.get("message");
		this.timeStamp = String.valueOf(errorAttributes.get("timestamp"));
		this.trace = (String) errorAttributes.get("trace");
	}

	public static Erreur build(int statut, Map<String, Object> attributsErreur) {
		Erreur erreur = new Erreur();
		erreur.setMessage(String.valueOf(attributsErreur.get("message")));
		erreur.setNom(String.valueOf(attributsErreur.get("error")));
		erreur.setStatut(statut);
		erreur.setTimeStamp(String.valueOf(attributsErreur.get("timestamp")));
		erreur.setTrace(String.valueOf(attributsErreur.get("trace")));
		erreur.setPath(String.valueOf(attributsErreur.get("path")));

		return erreur;
	}

}
