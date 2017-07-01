package com.bafal.dev.patient.modele.base.entite;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public abstract class BaseEntite extends UniqueObject {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@(?:[A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";

    public abstract Long getId();

    public boolean isSerialized() {
        return getId() != null;
    }

    public boolean isNotSerialized() {
        return !isSerialized();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("id",
            isSerialized() ? getId() : getuUID()).toString();
    }

}
