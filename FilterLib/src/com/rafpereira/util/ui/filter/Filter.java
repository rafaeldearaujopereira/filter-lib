package com.rafpereira.util.ui.filter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Define the minimum set of methods that a filter must implement.
 * @author rafaeldearaujopereira
 * @since 1.0
 * @version 1.0
 */
public interface Filter {

	/**
	 * Checks if the filter status is currently active.
	 * @return <b>true</b> when the filter is active.
	 */
	public boolean isActive();
	
	/**
	 * Defines the status of the filter.
	 * @param active new status.
	 */
	public void setActive(boolean active);
	
	/**
	 * Returns the name of the filter.
	 * @return Filter name
	 */
	public String getName();
	
	/**
	 * Returns the "value" object of the filter.
	 * @return Object that will be used to be compared by the filter.
	 */
	public Object getFilterObject();

	/**
	 * Defines the "value" object of the filter.
	 * @param filterObject Adds a filter to the component.
	 */
	public void setFilterObject(Object filterObject);

	/**
	 * Applies the filter on the set of items (that maybe already filtered by another filter).
	 * @param filteredItems Items to be filtered.
	 * @return Items filtered by this filter.
	 */
	@SuppressWarnings("rawtypes")
	public Collection<FilterableObject> applyFilter(Collection<FilterableObject> filteredItems);

	/**
	 * Gets the components that are using this filter.
	 * @return List of components.
	 */
	public ArrayList<FilterableComponent> getSubscribers();
	
	/**
	 * Adds a component to the list of components that are using this filter.
	 * @param subscriber Component to be filtered.
	 */
	public void addSubscriber(FilterableComponent subscriber);
	
	/**
	 * Removes a component from the list of components that are using this filter.
	 * @param subscriber Component that will not be filtered by this filter.
	 */
	public void removeSubscriber(FilterableComponent subscriber);
	
}
