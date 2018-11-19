package myVelibSortStations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import myVelibStationNetwork.Station;

/**
 * 
 * This Class allows to sort the stations from the most occupied to the least occupied
 * @author Pasteau Jebbari
 *
 */
public class LeastOccupiedSort implements Sort, Comparator<Station> {

	@Override
	public int compare(Station s1, Station s2) {
		
		if (s1.avgOccupationRate()>s2.avgOccupationRate()) {
			
			return -1;
			
		}
		
		else if (s1.avgOccupationRate()<s2.avgOccupationRate()) {
		
			return 1;
			
		}
	
		else {
		
			return 0;
		
		}
		
	}

	@Override
	public ArrayList<Station> sort(ArrayList<Station> stations) {
		
		Collections.sort(stations,new LeastOccupiedSort());
		return stations;
		
	}

}
