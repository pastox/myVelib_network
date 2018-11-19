package myVelibRides;

import java.util.ArrayList;

import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;

/**
 * In this class, we override the plan method of PlanningRide for the case the user wants to preserve the uniformity of bicycles repartition inside the stations.
 * @author Pasteau Jebbari
 *
 */
public class PlanningRideUniformityPreservation extends PlanningRide {

	public PlanningRideUniformityPreservation(Stations stations) {
		
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
		
		stationList1.remove(station1);
		stationList2.remove(station2);
		
		Station[] result = {station1,station2};
		
		
		for (Station station : stationList1) {
			
			if (station.getPosition().distanceTo(departurePosition) <= 1.05*station1.getPosition().distanceTo(departurePosition) && station.numberOf(bicycleType)>station1.numberOf(bicycleType)) {
				
				result[0] = station;
				
			}
			
		}
		
		for (Station station : stationList2) {
			
			if (station.getPosition().distanceTo(arrivalPosition) <= 1.05*station2.getPosition().distanceTo(arrivalPosition) && station.numberOfFreeParkingSlots()>station2.numberOfFreeParkingSlots()) {
				
				result[1] = station;
				
			}
			
		}
		
		return result;
		
	}

}
