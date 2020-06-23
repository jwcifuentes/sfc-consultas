package com.ibm.ams.audit.manager;

import static com.ibm.ams.util.AuditConstList.CONFIG_EHCACHE_FILE_NAME;
import static com.ibm.ams.util.AuditConstList.CONFIG_FOLDER;
import static com.ibm.ams.util.AuditConstList.CONFIG_URL_BASE;

import java.io.File;

import com.ibm.ams.audit.exception.AuditException;
import com.ibm.ams.cache.ManejadorCache;
import com.ibm.ams.cache.excepciones.ExcepcionCache;

public class CacheManager {

	private static CacheManager instance = null;
	private ManejadorCache cacheInstance = null;
	
	private CacheManager() throws ExcepcionCache {
		ManejadorCache.init(System.getProperty(CONFIG_URL_BASE) + CONFIG_FOLDER + File.separatorChar + CONFIG_EHCACHE_FILE_NAME, CONFIG_FOLDER, CONFIG_FOLDER);
		cacheInstance = ManejadorCache.getInstance();
	}
	
	public static CacheManager getInstance() throws AuditException {
		try {
			if (instance == null) {
				instance = new CacheManager();
			}
		} catch (ExcepcionCache e) {
			// TODO Manejar Excepcion
			e.printStackTrace();
		}
		return instance;
	}
	
	public Object getCacheData(String cacheName) {
		return cacheInstance.getCache(cacheName).get(cacheName);
	}
	
	public void putCacheData(String cacheName, Object cacheObject) {
		cacheInstance.getCache(cacheName).put(cacheName, cacheObject);
	}
	
}
