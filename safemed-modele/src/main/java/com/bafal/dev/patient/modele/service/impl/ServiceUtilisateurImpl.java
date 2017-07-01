package com.bafal.dev.patient.modele.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bafal.dev.patient.modele.base.enumeration.CodePrivilege;
import com.bafal.dev.patient.modele.base.enumeration.CodeService;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.converter.DmeTaskConverter;
import com.bafal.dev.patient.modele.converter.PrivilegeConverter;
import com.bafal.dev.patient.modele.converter.RoleConverter;
import com.bafal.dev.patient.modele.converter.ServiceMedicalConverter;
import com.bafal.dev.patient.modele.converter.UtilisateurConverter;
import com.bafal.dev.patient.modele.converter.UtilisateurJsonConverter;
import com.bafal.dev.patient.modele.dao.DmeTaskDao;
import com.bafal.dev.patient.modele.dao.PrivilegeDao;
import com.bafal.dev.patient.modele.dao.RoleDao;
import com.bafal.dev.patient.modele.dao.ServiceMedicalDao;
import com.bafal.dev.patient.modele.dao.UtilisateurDao;
import com.bafal.dev.patient.modele.dao.UtilisateurJsonDao;
import com.bafal.dev.patient.modele.dto.AgendaDto;
import com.bafal.dev.patient.modele.dto.DmeTaskDto;
import com.bafal.dev.patient.modele.dto.PrivilegeDto;
import com.bafal.dev.patient.modele.dto.ResetMotDePasseDto;
import com.bafal.dev.patient.modele.dto.RoleDto;
import com.bafal.dev.patient.modele.dto.ServiceMedicalDto;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.dto.UtilisateurJsonDto;
import com.bafal.dev.patient.modele.service.ServiceUtilisateur;

@Service
public class ServiceUtilisateurImpl implements ServiceUtilisateur {

    @Autowired
	private UtilisateurDao daoUser;
    @Autowired
	private UtilisateurJsonDao daoUserJson;
	@Autowired
    private ServiceMedicalDao daoService;
    @Autowired
	private PrivilegeDao daoPrivilege;
	@Autowired
	private DmeTaskDao daoTask;

	@Autowired
	private RoleDao daoRole;

    @Override
    public void modifierMotDePasse(String codeUtilisateur, String motDePasseActuel, String nouveauMotDePasse) {
        daoUser.setPersonnelMotDePasseFor(codeUtilisateur, motDePasseActuel, nouveauMotDePasse);
    }

	@Override
	public void resetPassword(ResetMotDePasseDto dto) {
		daoUser.setMotDePasseFor(dto.getCourriel(), dto.getNouveauMotDePasse());
	}

    @Override
	public Optional<UtilisateurDto> getUtilisateur(String codeUtilisateur) {
		return Optional.ofNullable(UtilisateurConverter.toDto(daoUser.findOneByCodeUtilisateur(codeUtilisateur)));
    }

	@Override
	public Optional<UtilisateurDto> getUtilisateurParCourriel(String courriel) {
		return Optional.ofNullable(UtilisateurConverter.toDto(daoUser.findOneByCourriel(courriel)));
	}

    @Override
	public UtilisateurDto enregistrer(UtilisateurDto utilisateur) {
		return UtilisateurConverter.toDto(daoUser.save(UtilisateurConverter.fromDto(utilisateur)));
    }

    @Override
	public ServiceMedicalDto getServiceMedical(Long idService) {
		return ServiceMedicalConverter.toDto(daoService.findOne(idService));
    }

    @Override
	public ServiceMedicalDto getServiceMedical(CodeService codeService) {
		return ServiceMedicalConverter.toDto(daoService.findOneByCodeService(codeService));
    }

	@Override
	public List<PrivilegeDto> getPrivileges(CodePrivilege... codes) {
		return PrivilegeConverter.toDtos(daoPrivilege.findByCodeIn(DME.asList(codes)));
	}

	@Override
	public List<PrivilegeDto> getListePrivileges() {
		return PrivilegeConverter.toDtos(daoPrivilege.findAll());
	}

	@Override
	public List<ServiceMedicalDto> getListeServices() {
		return ServiceMedicalConverter.toDtos(daoService.findAll());
	}

	@Override
	public List<RoleDto> getRoles(String... codes) {
		return RoleConverter.toDtos(daoRole.findByCodeIn(DME.asList(codes)));
	}

	@Override
	public List<RoleDto> getListeRoles() {
		return RoleConverter.toDtos(daoRole.findAll());
	}

	@Override
	public RoleDto enregistrerRole(RoleDto dto) {
		return RoleConverter.toDto(RoleConverter.fromDto(dto));
	}

	@Override
	public UtilisateurDto getUtilisateur(Long id) {
		return UtilisateurConverter.toDto(daoUser.findOne(id));
	}

	@Override
	public DmeTaskDto getTask(Long id) {
		return DmeTaskConverter.toDto(daoTask.findOne(id));
	}

	@Override
	public DmeTaskDto  enregistrerTask(DmeTaskDto dto) {
		return DmeTaskConverter.toDto(daoTask.save(DmeTaskConverter.fromDto(dto)));
	}

	@Override
	public List<UtilisateurJsonDto> getListeUtilisateursJson() {
		return UtilisateurJsonConverter.toDtos(daoUserJson.findAll());
	}

	@Override
	public List<AgendaDto> getAgendas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgendaDto getAgenda(Long idPraticien) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilisateurJsonDto> rechercherUtilisateursJsonParMotCle(String motCle) {
		return UtilisateurJsonConverter.toDtos(daoUserJson.findByNomCompletContaining(motCle));
	}

}
