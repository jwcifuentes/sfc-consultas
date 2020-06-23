package com.ibm.ams.ldap.parser;

/**
 * Clase que representa las caracteristicas de un usuario en el sistema, contiene nombre, apellido, correo, edad y miembros.
 * @author dmejia
 *
 */
@LdapEntity(objectType={"top","person", "inetOrgPerson"})
public class Usuario {
	@LdapAttribute (name="cn")
	private String nombre;
	@LdapAttribute (name="sn")
	private String apellido;
	@LdapAttribute (name="mail")
	private String correo;
	@LdapAttribute (name="age")
	private int edad;
	@LdapAttribute (name="member")
	private String[] miembros;

	/**
	 * Constructor por defecto
	 */
	public Usuario(){
		
	}
	
	/**
	 * Constructor con los parametros: nombre, apellido, correo electronico y edad
	 * @param nombre
	 * @param apellido
	 * @param correo
	 * @param edad
	 */
	public Usuario(String nombre, String apellido, String correo, int edad) {
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.correo = correo;
	    this.edad = edad;
	  }

	/**
	 * Metodo que obtiene el atributo nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que obtiene el atributo apellido
	 * @return
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Metodo que obtiene el atributo correo
	 * @return
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Metodo que obtiene el atributo edad
	 * @return
	 */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * Metodo que obtiene el atributo miembros
	 * @return
	 */
	public String[] getMiembros() {
		return miembros;
	}

	/**
	 * Metodo que setea el atributo miembros
	 * @param miembros
	 */
	public void setMiembros(String[] miembros) {
		this.miembros = miembros;
	}	
	
	/**
	 * Metodo que indica si un grupo determinado pertenece o no
	 * @param grupo
	 * @return
	 */
	public boolean perteneceAGrupo(String grupo){
		if(this.miembros == null || this.miembros.length == 0){
			for(String g : this.miembros){
				if(g.equals(grupo)){
					return true;
				}
			}
		}
		return false;
	}
}
