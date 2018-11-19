package myVelibTests;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import myVelibBicycles.Bicycle;
import myVelibBicycles.MechanicalBicycle;
import myVelibBicycles.MechanicalBicycleFactory;
import myVelibExceptions.WrongParkingSlotException;
import myVelibRides.PlanningRide;
import myVelibRides.PlanningRideAvoidPlus;
import myVelibRides.PlanningRideFastestPath;
import myVelibRides.PlanningRidePreferPlus;
import myVelibRides.PlanningRideShortestPath;
import myVelibRides.PlanningRideUniformityPreservation;
import myVelibRides.Ride;
import myVelibSortStations.LeastOccupiedSort;
import myVelibSortStations.MostUsedSort;
import myVelibBicycles.ElectricalBicycle;
import myVelibBicycles.ElectricalBicycleFactory;
import myVelibStationNetwork.ParkingSlot;
import myVelibStationNetwork.Station;
import myVelibStationNetwork.Stations;
import myVelibTools.GPSCoordinates;
import myVelibTools.MyDate;
import myVelibUsers.User;
import myVelibUsers.VlibreCardFactory;
import myVelibUsers.VmaxCardFactory;
class RideTest {
	
	
				
	@Test
	void test() throws InterruptedException, WrongParkingSlotException {
		
		//initializing the stations object  
		Stations stations = Stations.getInstance();
		
		//initializing 4 arraylist objects representing the stations
		ArrayList<ParkingSlot> parkingslots0  = new ArrayList<ParkingSlot>();
		ArrayList<ParkingSlot> parkingslots1  = new ArrayList<ParkingSlot>();
		ArrayList<ParkingSlot> parkingslots2  = new ArrayList<ParkingSlot>();
		ArrayList<ParkingSlot> parkingslots3  = new ArrayList<ParkingSlot>();
		
		//initializing the bicycle objects for station0 : two electrical bicycles and five mechanical bicycles 
		ElectricalBicycle bike0 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		ElectricalBicycle bike1 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike2 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike3 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike4 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike5 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike6 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		
		//initializing the parking slots for station0 : 7 occupied ones (containing the bicycles), and 3 free ones
		ParkingSlot parkingslot0 = new ParkingSlot("occupied",(Bicycle)bike0);
		ParkingSlot parkingslot1 = new ParkingSlot("occupied",(Bicycle)bike1);
		ParkingSlot parkingslot2 = new ParkingSlot("occupied",(Bicycle)bike2);
		ParkingSlot parkingslot3 = new ParkingSlot("occupied",(Bicycle)bike3);
		ParkingSlot parkingslot4 = new ParkingSlot("occupied",(Bicycle)bike4);
		ParkingSlot parkingslot5 = new ParkingSlot("occupied",(Bicycle)bike5);
		ParkingSlot parkingslot6 = new ParkingSlot("occupied",(Bicycle)bike6);
		ParkingSlot parkingslot7 = new ParkingSlot("free",null);
		ParkingSlot parkingslot8 = new ParkingSlot("free",null);
		ParkingSlot parkingslot9 = new ParkingSlot("free",null);
		
		//initializing the bicycle objects for station1 : two electrical bicycles and five mechanical bicycles 
		ElectricalBicycle bike10 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		ElectricalBicycle bike11 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike12 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike13 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike14 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike15 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike16 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		
		//initializing the parking slots for station1 : 7 occupied ones (containing the bicycles), and 3 free ones
		ParkingSlot parkingslot10 = new ParkingSlot("occupied",(Bicycle)bike10);
		ParkingSlot parkingslot11 = new ParkingSlot("occupied",(Bicycle)bike11);
		ParkingSlot parkingslot12 = new ParkingSlot("occupied",(Bicycle)bike12);
		ParkingSlot parkingslot13 = new ParkingSlot("occupied",(Bicycle)bike13);
		ParkingSlot parkingslot14 = new ParkingSlot("occupied",(Bicycle)bike14);
		ParkingSlot parkingslot15 = new ParkingSlot("occupied",(Bicycle)bike15);
		ParkingSlot parkingslot16 = new ParkingSlot("occupied",(Bicycle)bike16);
		ParkingSlot parkingslot17 = new ParkingSlot("free",null);
		ParkingSlot parkingslot18 = new ParkingSlot("free",null);
		ParkingSlot parkingslot19 = new ParkingSlot("free",null);
		
		//initializing the bicycle objects for station2 : two electrical bicycles and five mechanical bicycles 
		ElectricalBicycle bike20 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		ElectricalBicycle bike21 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike22 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike23 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike24 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike25 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike26 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		
		//initializing the parking slots for station2 : 7 occupied ones (containing the bicycles), and 3 free ones
		ParkingSlot parkingslot20 = new ParkingSlot("occupied",(Bicycle)bike20);
		ParkingSlot parkingslot21 = new ParkingSlot("occupied",(Bicycle)bike21);
		ParkingSlot parkingslot22 = new ParkingSlot("occupied",(Bicycle)bike22);
		ParkingSlot parkingslot23 = new ParkingSlot("occupied",(Bicycle)bike23);
		ParkingSlot parkingslot24 = new ParkingSlot("occupied",(Bicycle)bike24);
		ParkingSlot parkingslot25 = new ParkingSlot("occupied",(Bicycle)bike25);
		ParkingSlot parkingslot26 = new ParkingSlot("occupied",(Bicycle)bike26);
		ParkingSlot parkingslot27 = new ParkingSlot("free",null);
		ParkingSlot parkingslot28 = new ParkingSlot("free",null);
		ParkingSlot parkingslot29 = new ParkingSlot("free",null);
		
		//initializing the bicycle objects for station3 : two electrical bicycles and five mechanical bicycles 
		ElectricalBicycle bike30 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		ElectricalBicycle bike31= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike32= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike33= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike34= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike35= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		MechanicalBicycle bike36= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		
		//initializing the parking slots for station3 : 7 occupied ones (containing the bicycles), and 3 free ones
		ParkingSlot parkingslot30 = new ParkingSlot("occupied",(Bicycle)bike30);
		ParkingSlot parkingslot31 = new ParkingSlot("occupied",(Bicycle)bike31);
		ParkingSlot parkingslot32 = new ParkingSlot("occupied",(Bicycle)bike32);
		ParkingSlot parkingslot33 = new ParkingSlot("occupied",(Bicycle)bike33);
		ParkingSlot parkingslot34 = new ParkingSlot("occupied",(Bicycle)bike34);
		ParkingSlot parkingslot35 = new ParkingSlot("occupied",(Bicycle)bike35);
		ParkingSlot parkingslot36 = new ParkingSlot("occupied",(Bicycle)bike36);
		ParkingSlot parkingslot37 = new ParkingSlot("free",null);
		ParkingSlot parkingslot38 = new ParkingSlot("free",null);
		ParkingSlot parkingslot39 = new ParkingSlot("free",null);
		
		//filling the parking slots arraylist
		parkingslots0.add(parkingslot0);
		parkingslots0.add(parkingslot1);
		parkingslots0.add(parkingslot2);
		parkingslots0.add(parkingslot3);
		parkingslots0.add(parkingslot4);
		parkingslots0.add(parkingslot5);
		parkingslots0.add(parkingslot6);
		parkingslots0.add(parkingslot7);
		parkingslots0.add(parkingslot8);
		parkingslots0.add(parkingslot9);
		parkingslots1.add(parkingslot10);
		parkingslots1.add(parkingslot11);
		parkingslots1.add(parkingslot12);
		parkingslots1.add(parkingslot13);
		parkingslots1.add(parkingslot14);
		parkingslots1.add(parkingslot15);
		parkingslots1.add(parkingslot16);
		parkingslots1.add(parkingslot17);
		parkingslots1.add(parkingslot18);
		parkingslots1.add(parkingslot19);
		parkingslots2.add(parkingslot20);
		parkingslots2.add(parkingslot21);
		parkingslots2.add(parkingslot22);
		parkingslots2.add(parkingslot23);
		parkingslots2.add(parkingslot24);
		parkingslots2.add(parkingslot25);
		parkingslots2.add(parkingslot26);
		parkingslots2.add(parkingslot27);
		parkingslots2.add(parkingslot28);
		parkingslots2.add(parkingslot29);
		parkingslots3.add(parkingslot30);
		parkingslots3.add(parkingslot31);
		parkingslots3.add(parkingslot32);
		parkingslots3.add(parkingslot33);
		parkingslots3.add(parkingslot34);
		parkingslots3.add(parkingslot35);
		parkingslots3.add(parkingslot36);
		parkingslots3.add(parkingslot37);
		parkingslots3.add(parkingslot38);
		parkingslots3.add(parkingslot39);
		
		//creating the stations : station0 and station1 are standard stations, station2 and station3 are plus stations.
		// In real life, station0 represents "les algorithmes" bus stop near CentraleSupelec.
		// station1 represents "Joliot Curie" bus stop
		// station2 represents "Moulon" bus stop
		// station3 represents "université paris-saclay" bus stop
		Station station0=  new Station(parkingslots0,new GPSCoordinates(48.7117128, 2.1498897),new Boolean("True"),stations, "standard");
		Station station1=  new Station(parkingslots1,new GPSCoordinates(48.7110057, 2.1621127),new Boolean("True"),stations, "standard");
		Station station2=  new Station(parkingslots2,new GPSCoordinates(48.7119910, 2.1663017) ,new Boolean("True"),stations, "plus");
		Station station3=  new Station(parkingslots3,new GPSCoordinates(48.7118813, 2.1716943) ,new Boolean("True"),stations, "plus");
		//creating the users 
		//user0 is a Vlibre card user
		//user1 is a Vmax card user
		//user2 doesn't have a card 
		User user0 = new User("Vlibreuser",VlibreCardFactory.getinstance().createCard());
		User user1 = new User("Vmaxuser",VmaxCardFactory.getinstance().createCard());
		User user2 = new User("NoCardUser");
		
		//user0 starts at Station0, takes a bike, and 5 seconds later he puts it in station1  
		//user1 starts at Station0, takes a bike, and 5 seconds later he puts it in station2  
		//user2 starts at Station0, takes a bike, and 5 seconds later he puts it in station3  
		station0.getUserTerminal().rentBicycle(user0);
		station0.getUserTerminal().rentBicycle(user1);
		station0.getUserTerminal().rentBicycle(user2);
		Thread.sleep(5000);
		
		//creating b0, b1, and b2 that contain the bikes taken respectively by user0, user1, and user2
		Bicycle b0 = null;
		Bicycle b1 = null;
		Bicycle b2 = null;
		
		for (ObserverObservableInterfaces.Observer observer : station0.getObservers()) {
			
			if (((Ride) observer).getUser() == user0) {
				
				b0 = ((Ride)observer).getBicycle();
				break;
				
			}
			
		}
		
		for (ObserverObservableInterfaces.Observer observer : station0.getObservers()) {
			
			if (((Ride) observer).getUser() == user1) {
				
				b1 = ((Ride)observer).getBicycle();
				break;
				
			}
			
		}
		
		for (ObserverObservableInterfaces.Observer observer : station0.getObservers()) {
			
			if (((Ride) observer).getUser() == user2) {
				
				b2 = ((Ride)observer).getBicycle();
				break;
				
			}
			
		}
		
		// returning the bikes
		station1.getUserTerminal().returnBicycle(b0, new MyDate());
		station2.getUserTerminal().returnBicycle(b1, new MyDate());
		station3.getUserTerminal().returnBicycle(b2, new MyDate());
		
		//user1 wants to start a ride near station0 and wants to go near station3. He chooses a mechanical bicycle and an avoid plus stations strategy.
		//expects departure station0 and arrival station1.
		PlanningRide planningride3 = new PlanningRideAvoidPlus(stations);
		Ride ride3 = new Ride(planningride3,new GPSCoordinates(48.71225,2.14851),new GPSCoordinates(48.71254,2.17172),user1,MechanicalBicycleFactory.getinstance().createBicycle().getClass());
		ride3.getDepartureStation().getUserTerminal().rentBicyclePlanningRide(ride3.getUser());
		System.out.println(ride3.getDepartureStation().getStationID());
		System.out.println(ride3.getArrivalStation().getStationID());
		//the ride takes 3 seconds.
		Thread.sleep(3000);
		ride3.getArrivalStation().getUserTerminal().returnBicycle(ride3.getBicycle(), new MyDate());
		
		MyDate date0 = new MyDate();
		
		//user1 wants to start a ride near station0 and wants to go near station1. He chooses a mechanical bicycle and a prefer plus stations strategy.
		//expects departure station0 and arrival station1
		PlanningRide planningride4= new PlanningRidePreferPlus(stations);
		Ride ride4 = new Ride(planningride4,new GPSCoordinates(48.71235,2.14989),new GPSCoordinates(48.71119,2.16219),user1,MechanicalBicycleFactory.getinstance().createBicycle().getClass());
		ride4.getDepartureStation().getUserTerminal().rentBicyclePlanningRide(ride4.getUser());
		System.out.println(ride4.getDepartureStation().getStationID());
		System.out.println(ride4.getArrivalStation().getStationID());
		//the ride takes 3 seconds.
		Thread.sleep(3000);
		ride4.getArrivalStation().getUserTerminal().returnBicycle(ride4.getBicycle(), new MyDate());
		
		//user1 wants to start a ride near station0 and wants to go near station3. He chooses a mechanical bicycle and a shortest path strategy.
		//expects departure station0 and arrival station3
		PlanningRide planningride5 = new PlanningRideShortestPath(stations);
		Ride ride5 = new Ride(planningride5,new GPSCoordinates(48.71225,2.14851),new GPSCoordinates(48.71254,2.17172),user1,MechanicalBicycleFactory.getinstance().createBicycle().getClass());
		ride5.getDepartureStation().getUserTerminal().rentBicyclePlanningRide(ride5.getUser());
		System.out.println(ride5.getDepartureStation().getStationID());
		System.out.println(ride5.getArrivalStation().getStationID());
		//the ride takes 3 seconds.
		Thread.sleep(3000);
		ride5.getArrivalStation().getUserTerminal().returnBicycle(ride5.getBicycle(), new MyDate());
		
		
		//user2 wants to start a ride near station0 and wants to go near station3. He chooses a fastest path strategy.
		//expects departure station0 and arrival station3
		PlanningRide planningride7 = new PlanningRideFastestPath(stations);
		Ride ride7 = new Ride(planningride7,new GPSCoordinates(48.71225,2.14851),new GPSCoordinates(48.71254,2.17172),user2,MechanicalBicycleFactory.getinstance().createBicycle().getClass());		
		
		//user1 starts in a position right in the middle between station0 and station1 only a bit closer to station0 and wants to go near station3. He chooses an uniformity preservation strategy.
		//expects departure station1 and arrival station3
		PlanningRide planningride6 = new PlanningRideUniformityPreservation(stations);
		Ride ride6 = new Ride(planningride6,new GPSCoordinates(48.7112592,2.1560010),new GPSCoordinates(48.71254,2.17172),user1,MechanicalBicycleFactory.getinstance().createBicycle().getClass());
		ride6.getDepartureStation().getUserTerminal().rentBicyclePlanningRide(ride6.getUser());
		System.out.println(ride6.getDepartureDate());
		System.out.println(ride6.getBicycle().getBicycleID());
		System.out.println(ride6.getDepartureStation().getStationID());
		System.out.println(ride6.getArrivalStation().getStationID());
		Thread.sleep(3000);
		ride6.getArrivalStation().getUserTerminal().returnBicycle(ride6.getBicycle(), new MyDate());
		//user1 filled the last empty spot in station3. 
		//user2 has been notified that all the parking slots in his planned arrival station (station3) has become occupied.
		
		ride7.getDepartureStation().getUserTerminal().rentBicyclePlanningRide(ride7.getUser());
		System.out.println(ride7.getDepartureStation().getStationID());
		System.out.println(ride7.getArrivalStation().getStationID());
		//the ride takes 3 seconds.
		Thread.sleep(3000);
		ride7.getArrivalStation().getUserTerminal().returnBicycle(ride7.getBicycle(), new MyDate());
				
		//checking the users balances
		//checking user0 total time credit. expects 0 because he didn't take any ride to a plus station.
		System.out.println(user0.getCard().getTotalTimeCredit());
		//checking user1 total time credit. expects 15.0 because he took 3 rides to a plus station.
		System.out.println(user1.getCard().getTotalTimeCredit());
		//checking user1 total charges. expects 0.00139 for all his rides.
		System.out.println(user2.getTotalCharges());
		//checking station0 number of rents. expect 7.
		System.out.println(station0.getRentsNumber());
		//checking station0 number of returns. expect 0(no ride ended in station0)
		System.out.println(station0.getReturnsNumber());
		//checking station1 number of rents. expect 1.
		System.out.println(station1.getRentsNumber());
		//checking station1 number of returns. expect 3.
		System.out.println(station1.getReturnsNumber());
		//checking station1 number of rents. expect 3.
		System.out.println(station2.getRentsNumber());
		//checking station1 number of returns. expect 3.
		System.out.println(station2.getReturnsNumber());
		//checking station1 number of rents. expect 3.
		System.out.println(station3.getRentsNumber());
		//checking station1 number of returns. expect 3;
		System.out.println(station3.getReturnsNumber());
		//checking the duration if ride3. expect 0.05 minutes(3 seconds);
		System.out.println(ride3.computeTime());
		//checking the total time spent on a bike by user1.
		System.out.println(user1.getTotalTimeOnBicycle());
	
		//test the sorting methods.
		// testing the most used sorting method. expects (station1,station2,station0,station3)
		stations.setSort(new MostUsedSort());
		System.out.println(stations.getStationsList());
		System.out.println(stations.sortStations());
		// testing the least occupied sorting method. expects (station0,station2,station1,station3)
		stations.setSort(new LeastOccupiedSort());
		System.out.println(stations.sortStations());
		
		//testing the average occupation rate method for station1. expects a ratio of 0.875.
		MyDate date1 = new MyDate();
		System.out.println(station1.avgOccupationRate(date0, date1));
		
		
		
		
		
		
	}

}
