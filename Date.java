package ClassAndPrivacyLeaks;

/**
 * This is the Date class and it represents a date in our world. All days
 * are between 1 to 31, months are between 1 and 12, and the year is between
 * 2016 and 2026. If a date is invalid then the program ends.
 *
 * @author Sung Ho Park
 * @version 1.0
 * Class: CSS 143 B 
 * Assignment: Classes and Privacy Leaks(Money, Date Bill)
 */
public class Date 
{
	//Instance Variables for the class.
	private int month;
	private int day;
	private int year;
	
	/**
	 * This is the empty constructor
	 */
	public Date()
	{
		
	}
	
	/**
	 * Precondition: All the values in the parameter are positive and exists
	 * 
	 * Postcondition: It will set the parameter values to the instance 
	 * variables 
	 * 
	 * @param month
	 * @param day
	 * @param year
	 */
	public Date(int month, int day, int year)
	{
		//If the month meets the criteria of being between 1 and 12,
		//set it otherwise exit the program
		if(month >= 1 && month <= 12)
		{
			this.month = month;
		}
		else
		{
			System.out.print("Month should be in between 1 and 12");
			System.exit(0);
		}

		//If the day meets the criteria of being between 1 and 31,
		//set it otherwise exit the program
		if(day >= 1 && day <= 31)
		{
			this.day = day;
		}
		else
		{
			System.out.print("Day should be in between 1 and 31");
			System.exit(0);
		}
		
		//If the year meets the criteria of being between 2016 and 2026,
		//set it otherwise exit the program
		if(year >= 2016 && day <= 2026)
		{
			this.year = year;
		}
		else
		{
			System.out.print("Year should be in between 2016 and 2026");
			System.exit(0);
		}
		
	}
	
	/**
	 * Precondition: The Date other is not null
	 * 
	 * Postcondition: This will return a copy of the Date other. This is functions 
	 * as a copy constructor.
	 * 
	 * @param other
	 */
	public Date(Date other)
	{
		//Copy the other into this instance variable.
		this.month = other.month;
		this.day = other.day;
		this.year = other.year;
	}

	/**
	 * Precondition: Assume that the month is in between 1 and 12
	 * 
	 * Postcondition: Returns the month 
	 * 
	 * @return int month
	 */
	public int getMonth() 
	{
		return month;
	}

	/**
	 * Precondition: Assume that the month parameter is between 1 and 12
	 * 
	 * Postcondition: This will result in setting the parameter to the 
	 * instance variable of the class. 
	 * 
	 * @param month
	 */
	public void setMonth(int month)
	{
		this.month = month;
	}

	/**
	 * Precondition: Assume that the day is in between 1 and 31
	 * 
	 * Postcondition: Returns the day
	 * 
	 * @return int day
	 */
	public int getDay() 
	{
		return day;
	}

	/**
	 * Precondition: Assume that the day parameter is between 1 and 31
	 * 
	 * Postcondition: This will result in setting the parameter to the 
	 * instance variable of the class. 
	 * 
	 * @param day
	 */
	public void setDay(int day) 
	{
		this.day = day;
	}

	/**
	 * Precondition: Assume that the year is in between 2016 and 2026
	 * 
	 * Postcondition: Returns the year
	 * 
	 * @return int year
	 */
	public int getYear() 
	{
		return year;
	}

	/**
	 * Precondition: Assume that the year parameter is between 2016 and 2026
	 * 
	 * Postcondition: This will result in setting the parameter to the 
	 * instance variable of the class. 
	 * 
	 * @param year
	 */
	public void setYear(int year) 
	{
		this.year = year;
	}
	
	/**
	 * Precondition: The compareTo is not null
	 * 
	 * Postcondition: This will result in true if the compareTo date is after
	 * this date. False otherwise.
	 * 
	 * @param compareTo
	 * @return true or false depending if the compareTo variables of date are 
	 * after this class date.
	 */
	public boolean isAfter(Date compareTo)
	{
		//If the comparedTo date is greater than this date, then return 
		//true. Otherwise false
		if(this.getYear() < compareTo.getYear())
		{
			return true;
		}	
		else if(this.getYear() == compareTo.getYear() &&
				this.getMonth() < compareTo.getMonth()) 
		{
			return true;
		}
		else if(this.getYear() == compareTo.getYear() && 
				this.getMonth() == compareTo.getMonth() && 
				this.getDay() < compareTo.getDay())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	 /**
	  * Precondition: All methods in the class are working, Object date is not 
	  * null.
	  * 
	  * Postcondition: Returns true if the values inside this class and other
	  * class are equal. False otherwise.
	  * 
	  * @return true if all conditions are met
	  */
	public boolean equals(Object date)
	{
		//If the date is null then return false
		if(date == null)
		{
			return false;
		}
		
		//Type cast the Object class to Date class so that it can be used
		Date other = (Date) date;
		
		//If the month, day, year is the same for both this class and the other
		//class, then return true.
		if(this.month == other.month && this.day == other.day 
				&& this.year == other.year)
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	/**
	  * Precondition: Assuming all the methods work in the class.
	  * 
	  * Postcondition: Prints out what ever is needed into a string.
	  * In this case, it will print out the date. 
	  * 
	  * Ex. 01/34/2019, 10/01/2020, etc.
	  * 
	  * @return String of the date in a date form.
	  */
	public String toString()
	{
		//If both the day and month is less than 10, then have an extra
		//zero before both the day and month.
		if(this.month < 10 && this.day < 10)
		{
			return "0" + this.month + "/0" + this.day + "/" + this.year;
		}
		
		//If the month is less than 10, then have an extra zero before month
		if(this.month < 10)
		{
			return "0" + this.month + "/" + this.day + "/" + this.year;
		}
		
		//If the day is less than 10, then have an extra zero before day
		if(this.day < 10)
		{
			return this.month + "/0" + this.day + "/" + this.year;
		}
		
		//Return the date as it is
		return this.month + "/" + this.day + "/" + this.year;
	}
	

}
