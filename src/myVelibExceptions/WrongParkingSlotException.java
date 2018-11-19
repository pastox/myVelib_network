package myVelibExceptions;

public class WrongParkingSlotException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String state;
	
	public WrongParkingSlotException(String state) {
		
		this.state = state;
		
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}

