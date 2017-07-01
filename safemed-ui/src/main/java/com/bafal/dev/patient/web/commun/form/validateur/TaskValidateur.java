package com.bafal.dev.patient.web.commun.form.validateur;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bafal.dev.patient.modele.dto.DmeTaskDto;


/**
 * Utilitaire de validation customizé du formulaire task
 * 
 * @author bafal
 *
 */
@Component
@Configurable
public class TaskValidateur implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
		return DmeTaskDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
		DmeTaskDto form = (DmeTaskDto) target;
		validerDate(form, errors);
    }

    /**
	 *
	 * @param form
	 *            le formulaire
	 * @param errors
	 *            les erreurs
	 */
	private void validerDate(DmeTaskDto form, Errors errors) {
		if (form.getDateDebut() != null && form.getDateEcheance() != null
				&& form.getDateDebut().after(form.getDateEcheance())) {
			if (form.getDateDebut().after(form.getDateEcheance())) {
				errors.rejectValue("dateDebut", "task.date.invalide",
						"La date de debut doit etre anterieure a la date d'echeance");
			}
		}
    }

}
