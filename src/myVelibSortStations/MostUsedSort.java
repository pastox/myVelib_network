package myVelibSortStations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import myVelibStationNetwork.Station;

/**
 * 
 * This class allows to sort the stations from the least used to the most used
 * @author Pasteau Jebbari
 *
 */
public class MostUsedSort implements Sort, Comparator<Station>{

	/**
	 * this method sort the stations according to how much they are used. Let's take as a criteria the sum of the number of the number of rents and the number of returns of a station
	 */
	@Override
	public ArrayList<Station> sort(ArrayList<Station> stations) {
		
		Collections.sort(stations,new MostUsedSort());
		return stations;
		
	}

	@Override
	public int compare(Station s1, Station s2) {
			
		if (s1.getReturnsNumber() + s1.getRentsNumber() > s2.getReturnsNumber() + s2.getRentsNumber()) {
			
			return 1;
			
		}
		
		else if (s1.getReturnsNumber() + s1.getRentsNumber() < s2.getReturnsNumber() + s2.getRentsNumber()) {
		
			return -1;
			
		}
	
		else {
		
			return 0;
		
		}

	}
	
}