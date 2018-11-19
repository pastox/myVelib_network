package myVelibRides;

import java.util.ArrayList;

import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;

/**
 * In this class we override the method plan that looks for the optimal departure and arrival stations in case the user wants to avoid the plus stations as arrival stations
 * @author Pasteau Jebbari
 *
 */
public class PlanningRideAvoidPlus extends PlanningRide{
	
	public PlanningRideAvoidPlus(Stations stations) {
		
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
			
			if (station.getType().equalsIgnoreCase("plus") || station.isFull()) {
				
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
