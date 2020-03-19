package ClassAndPrivacyLeaks;

/**
 * This is the Bill Class. This class should contain the amount of the bill
 * as a Money object, the due date of the bill as a Date object, and a Date 
 * object to track the date paid.
 * 
 * @author Sung Ho Park
 * @version 1.0
 * Class: CSS 143 B
 * Assignment: Classes and Privacy Leaks(Money, Date Bill)
 *
 */
public class Bill 
{
	//Private instance variables that will be used in this class
	private Money amount;
	private Date dueDate;
	private Date paidDate;
	private String originator;
	
	/**
	 * Empty constructor
	 */
	public Bill()
	{
		
	}
	
	/**
	 * This is the copy constructor that will copy information of the parameter
	 * to the information in this class. 
	 * @param toCopy
	 */
	public Bill(Bill toCopy)
	{
		//Set the copy instance variables to the instance variables in the 
		//class
		this.amount = toCopy.amount;
		this.dueDate = toCopy.dueDate;
		this.paidDate = toCopy.paidDate;
		this.originator = toCopy.originator;
	}
	
	/**
	 * This is another copy constructor that will copy each of the different 
	 * classes in the main class. 
	 * 
	 * @param amount
	 * @param dueDate
	 * @param originator
	 */
	public Bill(Money amount, Date dueDate, String originator)
	{
		//If each of the instance in the class is null then exit
		if(amount == null || dueDate == null)
		{
			System.out.println("The objects passed in is null");
			System.exit(0);
		}
		
		//Copy the contents of the class parameters to this class 
		this.amount = new Money(amount);
		this.dueDate = new Date(dueDate);
		this.originator = originator;
		this.paidDate = null;
	}
	
	/**
	 * Precondition: The Money class is not null and a value that is 
	 * nonnegative is in amount
	 * 
	 * Postcondition: Returns the amount.
	 * 
	 * @return Money amount.
	 */
	public Money getAmount()
	{
		return this.amount;
	}
	
	/**
	 * Precondition: The Date class is not null and a value that is 
	 * nonnegative is in dueDate.
	 * 
	 * Postcondition: Returns the dueDate.
	 * 
	 * @return Date dueDate
	 */
	public Date getDueDate()
	{
		return this.dueDate;
	}
	
	/**
	 * Precondition: The String is not null.
	 * 
	 * Postcondition: Returns the string.
	 * 
	 * @return String originator
	 */
	public String getOriginator()
	{
		return this.originator;
	}
	
	/**
	 * Precondition: There is a value in paidDate.
	 * 
	 * Postcondition: Returns true is paidDate is paid. So if not null then
	 * return true. If it is null (meaning not paid), then return false.
	 * 
	 * @return true if paidDate is not null
	 */
	public boolean isPaid()
	{
		//If paidDate is not null then return true (Meaning if its paid), then
		//Return true, otherwise false.
		if(this.paidDate != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Precondition: The datePaid is not null and has values.
	 * 
	 * Postcondition: If datePaid is after the dueDate, the call does not
	 * update anything and returns false.  Else updates the paidDate and
	 * returns true
	 * 
	 * Example; date1 = 2/13/2019
	 * 			date2 = 3/10/2020
	 * 
	 * Sentence wise, it is better to say date2 is after date 1 to be true.
	 * 
	 * @param datePaid
	 * @return true or false 
	 */
	public boolean setPaid(Date datePaid)
	{
		//if date paid variables are after the due date variables, return 
		//false, else returns true and update the paidDate.
		
		if(this.dueDate.isAfter(datePaid))
		{
			return false;
		}
		else
		{
			this.paidDate = datePaid;
			return true;
		}
	}

	/**
	 * Precondition: nextDate is not null and has values.
	 * 
	 * Postcondition: Resets the due date. If the bill is already paid, this
	 * call fails and returns false.  Else it resets the due date and returns 
	 * true.
	 * 
	 * @param nextDate
	 * @return true or false
	 */
	public boolean setDueDate(Date nextDate)
	{
		//If paidDate is null, then you can't set the dueDate. If the paidDate
		//is not null, then set the nextDate to the dueDate and return true.
		if(this.paidDate == null)
		{
			return false;
		}
		else 
		{
			this.dueDate = nextDate;
			return true;
		}
	}
	
	/**
	 * Precondition: amount is not null and has values.
	 * 
	 * Postcondition: Change the amount owed. If already paid, returns false
	 * and does not change the amount owed  else changes the amount and 
	 * returns true. 
	 * 
	 * @param amount
	 * @return
	 */
	public boolean setAmount(Money amount)
	{
		//Set the amount to amount if paidDate is null. Otherwise return false.
		if(this.paidDate != null)
		{
			return false;
		}
		else
		{
			this.amount = amount;
		}
		return true;
	}

	/**
	 * Precondition: originator is not null and carries a String value
	 * 
	 * Postcondition: Sets the parameter String value to this classes 
	 * String value.
	 * 
	 * @param originator
	 */
	public void setOriginator(String originator) 
	{
		this.originator = originator;
	}
	
	@Override
	 /**
	  * Precondition: All methods in the class are working, Object o is not 
	  * null.
	  * 
	  * Postcondition: Returns true if the values inside this class and other
	  * class are equal. False otherwise.
	  * 
	  * @return true if all conditions are met
	  */
	public boolean equals(Object toCompare)
	{
		//If toCompare is null then automatically false
		if(toCompare == null)
		{
			return false;
		}
		
		//Type cast the Object class to Money class so that it can be used
		Bill other = (Bill) toCompare;
		
		//Returns true if the instance variables for both this class and the 
		//other class are the same.
		if(this.amount == other.amount && 
				this.dueDate == other.dueDate &&
				this.paidDate == other.paidDate && 
				this.originator == other.originator)
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
	  * Precondition: Assuming all the methods work in the class.
	  * 
	  * Postcondition: Prints out what ever is needed into a string.
	  * In this case, it would print out the bill, when it is due,
	  * to who, if it is paid and if paid on the date.
	  * 
	  * @return String 
	  */
	public String toString()
	{
		if(this.paidDate == null)
		{
			return "The Bill is " + this.amount + ". It is due: " + 
					this.dueDate + ".\nIt is from " + this.originator + 
					". Is it paid? " + this.isPaid();
		}
		return "The Bill is " + this.amount + ". It is due: " + 
			this.dueDate + ".\nIt is from " + this.originator + 
			". Is it paid? " + this.isPaid() + ". It is paid at: " 
			+ this.paidDate;
	}
}
