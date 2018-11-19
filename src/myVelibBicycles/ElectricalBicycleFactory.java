package myVelibBicycles;

public class ElectricalBicycleFactory extends BicycleFactory {
	
	private static ElectricalBicycleFactory instance = new ElectricalBicycleFactory();
	
	
	public static ElectricalBicycleFactory getinstance() {
		return instance;
	}


	@Override
	public Bicycle createBicycle() {
		
		counter++;
		return new ElectricalBicycle(counter);
		
	}

}
