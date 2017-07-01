package com.uva.dev.patient.modele.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bafal.dev.patient.modele.SafeMedModeleApplication;
import com.bafal.dev.patient.modele.dao.PatientDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafeMedModeleApplication.class)
public class PatientDaoTest {

    @Autowired
    private PatientDao dao;

    @Test
    public void testRecherche() {
        assertTrue(true);
    }

}
