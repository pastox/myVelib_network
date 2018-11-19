package myVelibBicycles;

import myVelibUsers.User;

/**
 * This class describes a bicycle
 * @author Pasteau Jebbari
 *
 */
public abstract class Bicycle {
	
	private int bicycleID;
	
	public Bicycle(int bicycleID) {
		
		this.bicycleID = bicycleID;
		
	}
	
	/**
	 * This method computes the cost of a ride done by user and that lasted time minutes. The ride was of course done with the bike instantiating this class.
	 * @param user
	 * @param time
	 * @return
	 */
	public abstract double cost(User user, double time);

	public int getBicycleID() {
		return bicycleID;
	}

	public void setBicycleID(int bicycleID) {
		this.bicycleID = bicycleID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bicycleID;
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
		Bicycle other = (Bicycle) obj;
		if (bicycleID != other.bicycleID)
			return false;
		return true;
	}
	
	

}
