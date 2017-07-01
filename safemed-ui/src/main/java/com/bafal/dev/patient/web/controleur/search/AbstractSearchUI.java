package com.bafal.dev.patient.web.controleur.search;

import java.util.List;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.filtre.BaseFiltre;

public abstract class AbstractSearchUI<T extends BaseFiltre, U extends BaseDto> {

    public static final String SESSION_SEARCH_KEY = "entity";

    protected abstract String getSearchJsp();

    protected abstract String getMenuSearch();

    protected abstract T creerFiltre();

    protected abstract List<U> effectuerRecherche();

}
