package com.bafal.dev.patient.web.commun.form.validateur;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bafal.dev.patient.modele.dto.ResetMotDePasseDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;


/**
 * Utilitaire de validation customizé du formulaire d'inscription
 * 
 * @author bafal
 *
 */
@Component
@Configurable
public class ResetValidateur implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
		return ResetMotDePasseDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
		ResetMotDePasseDto form = (ResetMotDePasseDto) target;
		validerResetForm(form, errors);


    }


    /**
	 * Permet de valider si lutilisateur dont le courriel est passe en param
	 * existe des utilisateurs
	 * 
	 * @param form
	 *            le formulaire
	 * @param errors
	 *            les erreurs
	 */
	private void validerUtilisateurExistant(ResetMotDePasseDto form, Errors errors) {
		if (!DmeCRUD.getServiceUtilisateur().getUtilisateurParCourriel(form.getCourriel()).isPresent()) {
			errors.rejectValue("courriel", "utilisateur.nexiste.pas", "Aucun utilisateur est associe a ce courriel");
        }
    }

    /**
     * Permet de valider que les mots de passe saisis sont identiques.
     * 
     * @param form le formulaire
     * @param errors les erreurs
     */
	private void validerResetForm(ResetMotDePasseDto form, Errors errors) {
		if (!form.getCourriel().equals(form.getConfirmation())) {
			errors.rejectValue("courriel", "utilisateur.courriel.nonegale", "les courriels ne sont pas identiques.");
			errors.rejectValue("confirmation", "utilisateur.confirmation.nonegale",
					"les courriels ne sont pas identiques.");
		} else {
			validerUtilisateurExistant(form, errors);
        }
    }

}
