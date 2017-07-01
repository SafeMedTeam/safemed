package com.bafal.dev.patient.modele.base.entite;

import java.io.Serializable;
import java.util.UUID;

public abstract class UniqueObject implements Serializable {

    private static final long serialVersionUID = -761055703431011558L;

    private final String uUID;

    public UniqueObject() {
        uUID = UUID.randomUUID().toString();
    }

    public String getuUID() {
        return uUID;
    }

}
