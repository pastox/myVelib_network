package myVelibBicycles;

import myVelibUsers.User;

public class MechanicalBicycle extends Bicycle {

	public MechanicalBicycle(int bicycleID) {

		super(bicycleID);

	}

	@Override
	public double cost(User user, double time) {
		
		if (user.getCard() == null) {
			
			return time/60;
			
		}
		
		else {
			
			return user.getCard().cost(this, time);
			
		}
		
	}

}
