package com.bafal.dev.patient.web.configuration.secure;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.RoleDto;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;

@SuppressWarnings("serial")
public class UtilisateurSecure extends UtilisateurDto implements UserDetails {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurSecure.class);
	
	public UtilisateurSecure() {
		super();
	}
	
	public UtilisateurSecure(UtilisateurDto personnel) {
		try {
			BeanUtils.copyProperties(this, personnel);
		} catch (IllegalAccessException | InvocationTargetException e) {
			LOGGER.error(e.getMessage(), e); 
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		List<RoleDto> roles = this.getRoles();
		LOGGER.info("Chargement des roles de l'utilisateur ... ");
		if (DME.isNotEmpty(roles)) {
			roles.forEach(role -> {
				role.getPrivileges()
						.forEach(privilege -> authorities.add(new SimpleGrantedAuthority(privilege.getCode().name())));
			});
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getMotDePasse();
	}

	@Override
	public String getUsername() {
		return super.getCodeUtilisateur();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.getDateFinActivite().after(Date.from(Instant.now()));
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return super.getDateDebutActivite().before(Date.from(Instant.now()))
				&& super.getDateFinActivite().after(Date.from(Instant.now()));
	}

}
