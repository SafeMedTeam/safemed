package com.bafal.dev.patient.web.configuration.secure;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Configurable
public class SafeMedAuthProvider implements AuthenticationProvider{

	private static final Logger LOGGER = LoggerFactory.getLogger(SafeMedAuthProvider.class);
	private static final String MSG_ERREUR = "";
	
	@Autowired
	private ServiceUserDetailImpl service;
	
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		try {
			String username = (String) auth.getPrincipal();
			String password = (String) auth.getCredentials();
			UserDetails user = service.loadUserByUsername(username);
			if (user != null && password.equals(user.getPassword())) {
				Collection<? extends GrantedAuthority> authorities = user
						.getAuthorities();
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			} else {
				throw new BadCredentialsException(MSG_ERREUR);
			}

		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			throw new BadCredentialsException(MSG_ERREUR); 
		}
	}
	

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
