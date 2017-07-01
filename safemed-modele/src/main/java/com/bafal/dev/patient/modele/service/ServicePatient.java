package com.bafal.dev.patient.modele.service;

import java.util.List;

import com.bafal.dev.patient.modele.dto.ChambreDto;
import com.bafal.dev.patient.modele.dto.DossierPatientDto;
import com.bafal.dev.patient.modele.dto.NoteCliniqueDto;
import com.bafal.dev.patient.modele.dto.PatientDto;
import com.bafal.dev.patient.modele.dto.PatientJsonDto;
import com.bafal.dev.patient.modele.filtre.PatientFiltre;

public interface ServicePatient {

    /**
     * Retourne la liste des patients dont le statut est actif.
     * 
     * @return la liste des patients actifs
     */
	List<PatientDto> getListePatientsActif();

    /**
     * Sauvegarde les mises à jour du patient passé en paramètre
     * 
     * @param patient le patient à mettre à jour
     * @return le patient mis à jour
     */
	PatientDto enregistrer(PatientDto patient);

    /**
     * Purge le patient dont le numero de dossier est passé en parmaètre
     * <p>
     * Archive le patient et le rend inactif
     * 
     * @param patient le patient
     */
    void purger(String codePatient);

    /**
	 * Retourne le patient dont le numero de dossier est passé en parametre
	 * 
	 * @param noDossier
	 * @return le patient trouvé
	 */
	PatientDto getPatientParNoDossier(String noDossier);

    /**
     * Retourne le patient dont le numero de dossier est passé en parametre
     * 
     * @param codePatient
     * @return le patient trouvé
     */
	PatientDto getPatientCompletParCode(String codePatient);

    /**
     * Retourne le nombre de patients en base dont le numéro de dossier commence par la
     * chaine de caractèeres en entrée.
     * 
     * @param codePatient le début du code patient
     * @return le nombre de patients trouvé
     */
    Long getNombrePatientsByNumeroDossier(String codePatient);

    /**
     * Retourne la liste des chambres dont le nombre de lits disponibles est supérieur ou
     * égal à la valeur en entrée
     * 
     * @param nombreLitDisponible le nombre de lits disponibles
     * @return la liste des chambres
     */
	List<ChambreDto> getListeChambreParNombreLitDisponible(Integer nombreLitDisponible);

	DossierPatientDto getDossierPatient(String noDossier);

	NoteCliniqueDto getNoteCliniqueEnRedaction(Long idNote);

	List<PatientDto> rechercher(PatientFiltre filtre);

	List<PatientJsonDto> rechercherPatientJsonParMotCle(String motCle);

}