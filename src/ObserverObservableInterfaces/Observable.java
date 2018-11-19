package ObserverObservableInterfaces;

import myVelibBicycles.Bicycle;
import myVelibStationNetwork.Station;
import myVelibTools.MyDate;

/**
 * 
 * This interface was created in order to apply the observer design pattern
 * @author Pasteau Jebbari
 *
 */
public interface Observable {
	
	/**
	 * This method registers a new Observer to an observable's list of observers
	 * @param observer : observer to be registered
	 */
	public void registerObserver(Observer observer);
	
	/**
	 * This method removes an observer from an observable's list of observers
	 * @param observer : observer to be removed
	 */
	public void removeObserver(Observer observer);
	
	/**
	 * this method notifies the observer that has Bicycle bicycle about a change in an observable and returns this observer. 
	 * @param bicycle : in the myvelib project, observables are stations and when they notify the observers (the rides), they need to tell them what bike just arrived in order to find the right ride.
	 */
	public void notifyObservers(Bicycle bicycle, Station arrivalStation, MyDate date);
	
	/**
	 * this method notifies observers of type user : a user needs to know that his previously planned arrivalStation is offline or that all its parkingslots are occupied or out-of-order 
	 */
	public void notifyObservers2();

}
