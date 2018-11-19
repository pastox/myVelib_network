package myVelibTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import myVelibTools.GPSCoordinates;

class GPSCoordinatesTest {

	@Test
	void distancetotest() {
		
		GPSCoordinates position1 = new GPSCoordinates(47.45376854,0.71693349);
		GPSCoordinates position2 = new GPSCoordinates(47.44431175,0.70717026);
		//checking the distance between position1 and position2. expects 1282 meters.
		assertTrue(Math.abs(position1.distanceTo(position2)-1282)<3);
	}
	
	

}
