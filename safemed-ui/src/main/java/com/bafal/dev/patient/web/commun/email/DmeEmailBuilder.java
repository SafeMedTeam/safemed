package com.bafal.dev.patient.web.commun.email;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.mail.internet.InternetAddress;

import com.bafal.dev.patient.modele.base.logger.SafeMedLogger;
import com.bafal.dev.patient.modele.base.logger.SafeMedLogger.Level;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.FichierDto;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;

import it.ozimov.springboot.templating.mail.model.Email;
import it.ozimov.springboot.templating.mail.model.impl.EmailAttachmentImpl;
import it.ozimov.springboot.templating.mail.model.impl.EmailImpl;

public class DmeEmailBuilder {

	private static final String UTF_8 = "UTF-8";

	public static Email build(UtilisateurDto dto) throws UnsupportedEncodingException {
		return EmailImpl.builder()
				.from(new InternetAddress("noreply@admin.safemed.com", "NOREPLY SafeMed")) //
				.to(DME.asList(new InternetAddress("bafal.fall@gmail.com", dto.getPrenom() + " " + dto.getNom()))) //
				.subject("SafeMed Account created ") //
				.body("") //
				// .attachments(DmeEmailBuilder.buildAttachements(dto.getFichiers()))
				// .cc(DmeEmailBuilder.buildInternetAdresses(dto.getCc())) //
				// .bcc(DmeEmailBuilder.buildInternetAdresses(dto.getBcc())) //
				.encoding(Charset.forName(UTF_8)).build();
	}
	
	public static Collection<EmailAttachmentImpl> buildAttachements(List<FichierDto> fichiers) {
		if (DME.isEmpty(fichiers)) {

			// TODO a implementer
			return null;
		}
		return null;
	}

	static List<InternetAddress> buildInternetAdresses(List<String> destinataires) throws UnsupportedEncodingException {
		if (DME.isEmpty(destinataires)) {
			return null;
		}
		List<InternetAddress> adresses = new ArrayList<>();
		destinataires.forEach(dest -> {
			try {
				adresses.add(new InternetAddress(dest, dest));
			} catch (UnsupportedEncodingException e) {
				SafeMedLogger.log(DmeEmailBuilder.class, "Erreur InternetAddress", Level.ERROR);
			}
		});

		return adresses;
	}
}
