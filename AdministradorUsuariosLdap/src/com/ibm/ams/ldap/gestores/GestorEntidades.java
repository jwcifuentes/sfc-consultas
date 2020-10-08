package com.ibm.ams.ldap.gestores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.directory.api.ldap.model.entry.Attribute;
import org.apache.directory.api.ldap.model.entry.DefaultEntry;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.Value;
import org.apache.directory.api.ldap.model.exception.LdapException;

import com.ibm.ams.ldap.GestorLdapApache;
import com.ibm.ams.ldap.config.ConfiguracionMapeoLdap;
import com.ibm.ams.ldap.config.ConfiguracionParametrosLdap;
import com.ibm.ams.ldap.dto.Entidad;
import com.ibm.ams.ldap.parser.LdapParser;
import com.ibm.ams.utils.ConstantesUsuariosLDAP;
import com.ibm.ams.log.LoggerInst;

public class GestorEntidades implements IGestorEntidades{
	
	/** Instancia del Logger. */
	private static LoggerInst logger = new LoggerInst(GestorGrupos.class, ConstantesUsuariosLDAP.NOMBRE_APLICACION, ConstantesUsuariosLDAP.NOMBRE_APLICACION);
	
	/**
	 * Singleton con la instancia de esta clase
	 */
	private static GestorEntidades instance;
	/**
	 * Objeto con la funcionalidad a bajo nivel con los metodos de acceso a Ldap
	 */
	private GestorLdapApache gestorLdap;
	/**
	 * Objeto con la configuracion de objetos tipo grupo y usuario
	 */
	private ConfiguracionMapeoLdap mapeoLdap;

	private GestorEntidades(ConfiguracionParametrosLdap parametros,ConfiguracionMapeoLdap mapeo) {
		gestorLdap = GestorLdapApache.getInstance(parametros, mapeo);
		this.mapeoLdap = mapeo;
	}

	public static GestorEntidades getInstance(ConfiguracionParametrosLdap parametros,ConfiguracionMapeoLdap mapeo){
		if(instance == null){
			instance = new GestorEntidades(parametros,mapeo);
		}
		return instance;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.ibm.ams.ldap.gestores.IGestorGrupos#consultarGrupo(java.lang.String)
	 */
	
	
	public void crearEntidad(String cn, String organization, String ruta, Entidad entidad) {
		try {
			List<String> atributos = LdapParser.toLdapAttrList(entidad);
			DefaultEntry entrada = new DefaultEntry(mapeoLdap.getObjetoEstablecimientos() + "=" + cn, atributos.toArray());
			entrada.add(ConstantesUsuariosLDAP.ENTRADA, cn );
			entrada.add(ConstantesUsuariosLDAP.ORGANIZATION, organization );
			
			String businessCategory = entrada.get(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY.toLowerCase()).toString();
			entrada.removeAttributes(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY.toLowerCase());
			entrada.put(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY, businessCategory.split(":")[1].trim());
			
			gestorLdap.crearEntidad(cn, organization, entrada, ruta);
		} catch (LdapException e) {
			logger.error("crearEntidad"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("crearEntidad"," Error Instancia",e);
		} catch (IllegalAccessException e) {
			logger.error("crearEntidad"," Error Instanciacion",e);
		}
	}
	
	public List<String> consultarEstablecimientos(String rutaBase){
		
		List <String> establecimientos = new ArrayList<String>();
		try {
			
			List<Entry> resultados = gestorLdap.ejecutarConsultaEstablecimientos(rutaBase);
			
			if(resultados == null || resultados.isEmpty()){
				return null;
			}
			
			for (Entry entry : resultados) {
				
				String cn = entry.get("cn").toString();
				System.out.println("CN: " + cn);
				String organization = entry.get("organization").toString();
				cn= cn.substring(4, cn.length() - 1); 
				organization = organization.substring(14, organization.length() - 1);
				String cadena = cn + ";" + organization;
				
				establecimientos.add(cadena);
			}
			
		} catch (Exception e){
			logger.error("consultarEstablecimiento"," Error Ldap",e);
		}
		
		System.out.println("ESTABLECIMIENTOS ENCONTRADOS: " + establecimientos.size());
		
		return establecimientos;
		
	}
	
	public void modificarEntidad(String cnRuta,Entidad entidad,String usuario){
		
		try {
			
			System.out.println("modificarEntidad - entidad: " + entidad.toString());
			
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdGrupo(), entidad.getNombreEntidad());
			
			Entry eUsuario = null;
			for (Entry entry : resultados) {
				if (entry.getDn().toString().startsWith("cn")) {
					eUsuario = entry;
					
					break;
				}
			}
			
			if(eUsuario.get("uniquemember") != null){
					Iterator<Value<?>> lista = eUsuario.get("uniquemember").iterator();
					List<String> listaArray  = new ArrayList<String>();
					
					while(lista.hasNext()) listaArray.add(lista.next().getString());
							
					Object[] objetos = (Object[])listaArray.toArray();
					String[] usuarios = new String[objetos.length+1];
					int i=0;
					
					for(Object o : objetos){
						
						usuarios[i] = o.toString();
						i++;
					}
				
					usuarios[i] = usuario;
					entidad.setUsuarios(usuarios); 
					
			}else{
				List<String> listaArray  = new ArrayList<String>();
				
				listaArray.add(usuario);
				
				Object[] objetos = (Object[])listaArray.toArray();
				String[] usuarios = new String[objetos.length+1];
				int i=0;
				
				for(Object o : objetos){
					
					usuarios[i] = o.toString();
					i++;
				}
			
				usuarios[i] = usuario;
				entidad.setUsuarios(usuarios); 
			}
			
			System.out.println("modificarEntidad - entidad 2: " + entidad.toString());
			
			
			List<String> atributos = LdapParser.toLdapAttrList(entidad);
			System.out.println("atributos: " + atributos.toString());
				
			gestorLdap.modificarEntrada(cnRuta, atributos, false);
			
		} catch (LdapException e) {
			logger.error("modificarEntidad"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("modificarEntidad"," Error Ldap",e);
		} catch (IllegalAccessException e) {
			logger.error("modificarEntidad"," Error Ldap",e);
		} 
	}
	
	
	public List<String> consultarEstablecimientosUID(String rutaBase, String uid){
		
		List <String> establecimientos = new ArrayList<String>();
		try {
			
			List<Entry> resultados = gestorLdap.ejecutarConsultaEstablecimientos(rutaBase);
			
			if(resultados == null || resultados.isEmpty()){
				return null;
			}
			
			for(Entry entry: resultados) {
				Attribute uniquemember = entry.get("uniquemember");
				
				if (uniquemember != null) {
					Iterator<Value<?>> lista = uniquemember.iterator();
					
					while(lista.hasNext()) {
						String element = lista.next().getString();
						String[] value = element.split(",");
						try {
							String login = value[0].substring(4, value[0].length());
							if( login.equals(uid) )
							{
								String cn = entry.get("cn").getString();
								String organization = entry.get("organization").getString();
								establecimientos.add( cn + "," + organization);
							}
						} catch (StringIndexOutOfBoundsException ex){
							logger.error("consultarEstablecimientosUID"," Error Ldap",ex);
						}
					}
				}
			}
			
		} catch (LdapException e) {
			logger.error("consultarEstablecimientosUID"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("consultarEstablecimientosUID"," Error Ldap",e);
		} 
		
		return establecimientos;
		
	}
	
	public boolean existeComercio(String rutaComercio) {
		boolean existe = false;
		
		try {
			if(gestorLdap.existeGrupo(rutaComercio)) {
				existe = true;
			}
		} catch (LdapException e) {
			logger.error("modificarEntidad"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("modificarEntidad"," Error Ldap",e);
		}
		return existe;
	}
}






