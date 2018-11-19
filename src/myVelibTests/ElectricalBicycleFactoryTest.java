package myVelibTests;

import org.junit.jupiter.api.Test;

import myVelibBicycles.ElectricalBicycle;
import myVelibBicycles.ElectricalBicycleFactory;

class ElectricalBicycleFactoryTest {

	@Test
	void test() {
		ElectricalBicycleFactory factory = ElectricalBicycleFactory.getinstance();
		ElectricalBicycle bike = (ElectricalBicycle) factory.createBicycle();
		System.out.println(bike);
		
	}

}
