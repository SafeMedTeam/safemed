package com.bafal.dev.patient.web.commun.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.base.util.DmeConstante;
import com.bafal.dev.patient.modele.dto.PatientDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;

public class DmeUIDGeneratorUtils {

    private static int MIN_LENGTH = 2;

	private static final int LONGUEUR_PASSWAORD = 8;

	private static final int LIMITE_ZERO = 0;

	private static final int LIMITE_SUP_CHIFFRE = 2;
	private static final int LIMITE_SUP_LETTRE = 6;
	private static final int POSSIBILITE_CHIFFRE = 10;
	private static final int POSSIBILITE_CARACTERE = 52;
	private static final int DEBUT_CHIFFRE_ASCII = 48;
	private static final int DEBUT_LETTRE_ASCII = 65;
	// DE 90 A 96 les codes ASCII ne sont pas des lettres.
	private static final int FIN_LETTRE_MAJUSTCULE_ASCII = 90;

	public static String genererPatientNoDossierUID(PatientDto dto) {
        StringBuilder uidBuilder = new StringBuilder();
        String prefixe = getPrefixe(dto);
        if (StringUtils.isNotBlank(prefixe)) {
            uidBuilder.append(prefixe);
        }
		uidBuilder.append(getDateSelonFormat(DmeConstante.FORMAT_UID_YYMMDD, dto.getDateNaissance()));
        int numeroSuivant =
            DmeCRUD.getServicePatient().getNombrePatientsByNumeroDossier(uidBuilder.toString()).intValue() + 1;
        uidBuilder.append(StringUtils.leftPad(String.valueOf(numeroSuivant), 3, '0'));
        return uidBuilder.toString();
    }

	private static String getPrefixe(PatientDto patient) {
        Validate.notNull(patient);
        Validate.notNull(patient.getNom());
        Validate.notNull(patient.getPrenom());
        Validate.isTrue(patient.getNom().length() >= MIN_LENGTH);

        StringBuilder prefixBuilder = new StringBuilder();
        if (patient.getNom().length() > MIN_LENGTH) {
            prefixBuilder.append(patient.getNom().substring(0, 3).toUpperCase());
            prefixBuilder.append(patient.getPrenom().substring(0, 1).toUpperCase());
        } else if (patient.getNom().length() == MIN_LENGTH) {
            prefixBuilder.append(patient.getNom().toUpperCase());
            prefixBuilder.append(patient.getPrenom().substring(0, 2).toUpperCase());
        }
        return prefixBuilder.toString();
    }

    public static String getGeneratedUIDFormate(String uid) {
        return uid;
    }

    private static String getDateSelonFormat(String format, Date date) {
        Validate.notNull(date);
        return new SimpleDateFormat(format).format(date);
    }

	/**
	 * Cette methode permet de generer un mot de passe temporaire de facon
	 * aleatoire. Le mot de passe contient 6 caracteres et 2 chiffres
	 * 
	 * @return Le mot de passe
	 */
	public static String genererMotDePasse() {
		int asciiCode, position;
		Random rand = new Random();

		// Le mot de passe genere possede 8 caracteres
		StringBuilder passwordBuilder = new StringBuilder(LONGUEUR_PASSWAORD);

		// Le mot de passe doit avoir 6 caracteres et 2 chiffres aleatoires.
		for (int i = LIMITE_ZERO; i < LIMITE_SUP_LETTRE; i++) {
			// Codes ASCII des lettres majuscules debutent a  65 et il y a 52
			// caracteres possibles en differenciant majuscules et minuscules
			asciiCode = rand.nextInt(POSSIBILITE_CARACTERE) + DEBUT_LETTRE_ASCII;

			// 6 caracteres separent les lettres majuscules et minuscules dans
			// la table de codes ASCII (91 a 96)
			// on doit donc additionner 6 a  tous les codes au-dela  de 90
			if (asciiCode > FIN_LETTRE_MAJUSTCULE_ASCII) {
				asciiCode = asciiCode + LIMITE_SUP_LETTRE;
			}
			passwordBuilder.append((char) asciiCode);
		}

		for (int j = LIMITE_ZERO; j < LIMITE_SUP_CHIFFRE; j++) {
			// ASCII des chiffres debutent a 48 et il y a 10 chiffres possibles
			asciiCode = rand.nextInt(POSSIBILITE_CHIFFRE) + DEBUT_CHIFFRE_ASCII;
			// Determiner aleatoirement position ou inserer le chiffre
			position = rand.nextInt(LIMITE_SUP_LETTRE);
			// Inserer le chiffre a la position donnee
			passwordBuilder.insert(position, (char) asciiCode);
		}

		return passwordBuilder.toString();
	}

	/**
	 * genere le code utilisateur unique en fonction du prenom et du nom de
	 * l'utilisateur
	 * 
	 * @param prenom
	 * @param nom
	 * @return
	 */
	public static String genererCodeUtilisateur(String prenom, String nom) {
		String code = DME.normaliserChaine(prenom).charAt(0)
				+ StringUtils.substring(DME.normaliserChaine(nom), 0, Math.min(7, nom.length()));
		// TODO Tester s'il existe en BD
		return code.toLowerCase();
	}

}
