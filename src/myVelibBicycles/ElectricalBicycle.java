package myVelibBicycles;

import myVelibUsers.User;

public class ElectricalBicycle extends Bicycle{

	public ElectricalBicycle(int bicycleID) {
		
		super(bicycleID);
		
	}
	
	@Override
	public double cost(User user, double time) {
		
		if (user.getCard() == null) {
			
			return 2*time/60;
			
		}
		
		else {
			
			return user.getCard().cost(this, time);
			
		}
		
	}

}
