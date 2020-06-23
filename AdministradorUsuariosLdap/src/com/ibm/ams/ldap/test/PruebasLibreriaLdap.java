package com.ibm.ams.ldap.test;

import java.io.File;
import java.util.List;

import com.ibm.ams.excepcion.XmlToDtoException;
import com.ibm.ams.ldap.config.ConfiguracionMapeoLdap;
import com.ibm.ams.ldap.config.ConfiguracionParametrosLdap;
import com.ibm.ams.ldap.dto.Grupo;
import com.ibm.ams.ldap.dto.Usuario;
import com.ibm.ams.ldap.gestores.GestorGrupos;
import com.ibm.ams.ldap.gestores.GestorUsuarios;
import com.ibm.ams.utils.XmlToDto;

public class PruebasLibreriaLdap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//pruebasUsuarios();
		cargarConfiguracion();
	}
	
	public static void pruebasGrupos(ConfiguracionParametrosLdap configP,ConfiguracionMapeoLdap config){
		GestorGrupos gestorG = GestorGrupos.getInstance(configP,config);
		Grupo  g =gestorG.consultarGrupo("wpsadmins");
		System.out.println("Grupo "+g.getNombreGrupo());
		System.out.println("Usuario "+g.getUsuarios()[0]);
		List<String> usuarios =gestorG.getUsuarios("wpsadmins");
		System.out.println("Usuarios "+usuarios);
	}
	
	public static void pruebasUsuarios(ConfiguracionParametrosLdap configP,ConfiguracionMapeoLdap config){
		//Usuario usuario = new Usuario("Oscar Arturo","Ballesteros Galvis","oballest@co.ibm.com","oballest","pass","es_CO");
	//	System.out.println(usuario);
		
		
		
		GestorUsuarios gUsuarios = GestorUsuarios.getInstance(configP,config);
		//gUsuarios.crearUsuario(usuario);
		//Usuario usuario1 = gUsuarios.consultarUsuario("comercio1");
		//System.out.println(usuario1);
		//System.out.println(usuario1.getNombres());
		//System.out.println(usuario1.getGrupos());
		//gUsuarios.asociarGrupo("oballest", "wpsadmins");
		//gUsuarios.asociarGrupo("oballest", "wpsContentAdministrators");
		//gUsuarios.cambiarPassword("oballest", "");
		//gUsuarios.eliminarUsuario("oballest");
		
	//	usuario.setNombres("Oscar");
		//usuario.setApellidos("Ballesteros");
		
		//gUsuarios.modificar(usuario);
		System.out.println(gUsuarios.consultarListaEntidades("comercio1")) ;
		//boolean esredeaban = gUsuarios.esUsuarioRedeban("comercio1");
		//System.out.println("es redeaban "+esredeaban);
	}
	
	public static void cargarConfiguracion(){
		XmlToDto<ConfiguracionMapeoLdap> parser = new XmlToDto<ConfiguracionMapeoLdap>();
		
		
		File archivo = new File("C:/$user/WMBWorkspaceRBM/AdministradorUsuariosLdap/src/com/ibm/ams/ldap/test/ldapMappign.xml");
		File archivo1 = new File("C:/$user/WMBWorkspaceRBM/AdministradorUsuariosLdap/src/com/ibm/ams/ldap/test/ldapConfig.xml");
		try {
			ConfiguracionMapeoLdap config = new ConfiguracionMapeoLdap();
			config=  parser.getDto(config, archivo);
			System.out.println("config "+config.getBaseBusqueda());
			
			ConfiguracionParametrosLdap configP = new ConfiguracionParametrosLdap();
			configP=  parser.getDto(configP, archivo1);
			System.out.println("configP "+configP.getLdaphost());
			
			//pruebasUsuarios(configP, config);
			//pruebasGrupos(configP, config);
			obtenerUsuario(configP, config);
			
		} catch (XmlToDtoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void obtenerUsuario(ConfiguracionParametrosLdap configP,ConfiguracionMapeoLdap config){
		GestorUsuarios gestor = GestorUsuarios.getInstance(configP, config);
		Usuario us = gestor.consultarUsuario("usuarionit1");
		//us.setCategoriaDeNegocio("CORPORATIVO");
		//us.setPassword("12345");
		//gestor.modificar(us);
		System.out.println("Usuario: "+us);
		System.out.println("Nombre: "+us.getNombres() + " " + us.getApellidos());
		System.out.println("Categoria: "+us.getCategoriaDeNegocio());
		//System.out.println(gestor.consultarListaEntidades("casab"));
		
		//List<String> entidades = gestor.consultarListaEntidades("usuarionit1");
		//System.out.println("Comercios: " + entidades);
	}
}
