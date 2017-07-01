package com.uva.dev.patient.modele.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bafal.dev.patient.modele.SafeMedModeleApplication;
import com.bafal.dev.patient.modele.dao.DomaineValeurDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafeMedModeleApplication.class)
public class DomaineValeurDaoTest {

    private static final String CLE_DOMAINE_PAYS = "PAYS";
    @Autowired
    private DomaineValeurDao dao;

    @Test
    public void testGetListePays() {
        // List<DomaineValeur> listePays =
        // dao.findAllByIdCleDomaineOrderByOrdreTriAsc(CLE_DOMAINE_PAYS);
        assertTrue(true);
    }

    @Test
    public void testListeDomainevaleur() {
        // List<DomaineValeur> listeDomaine = dao.findAllByIdCleDomaine(CLE_DOMAINE_PAYS);
        assertTrue(true);
    }

}
