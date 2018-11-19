package clui;

import java.util.ArrayList;

/**
 * This class' unique instance (singleton pattern) stores all the created MyVelibs systems
 * @author Pasteau Jebbari
 *
 */
public class MyVelibs {
	
	private ArrayList<MyVelib> myVelibs = new ArrayList<MyVelib>();
	
	private static MyVelibs instance = new MyVelibs();
	
	public static MyVelibs getInstance() {
		
		return instance;
		
	}
	
	/**
	 * This method returns true if a MyVelib System with the name name exists, false otherwise
	 * @param name
	 * @return
	 */
	public boolean exists(String name) {
		
		for (MyVelib v : this.myVelibs) {
			
			if (v.getName().equalsIgnoreCase(name)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/**
	 * This method adds v to the MyVelib systems' list
	 * @param v
	 */
	public void add(MyVelib v) {
		
		this.myVelibs.add(v);
		
	}
	
	/**
	 * This method returns the MyVelib System with the name name. There is no need for an exception here because every time this method is used, it has been checked that the result of exists(name) is true
	 * @param name
	 * @return
	 */
	public MyVelib find(String name) {
		
		for (MyVelib v : this.myVelibs) {
			
			if (v.getName().equalsIgnoreCase(name)) {
				
				return v;
				
			}
			
		}
		
		return null;
		
	}

}
