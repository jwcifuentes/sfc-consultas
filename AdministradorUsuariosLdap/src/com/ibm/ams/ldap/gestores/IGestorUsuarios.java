package com.ibm.ams.ldap.gestores;

import java.util.List;

import com.ibm.ams.ldap.dto.Usuario;
import com.ibm.ams.ldap.dto.UsuarioPassword;

import com.ibm.ams.ldap.dto.UsuarioModificado;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p>Interface con las funcionalidades que presenta el gestor de usuarios
*   
*   
* 	<p><b>Notas: </b>
*   <p>
*   
* 	<p><b>Proyecto base: </b> CompensacionPortlet
*   
*   @author <A HREF="mailto:oballest@co.ibm.com">Oscar Arturo Ballesteros</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 05/sep/2013
*   
*   @version 1.0, 06/sep/2013
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	<p>- Creacion de documentacion.
**/
public interface IGestorUsuarios {
	/**
	 * Metodo encargado de consultar un usuario por su identificador unico
	 * @param uid Identificador unico con el que se consulta el usuario
	 * @return Objeto DTO con la informacion del usuaruio extraida
	 */
	Usuario consultarUsuario(String uid);
	/**
	 * Metodo encargado de crear un usuario el el servidor Ldap.
	 * @param usuario Informacion del usuario encapsulada en un DTO
	 */
	void crearUsuario(Usuario usuario, String ruta);
	
	void crearUsuarioNuevo(Usuario usuario, String ruta) throws Exception;
	/**
	 * Metodo encargado de eliminar un usuario del directorio utilizando su identificador
	 * @param uid Identificador unico del usuario a eliminar.
	 * @return flag indicando si el usuario fue eliminado existosamente
	 */
	boolean eliminarUsuario(String uid);
	/**
	 * Metodo con el cual se modifica la entrada de un usuario en el directorio corporativo
	 * @param usuario Informacion del usuario a modificar.
	 */
	void modificar(Usuario usuario);
	
	
	/**
	 * Metodo con el cual se modifica las dos ultimas fechas de ingreo de un usuario en el directorio corporativo
	 * @param usuario Informacion del usuario a modificar.
	 */
	void modificarUsuario(UsuarioModificado usuarioModificado);
	
	/**
	 * Metodo encargado de modificar la constraseña de conexion al servidor para un usuarios
	 * @param uidUsuario Identificador unico del usuario al cual se le cambia la contraseña
	 * @param password nuevo password para la enttada
	 */
	boolean cambiarPassword(String uidUsuario,String password);
	/**
	 * Metodo encargado de asociar un usuario a un grupo en particular
	 * @param uidUsuario identificador unico del usuario a aosciar al gurpo
	 * @param cnGrupo identificador del gurpo al que se le asocia el usuario.
	 */
	void asociarGrupo(String uidUsuario,String cnGrupo, String tipoEntidad);
	
	List<String> consultarGruposPorTipo(String idUsuario, String rutaBusquedaGrupos);
	
	void modificarUsuarioSinPassword(UsuarioPassword usuarioPass);
	
	
}
