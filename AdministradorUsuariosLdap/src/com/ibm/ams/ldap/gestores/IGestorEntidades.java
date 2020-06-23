package com.ibm.ams.ldap.gestores;

import com.ibm.ams.ldap.dto.Entidad;

public interface IGestorEntidades {
	
	void crearEntidad(String cn, String organization, String ruta, Entidad entidad);

}
