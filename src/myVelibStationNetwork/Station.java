package myVelibStationNetwork;

import java.lang.reflect.Type;
import java.util.ArrayList;
import ObserverObservableInterfaces.Observable;
import ObserverObservableInterfaces.Observer;
import myVelibBicycles.Bicycle;
import myVelibTools.GPSCoordinates;
import myVelibTools.MyDate;
import myVelibExceptions.WrongParkingSlotException;
import myVelibExceptions.WrongTimePeriodException;
import myVelibRides.Ride;

/**
 * This Class describes a station of the Velib System.
 * 
 * @author Pasteau Jebbari
 * 
 */

public class Station implements Observable{

	private ArrayList<ParkingSlot> parkingSlots;
	private UserTerminal userTerminal;
	private int stationID;
	private GPSCoordinates position;
	private boolean state;
	private int rentsNumber;
	private int returnsNumber;
	private ArrayList<Observer> observers;
	private Stations stations;
	private String type;
	private static int counter = 0;
	
	/**
	 * This constructor builds a station.
	 * @param parkingSlots
	 * @param type : the type of the station : "plus" or "standard"
	 * @param stationID : a unique ID for the station
	 * @param position : position of the station
	 * @param state : on service(True) or offline(False)
	 * @param stations : object that has an attribute containing all the stations of the myVelib system.
	 */
	public Station(ArrayList<ParkingSlot> parkingSlots,GPSCoordinates position,boolean state,Stations stations, String type) {
		
		this.parkingSlots = parkingSlots;
		this.userTerminal = new UserTerminal(this);
		this.stationID = counter++;
		this.position = position;
		this.state = state;
		this.stations = stations;
		this.type = type;
		this.rentsNumber = 0;
		this.returnsNumber = 0;
		this.observers = new ArrayList<Observer>();
		this.stations.addStation(this);
		
	}
	
	/**
	 * this method adds a bicycle to a parking slot of the station and throws an exception if this isn't possible
	 * @param bicycle
	 * @param parkingslot
	 * @throws WrongParkingSlotException
	 */
	public void addBicycle(Bicycle bicycle, ParkingSlot parkingSlot) throws WrongParkingSlotException{
		
		if (parkingSlot.getState().equalsIgnoreCase("free")) {
			
			parkingSlot.setBicycle(bicycle);
			parkingSlot.setState("occupied");
			Object[] n = {new MyDate(),"a"};
			parkingSlot.events.add(n);
		
		}
		
		else {
			
			System.out.println("Sorry, this parking slot is " + parkingSlot.getState());
			throw new WrongParkingSlotException(parkingSlot.getState());
			
		}
		
	}
	
	/**
	 * This method removes a bicycle from a parking slot of the station and throws an exception if this isn't possible
	 * @param parkingSlot
	 * @throws WrongParkingSlotException
	 */
	public void removeBicycle(ParkingSlot parkingSlot) throws WrongParkingSlotException {
		
		if (parkingSlot.getState().equalsIgnoreCase("occupied")) {
		
			parkingSlot.setBicycle(null);
			parkingSlot.setState("free");
			Object[] n = {new MyDate(),"r"};
			parkingSlot.events.add(n);
			
		
		}
		
		else {
			
			System.out.println("Sorry, this parking slot is " + parkingSlot.getState());
			throw new WrongParkingSlotException(parkingSlot.getState());
			
		}
		
	}
	
	/**
	 * This method computes the average occupation rate of the station over a given time period
	 * @param startDate : beginning of the time period
	 * @param endDate : end of the time period
	 * @return
	 */
	public double avgOccupationRate(MyDate startDate, MyDate endDate) {
		
		try {
			
			double s = 0;
			for (ParkingSlot p : this.parkingSlots) {
				
				s += p.occupationRate(startDate, endDate);
				
			}
			
			return s/this.parkingSlots.size();
			
		}catch (WrongTimePeriodException e){
			
			System.err.println("you entered a time period starting too early");
			return 0;
		}
		
	}
	
	/**
	 * This method computes the average occupation rate of the station since it was created
	 * 
	 * @return
	 */
	public double avgOccupationRate() {
			
			double s = 0;
			for (ParkingSlot p : this.parkingSlots) {
				
				s += p.occupationRate();
				
			}
			
			return s/this.parkingSlots.size();		
	}
	
	@Override
	public void registerObserver(Observer observer) {
		
		this.observers.add(observer);
		
	}
	

	@Override
	public void removeObserver(Observer observer) {
		
		this.observers.remove(observer);
		
	}

	/**
	 * When a bike is returned to a station, it means that an unfinished ride has just ended. This method is called so that all the stations of the myVelib system become aware that this ride has just ended. This is why it call stations.notifyObservers(bicycle).
	 * @return 
	 */
	@Override
	public void notifyObservers(Bicycle bicycle, Station arrivalStation, MyDate date) {
		
		stations.notifyObservers(bicycle, arrivalStation, date);
		
	}
	
	/**
	 * This method notifies users who have planned a ride that isn't over and that has this station as arrivalStation that this station has just become 
	 */
	@Override
	public void notifyObservers2() {
		
		for (Observer observer : this.observers) {
			
			if (((Ride)observer).getArrivalStation().equals(this)) {
				
				((Ride)observer).getUser().update(null, new MyDate());
				
			}
			
		}
		
	}
	
	public boolean isFull() {
		
		for (ParkingSlot p : this.getParkingSlots()) {
			
			if (p.getState().equalsIgnoreCase("free")) {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public boolean isEmpty(Class<?> bicycleType) {
		// bicycle Type = class myVelibBicycles.ElectricalBicycle ou class myVelibBicycles.MechanicalBicycle
		if (bicycleType == null) {
			
			for (ParkingSlot p : this.getParkingSlots()) {
				
				if (!p.getState().equalsIgnoreCase("free")) {
					
					return false;
					
				}	
			}
			
			return true;
			
		}
		
		else {
			
			for (ParkingSlot p : this.getParkingSlots()) {
				
				if (p.getState().equalsIgnoreCase("occupied") && !p.getState().equalsIgnoreCase("out-of-order"))
				
					if (p.getBicycle().getClass() ==  bicycleType && !p.getState().equalsIgnoreCase("out-of-order")) {
						
						return false;
						
					}
			
			} 
			
			return true;
			
		}
		
	}
	
	public int numberOf(Type bicycleType) {
		
		int s = 0;
		
		for (ParkingSlot p : this.parkingSlots) {
			
			if (p.getState().equalsIgnoreCase("occupied") && p.getBicycle().getClass() == bicycleType) {
				
				s++;
				
			}
			
		}
		
		return s;
		
	}
	
	public int numberOfFreeParkingSlots() {
		
		int s = 0;
		
		for (ParkingSlot p : this.parkingSlots) {
			
			if (p.getState().equalsIgnoreCase("free")) {
				
				s++;
				
			}
			
		}
		
		return s;
		
	}

	public ArrayList<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}

	public void setParkingSlots(ArrayList<ParkingSlot> parkingSlots) {
		this.parkingSlots = parkingSlots;
	}

	public UserTerminal getUserTerminal() {
		return userTerminal;
	}

	public void setUserTerminal(UserTerminal userTerminal) {
		this.userTerminal = userTerminal;
	}

	public int getStationID() {
		return stationID;
	}

	public void setStationID(int stationID) {
		this.stationID = stationID;
	}

	public GPSCoordinates getPosition() {
		return position;
	}

	public void setPosition(GPSCoordinates position) {
		this.position = position;
	}

	public boolean isState() {
		return state;
	}

	/**
	 * this method sets the state of a station. If the state of this station becomes false (ie if the station becomes online), it notifies all the users who had planned a ride whose arrivalStation is this one.
	 * @param state
	 */
	public void setState(boolean state) {
		
		this.state = state;
		
		if (!this.state) {
			
			this.notifyObservers2();
			
		}
		
	}

	public int getRentsNumber() {
		return rentsNumber;
	}

	public void setRentsNumber(int rentsNumber) {
		this.rentsNumber = rentsNumber;
	}

	public int getReturnsNumber() {
		return returnsNumber;
	}

	public void setReturnsNumber(int returnsNumber) {
		this.returnsNumber = returnsNumber;
	}

	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public Stations getStations() {
		return stations;
	}

	public void setStations(Stations stations) {
		this.stations = stations;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + stationID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Station other = (Station) obj;
		if (stationID != other.stationID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Station [stationID=" + stationID + "]";
	}

}
