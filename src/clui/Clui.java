package clui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


import ObserverObservableInterfaces.Observer;
import myVelibBicycles.Bicycle;
import myVelibBicycles.ElectricalBicycle;
import myVelibBicycles.ElectricalBicycleFactory;
import myVelibBicycles.MechanicalBicycle;
import myVelibBicycles.MechanicalBicycleFactory;
import myVelibRides.Ride;
import myVelibSortStations.LeastOccupiedSort;
import myVelibSortStations.MostUsedSort;
import myVelibStationNetwork.*;
import myVelibTools.GPSCoordinates;
import myVelibTools.MyDate;
import myVelibUsers.*;
import java.util.Scanner;


/**
 * This Class has a method main which triggers tha command line user interface which a user can interact with
 * @author Pasteau Jebbari
 *
 */
public class Clui {
	
	private static boolean quit = false;
	
	public static void main(final String[] args) throws IOException {
		 
		System.out.println("Welcome to the MyVelib user interface system");
		Scanner sc = new Scanner(System.in);
		
		String[] command = new String[2];
		command[0] = "runtest";
		command[1] = "my_velib.ini";
		nextcommand(command);
		
		do {
				
			String s = sc.nextLine();
			command = s.split(" ");
			try {
				nextcommand(command);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				    	
			} while (!quit);
			
				sc.close();

		}
	
	public static String nextcommand(String[] command) throws IOException {
		
		
		try {
			
			if(command[0].equalsIgnoreCase("setup")) {
		    	String velibnetworkName = command[1];
			    	//initializing the stations object  
				Stations stations = Stations.getInstance();
				MyVelibs myVelibs = MyVelibs.getInstance();
		    	if (!myVelibs.exists(velibnetworkName)) {
		    		
		    		MyVelib velibnetwork = new MyVelib(velibnetworkName);
		    	
		    	

				
					//initializing arraylist objects representing the stations
					ArrayList<ParkingSlot> parkingslots0  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots1  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots2  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots3  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots4  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots5  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots6  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots7  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots8  = new ArrayList<ParkingSlot>();
					ArrayList<ParkingSlot> parkingslots9  = new ArrayList<ParkingSlot>();
					
					//initializing the bikes
					ElectricalBicycle bike0 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike1 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike2 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike3 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike4 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike5 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike6 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike7 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike8 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike9 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike10 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike11 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike12 = (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike13= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike14 = (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike15= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike16= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike17= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike18= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike19= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike20= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike21= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike22= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike23= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike24= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike25= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike26= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike27= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike28= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike29= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike30= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike31= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike32= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike33= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike34= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike36= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike37= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike38= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike39= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike40= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike41= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike42= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike43= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike44= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike46= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike47= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike48= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike49= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike50= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike51= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike52= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike53= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike54= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike56= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike57= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike58= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike59= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike60= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike61= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike62= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike63= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike64= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike66= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike67= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike68= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					ElectricalBicycle bike69= (ElectricalBicycle) ElectricalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike70= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike71= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					MechanicalBicycle bike72= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					@SuppressWarnings("unused")
					MechanicalBicycle bike73= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					@SuppressWarnings("unused")
					MechanicalBicycle bike74= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
					@SuppressWarnings("unused")
					MechanicalBicycle bike75= (MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle();
		
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
					
					ParkingSlot parkingslot10 = new ParkingSlot("occupied",(Bicycle)bike7);
					ParkingSlot parkingslot11 = new ParkingSlot("occupied",(Bicycle)bike8);
					ParkingSlot parkingslot12 = new ParkingSlot("occupied",(Bicycle)bike9);
					ParkingSlot parkingslot13 = new ParkingSlot("occupied",(Bicycle)bike10);
					ParkingSlot parkingslot14 = new ParkingSlot("occupied",(Bicycle)bike11);
					ParkingSlot parkingslot15 = new ParkingSlot("occupied",(Bicycle)bike12);
					ParkingSlot parkingslot16 = new ParkingSlot("occupied",(Bicycle)bike13);
					ParkingSlot parkingslot17 = new ParkingSlot("free",null);
					ParkingSlot parkingslot18 = new ParkingSlot("free",null);
					ParkingSlot parkingslot19 = new ParkingSlot("free",null);
					
					ParkingSlot parkingslot20 = new ParkingSlot("occupied",(Bicycle)bike14);
					ParkingSlot parkingslot21 = new ParkingSlot("occupied",(Bicycle)bike15);
					ParkingSlot parkingslot22 = new ParkingSlot("occupied",(Bicycle)bike16);
					ParkingSlot parkingslot23 = new ParkingSlot("occupied",(Bicycle)bike17);
					ParkingSlot parkingslot24 = new ParkingSlot("occupied",(Bicycle)bike18);
					ParkingSlot parkingslot25 = new ParkingSlot("occupied",(Bicycle)bike19);
					ParkingSlot parkingslot26 = new ParkingSlot("free",null);
					ParkingSlot parkingslot27 = new ParkingSlot("free",null);
					ParkingSlot parkingslot28 = new ParkingSlot("free",null);
					ParkingSlot parkingslot29 = new ParkingSlot("free",null);
					
					ParkingSlot parkingslot30 = new ParkingSlot("occupied",(Bicycle)bike20);
					ParkingSlot parkingslot31 = new ParkingSlot("occupied",(Bicycle)bike21);
					ParkingSlot parkingslot32 = new ParkingSlot("occupied",(Bicycle)bike22);
					ParkingSlot parkingslot33 = new ParkingSlot("occupied",(Bicycle)bike23);
					ParkingSlot parkingslot34 = new ParkingSlot("occupied",(Bicycle)bike24);
					ParkingSlot parkingslot35 = new ParkingSlot("occupied",(Bicycle)bike25);
					ParkingSlot parkingslot36 = new ParkingSlot("occupied",(Bicycle)bike26);
					ParkingSlot parkingslot37 = new ParkingSlot("free",null);
					ParkingSlot parkingslot38 = new ParkingSlot("free",null);
					ParkingSlot parkingslot39 = new ParkingSlot("free",null);
					
					ParkingSlot parkingslot40 =new ParkingSlot("free",null);
					ParkingSlot parkingslot41 =new ParkingSlot("free",null);
					ParkingSlot parkingslot42 =new ParkingSlot("free",null);
					ParkingSlot parkingslot43 = new ParkingSlot("occupied",(Bicycle)bike27);
					ParkingSlot parkingslot44 = new ParkingSlot("occupied",(Bicycle)bike28);
					ParkingSlot parkingslot45 = new ParkingSlot("occupied",(Bicycle)bike29);
					ParkingSlot parkingslot46 = new ParkingSlot("occupied",(Bicycle)bike30);
					ParkingSlot parkingslot47 = new ParkingSlot("occupied",(Bicycle)bike31);
					ParkingSlot parkingslot48 = new ParkingSlot("occupied",(Bicycle)bike32);
					ParkingSlot parkingslot49 = new ParkingSlot("occupied",(Bicycle)bike33);
					
					ParkingSlot parkingslot50 =new ParkingSlot("free",null);
					ParkingSlot parkingslot51 =new ParkingSlot("free",null);
					ParkingSlot parkingslot52 =new ParkingSlot("free",null);
					ParkingSlot parkingslot53 = new ParkingSlot("occupied",(Bicycle)bike34);
					ParkingSlot parkingslot54 = new ParkingSlot("occupied",(Bicycle)bike36);
					ParkingSlot parkingslot55 = new ParkingSlot("occupied",(Bicycle)bike37);
					ParkingSlot parkingslot56 = new ParkingSlot("occupied",(Bicycle)bike38);
					ParkingSlot parkingslot57 = new ParkingSlot("occupied",(Bicycle)bike39);
					ParkingSlot parkingslot58 = new ParkingSlot("occupied",(Bicycle)bike40);
					ParkingSlot parkingslot59 = new ParkingSlot("occupied",(Bicycle)bike41);
					
					ParkingSlot parkingslot60 =new ParkingSlot("free",null);
					ParkingSlot parkingslot61 =new ParkingSlot("free",null);
					ParkingSlot parkingslot62 =new ParkingSlot("free",null);
					ParkingSlot parkingslot63 = new ParkingSlot("occupied",(Bicycle)bike42);
					ParkingSlot parkingslot64 = new ParkingSlot("occupied",(Bicycle)bike43);
					ParkingSlot parkingslot65 = new ParkingSlot("occupied",(Bicycle)bike44);
					ParkingSlot parkingslot66 = new ParkingSlot("occupied",(Bicycle)bike46);
					ParkingSlot parkingslot67 = new ParkingSlot("occupied",(Bicycle)bike47);
					ParkingSlot parkingslot68 = new ParkingSlot("occupied",(Bicycle)bike48);
					ParkingSlot parkingslot69 = new ParkingSlot("occupied",(Bicycle)bike49);
	
					ParkingSlot parkingslot70 =new ParkingSlot("free",null);
					ParkingSlot parkingslot71 =new ParkingSlot("free",null);
					ParkingSlot parkingslot72 =new ParkingSlot("free",null);
					ParkingSlot parkingslot73 = new ParkingSlot("occupied",(Bicycle)bike50);
					ParkingSlot parkingslot74 = new ParkingSlot("occupied",(Bicycle)bike51);
					ParkingSlot parkingslot75 = new ParkingSlot("occupied",(Bicycle)bike52);
					ParkingSlot parkingslot76 = new ParkingSlot("occupied",(Bicycle)bike53);
					ParkingSlot parkingslot77 = new ParkingSlot("occupied",(Bicycle)bike54);
					ParkingSlot parkingslot78 = new ParkingSlot("occupied",(Bicycle)bike56);
					ParkingSlot parkingslot79 = new ParkingSlot("occupied",(Bicycle)bike57);
					
					ParkingSlot parkingslot80 =new ParkingSlot("free",null);
					ParkingSlot parkingslot81 =new ParkingSlot("free",null);
					ParkingSlot parkingslot82 =new ParkingSlot("free",null);
					ParkingSlot parkingslot83 = new ParkingSlot("occupied",(Bicycle)bike58);
					ParkingSlot parkingslot84 = new ParkingSlot("occupied",(Bicycle)bike59);
					ParkingSlot parkingslot85 = new ParkingSlot("occupied",(Bicycle)bike60);
					ParkingSlot parkingslot86 = new ParkingSlot("occupied",(Bicycle)bike61);
					ParkingSlot parkingslot87 = new ParkingSlot("occupied",(Bicycle)bike62);
					ParkingSlot parkingslot88 = new ParkingSlot("occupied",(Bicycle)bike63);
					ParkingSlot parkingslot89 = new ParkingSlot("occupied",(Bicycle)bike64);
					
					ParkingSlot parkingslot90 =new ParkingSlot("free",null);
					ParkingSlot parkingslot91 =new ParkingSlot("free",null);
					ParkingSlot parkingslot92 =new ParkingSlot("free",null);
					ParkingSlot parkingslot93 = new ParkingSlot("occupied",(Bicycle)bike66);
					ParkingSlot parkingslot94 = new ParkingSlot("occupied",(Bicycle)bike67);
					ParkingSlot parkingslot95 = new ParkingSlot("occupied",(Bicycle)bike68);
					ParkingSlot parkingslot96 = new ParkingSlot("occupied",(Bicycle)bike69);
					ParkingSlot parkingslot97 = new ParkingSlot("occupied",(Bicycle)bike70);
					ParkingSlot parkingslot98 = new ParkingSlot("occupied",(Bicycle)bike71);
					ParkingSlot parkingslot99 = new ParkingSlot("occupied",(Bicycle)bike72);
					
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
					parkingslots4.add(parkingslot40);
					parkingslots4.add(parkingslot41);
					parkingslots4.add(parkingslot42);
					parkingslots4.add(parkingslot43);
					parkingslots4.add(parkingslot44);
					parkingslots4.add(parkingslot45);
					parkingslots4.add(parkingslot46);
					parkingslots4.add(parkingslot47);
					parkingslots4.add(parkingslot48);
					parkingslots4.add(parkingslot49);
					parkingslots5.add(parkingslot50);
					parkingslots5.add(parkingslot51);
					parkingslots5.add(parkingslot52);
					parkingslots5.add(parkingslot53);
					parkingslots5.add(parkingslot54);
					parkingslots5.add(parkingslot55);
					parkingslots5.add(parkingslot56);
					parkingslots5.add(parkingslot57);
					parkingslots5.add(parkingslot58);
					parkingslots5.add(parkingslot59);
					parkingslots6.add(parkingslot60);
					parkingslots6.add(parkingslot61);
					parkingslots6.add(parkingslot62);
					parkingslots6.add(parkingslot63);
					parkingslots6.add(parkingslot64);
					parkingslots6.add(parkingslot65);
					parkingslots6.add(parkingslot66);
					parkingslots6.add(parkingslot67);
					parkingslots6.add(parkingslot68);
					parkingslots6.add(parkingslot69);
					parkingslots7.add(parkingslot70);
					parkingslots7.add(parkingslot71);
					parkingslots7.add(parkingslot72);
					parkingslots7.add(parkingslot73);
					parkingslots7.add(parkingslot74);
					parkingslots7.add(parkingslot75);
					parkingslots7.add(parkingslot76);
					parkingslots7.add(parkingslot77);
					parkingslots7.add(parkingslot78);
					parkingslots7.add(parkingslot79);
					parkingslots8.add(parkingslot80);
					parkingslots8.add(parkingslot81);
					parkingslots8.add(parkingslot82);
					parkingslots8.add(parkingslot83);
					parkingslots8.add(parkingslot84);
					parkingslots8.add(parkingslot85);
					parkingslots8.add(parkingslot86);
					parkingslots8.add(parkingslot87);
					parkingslots8.add(parkingslot88);
					parkingslots8.add(parkingslot89);
					parkingslots9.add(parkingslot90);
					parkingslots9.add(parkingslot91);
					parkingslots9.add(parkingslot92);
					parkingslots9.add(parkingslot93);
					parkingslots9.add(parkingslot94);
					parkingslots9.add(parkingslot95);
					parkingslots9.add(parkingslot96);
					parkingslots9.add(parkingslot97);
					parkingslots9.add(parkingslot98);
					parkingslots9.add(parkingslot99);
					
					//creating the stations 
					
					Station station0=  new Station(parkingslots0,new GPSCoordinates(48.7184, 2.1671),new Boolean("True"),stations, "standard");
					Station station1=  new Station(parkingslots1,new GPSCoordinates(48.7153, 2.1853),new Boolean("True"),stations, "standard");
					Station station2=  new Station(parkingslots2,new GPSCoordinates(48.7150, 2.1971),new Boolean("True"),stations, "standard");
					Station station3=  new Station(parkingslots3,new GPSCoordinates(48.7063, 2.1648),new Boolean("True"),stations, "standard");
					Station station4=  new Station(parkingslots4,new GPSCoordinates(48.7160, 2.1916),new Boolean("True"),stations, "standard");
					Station station5=  new Station(parkingslots5,new GPSCoordinates(48.7083, 2.1785),new Boolean("True"),stations, "standard");
					Station station6=  new Station(parkingslots6,new GPSCoordinates(48.7169, 2.1974),new Boolean("True"),stations, "standard");
					Station station7=  new Station(parkingslots7,new GPSCoordinates(48.7116, 2.1790),new Boolean("True"),stations, "standard");
					Station station8=  new Station(parkingslots8,new GPSCoordinates(48.7080, 2.1744),new Boolean("True"),stations, "standard");
					Station station9=  new Station(parkingslots9,new GPSCoordinates(48.7124, 2.2008),new Boolean("True"),stations, "standard");
					
					//adding the stations to myvelibnetwork
					
					velibnetwork.addStation(station0);
					velibnetwork.addStation(station1);
					velibnetwork.addStation(station2);
					velibnetwork.addStation(station3);
					velibnetwork.addStation(station4);
					velibnetwork.addStation(station5);
					velibnetwork.addStation(station6);
					velibnetwork.addStation(station7);
					velibnetwork.addStation(station8);
					velibnetwork.addStation(station9);
					
					System.out.println("setup from " + velibnetworkName + "  done");
					return ("setup from " + velibnetworkName + " done");
					
		    	}
		    	
		    	else {
		    		
		    		System.out.println("Another MyVelib already has this name");
		    		return("Another MyVelib already has this name");
		    		
		    	}

			}
			
			else if(command[0].equalsIgnoreCase("setup1")) {
				String name = command[1];
				Integer nstations = Integer.valueOf(command[2]);
				Integer nslots = Integer.valueOf(command[3]);
				Integer sidearea = Integer.valueOf(command[4]);
				Integer nbikes = Integer.valueOf(command[5]);
				
				MyVelibs myVelibs = MyVelibs.getInstance();
		    	if (!myVelibs.exists(name)) {
		    		
		    		Stations stations = Stations.getInstance();
		    		MyVelib velibnetwork = new MyVelib(name);
		    		// one degree in latitude or longitude is more or less equivalent to 111 kilometers
		    		int length =sidearea/111;
		    		for (int i=0; i<nstations;i++) {
		    			
		    			float longitude = ((int) Math.floor(Math.random() *(length*1000+1)))/1000;
		    			float latitude  = ((int) Math.floor(Math.random() *(length*1000+1)))/1000;
						velibnetwork.addStation(new Station(new ArrayList<ParkingSlot>(),new GPSCoordinates(latitude, longitude),new Boolean("True"),stations, "standard"));
		    		}
					//defining the number of full parking slots for each station
					ArrayList<Integer> slots = new ArrayList<Integer>();
					for (int n = 0; n < nstations; n++) {
						
						slots.add(0);
						
					}
					
					for (int j=0;j<nstations;j++) {
						int sum = 0;
						for(int i = 0; i < j; i++)
					    {
					        sum = sum + slots.get(i);
					    }
						
						if (sum<nbikes) {
							
							int reste = nbikes - sum;
							if (reste>=nslots){
								slots.set(j,(int) Math.floor(Math.random() *(nslots+1)));
							
								}
							else {
								slots.set(j,(int) Math.floor(Math.random() *(reste+1)));
								}
							}
						
						else {
							slots.set(j,0);
						}
					}	
					
					//filling each station with the corresponding number of bikes
					for (int j=0;j<nstations;j++) {
						for (int i=0;i<slots.get(j);i++) {
						
							velibnetwork.getStations().get(j).getParkingSlots().add(new ParkingSlot("occupied",(MechanicalBicycle) MechanicalBicycleFactory.getinstance().createBicycle() ));
						}
						for (int i=slots.get(j);i<nslots;i++) {
							
							velibnetwork.getStations().get(j).getParkingSlots().add(new ParkingSlot("free",null));
							

						}
					}
		    			
		    			
		    		
		    		
		    		System.out.println("setup from " + name + " done.");
		    		return("setup from " + name + " done.");
		    	}
		    	
		    	else {
		    		
		    		System.out.println("Another MyVelib already has this name");
		    		return ("Another MyVelib already has this name");
		    		
		    	}
			}
			   
			else if( command[0].equalsIgnoreCase( "addUser" ) ) {
			    	
			    	String userName = command[1];
			    	String cardType = command[2];
			    	String velibnetworkName = command[3];
			    	MyVelib velibnetwork;
			    	
			    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
			    		
			    		System.out.println("This MyVelib System doesn't exist");
			    		return("This MyVelib System doesn't exist");
			    		
			    	}
			    	
			    	else {
			    		
			    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
			    		
			    	}
			    	
			    	if (cardType.equalsIgnoreCase("none")) {
			    		velibnetwork.addUser(new User(userName));
			    		System.out.println("User " + userName + " added to " + velibnetwork);
			    		return ("User " + userName + " added to " + velibnetwork);}
			    	if (cardType.equalsIgnoreCase("VlibreCard")) {
			    		velibnetwork.addUser(new User(userName,VlibreCardFactory.getinstance().createCard() ));
			    		System.out.println("User " + userName + " added to " + velibnetwork);
			    		return ("User " + userName + " added to " + velibnetwork);}
			    	if (cardType.equalsIgnoreCase("VmaxCard")) {
			    		velibnetwork.addUser(new User(userName,VmaxCardFactory.getinstance().createCard() ));
			    		System.out.println("User " + userName + " added to " + velibnetwork);
			    		return ("User " + userName + " added to " + velibnetwork);}
			    	else {
			    		System.out.println("Error in your command's parameters");
			    		return("Error in your command's parameters");}
			    }
			    
			    else if(command[0].equalsIgnoreCase( "offline" )) {
				    	String velibnetworkName = command[1];
				    	String stationID = command[2];
				    	MyVelib velibnetwork;
				    	
				    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
				    		
				    		System.out.println("This MyVelib System doesn't exist");
				    		return("This MyVelib System doesn't exist");
				    		
				    	}
				    	
				    	else {
				    		
				    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
				    		
				    	}
				    	
				    	boolean exists = false;
				    	for(Station station:velibnetwork.getStations()) {
				    		if (stationID.equals(String.valueOf(station.getStationID()))) {
				    			station.setState(false);
				    			exists = true;
				    			System.out.println("Station " + stationID + " has been put offline.");
				    			return("Station " + stationID + " has been put offline.");
				    		}
				    	}
				    	if(exists == false)	{	
				    		System.out.println("the station doesn't exist");
				    		return("the station doesn't exist");
				    		}
				    	
			    }
			    	
			    else if(command[0].equalsIgnoreCase( "online" )) {
				    	String velibnetworkName = command[1];
				    	String stationID = command[2];
				    	
				    	MyVelib velibnetwork;
				    	
				    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
				    		
				    		System.out.println("This MyVelib System doesn't exist");
				    		return("This MyVelib System doesn't exist");
				    		
				    	}
				    	
				    	else {
				    		
				    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
				    		
				    	}
				    	
				    	boolean exists1 = false;
				    	for(Station station:velibnetwork.getStations()) {
				    		if (stationID.equals(String.valueOf(station.getStationID()))) {
				    			station.setState(true);
				    			exists1 = true;
				    			System.out.println("Station " + stationID + " has been put online.");
				    			return("Station " + stationID + " has been put online.");
				    			}
				    		}
				    	if(exists1 == false) {		
				    		System.out.println("the station doesn't exist");
				    		return("the station doesn't exist");
				    	}
			    	}
			    	
			    	else if(command[0].equalsIgnoreCase("rentBike")) {
			    		String userID = command[1];
			    		String stationID = command[2];
			    		//check if the user exists 
			    		boolean existsUser = false;
			    		for (User user:Users.getInstance().getUsersList()) {
			    			if (String.valueOf(user.getUserID()).equals(userID)) { 
			    				existsUser = true;
			    			}
			    		}
		    			if(existsUser == false)	{	
				    		System.out.println("the user doesn't exist");
				    		return("the user doesn't exist");
				  
				    	}
		    			else {
			    				
			    		//check if the station exists
				    		boolean existsStation= false;
		
				    		for(Station station:Stations.getInstance().getStationsList()) {
					    		if (String.valueOf(station.getStationID()).equals(stationID)) {
					    			existsStation = true;
					    			for (User user:Users.getInstance().getUsersList()) {
						    			if (String.valueOf(user.getUserID()).equals(userID)) { 
						    				String r = station.getUserTerminal().rentBicycle(user);
						    				System.out.println(r);
						    				return(r);
						    			}	
					    			}
					    			break;
					    		}
					    		
					    	}
				    		
				    		if(existsStation == false)	{	
				    			System.out.println("the station doesn't exist");
				    			return("the station doesn't exist");
		
				    	}	
		    		}
			    }
			    
			    	else if(command[0].equalsIgnoreCase("returnBike")) {
				    	String userID = command[1];
			    		String stationID = command[2];
			    		String year = command[3];
			    		String month = command[4];
			    		String day = command[5];
			    		String hour = command[6];
			    		String minute = command[7];
			    		
			    		boolean existsstation = false;
			    		boolean existsuser = false;
			    		User u = null;
			    		Station st = null;
				    	for(Station station:Stations.getInstance().getStationsList()) {
				    		if (stationID.equals(String.valueOf(station.getStationID()))) {
				    			
				    			existsstation = true;
				    			st = station;
				    			break;
				    			
				    		}
				    	}
				    		 
				    	if(!existsstation) {		
				    		System.out.println("the station doesn't exist");
				    		return("the station doesn't exist");
				    	}
				    	
				    	else {
				    		
				    		for (User user : Users.getInstance().getUsersList()) {
				    			
				    			if (userID.equals(String.valueOf(user.getUserID()))) {
				    				
				    				existsuser = true;
				    				u = user;
				    				break;
				    				
				    			}
				    			
				    		}
				    		
				    		if (!existsuser) {
				    			
				    			System.out.println("The user doesn't exist");
				    			return("The user doesn't exist");
				    			
				    		} 
				    		
				    		else {
				    			
				    			Bicycle b = null;
					    		boolean hasbicycle = false;
					    		
					    		for (Observer ride : st.getObservers()) {
					    			
					    			if (((Ride) ride).getUser().equals(u) ) {
					    				
					    				b = ((Ride)ride).getBicycle();
					    				hasbicycle = true;
					    				break;
					    			}
					    			
					    		}
					    		
					    		if (!hasbicycle) {
					    			
					    			System.out.println("User " + u.getName() + " doesn't have any bicycle.");
					    			return ("User " + u.getName() + " doesn't have any bicycle.");
					    			
					    		}
					    		
				    			String r = st.getUserTerminal().returnBicycle(b, new MyDate(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day), Integer.valueOf(hour), Integer.valueOf(minute)));
				    			System.out.println(r);
				    			return(r);
				    			
				    		} 
				    		
				    	}
				    		
				    }
	
			    else if (command[0].equalsIgnoreCase("displayStation")) {
			    		String velibnetworkName = command[1];
				    	String stationID = command[2];
				    	
				    	MyVelib velibnetwork;
				    	
				    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
				    		
				    		System.out.println("This MyVelib System doesn't exist");
				    		return("This MyVelib System doesn't exist");
				    		
				    	}
				    	
				    	else {
				    		
				    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
				    		
				    	}
				    	
				    	boolean existsStation = false;
				    	for (Station station:velibnetwork.getStations()) {
				    		if (String.valueOf(station.getStationID()).equals(stationID)) {
				    			System.out.println("Station" + station.getStationID() +"'s number of rents is" + station.getRentsNumber());
				    			System.out.println("Station" + station.getStationID() +"'s number of returns is" + station.getReturnsNumber());
				    			System.out.println("Station" + station.getStationID() +"'s average occupation rate since its creation is " + station.avgOccupationRate());
				    			return("Station" + station.getStationID() +"'s number of rents is" + station.getRentsNumber() + "\n" +
				    					"Station" + station.getStationID() +"'s number of returns is" + station.getReturnsNumber() + "\n" +
				    					"Station" + station.getStationID() +"'s average occupation rate since its creation is " + station.avgOccupationRate());
				    			}
				    		}
				    	
				    	if (!existsStation) {	
				    		System.out.println("the station doesn't exist");
				    		return("the station doesn't exist");
				    		}
			    		
			    	}
			    	else if (command[0].equalsIgnoreCase("displayUser")) {
			    		String velibnetworkName = command[1];
			    		String userID = command[2];
			    		
			    		MyVelib velibnetwork;
				    	
				    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
				    		
				    		System.out.println("This MyVelib System doesn't exist");
				    		return("This MyVelib System doesn't exist");
				    		
				    	}
				    	
				    	else {
				    		
				    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
				    		
				    	}
			    		
			    		boolean existsUser = false;
			    		for (User user:velibnetwork.getUsers()) {
			    			if (String.valueOf(user.getUserID()).equals(userID)) {
				    			if (user.getCard()==null) {
			    					System.out.println("the user " + user.getName() + " has done "+ user.getRidesNumber()+" rides");
				    				System.out.println("the user " + user.getName() + " has been charged "+ user.getTotalCharges() + " euros");
				    				System.out.println("the user " + user.getName() + " has done a total time of "+ user.getTotalTimeOnBicycle() + " minutes on a bicycle");
			    					return("the user " + user.getName() + " has done "+ user.getRidesNumber()+"rides" + "\n" +
			    						   "the user " + user.getName() + " has been charged "+ user.getTotalCharges() + " euros\n" +
			    						   "the user " + user.getName() + " has done a total time of "+ user.getTotalTimeOnBicycle() + " minutes on a bicycle");	
				    				
				    				} else {
				    					
				    					System.out.println("the user " + user.getName() + " has done "+ user.getRidesNumber()+" rides");
					    				System.out.println("the user " + user.getName() + " has been charged "+ user.getTotalCharges() + " euros");
					    				System.out.println("the user " + user.getName() + " has done a total time of "+ user.getTotalTimeOnBicycle() + " minutes on a bicycle");
					    				System.out.println("the user " + user.getName() + " has a time credit of " + user.getCard().getTimeCredit());
					    				System.out.println("the user " + user.getName() + " has a total time credit of " + user.getCard().getTotalTimeCredit());
					    				return("the user " + user.getName() + " has done "+ user.getRidesNumber()+"rides" + "\n" +
					    						   "the user " + user.getName() + " has been charged "+ user.getTotalCharges() + " euros\n" +
					    						   "the user " + user.getName() + " has done a total time of "+ user.getTotalTimeOnBicycle() + " minutes on a bicycle \n" +
					    						   "the user " + user.getName() + " has a time credit of " + user.getCard().getTimeCredit() + "\n" +
					    						   "the user " + user.getName() + " has a total time credit of " + user.getCard().getTotalTimeCredit());
				    				}
				    			
			    			}
			    			
			    		}
			    		
			    		if (!existsUser) {
			    			System.out.println("the user doesn't exist");
			    			return ("the user doesn't exist");
			    			}
			    		
			    	}
			
			    	else if (command[0].equalsIgnoreCase("sortStation")) {
			    		String velibnetworkName = command[1];
			    		String sortPolicy = command[2];
			    		
			    		MyVelib velibnetwork;
				    	
				    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
				    		
				    		System.out.println("This MyVelib System doesn't exist");
				    		return("This MyVelib System doesn't exist");
				    		
				    	}
				    	
				    	else {
				    		
				    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
				    		
				    	}
	
			    		if (sortPolicy.equalsIgnoreCase("mostusedsort")) {
			    			velibnetwork.setSort(new MostUsedSort());
			    			System.out.println(velibnetwork.sortStations());
			    			return(velibnetwork.sortStations().toString());
			    		}
			    		if (sortPolicy.equalsIgnoreCase("leastoccupiedsort")) {
			    			velibnetwork.setSort(new LeastOccupiedSort());
			    			System.out.println(velibnetwork.sortStations());
			    			return(velibnetwork.sortStations().toString());
			    			
			    		}
			    		
			    		else {
			    			System.out.println("Error in your last command's parameters");	
			    			return("Error in your last command's parameters");
			    			}
			    		
			    	}
			    	else if (command[0].equalsIgnoreCase("display")) {
			    		String velibnetworkName = command[1];
			    		
			    		MyVelib velibnetwork;
				    	
				    	if (!MyVelibs.getInstance().exists(velibnetworkName)) {
				    		
				    		System.out.println("This MyVelib System doesn't exist");
				    		return("This MyVelib System doesn't exist");
				    		
				    	}
				    	
				    	else {
				    		
				    		velibnetwork = MyVelibs.getInstance().find(velibnetworkName);
				    		
				    	}
			    		
				    	String r = new String();
			    		System.out.println(velibnetworkName + " contains the following stations");
			    		r = r+velibnetworkName + " contains the following stations \n";
			    		for (Station station:velibnetwork.getStations()) {
			    			System.out.println("the station with the stationID" + station.getStationID() + "contains the following parking slots" + station.getParkingSlots());
			    			r = r + "the station with the stationID" + station.getStationID() + "contains the following parking slots" + station.getParkingSlots() +"\n";
			    		}
			    		System.out.println(velibnetworkName + " contains the following users");
			    		r = r + velibnetworkName + " contains the following users \n";
			    		for (User user:velibnetwork.getUsers()) {
			    			System.out.println("the user " + user.getName() + " with the userID " + user.getUserID() );
			    			r = r + "the user " + user.getName() + " with the userID " + user.getUserID() + "\n";
	
			    		}
			    		
			    		return r;
			    	}
			    	
			    	else if (command[0].equalsIgnoreCase("exit")){
			    		
			    		quit = true;
			    		System.out.println("See you next time!");
			    		return("See you next time");
			    		
			    	}
			    	
			    	else if (command[0].equalsIgnoreCase("runtest")) { 
			    	
			    		String file = command[1];
			    		ArrayList<String[]> commands = new ArrayList<String[]>();
			    		ArrayList<String> answers = new ArrayList<String>();
			    		InputStream fis = new FileInputStream("eval/"+file);
			    		@SuppressWarnings("resource")
						Scanner sc = new Scanner(fis);
			    		String s = sc.nextLine();
			    		String r;
			    		String[] commandline;
			    		while(!s.equals("")){
			    			
			    			commandline = s.split(" ");
			    			commands.add(commandline);
			    			s = sc.nextLine();
			    			
			    			}
			
						for (String[] command1 : commands) {
							
							r = nextcommand(command1);
							answers.add(r);
								
						}
						
						if (!file.equalsIgnoreCase("my_velib.ini")) {	
							char[] fichier = file.toCharArray();
							char num = fichier[12];
							PrintWriter writer = new PrintWriter("eval/" + "testScenario" + num + "output.txt", "UTF-8");
							
							for (String answer : answers) {
								
								writer.println(answer);
								
							}
							
							writer.close();
							}	
						
						System.out.println("Test completed");
						return("Test completed");
			    		
			    		
			    	}
			    	
			    	else {
			    		
			    		System.out.println("Error in the last command's name, try again");
			    		return("Error in the last command's name, try again");
			    		
			    	}
		    	
				}	
				
			    catch( Exception e ) {
				    System.out.println( "Error in your command's parameters" );
				    return( "Error in your command's parameters" );
				}
		return null;
		
		}	
		
	}	
	

