package myVelibRides;

import java.util.ArrayList;

import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;

/**
 * This abstract class is like the strategy interface in the strategy design pattern
 * @author Pasteau Jebbari
 *
 */
public abstract class PlanningRide {
	
	private Stations stations;
	
	/**
	 * Constructor that builds a PlanningRide object
	 * @param stations : it should be the only instantiation of the class Stations
	 */
	public PlanningRide(Stations stations) {
		
		this.stations = stations;
		
	}
	
	/**
	 * This abstract method will be overridden in each different PlanningRide subclass, and returns the departure and arrival stations of a ride that has to be planned.
	 * 
	 * @param departurePosition
	 * @param arrivalPosition
	 * @return
	 */
	public abstract Station[] plan(GPSCoordinates departurePosition, GPSCoordinates arrivalPosition, Class<?> bicycleType);
	//bicycleType must be of the sort of myVelibBicycles.ElectricalBicycle
	/**
	 * This method finds the closest online station to a given position within a list of stations
	 * @param position
	 * @return
	 */
	public Station closestStationToPosition(GPSCoordinates position, ArrayList<Station> stationList) {
		
		double minDistance = Double.POSITIVE_INFINITY;
		Station closestStation = null;
		
		for (Station station : stationList) {
			
			if (position.distanceTo(station.getPosition()) < minDistance && station.isState()) {
				
				minDistance = position.distanceTo(station.getPosition());
				closestStation = station;
				
			}
			
		}
		
		return closestStation;
		
	}

	public Stations getStations() {
		return stations;
	}

	public void setStations(Stations stations) {
		this.stations = stations;
	}

}
