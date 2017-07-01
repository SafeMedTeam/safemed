package com.uva.dev.patient.modele.dto;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.base.util.DmeConstante;
import com.bafal.dev.patient.modele.dto.AgendaSchedulerDto;

public class SchedulerTest {

	@Test
	public void testBuildAgendaSemaineDefault() {
		AgendaSchedulerDto agenda = AgendaSchedulerDto.buildDefaultSemaine();
		assertTrue(agenda.getPlagesUneSemaine().size() == 14);
	}

	@Test
	public void testGetDate00H00_23H59() {
		Date entree = DME.now();
		Date minuit = DME.getDateJour00h00(DME.now());
		Date max = DME.getDateJour23h59(DME.now());
		assertTrue(max.after(minuit));
		System.out.println("Entree -> " + DME.format(entree, DmeConstante.FORMAT_DDMMYYYY_HHMM));
		System.out.println("Minuit -> " + DME.format(minuit, DmeConstante.FORMAT_DDMMYYYY_HHMM));
		System.out.println("Max -> " + DME.format(max, DmeConstante.FORMAT_DDMMYYYY_HHMM));
	}


}
