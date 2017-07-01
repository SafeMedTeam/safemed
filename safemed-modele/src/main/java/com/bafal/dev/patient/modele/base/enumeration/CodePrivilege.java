package com.bafal.dev.patient.modele.base.enumeration;

public enum CodePrivilege implements CodeEnum {
	DME_PRIV_EDIT_PATIENT("Editer le Dossier Patient"),
	DME_PRIV_VIEW_PATIENT("Consulter le Dossier Patient"),
	DME_PRIV_EDIT_FACTURE("Editer la facturation"),
	DME_PRIV_VIEW_FACTURE("Consulter la facturation"),
	DME_PRIV_ADMIN_FACTURE("Administrer la facturation"),
	DME_PRIV_CREATE_USER("Creer un nouvel Utilisateur"),
	DME_PRIV_EDIT_USER("Editer un Utilisateur"),
	DME_PRIV_VIEW_USER("Consulter un utilisateur"),
	DME_PRIV_EDIT_AGENDA("Editer un Agenda"),
	DME_PRIV_VIEW_AGENDA("Consulter un agenda"),
	DME_PRIV_EDIT_RAPPORT("Editer un Rapport"),
	DME_PRIV_VIEW_RAPPORT("Consulter un Rapport");

	private final String nom;

	private CodePrivilege(String nom) {
		this.nom = nom;
	}

	@Override
	public String getNom() {
		return nom;
	}
}
