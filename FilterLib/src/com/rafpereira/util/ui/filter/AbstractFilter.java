package com.rafpereira.util.ui.filter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Abstract class that implements some standard methods for filters.
 * @author rafaeldearaujopereira
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractFilter implements Filter {

	/**
	 * The "value" object of the filter.
	 */
	protected Object filterObject;
	
	/**
	 * Status of <b>this</b> filter.
	 */
	protected boolean active;
	
	/**
	 * List of components that are using this filter.
	 */
	protected ArrayList<FilterableComponent> subscribers;

	/**
	 * Default constructor, initializes the list of components.
	 */
	public AbstractFilter() {
		this.subscribers = new ArrayList<>();
	}

	/**
	 * Checks if the filter status is currently active.
	 * @return <b>true</b> when the filter is active.
	 */
	@Override
	public boolean isActive() {
		return active;
	}

	/**
	 * Defines the status of the filter.
	 * @param active new status.
	 */
	@Override
	public void setActive(boolean newStatus) {
		this.active = newStatus;
	}

	/**
	 * Returns the "value" object of the filter.
	 * @return Object that will be used to be compared by the filter.
	 */
	@Override
	public Object getFilterObject() {
		return filterObject;
	}

	/**
	 * Defines the "value" object of the filter.
	 * @param filterObject Adds a filter to the component.
	 */
	@Override
	public void setFilterObject(Object newFilterObject) {
		this.filterObject = newFilterObject;
		reapplyFilters();
	}

	/**
	 * For each component that is using this filter, requests to update its view.
	 */
	protected void reapplyFilters() {
		for (FilterableComponent subscriber : subscribers) {
			subscriber.updateView();
		}
	}

	/**
	 * Applies the filter on the set of items (that maybe already filtered by another filter).
	 * @param filteredItems Items to be filtered.
	 * @return Items filtered by this filter.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Collection<FilterableObject> applyFilter(Collection<FilterableObject> filteredItems) {
		ArrayList<FilterableObject> filteredList = new ArrayList<FilterableObject>();
		for (FilterableObject item : filteredItems) {
			if (item.isRelated(filterObject)) {
				filteredList.add(item);
			}
		}
		return filteredList;
	}

	/**
	 * Gets the components that are using this filter.
	 * @return List of components.
	 */
	@Override
	public ArrayList<FilterableComponent> getSubscribers() {
		for (FilterableComponent subscriber : subscribers) {
			if (!subscriber.containsFilter(this)) {
				subscribers.remove(subscriber);
			}
		}
		return subscribers;
	}

	/**
	 * Adds a component to the list of components that are using this filter.
	 * @param subscriber Component to be filtered.
	 */
	@Override
	public void addSubscriber(FilterableComponent subscriber) {
		this.subscribers.add(subscriber);
	}

	/**
	 * Removes a component from the list of components that are using this filter.
	 * @param subscriber Component that will not be filtered by this filter.
	 */
	@Override
	public void removeSubscriber(FilterableComponent subscriber) {
		this.subscribers.remove(subscriber);
	}

}
