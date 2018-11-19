package myVelibStationNetwork;

import java.util.ArrayList;
import myVelibBicycles.Bicycle;
import myVelibExceptions.WrongTimePeriodException;
import myVelibTools.MyDate;

/**
 * This class describes a Parking slot
 * @author Pasteau Jebbari
 *
 */
public class ParkingSlot {
	
	private static int counter=0; 
	private int parkingSlotID;
	private String state;
	public ArrayList<Object[]> events;
	private Bicycle bicycle;
	
	/**
	 * This constructor creates a parking slot
	 * @param parkingSlotID : a unique identifier for this parking slot
	 * @param state : can have the values "occupied", "free", or "out-of-order" 
	 * @param bicycle : the bicycle that is parked on this parking slot. Attention : if state is "free", bicycle should have the value null
	 * The attribute events is an ArrayList in which there are arrays of size 2 containing an object of type MyDate and a String saying whether a bike has been added to or removed from this parking slot at this date.
	 */
	/*I changed the ParkingSlot method (but I think we should increment the ID everytime we instantiate a parkingslot)*/
	public ParkingSlot(String state, Bicycle bicycle) {
		
		this.parkingSlotID = counter;
		counter++;
		this.state = state;
		if ( this.state == "free") {this.bicycle = null;}
		else
		{this.bicycle = bicycle;};
		this.events = new ArrayList<Object[]>();
		if (this.state == "free") {
			Object[] n = {new MyDate(),"r"};
			events.add(n);
		} else if (this.state == "occupied") {
			Object[] n = {new MyDate(),"a"};
			events.add(n);
		} else {
			Object[] n = {new MyDate(),"o"};
			events.add(n);
		}
		
	}
	
	
	/**
	 * This method computes the occupation rate of this parking slot
	 * @return
	 */
	public double occupationRate(MyDate startDate, MyDate endDate) throws WrongTimePeriodException {
		
		if (startDate.compareTo((MyDate)this.events.get(0)[0])<0) { //if the startDate is before the commissioning of the station, we throw an exception
			
			System.out.println("Sorry, the given startDate is before the commissioning of this station");
			throw new WrongTimePeriodException(startDate);
			
		}
		
		else {
			
			double totaltime = 0;
			int i = 0;
			int n = this.events.size();
			while(i<n && ((MyDate)this.events.get(i)[0]).compareTo(startDate)<0) { // we're looking for the first event of this parkingslot that is after the startDate
				
				i++;
				
			}
			
			if (i<n) { //if this first event exists, we compute the totaltime the parkingslot has been occupied(a) or out-of-order(o)
				
				int j = i;
				while (j<n-1 && ((MyDate) this.events.get(j+1)[0]).compareTo(endDate)<0) {//we go through the events list until the end or until we have reached the endDate
					
					if (this.events.get(j)[1] == "a" || this.events.get(j)[1] == "o") {
						
						Object[] o = this.events.get(j+1);
						totaltime += ((MyDate)o[0]).timeUntilThis((MyDate) this.events.get(j)[0]); 
						
					}
					
					j++;
					
				}
				
				if (this.events.get(j)[1] == "a" || this.events.get(j)[0] == "o") {//we don't forget the time between the last event before the endDate and the endDate
					
					totaltime += endDate.timeUntilThis((MyDate) this.events.get(j)[0]);
					
				}
				
				return totaltime/(endDate.timeUntilThis(startDate));
				
			}
			
			else {
				
				if (this.events.get(this.events.size()-1)[1] == "a" || this.events.get(this.events.size()-1)[0] == "o") {
					
					return 1;
					
				}
				
				else {
					
					return 0;
					
				}
				
			}
			
		}
		
	}
	
	/**
	 * This method computes the occupation of this parking slot since it was created
	 * 
	 * @return
	 */
	public double occupationRate() {
		
		double totaltime = 0;
		int n = this.events.size();
		
		for (int i = 0; i<n-1; i++){
			
			if (this.events.get(i)[1] == "a" || this.events.get(i)[1] == "o") {
				
				Object[] o = this.events.get(i+1);
				totaltime += ((MyDate) o[0]).timeUntilThis((MyDate) this.events.get(i)[0]);
				
			}
			
		}
		
		if (this.events.get(n-1)[1] == "a" || this.events.get(n-1)[1] == "o") {
			
			MyDate currentDate = new MyDate();
			totaltime += currentDate.timeUntilThis((MyDate) this.events.get(n-1)[0]);
			
		}
		
		return totaltime/(new MyDate().timeUntilThis((MyDate) this.events.get(0)[0]));
		
	}
	
	public int getParkingSlotID() {
		return parkingSlotID;
	}
	public void setParkingSlotID(int parkingSlotID) {
		this.parkingSlotID = parkingSlotID;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
		if (state.equalsIgnoreCase("out-of-order")){
			
			Object[] n = {new MyDate(), "o"};
			this.events.add(n);
			
		}
	}

	public Bicycle getBicycle() {
		return bicycle;
	}
	public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + parkingSlotID;
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
		ParkingSlot other = (ParkingSlot) obj;
		if (parkingSlotID != other.parkingSlotID)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ParkingSlot [parkingSlotID=" + parkingSlotID + "]";
	}
	
	

}
