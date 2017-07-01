package com.bafal.dev.patient.web.commun.util;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.bafal.dev.patient.modele.base.enumeration.CodePrivilege;
import com.bafal.dev.patient.modele.base.util.DME;

public class SafeMedSecurityUtils {

	// example usage --> @PreAuthorize("@securityUtils.hasAnyRole(...)")

	public static boolean hasAnyPrivilege(CodePrivilege... roles) { // hasPermission() // hasAnyPrivilege() 
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication()
				.getAuthorities();

		if (DME.isNotEmpty(authorities)) {
			for (CodePrivilege role : roles) {
				if (role.name().equals(((GrantedAuthority) authorities.toArray()[0]).getAuthority())) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	public static String getCurrentUser() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	
	 /**
     * Returns true if the currently logged user has the privilege to edit a requisition.
     * @return
     */
    public boolean isAdministrationAllowed(){
		return hasAnyPrivilege();
    }  
    

}
