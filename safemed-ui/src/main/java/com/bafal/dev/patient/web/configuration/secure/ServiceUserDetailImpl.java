package com.bafal.dev.patient.web.configuration.secure;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bafal.dev.patient.modele.base.exception.UtilisateurNonTrouveException;
import com.bafal.dev.patient.modele.dto.UtilisateurDto;
import com.bafal.dev.patient.modele.service.DmeCRUD;

@Service
public class ServiceUserDetailImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UtilisateurDto utilisateur =
            DmeCRUD
                .getServiceUtilisateur()
                .getUtilisateur(username)
                .orElseThrow(
                    () -> new UtilisateurNonTrouveException(String.format(
                        "L'utilisateur [%s] n'existe pas.", username)));

        return new UtilisateurSecure(utilisateur);
    }

}
