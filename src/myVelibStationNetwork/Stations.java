package myVelibStationNetwork;

import java.util.ArrayList;

import ObserverObservableInterfaces.Observable;
import ObserverObservableInterfaces.Observer;
import myVelibBicycles.Bicycle;
import myVelibRides.Ride;
import myVelibSortStations.Sort;
import myVelibTools.MyDate;

/**
 * This class' only instance stores all the created stations. Whenever one wants to create a new Station, one must create it with this Stations object as attribute, and this automatically adds this new station to the stationsList of this Stations object. This is particularly useful for the observer design pattern in which all the stations are observables for all the "unfinished" rides. To make sure this class is only instanciated once, the singleton pattern is used here.
 * @author Pasteau Jebbari
 *
 */
public class Stations implements Observable{
	
	private ArrayList<Station> stationsList = new ArrayList<Station>();
	private Sort sort;
	
	private static Stations instance = new Stations();
	
	public static Stations getInstance(){
		
		return instance;
		
	}
	
	/**
	 * This method adds a station to the list of existing stations
	 * @param station
	 */
	public void addStation(Station station) {
		
		this.stationsList.add(station);
		
	}
	
	/**
	 * This method returns the sorted list of the existing stations with the right sorting policy (attribute sort's type)
	 * @return
	 */
	public ArrayList<Station> sortStations(){
		
		return sort.sort(this.stationsList);
		
	}

	/**
	 * This method adds an observer to the observers lists of all the stations of StationsList. In fact, the different stations are the true observables, whereas the object stations just gathers all these observables at one place in order to make them evolve simultaneously.
	 */
	@Override
	public void registerObserver(Observer observer) {
		
		for (Station station : this.stationsList) {
			
			station.registerObserver(observer);
			
		}
		
	}

	/**
	 * This method removes an observer from the observers lists of all the stations of StationsList. In fact, the different stations are the true observables, whereas the object stations just gathers all these observables at one place in order to make them evolve simultaneously.
	 */
	@Override
	public void removeObserver(Observer observer) {
		
		for (Station station : this.stationsList) {
			
			station.removeObserver(observer);
			
		}
		
	}

	/**
	 * This method looks for the observer (ie the unfinished ride) in which the Bicycle bicycle is used. Once it has found it, it updates this ride, and removes it from all the stations's observers lists by calling removeObserver() 
	 */
	@Override
	public void notifyObservers(Bicycle bicycle, Station arrivalStation, MyDate date) {

		for (Observer observer : stationsList.get(0).getObservers()) {
			
			if (observer instanceof Ride) {
				
				if (bicycle.equals(((Ride)observer).getBicycle())) {
					
					observer.update(arrivalStation, date);
					removeObserver(observer);
					break;
					
				}
				
			}
			
		}
			
	}

	public ArrayList<Station> getStationsList() {
		return stationsList;
	}

	public void setStationsList(ArrayList<Station> stationsList) {
		this.stationsList = stationsList;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	@Override
	public void notifyObservers2() {
		// TODO Auto-generated method stub //there is nothing to do here!
		
	}
	

}
