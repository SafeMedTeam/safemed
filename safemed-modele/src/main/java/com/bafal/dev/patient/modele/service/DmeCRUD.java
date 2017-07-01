package com.bafal.dev.patient.modele.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

@Configurable
@Component
public class DmeCRUD {

    /**
     * Service d'accès aux données de l'unité de traitement du Patient
     */
    private static ServicePatient servicePatient;

    /**
     * Service d'accès aux données de Pilotage
     */
    private static ServicePilotage servicePilotage;

    /**
     * Service d'accès aux données de l'unité de traitement du Personnel médical
     */
    private static ServiceUtilisateur serviceUtilisateur;

	private static ServiceAgenda serviceAgenda;

    /**
     * Service d'accès aux données de l'unité de traitement du Patient
     * 
     * @return
     */
    public static ServicePatient getServicePatient() {
        return DmeCRUD.servicePatient;
    }

    @Autowired
    private void setServicePatient(ServicePatient servicePatient) {
        DmeCRUD.servicePatient = servicePatient;
    }

    /**
     * Service d'accès aux données de Pilotage
     * 
     * @return
     */
    public static ServicePilotage getServicePilotage() {
        return servicePilotage;
    }

    @Autowired
    private void setServicePilotage(ServicePilotage servicePilotage) {
        DmeCRUD.servicePilotage = servicePilotage;
    }

    /**
     * Service d'accès aux données de l'unité de traitement du Personnel médical
     * 
     * @return
     */
    public static ServiceUtilisateur getServiceUtilisateur() {
        return serviceUtilisateur;
    }

    @Autowired
    private void setServiceUtilisateur(ServiceUtilisateur serviceUtilisateur) {
        DmeCRUD.serviceUtilisateur = serviceUtilisateur;
    }

	/**
	 * Service d'accès aux données de Pilotage
	 * 
	 * @return
	 */
	public static ServiceAgenda getServiceAgenda() {
		return serviceAgenda;
	}

	@Autowired
	private void setServiceAgenda(ServiceAgenda serviceAgenda) {
		DmeCRUD.serviceAgenda = serviceAgenda;
	}

}
