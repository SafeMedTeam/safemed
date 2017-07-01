package com.bafal.dev.patient.web;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bafal.dev.patient.modele.entite.Chambre;
import com.bafal.dev.patient.web.commun.menu.MenuItem;
import com.bafal.dev.patient.web.commun.util.SafeMedUtils;

public class TestUtilitaireWeb {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		List<MenuItem> menu = SafeMedUtils.getMenus("/personnel");
		assertTrue(menu.size() ==5);
	}
	
	//OK
	@Test 
	public void testNombreLitsDispo(){
		List<Chambre> chambresDisponibles = getListeChambresDisponibles();
		Integer valeur = chambresDisponibles
			.stream()
			.mapToInt(d -> d.getNombreLitDisponible())
			.sum();
		
		assertEquals(valeur.intValue(), 9);
	}

	private List<Chambre> getListeChambresDisponibles() {
		return Arrays.asList(addChambre("3.20", 3), addChambre("3.21", 2), addChambre("386", 4));
	}

	private Chambre addChambre(String code, int nbLitsDispo) {
		Chambre chambre = new Chambre();
		chambre.setCodeChambre(code);
		chambre.setNombreLitDisponible(nbLitsDispo);
		return chambre;
	}
	

}
