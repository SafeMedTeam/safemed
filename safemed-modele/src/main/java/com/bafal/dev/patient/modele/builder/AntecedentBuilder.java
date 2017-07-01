package com.bafal.dev.patient.modele.builder;

import com.bafal.dev.patient.modele.base.enumeration.TypeAntecedent;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentChirurgicalDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentFamilialDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentObstetricalDto;
import com.bafal.dev.patient.modele.dto.antecedent.AntecedentPersonnelDto;
import com.bafal.dev.patient.modele.entite.antecedent.Antecedent;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentChirurgical;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentFamilial;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentObstetrical;
import com.bafal.dev.patient.modele.entite.antecedent.AntecedentPersonnel;

public class AntecedentBuilder {

	public static Antecedent build(TypeAntecedent type) {
		if (DME.isNull(type)) {
			return null;
		}
		switch (type) {
			case CHIRU:
				return new AntecedentChirurgical();
			case FAMIL:
				return new AntecedentFamilial();
			case OBSTE:
				return new AntecedentObstetrical();
			case PERSO:
				return new AntecedentPersonnel();
			default:
				break;
		}
		return new Antecedent();
	}

	public static AntecedentDto buildDto(TypeAntecedent type) {
		if (DME.isNull(type)) {
			return null;
		}
		switch (type) {
			case CHIRU:
				return new AntecedentChirurgicalDto();
			case FAMIL:
				return new AntecedentFamilialDto();
			case OBSTE:
				return new AntecedentObstetricalDto();
			case PERSO:
				return new AntecedentPersonnelDto();
			default:
				break;
		}
		return new AntecedentDto();
	}
}
