package com.ibm.ams.ldap.gestores;

import java.util.List;

import com.ibm.ams.ldap.dto.Grupo;

public interface IGestorGrupos {
	
	/**
	 * Metodo encargado de consultar la informacion de un grupo
	 * @param cnGrupo identificador del grupo en el directorio
	 * @return Informacion del grupo
	 */
	Grupo consultarGrupo(String cnGrupo);
	/**
	 * Metodo encargado de consultar la lista de usuarios de un grupo
	 * @param cnGrupo identificador del grupo para el cual se quiere conocer la lista de usuarios
	 * @return Listado de usuarios a las cuales estan asociados al grupo
	 */
	List<String> getUsuarios(String cnGrupo);
	
}
