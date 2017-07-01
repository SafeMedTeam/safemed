package com.bafal.dev.patient.modele.base.enumeration;

public enum TypeMaladie implements CodeEnum {

        DIAB("Diabète"),
        HTEN("Hypertension"),
        MCAR("Maladies cardiaques"),
        ASTM("Asthme"),
        HCHO("Hypercholestérolémie"),
        ALLE("Allergies"),
        ARTH("Arthrite"),
        OSTE("Ostéoporose"),
        HTYR("Hypothyroïdie"),
        MGEN("Maladies génétiques"),
        MPSY("Maladies psychiatriques"),
        CANC("Cancer"),
        MNEU("Maladies neurologiques"),
        AUTR("Autre");

    private final String nom;

    private TypeMaladie(String nom) {
        this.nom = nom;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
