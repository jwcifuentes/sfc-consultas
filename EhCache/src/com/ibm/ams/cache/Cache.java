package com.ibm.ams.cache;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Element;

public class Cache {
	private net.sf.ehcache.Cache cache = null;

	protected Cache(net.sf.ehcache.Cache cache) {
		this.cache = cache;
	}

	/**
	 * Empieza ordenadamente a terminar la ejecucion de el cache
	 * 
	 * @throws IllegalStateException
	 */
	public void dispose() throws IllegalStateException {
		cache.dispose();
	}

	/**
	 * Obtiene un elemento del cache segun la llave dada
	 * 
	 * @param llave
	 * @return Element
	 * @throws IllegalStateException
	 * @throws CacheException
	 */
	public final Object get(Object llave) throws IllegalStateException {
		Element elem = cache.get(llave);
		if(elem != null){
			return elem.getObjectValue();
		}
		return null;
	}

	/**
	 * Obtiene las llaves de todos los elementos en el cache asi hayan o no
	 * caducado
	 * 
	 * @return List
	 * @throws IllegalStateException
	 * @throws CacheException
	 */
	@SuppressWarnings("rawtypes")
	public final List getKeys() throws IllegalStateException {
		return cache.getKeys();
	}

	/**
	 * Obtiene el tamanno del cache
	 * 
	 * @return int
	 * @throws IllegalStateException
	 * @throws CacheException
	 * @see net.sf.ehcache.Cache#getSize()
	 */
	public final int getSize() throws IllegalStateException {
		return cache.getSize();
	}

	/**
	 * Pone un elemento en el cache
	 * 
	 * @param elemento
	 * @param llave
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 * @throws CacheException
	 */
	public final void put(Object llave, Object elemento)
			throws IllegalArgumentException, IllegalStateException {
		Element objeto = new Element(llave, elemento);
		cache.put(objeto);
	}

	/**
	 * Pone una coleccion de elementos en el Cache
	 * 
	 * @param elements
	 * @throws IllegalArgumentException
	 * @throws IllegalStateException
	 * @throws CacheException
	 */
	public void putAll(Map<Object, Object> elements)
			throws IllegalArgumentException, IllegalStateException,
			CacheException {
		for (Map.Entry<Object, Object> entry : elements.entrySet()){
			cache.put(new Element(entry.getKey(), entry.getValue()));
		}
	}

	/**
	 * Remueve un objeto del cache
	 * 
	 * @param key
	 * @return boolean
	 * @throws IllegalStateException
	 */
	public final boolean remove(String key) throws IllegalStateException {
		return cache.remove(key);
	}

	/**
	 * Elimina todos los items del cache
	 * 
	 * @throws IllegalStateException
	 * @throws CacheException
	 */
	public void removeAll() throws IllegalStateException {
		cache.removeAll();
	}

	/**
	 * Habilita o deshabilita el cache
	 * 
	 * @param habilitado
	 */
	public void setDisabled(boolean habilitado) {
		cache.setDisabled(habilitado);
	}
}
