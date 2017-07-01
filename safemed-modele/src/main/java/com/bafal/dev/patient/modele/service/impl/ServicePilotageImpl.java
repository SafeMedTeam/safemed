package com.bafal.dev.patient.modele.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bafal.dev.patient.modele.dao.DomaineValeurDao;
import com.bafal.dev.patient.modele.entite.DomaineValeur;
import com.bafal.dev.patient.modele.service.ServicePilotage;

@Service
public class ServicePilotageImpl implements ServicePilotage {

    @Autowired
    private DomaineValeurDao daoDomaineValeur;

    @Override
    public List<DomaineValeur> getListePays() {
        return daoDomaineValeur.findAllByIdCleDomaineOrderByOrdreTriAsc(CLE_DOMAINE_PAYS);
    }

    @Override
    public List<DomaineValeur> getListeDomaineValeur(String cleDomaine) {
        return daoDomaineValeur.findAllByIdCleDomaineOrderByOrdreTriAsc(cleDomaine);
    }

}
