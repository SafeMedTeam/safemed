package com.bafal.dev.patient.modele.builder;

import java.util.ArrayList;
import java.util.List;

import com.bafal.dev.patient.modele.base.enumeration.CodePrivilege;
import com.bafal.dev.patient.modele.base.util.DME;
import com.bafal.dev.patient.modele.dto.PrivilegeDto;

public class PrivilegeBuilder {

	public static CodePrivilege[] toCodePrivilege(String... codePrivileges) {
		List<CodePrivilege> codes = new ArrayList<>();
		for (String code : codePrivileges) {
			codes.add(CodePrivilege.valueOf(code));
		}
		return codes.toArray(new CodePrivilege[] {});
	}

	public static String[] fromPrivilege(List<PrivilegeDto> privileges) {
		List<String> codes = new ArrayList<>();
		if (DME.isNotEmpty(privileges)) {
			privileges.forEach(privilege -> codes.add(privilege.getCode().name()));
		}
		return codes.toArray(new String[] {});
	}
}
