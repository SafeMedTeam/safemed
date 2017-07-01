package com.bafal.dev.patient.modele.dto;

import java.util.List;

import com.bafal.dev.patient.modele.base.dto.BaseDto;
import com.bafal.dev.patient.modele.base.enumeration.CodeService;

public class ServiceMedicalDto extends BaseDto {


    private CodeService codeService;

    private String nomService;

    private String description;

    private List<UtilisateurDto> personnels;


    public CodeService getCodeService() {
        return codeService;
    }

    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UtilisateurDto> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(List<UtilisateurDto> personnels) {
        this.personnels = personnels;
    }


}
