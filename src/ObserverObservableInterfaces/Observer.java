package ObserverObservableInterfaces;

import myVelibStationNetwork.Station;
import myVelibTools.MyDate;

/**
 * This interface was created in order to apply the observer design pattern
 * @author Pasteau Jebbari
 *
 */
public interface Observer {
	
	/**
	 * This method updates an observer.
	 * 
	 */
	public void update(Station arrivalStation, MyDate date);

}
