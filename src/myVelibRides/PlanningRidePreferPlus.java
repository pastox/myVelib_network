package myVelibRides;

import java.util.ArrayList;


import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;

/**
 * In this class, we override the plan method so that one tries to have a plus station as a destination. Sometimes, it is not possible or it would make people walk too much, so it can return also a standard station as destination station.
 * @author Pasteau Jebbari
 *
 */
public class PlanningRidePreferPlus extends PlanningRide {

	public PlanningRidePreferPlus(Stations stations) {

		super(stations);

	}

	@Override
	public Station[] plan(GPSCoordinates departurePosition, GPSCoordinates arrivalPosition, Class<?> bicycleType) {
		
		ArrayList<Station> stationList1 = new ArrayList<Station>();
		ArrayList<Station> stationList2 = new ArrayList<Station>();
		ArrayList<Station> stationList3 = new ArrayList<Station>();
		
		for (Station station : this.getStations().getStationsList()) {
			
			stationList1.add(station);
			stationList2.add(station);
			stationList3.add(station);
			
		}
		
		for (Station station : this.getStations().getStationsList()) {
			
			if (station.getType().equalsIgnoreCase("standard") || station.isFull()) {
				
				stationList2.remove(station);
				
			}
			
			if (station.isFull()) {
				
				stationList3.remove(station);
				
			}
			
			if (station.isEmpty(bicycleType)) {
				
				stationList1.remove(station);
				
			}
			
		}
		
		Station station1 = closestStationToPosition(departurePosition,stationList1);
		Station station2 = closestStationToPosition(arrivalPosition,stationList2);
		Station station3 = closestStationToPosition(arrivalPosition,stationList3);
		
		if (station2.getPosition().distanceTo(arrivalPosition) <= 1.1*station3.getPosition().distanceTo(arrivalPosition)) {
			
			Station[] result = {station1, station2};
			return result;
			
		}
		
		else {
			
			Station[] result = {station1, station3};
			return result;
			
		}
		
	}

}
