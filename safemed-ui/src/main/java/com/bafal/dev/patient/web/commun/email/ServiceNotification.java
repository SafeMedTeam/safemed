package com.bafal.dev.patient.web.commun.email;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bafal.dev.patient.modele.base.exception.SafeMedException;
import com.bafal.dev.patient.modele.base.logger.SafeMedLogger;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.ResetMotDePasseDto;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;

import it.ozimov.springboot.templating.mail.model.Email;
import it.ozimov.springboot.templating.mail.model.impl.EmailImpl;
import it.ozimov.springboot.templating.mail.service.EmailService;
import it.ozimov.springboot.templating.mail.service.exception.CannotSendEmailException;

@Service
public class ServiceNotification {

	@Autowired
	public EmailService serviceEmail;

	private static final String UTF_8 = "UTF-8";

	public void envoyerNotificationCreationCompte(UtilisateurDto dto) throws SafeMedException {
		Email email;
		try {
			email = DmeEmailBuilder.build(dto);
			this.envoyerMail(email);
		} catch (UnsupportedEncodingException e) {
			SafeMedLogger.error(ServiceNotification.class, "Erreur survenue lors de lenvoi du mail", e);
			throw new SafeMedException(e.getMessage());
		}
	}

	public void envoyerNotificationCreationCompte(UtilisateurDto dto, String template) throws SafeMedException {
		try {
			// BATIR LES TOKENS
			final Map<String, Object> parametres = new HashMap<String, Object>();
			parametres.put("civilite", dto.getCivilite().getNom());
			parametres.put("prenom", dto.getPrenom());
			parametres.put("username", dto.getCodeUtilisateur());
			parametres.put("password", dto.getMotDePasse());
			parametres.put("courriel", dto.getCourriel());
			parametres.put("emailsupport", "support@admin.safemed.com");
			this.envoyerMail(DmeEmailBuilder.build(dto), template, parametres);
		} catch (UnsupportedEncodingException | CannotSendEmailException e) {
			SafeMedLogger.error(ServiceNotification.class, "Erreur lors de lenvoi du mail avec Template ..", e);
			throw new SafeMedException(e.getMessage());
		}

	}

	public void envoyerNotificationResetMDP(ResetMotDePasseDto dto, String template) throws SafeMedException {
		try {
			// BATIR LES TOKENS
			final Map<String, Object> parametres = new HashMap<String, Object>();
			parametres.put("password", dto.getNouveauMotDePasse());
			parametres.put("courriel", dto.getCourriel());
			parametres.put("emailsupport", "support@admin.safemed.com");
			Email email = EmailImpl.builder().from(new InternetAddress("noreply@admin.safemed.com", "NOREPLY SafeMed")) //
					.to(DME.asList(new InternetAddress("bafal.fall@gmail.com", "bafal.fall@gmail.com"))) //
					.subject("SafeMed Reset Password") //
					.body("").encoding(Charset.forName(UTF_8)).build();
			this.envoyerMail(email, template, parametres);
		} catch (UnsupportedEncodingException | CannotSendEmailException e) {
			SafeMedLogger.error(ServiceNotification.class, "Erreur lors de lenvoi du mail avec Template ..", e);
			throw new SafeMedException(e.getMessage());
		}
	}

	public void envoyerMail(Email email) {
		serviceEmail.send(email);
	}

	public void envoyerMail(Email email, String template, Map<String, Object> parametres)
			throws CannotSendEmailException {
		serviceEmail.send(email, template, parametres);
	}
}
