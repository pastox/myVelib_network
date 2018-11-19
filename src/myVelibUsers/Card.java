package myVelibUsers;

import myVelibBicycles.ElectricalBicycle;
import myVelibBicycles.MechanicalBicycle;

/**
 * This class describes a myVelib system's user's card
 * @author Pasteau Jebbari
 *
 */
public abstract class Card {
	
	private double timeCredit;
	private double totalTimeCredit;

	/**
	 * This constructor creates an object of type Card and initializes the time credit to 0
	 */
	public Card() {
		
		this.timeCredit = 0;
		this.totalTimeCredit = 0;
		
	}
	
	public double getTimeCredit() {
		return timeCredit;
	}

	public void setTimeCredit(double timeCredit) {
		this.timeCredit = timeCredit;
	}
	
	
	
	public double getTotalTimeCredit() {
		return totalTimeCredit;
	}

	public void setTotalTimeCredit(double totalTimeCredit) {
		this.totalTimeCredit = totalTimeCredit;
	}

	/**
	 * This method computes the cost of a ride that lasted "time" minutes and in which a mechanical bicycle was used and updates the card's timecredit if necessary.
	 * @param bicycle
	 * @param time
	 * @return
	 */
	public abstract double cost(MechanicalBicycle bicycle, double time);
	
	/**
	 * This method computes the cost of a ride that lasted "time" minutes and in which an electrical bicycle was used, and updates the card's timecredit if necessary.
	 * @param bicycle
	 * @param time
	 * @return
	 */
	public abstract double cost(ElectricalBicycle bicycle, double time);

}
