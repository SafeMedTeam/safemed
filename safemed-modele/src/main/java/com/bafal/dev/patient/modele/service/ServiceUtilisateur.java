package com.bafal.dev.patient.modele.service;

import java.util.List;
import java.util.Optional;

import com.bafal.dev.patient.modele.base.enumeration.CodePrivilege;
import com.bafal.dev.patient.modele.base.enumeration.CodeService;
import com.bafal.dev.patient.modele.dto.AgendaDto;
import com.bafal.dev.patient.modele.dto.DmeTaskDto;
import com.bafal.dev.patient.modele.dto.PrivilegeDto;
import com.bafal.dev.patient.modele.dto.ResetMotDePasseDto;
import com.bafal.dev.patient.modele.dto.RoleDto;
import com.bafal.dev.patient.modele.dto.ServiceMedicalDto;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.dto.UtilisateurJsonDto;

public interface ServiceUtilisateur {

    void modifierMotDePasse(String codeUtilisateur, String motDePasseActuel, String nouveauMotDePasse);

    /**
     * Retourne le personnel dont le code est passé en parametre
     * 
     * @param codeUtilisateur le code personnel
     * @return l'utilisateur trouvé
     */
	Optional<UtilisateurDto> getUtilisateur(String codeUtilisateur);

	Optional<UtilisateurDto> getUtilisateurParCourriel(String courriel);

    /**
     * Sauvegarde les modifications apportées à l'utilisateur en parametre
     * 
     * @param dto le personnel
     * @return l'utilisateur modifié
     */
	UtilisateurDto enregistrer(UtilisateurDto dto);

	ServiceMedicalDto getServiceMedical(Long idService);

	ServiceMedicalDto getServiceMedical(CodeService codeService);

	List<PrivilegeDto> getPrivileges(CodePrivilege... code);

	List<PrivilegeDto> getListePrivileges();

	List<ServiceMedicalDto> getListeServices();

	List<RoleDto> getRoles(String... codeRoles);

	List<RoleDto> getListeRoles();

	RoleDto enregistrerRole(RoleDto dto);

	void resetPassword(ResetMotDePasseDto dto);

	UtilisateurDto getUtilisateur(Long id);

	DmeTaskDto getTask(Long id);

	DmeTaskDto enregistrerTask(DmeTaskDto dto);

	List<UtilisateurJsonDto> getListeUtilisateursJson();

	List<UtilisateurJsonDto> rechercherUtilisateursJsonParMotCle(String motCle);

	List<AgendaDto> getAgendas();

	AgendaDto getAgenda(Long idPraticien);
}
