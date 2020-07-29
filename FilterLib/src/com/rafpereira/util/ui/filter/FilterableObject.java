package com.rafpereira.util.ui.filter;

/**
 * Define the minimum set of methods that classes must have in order to be filtered.
 * @author rafaeldearaujopereira
 * @since 1.0
 * @version 1.0
 */
public interface FilterableObject<T> {

	/**
	 * Checks if the object is related to the filter object provided as parameter. 
	 * @param obj Filter object.
	 * @return <b>true</b> when the current object is related to obj.
	 */
	public boolean isRelated(T obj);
	
}
