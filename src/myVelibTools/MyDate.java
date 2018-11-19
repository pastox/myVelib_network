package myVelibTools;

import java.util.Date;

/**
 * This class represents a date. In a myVelib System, we don't care about seconds because we don't wanna be that precise, so we compute all the times and durations in minuts 
 * @author aurep
 *
 */
public class MyDate extends Date{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor builds an object of type MyDate() that is initialized to the Date of the instant when it's created
	 */
	public MyDate() {
		
		super();
		
	}
	
	/**
	 * This constructor builds an object of type MyDate given year, month, day, hours and minutes. We're not interested in going into more precision
	 * @param year
	 * @param month
	 * @param date
	 * @param hrs
	 * @param min
	 */
	@SuppressWarnings("deprecation")
	public MyDate(int year, int month, int day, int hrs, int min) {
		
		super(year-1900, month, day, hrs, min);
		
	}

	/**
	 * This method returns the number of minutes between startDate and the MyDate object from which it is called.
	 * @param startDate
	 * @return
	 */
	public double timeUntilThis(MyDate startDate) {
		
		return (((double)this.getTime() - (double)startDate.getTime())/(60*1000));
		
	}

}
