package com.ibm.ams.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Status;

import com.ibm.ams.cache.excepciones.ExcepcionCache;
import com.ibm.ams.log.Logger;

public class ManejadorCache {
	private static ManejadorCache instance;
	private static Logger logger = null;
	private CacheManager cacheMgr = null;

	public static ManejadorCache getInstance() {
		return instance;
	}

	/**
	 * Instancia el manejadorCache con el Singleton de acuerdo a la
	 * configuracion default.
	 * 
	 * @throws ExcepcionCache
	 */
	public static void init(String id, String configDirLog) throws ExcepcionCache {
		if(logger == null){
			logger = Logger.getInstance(id, configDirLog);
		}
		try {
			instance = new ManejadorCache();
			instance.cacheMgr = CacheManager.create();
			logger.info("ManejadorCache", "init", "Iniciando cache con configuracion default");

		} catch (CacheException e) {
			throw new ExcepcionCache("Error al iniciar el cache", e);
		}
	}

	/**
	 * Instancia el manejadorCache de acuerdo a un archivo de configuracion
	 * 
	 * @param rutaArchivoConf
	 * @throws ExcepcionCache
	 */
	public static void init(String rutaArchivoConf, String id, String configDirLog) throws ExcepcionCache {
		if(logger == null){
			logger = Logger.getInstance(id, configDirLog);
		}
		try {
			instance = new ManejadorCache();
			instance.cacheMgr = CacheManager.create(rutaArchivoConf);
			logger.info("ManejadorCache","crearManejadorCache","Iniciando cache con configuracion desde: "+ rutaArchivoConf);
		} catch (CacheException e) {
			throw new ExcepcionCache("Error al iniciar el cache", e);
		}
	}

	/**
	 * Limpia todo el contenido de todos los caches en el CacheManager, pero sin
	 * remover los caches
	 */
	public void clearAll() {
		cacheMgr.clearAll();
	}

	/**
	 * Retorna un cache a partir de su nombre. Retorna el cache si este esta
	 * disponible en el CacheManager
	 * 
	 * @param name
	 * @return Cache
	 * @throws IllegalStateException
	 */
	public Cache getCache(String name) throws IllegalStateException {
		if (!cacheMgr.cacheExists(name)){
			cacheMgr.addCache(name);
		}
		return new Cache(cacheMgr.getCache(name));
	}

	/**
	 * Retorna los nombre de todos los caches
	 * 
	 * @return String[]
	 * @throws IllegalStateException
	 */
	public String[] getCacheNames() throws IllegalStateException {
		return cacheMgr.getCacheNames();
	}

	/**
	 * Retorna el estado del CacheManager
	 * 
	 * @return Status
	 */
	public Status getStatus() {
		return cacheMgr.getStatus();
	}

	/**
	 * Elimina todos los caches que se encuentran en el CacheManager
	 */
	public void removeAllCaches() {
		cacheMgr.removeAllCaches();
	}

	/**
	 * Elimina el cache con el nombre dado del CacheManager
	 * 
	 * @param nombreCache
	 * @throws IllegalStateException
	 */
	public void removeCache(String nombreCache) throws IllegalStateException {
		cacheMgr.removeCache(nombreCache);
	}

	/**
	 * Metodo que apaga o termina la ejecucion del CacheManager
	 */
	public void shutdown() {
		cacheMgr.shutdown();
	}

	public void put(String name, Object llave, Object valor) {
		Cache cache = getCache(name);
		cache.put(llave, valor);
	}

	public Object get(String name, Object llave) {
		Cache cache = getCache(name);
		return cache.get(llave);
	}
}
