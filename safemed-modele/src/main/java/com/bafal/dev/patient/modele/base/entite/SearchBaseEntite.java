package com.bafal.dev.patient.modele.base.entite;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("serial")
public abstract class SearchBaseEntite extends BaseEntite {

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("id",
            isSerialized() ? getId() : getuUID()).toString();
    }

}
