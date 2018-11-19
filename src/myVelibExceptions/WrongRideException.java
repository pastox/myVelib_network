package myVelibExceptions;

import myVelibRides.Ride;

public class WrongRideException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ride ride;
	
	public WrongRideException(Ride ride) {
		
		this.ride = ride;
		
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}
	

}
