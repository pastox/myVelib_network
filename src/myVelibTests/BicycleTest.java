package myVelibTests;

import org.junit.jupiter.api.Test;

import myVelibBicycles.ElectricalBicycle;

class BicycleTest {
	
	@Test
	void test() {
		ElectricalBicycle bike = new ElectricalBicycle(0);
		System.out.println(bike.getClass());
	}

}
