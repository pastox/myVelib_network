package clui;

import java.util.ArrayList;

import myVelibSortStations.Sort;
import myVelibStationNetwork.Station;
import myVelibUsers.*;

/**
 * An instance of this class is a MyVelib System
 * @author Pasteau Jebbari
 *
 */
public class MyVelib {
	
	private String name;
	private ArrayList<Station> stations;
	private ArrayList<User> users = new ArrayList<User>();
	private Sort sort;
	
	/**
	 * This method returns the sorted list of this MyVelib system's stations with the right sorting policy (attribute sort's type)
	 * @return
	 */
	public ArrayList<Station> sortStations(){
		
		return sort.sort(this.stations);
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Station> getStations() {
		return stations;
	}
	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
		this.users.add(user);	
	}
	public void addStation(Station station) {
		stations.add(station);
	}
	public MyVelib(String name) {
		super();
		this.name = name;
		this.stations = new ArrayList<Station>();
		MyVelibs.getInstance().add(this);
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "MyVelib [name=" + name + "]";
	}
	
}
