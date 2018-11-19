package myVelibRides;

import java.util.ArrayList;

import ObserverObservableInterfaces.Observer;
import myVelibBicycles.Bicycle;

import myVelibExceptions.WrongRideException;
import myVelibStationNetwork.Station;
import myVelibTools.GPSCoordinates;
import myVelibTools.MyDate;
import myVelibUsers.User;

/**
 * This class describes a ride between two stations of the myvelib network
 * @author Pasteau Jebbari
 *
 */
public class Ride implements Observer {

	private Bicycle bicycle;
	private User user;
	private PlanningRide planningRide;
	private Station departureStation;
	private Station arrivalStation;
	private GPSCoordinates departurePosition;
	private GPSCoordinates arrivalPosition;
	private MyDate departureDate;
	private MyDate arrivalDate;
	private double cost;
	
	/**
	 * This constructor builds a ride that has to be planned  and adds this ride to all the stations' list of observers
	 * @param planningRide : object that instantiates a class that implement PlanningRide which has to get the departure and arrival stations
	 * @param departurePosition : position from where the user wants to leave (not necessarily a station)
	 * @param arrivalPosition : position where the user wants to arrive (not necessarily a station)
	 * @param user : the user who does the ride
	 * @param bicycle : the bicycle used during that ride
	 */
	public Ride(PlanningRide planningRide, GPSCoordinates departurePosition, GPSCoordinates arrivalPosition, User user, Class<?> bicycleType) {
		
		this.planningRide = planningRide;
		this.departurePosition = departurePosition;
		this.arrivalPosition = arrivalPosition;
		this.user = user;
		Station[] stations = planningRide.plan(departurePosition, arrivalPosition, bicycleType);
		this.departureStation = stations[0];
		this.arrivalStation = stations[1];
		stations[0].getStations().registerObserver(this);
		
	}
	
	/**
	 * This constructor builds a ride that hasn't to be planned (if the user already knows to what station he wants to go for example) and adds this ride to all the stations' list of observers
	 * @param departureStation
	 * @param user
	 * @param bicycle
	 */
	public Ride(Station departureStation, User user, Bicycle bicycle) {
		
		this.departureStation = departureStation;
		this.user = user;
		this.bicycle = bicycle;
		this.departureDate = new MyDate();
		departureStation.getStations().registerObserver(this);
		
	}
	
	/**
	 * This method updates a ride when the user has arrived at a station and has put the bicycle there : It sets the arrival Station, the arrival date, computes the cost of the ride and updates some statistics about the user
	 */
	@Override
	public void update(Station arrivalStation, MyDate date) {
		
		this.setArrivalDate(date);
		this.setArrivalStation(arrivalStation);
		double time = this.computeTime();
		double cost = this.bicycle.cost(this.user, time);
		this.setCost(cost);
		this.user.setTotalTimeOnBicycle(user.getTotalTimeOnBicycle() + time);
		this.user.setTotalCharges(user.getTotalCharges() + cost);
		if (this.user.getCard() != null) {
			
			if (this.arrivalStation.getType().equalsIgnoreCase("plus")) {
				
				this.user.getCard().setTimeCredit(user.getCard().getTimeCredit() + 5);
				this.user.getCard().setTotalTimeCredit(user.getCard().getTotalTimeCredit() + 5);
				
				}

		}

	}
	
	/**
	 * this method computes the duration of the ride (in minutes)
	 * @return
	 */
	public double computeTime() {
		
		return this.arrivalDate.timeUntilThis(this.departureDate);
		
	}
	
	/**
	 * This method sets as new arrivalStation of a ride the closest station to the previous arrivalStation, if this previous arrivalStation exists. It also returns the new arrival station. If the previous arrival station doesn't exist, the method throws an exception.
	 * @return
	 * @throws WrongRideException
	 */
	public Station newArrival() throws WrongRideException{
		
		if (this.arrivalStation != null) {
		
			ArrayList<Station> stations = new ArrayList<Station>();
			for (Station station : this.arrivalStation.getStations().getStationsList()) {
				
				stations.add(station);
				
			}
			
			Station closestStation = null;
			double closestDistance =  Double.POSITIVE_INFINITY;
			
			while (stations.size() > 0) {
				
				closestStation = null;
				closestDistance =  Double.POSITIVE_INFINITY;
				
				for (Station station : stations) {
					
					if (this.arrivalStation.getPosition().distanceTo(station.getPosition()) < closestDistance) {
						
						closestDistance = this.arrivalStation.getPosition().distanceTo(station.getPosition());
						closestStation = station;
						
					}
					
				}
				
				if (closestStation.isFull()) {
					
					stations.remove(closestStation);
					
				} else {
					
					break;
					
				}
				
			}
			
			this.setArrivalStation(closestStation);
			return closestStation;
		
		}
		
		else {
			
			throw  new WrongRideException(this);
			
		}
	
	}

	public Bicycle getBicycle() {
		return bicycle;
	}

	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PlanningRide getPlanningRide() {
		return planningRide;
	}

	public void setPlanningRide(PlanningRide planningRide) {
		this.planningRide = planningRide;
	}

	public Station getDepartureStation() {
		return departureStation;
	}

	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}

	public Station getArrivalStation() {
		return arrivalStation;
	}

	public void setArrivalStation(Station arrivalStation) {
		this.arrivalStation = arrivalStation;
	}

	public GPSCoordinates getDeparturePosition() {
		return departurePosition;
	}

	public void setDeparturePosition(GPSCoordinates departurePosition) {
		this.departurePosition = departurePosition;
	}

	public GPSCoordinates getArrivalPosition() {
		return arrivalPosition;
	}

	public void setArrivalPosition(GPSCoordinates arrivalPosition) {
		this.arrivalPosition = arrivalPosition;
	}

	public MyDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(MyDate departureDate) {
		this.departureDate = departureDate;
	}

	public MyDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(MyDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
