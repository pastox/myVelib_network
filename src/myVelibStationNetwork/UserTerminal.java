package myVelibStationNetwork;

import ObserverObservableInterfaces.Observer;
import myVelibBicycles.Bicycle;
import myVelibExceptions.WrongParkingSlotException;
import myVelibRides.Ride;
import myVelibTools.MyDate;
import myVelibUsers.User;

public class UserTerminal {
	
	private  Station station;
	
	public UserTerminal(Station station) {
		
		this.station = station;
		
	}
	
	/**
	 * This method enables a user to rent a bicycle without planning the ride at the station which this is the user terminal, if there are some available bicycles there. It also updates some statistics of the user who rents the bike and of the station.
	 * @param user
	 */
	public String rentBicycle(User user) {
		
		int i = 0;
		int n = this.station.getParkingSlots().size();
		while(i<n && !this.station.getParkingSlots().get(i).getState().equalsIgnoreCase("occupied")) {
			
			i++;
			
		}
		
		if (i < n) {
			
			try {
				
				Bicycle bicycle = this.station.getParkingSlots().get(i).getBicycle();
				this.station.removeBicycle(this.station.getParkingSlots().get(i));
				@SuppressWarnings("unused")
				Ride ride = new Ride(this.station, user, bicycle);
				this.station.setRentsNumber(this.station.getRentsNumber() + 1);
				user.setRidesNumber(user.getRidesNumber() + 1);
				return("A bicycle has been rented at the station " + this.getStation().getStationID() + " by user " + user.getName());
				
			} catch (WrongParkingSlotException e) { //This should actually never happen because of the while loop here above
				
				System.err.println("error");
				return("error");
				
			}finally {}
			
		}
		
		else {
			
			return("Sorry, there is no more available bicycle at this station");
			
		}
		
	}
	
	/**
	 * This method enables a user to rent a bicycle at the station if there is one available, in the case the trip was planned by the myvelibSystem : this means the Ride object has already been initialized and already contains the planned arrivalStation. This Ride object has also already been added to the observers lists of the stations. It also updates some statistics of the user who rents the bike and of the station.
	 * 
	 * @param user
	 * @param arrivalPosition
	 * @param planningRide
	 */
	public void rentBicyclePlanningRide(User user) {
		
		int i = 0;
		int n = this.station.getParkingSlots().size();
		while(i<n && !this.station.getParkingSlots().get(i).getState().equalsIgnoreCase("occupied")) {
			
			i++;
			
		}
		
		if (i < n) {
			
			try {
				
				Bicycle bicycle = this.station.getParkingSlots().get(i).getBicycle();
				Ride ride = null;
				for (Observer observer : this.station.getObservers()) {
					
					if (((Ride) observer).getUser().equals(user)) {
						
						ride = (Ride)observer;
						break;
						
					}
					
				}
				ride.setBicycle(bicycle);
				ride.setDepartureDate(new MyDate());
				this.station.removeBicycle(this.station.getParkingSlots().get(i));
				this.station.setRentsNumber(this.station.getRentsNumber() + 1);
				user.setRidesNumber(user.getRidesNumber() + 1);
				
			} catch (WrongParkingSlotException e) { //This should actually never happen because of the while loop here above
				
				System.err.println("error");
				
			}finally {}
			
		}
		
		else {
			
			System.out.println("Sorry, there is no more available bicycle at this station");
			
		}
		
	}
	
	/**
	 * This method allows a user to restore a bike to the station and most importantly to let the system know that his/her ride is over. and to know about the cost of the ride. It also updates some statistics of the station, and the time credit of the card if the user who returns the bike has one.
	 * Whenever this method is executed, one verifies if there are still some free parking slots in the station. If not, the method station.notifyObervers2() is called in order to notify the users whose planned arrival station is this one that their planned arrival station is full.
	 * 
	 * @param bicycle
	 * @param user
	 */
	public String returnBicycle(Bicycle bicycle, MyDate date) {
		
		int i = 0;
		int n = this.station.getParkingSlots().size();
		while(i<n && !this.station.getParkingSlots().get(i).getState().equalsIgnoreCase("free")) {
			
			i++;
			
		}
		
		if (i < n) {
			
			try {
				
				this.station.addBicycle(bicycle,this.station.getParkingSlots().get(i));
				this.station.notifyObservers(bicycle, this.station, date);
				this.station.setReturnsNumber(this.station.getReturnsNumber() + 1);
				return("the bicycle " + bicycle.getBicycleID() + " has been given back to the station " + this.getStation().getStationID());
			} catch (WrongParkingSlotException e) { //This should actually never happen because of the while loop here above
				
				System.err.println("error");
				return("error");
				
			}finally {
				
				if (this.station.isFull()) {
					
					this.station.notifyObservers2();
					
				}
				
			}
			
		}
		
		else {
			
			System.out.println("Sorry, all the parking slots are occupied or out-of-order");
			return("Sorry, all the parking slots are occupied or out-of-order");
			
		}
		
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

}
