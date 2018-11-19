package myVelibSortStations;

import java.util.ArrayList;

import myVelibStationNetwork.Station;

/**
 * This interface enables to sort an ArrayList of stations with the Strategy design pattern
 * @author Pasteau Jebbari
 *
 */
public interface Sort {
	
	public ArrayList<Station> sort(ArrayList<Station> stations);

}
