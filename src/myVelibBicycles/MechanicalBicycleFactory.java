package myVelibBicycles;

public class MechanicalBicycleFactory extends BicycleFactory {
	
	private static MechanicalBicycleFactory instance = new MechanicalBicycleFactory();
		
	public static MechanicalBicycleFactory getinstance(){
		 return instance;
	}

	@Override
	public MechanicalBicycle createBicycle() {
		
		counter++;
		return new MechanicalBicycle(counter);
		
	}

}
