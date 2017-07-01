package com.uva.dev.patient.modele.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bafal.dev.patient.modele.SafeMedModeleApplication;
import com.bafal.dev.patient.modele.dao.PrivilegeDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafeMedModeleApplication.class)
public class PrivilegeDaoTest {

	@Autowired
	private PrivilegeDao dao;

	@Test
	public void testAddPrivilege() {

		/*
		 * for (CodePrivilege code : CodePrivilege.values()) { Privilege role =
		 * new Privilege(); role.setCode(code); role.setNom(code.getNom());
		 * role.setDescription("Privilege Acces : " + code.getNom());
		 * role.setCreePar("bafal"); role.setDateCreation(DME.now());
		 * 
		 * dao.save(role); }
		 */

		assertTrue(true);
	}

}
