package com.bafal.dev.patient.web.commun.form.validateur;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;


/**
 * Utilitaire de validation customizé du formulaire d'inscription
 * 
 * @author bafal
 *
 */
@Component
@Configurable
public class UtilisateurValidateur implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
		return UtilisateurDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
		UtilisateurDto form = (UtilisateurDto) target;
        validerCodeUtilisateur(form, errors);
        validerMotDePasse(form, errors);

    }


    /**
     * Permet de valider que le code d'utilisateur n'est pas déjà présent dans l'annuaire
     * des utilisateurs
     * 
     * @param form le formulaire
     * @param errors les erreurs
     */
	private void validerCodeUtilisateur(UtilisateurDto form, Errors errors) {
		if (DmeCRUD.getServiceUtilisateur().getUtilisateur(form.getCodeUtilisateur()).isPresent()) {
            errors.rejectValue("nomUtilisateur", "utilisateur.existe.deja", "Le nom d'utilisateur existe deja!");
        }
    }

    /**
     * Permet de valider que les mots de passe saisis sont identiques.
     * 
     * @param form le formulaire
     * @param errors les erreurs
     */
	private void validerMotDePasse(UtilisateurDto form, Errors errors) {
		if (!form.getMotDePasse().equals(form.getConfirmationMotDePasse())) {
            errors.rejectValue("motDePasse", "utilisateur.motdepasse.nonegale",
                "les mots de passe ne sont pas identiques.");
            errors.rejectValue("confirmationMotDePasse", "utilisateur.confmotdepasse.nonegale",
                "les mots de passe ne sont pas identiques.");
        }
    }

}
