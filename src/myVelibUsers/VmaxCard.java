package myVelibUsers;

import myVelibBicycles.ElectricalBicycle;
import myVelibBicycles.MechanicalBicycle;

/**
 * This class describes a VmaxCard
 * @author Pasteau Jebbari
 *
 */
public class VmaxCard extends Card {
	
	public VmaxCard() {
		
		super();
		
	}

	@Override
	public double cost(MechanicalBicycle bicycle, double time) {
		
		if (time <= 60) {
			
			return 0;
			
		}
		
		else {
			
			if (time - 60 <= this.getTimeCredit()) {
				
				this.setTimeCredit(this.getTimeCredit() - (time - 60));
				return 0;
				
			}
			
			else {
				
				double chargedTime = time - 60 - this.getTimeCredit();
				this.setTimeCredit(0);
				return chargedTime/60;
				
			}
			
		}
		
	}

	@Override
	public double cost(ElectricalBicycle bicycle, double time) {
		
		if (time <= 60) {
			
			return 0;
			
		}
		
		else {
			
			if (time - 60 <= this.getTimeCredit()) {
				
				this.setTimeCredit(this.getTimeCredit() - (time - 60));
				return 0;
				
			}
			
			else {
				
				double chargedTime = time - 60 - this.getTimeCredit();
				this.setTimeCredit(0);
				return chargedTime/60;
				
			}
			
		}
		
	}

}
