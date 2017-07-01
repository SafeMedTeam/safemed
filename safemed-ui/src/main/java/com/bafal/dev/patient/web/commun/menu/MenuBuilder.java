package com.bafal.dev.patient.web.commun.menu;

import java.util.List;

public class MenuBuilder {

    public static MenuItem buildMenu(int ordreTri, String nom, String url, String cssClasse, List<ItemEnfant> items) {
        MenuItem menu = new MenuItem();
        menu.setOrdreTri(ordreTri);
        menu.setNom(nom);
        menu.setUrl(url);
        menu.setCssClasse(cssClasse);
        menu.setItems(items);

        return menu;
    }

    public static ItemEnfant buildMenuEnfant(int ordreTri, String nom, String url, String cssClasse) {
        ItemEnfant item = new ItemEnfant();
        item.setOrdreTri(ordreTri);
        item.setNom(nom);
        item.setUrl(url);
        item.setCssClasse(cssClasse);

        return item;
    }
}
