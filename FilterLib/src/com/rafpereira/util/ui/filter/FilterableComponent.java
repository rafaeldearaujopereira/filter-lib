package com.rafpereira.util.ui.filter;

import java.util.Collection;

/**
 * Define the minimum set of methods that components must have in order to interact with filters.
 * @author rafaeldearaujopereira
 * @since 1.0
 * @version 1.0
 */
public interface FilterableComponent {

	/**
	 * Checks if the component contains a specific filter.
	 * @param filter filter to be checked.
	 * @return <b>true</b> when the component has the filter.
	 */
	public boolean containsFilter(Filter filter);
	
	/**
	 * Clears the current list of filters added to the component.
	 */
	public void clearFilters();
	
	/**
	 * Adds a filter to the component.
	 * @param filter filter to be added.
	 */
	public void addFilter(Filter filter);
	
	/**
	 * Gets the list of items already filtered.
	 * @return filtered items.
	 */
	@SuppressWarnings("rawtypes")
	public Collection getFilteredItems();
	
	/**
	 * Update the view of the component, applying the filters.
	 */
	public void updateView();
	
}
