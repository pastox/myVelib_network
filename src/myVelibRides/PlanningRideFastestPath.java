package myVelibRides;

import java.util.ArrayList;


import myVelibBicycles.ElectricalBicycleFactory;
import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;

/**
 * In this class, we override the plan method so that it returns the departure and arrival stations that will allow to have the fastest path
 * @author Pasteau Jebbari
 *
 */
public class PlanningRideFastestPath extends PlanningRide{

	public PlanningRideFastestPath(Stations stations) {
		
		super(stations);
		
	}

	@Override
	public Station[] plan(GPSCoordinates departurePosition, GPSCoordinates arrivalPosition, Class<?> bicycleType) {
		
		ArrayList<Station> stationList1 = new ArrayList<Station>();
		
		for (Station station : this.getStations().getStationsList()) {
			
			stationList1.add(station);
			
		}
		
		Station[] result = new Station[2];
		Station station2 = this.closestStationToPosition(arrivalPosition, this.getStations().getStationsList());
		result[1] = station2;
		double shortestTime = Double.POSITIVE_INFINITY;
		
		for (Station station1 : stationList1) {
				
			if (!station1.isEmpty(ElectricalBicycleFactory.getinstance().createBicycle().getClass())) {
				
				double time = station1.getPosition().distanceTo(departurePosition)/(4/3.6) + station2.getPosition().distanceTo(arrivalPosition)/(4/3.6) + station1.getPosition().distanceTo(station2.getPosition())/(20/3.6);
				if (time < shortestTime) {
					
					shortestTime = time;
					result[0] = station1;
					
				}		
				
			}
				
			else if (!station1.isEmpty(null)) {
				
				double time = station1.getPosition().distanceTo(departurePosition)/(4/3.6) + station2.getPosition().distanceTo(arrivalPosition)/(4/3.6) + station1.getPosition().distanceTo(station2.getPosition())/(15/3.6);
				if (time < shortestTime) {
					
					shortestTime = time;
					result[0] = station1;
					
				}	
					
			}
				
		}
		
		return result;
		
	}

}
