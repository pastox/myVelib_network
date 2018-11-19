package myVelibExceptions;

import myVelibTools.MyDate;

public class WrongTimePeriodException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyDate startDate;
	
	public WrongTimePeriodException(MyDate startDate) {
		
		this.startDate = startDate;
		
	}

	public MyDate getStartDate() {
		return startDate;
	}

	public void setStartDate(MyDate startDate) {
		this.startDate = startDate;
	}
	

}
