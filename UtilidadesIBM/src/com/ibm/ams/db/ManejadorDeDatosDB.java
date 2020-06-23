package com.ibm.ams.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.ibm.ams.constantes.Constantes;

/**
 * Clase ManejadorDeDatosDB.
 */
public class ManejadorDeDatosDB {
	

	/**
	 * Obtener conexion por driver, metodo que crea conexion pr driver para pruebas standalone
	 *
	 * @param ruta donde se ubica el driber
	 * @param contrasenia
	 * @param usuario
	 * @param driver
	 * @return  connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	/*public static Connection obtenerConexionPorDriver(String ruta, String contrasenia, String usuario, String driver){
		try{
			Class.forName(driver);
			return DriverManager.getConnection(ruta, usuario, contrasenia);
		}catch(Throwable e){
			throw new RuntimeException("Error generando la conexion a la base de datos por driver", e);
		}

	}*/


	/**
	 * Obtener conexion por datasource, crea una conexion a partir del datasource que se encuentra en el servidor
	 *
	 * @param origenDatos
	 * @return connection
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static Connection obtenerConexionPorDatasource(String origenDatos){
		if(System.getenv(Constantes.IS_TEST) != null){
			return GestorDriverDB.getInstance().getConexion(origenDatos);
		}
					
		try{
			InitialContext contextoInicial = new InitialContext();
			DataSource dataSource = (DataSource) contextoInicial.lookup(origenDatos);
			return dataSource.getConnection();
		}catch(Throwable e){
			throw new RuntimeException("Error generando la conexion a la base de datos por datasource", e);
		}
	}

	/**
	 * Cerrar conexion.
	 *
	 * @param conexion
	 * @throws SQLException 
	 */
	public static void cerrarConexion(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conexion = null;
		}
	}

	/**
	 * Consultar bd, metodo que ejecuta un query de consulta a partir de una conexion preexistente
	 *
	 * @param conexion
	 * @param query
	 * @param timeout tiempo limite de consulta a la bae de datos
	 * @return  result set
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static ResultSet consultarBD(Connection conexion, String query, int timeout) throws SQLException, NamingException{
		try{
			return consultarBD(conexion, query, null, timeout);
		}catch(Throwable e){
			throw new RuntimeException("Error de acceso a Base de Datos", e);
		}
	}

	/**
	 * Consultar bd, metodo que ejecuta un query de consulta con unos parametros especificos a partir de una conexion preexistente
	 *
	 * @param conexion
	 * @param query
	 * @param valores, lista de parametros
	 * @param timeout
	 * @return result set
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static ResultSet consultarBD(Connection conexion, String query, List<Object> valores, int timeout){
		if(conexion == null){
			throw new IllegalArgumentException("No se especifico una conexion para consultar la base de datos");
		}
		try{
			PreparedStatement stmt = conexion.prepareStatement(query);
			stmt.setQueryTimeout(timeout);
			asignarParametros(stmt, valores);
			return stmt.executeQuery();
		}catch(Throwable e){
			throw new RuntimeException("Error de acceso a Base de Datos", e);
		}

	}

	/**
	 * Actualizar db metodo que ejecuta un query de tipo UPDATE a partir de una conexion preexistente
	 *
	 * @param origenDatos
	 * @param query
	 * @param valores
	 * @param timeout
	 * @return  int filas que axctualizo
	 * @throws SQLException
	 * @throws NamingException
	 */
	public static int actualizarDB(String origenDatos, String query, List<Object> valores, int timeout){

		Connection conexion = obtenerConexionPorDatasource(origenDatos);
		PreparedStatement pStmt = null;
		try {
			conexion.setAutoCommit(true);
			pStmt = conexion.prepareStatement(query);
			pStmt.setQueryTimeout(timeout);
			asignarParametros(pStmt, valores);
			return pStmt.executeUpdate();

		}catch(Throwable e){
			throw new RuntimeException("Error de acceso a Base de Datos", e);
		}finally{
			if(pStmt!=null){
				try {
					pStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cerrarConexion(conexion);
		}
	}
	public static int actualizarDB(Connection conexion, String query, List<Object> valores, int timeout){
		PreparedStatement pStmt = null;
		try {
			conexion.setAutoCommit(true);
			pStmt = conexion.prepareStatement(query);
			pStmt.setQueryTimeout(timeout);
			asignarParametros(pStmt, valores);
			return pStmt.executeUpdate();

		}catch(Throwable e){
			throw new RuntimeException("Error de acceso a Base de Datos", e);
		}finally{
			if(pStmt!=null){
				try {
					pStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			cerrarConexion(conexion);		
		}
	}
	/**
	 * Asignar parametros, metodo que asigala la lista de parametros a un query
	 *
	 * @param pStmt
	 * @param valores
	 * @throws SQLException
	 */
	public static void asignarParametros(PreparedStatement pStmt, List<Object> valores) throws SQLException {
		if(valores == null){
			return;
		}
		int i = 1;
		for(Object itr: valores){
			pStmt.setObject(i, itr);
			i++;
		}
	}

}
