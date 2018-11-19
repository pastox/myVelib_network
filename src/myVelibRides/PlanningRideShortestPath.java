package myVelibRides;

import java.util.ArrayList;


import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;

/**
 * In this class, we override the plan method so that it returns the departure and arrival stations that will allow to have the shortest path.
 * @author Pasteau Jebbari
 *
 */
public class PlanningRideShortestPath extends PlanningRide{

	public PlanningRideShortestPath(Stations stations) {
		
		super(stations);
		
	}

	@Override
	public Station[] plan(GPSCoordinates departurePosition, GPSCoordinates arrivalPosition, Class<?> bicycleType) {
		
		ArrayList<Station> stationList1 = new ArrayList<Station>();
		ArrayList<Station> stationList2 = new ArrayList<Station>();
		
		for (Station station : this.getStations().getStationsList()) {
			
			stationList1.add(station);
			stationList2.add(station);
			
		}
		
		
		for (Station station : this.getStations().getStationsList()) {
			
			if (station.isFull()) {
				
				stationList2.remove(station);
				
			}
			
			if (station.isEmpty(bicycleType)) {
				
				stationList1.remove(station);
				
			}
			
		}
		
		Station station1 = closestStationToPosition(departurePosition,stationList1);
		Station station2 = closestStationToPosition(arrivalPosition,stationList2);
		Station[] result = {station1, station2};
		
		return result;

		
	}
	
}
