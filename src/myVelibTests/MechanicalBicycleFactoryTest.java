package myVelibTests;

import org.junit.jupiter.api.Test;
import myVelibBicycles.MechanicalBicycle;
import myVelibBicycles.MechanicalBicycleFactory;
class MechanicalBicycleFactoryTest {
	
	@Test
	void test() {
		MechanicalBicycleFactory factory = MechanicalBicycleFactory.getinstance();
		MechanicalBicycle bike = factory.createBicycle();
		System.out.println(bike);
		
		
		
		
		
	}

}
