package myVelibUsers;

import java.util.ArrayList;

/**
 * This class' only instance stores all the created users. Whenever one wants to create a new user, one must create it with this Users object as attribute, and this automatically adds this new user to the usersList of this Users object. To make sure this class is only instantiated once, the singleton pattern is used here.
 * @author Pasteau Jebbari
 *
 */
public class Users {
	
	private ArrayList<User> usersList = new ArrayList<User>();
	
	private static Users instance = new Users();
	
	public static Users getInstance(){
			
			return instance;
	}
	
	/**
	 * This method adds a user to the list of created users
	 * @param user
	 */
	public void addUser(User user) {
			
			this.usersList.add(user);
			
	}

	public ArrayList<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<User> usersList) {
		this.usersList = usersList;
	}

	public static void setInstance(Users instance) {
		Users.instance = instance;
	}

	
	

	
}
