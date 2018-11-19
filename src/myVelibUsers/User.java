package myVelibUsers;


import ObserverObservableInterfaces.Observer;
import myVelibStationNetwork.Station;
import myVelibTools.MyDate;

/**
 * This class describes a user of the myVelib System
 * @author Pasteau Jebbari
 *
 */
public class User implements Observer {
	private static int counter = 0;
	private int userID;
	private String name;
	private Card card;
	private double totalTimeOnBicycle;
	private int ridesNumber;
	private double totalCharges;
	
	/**
	 * This Constructor creates an object of type User that has no card
	 * 
	 * @param userID
	 */
	public User(String name) {
		
		this.userID = counter;
		this.name = name;
		this.card = null;
		this.totalTimeOnBicycle = 0;
		this.ridesNumber = 0;
		this.totalCharges = 0;	
		counter++;
		Users.getInstance().addUser(this);
	}
	
	/**
	 * This constructor creates an object of type User that has a card.
	 * 
	 * @param userID
	 * @param card
	 */
	public User(String name, Card card) {
		
		this.userID = counter;
		this.name = name;
		this.card = card;
		this.totalTimeOnBicycle = 0;
		this.ridesNumber = 0;
		this.totalCharges = 0;
		counter++;
		Users.getInstance().addUser(this);
		
	}
	
	@Override
	public void update(Station station, MyDate date) {
		
		System.out.println("The user " + this.name + " has been notified that his planned arrivalStation has become offline or that all its parkingSlots have become occupied.");

	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public double getTotalTimeOnBicycle() {
		return totalTimeOnBicycle;
	}

	public void setTotalTimeOnBicycle(double totalTimeOnBicycle) {
		this.totalTimeOnBicycle = totalTimeOnBicycle;
	}

	public int getRidesNumber() {
		return ridesNumber;
	}

	public void setRidesNumber(int ridesNumber) {
		this.ridesNumber = ridesNumber;
	}

	public double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
