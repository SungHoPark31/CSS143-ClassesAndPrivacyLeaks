package ClassAndPrivacyLeaks;

/**
 * This is the Money class. What this class does is that it tracks the amount
 * of money in USD using integer values for dollars and cents. In this class,
 * it also doesn't return the cents over 99 because that 100 cents is a dollar.
 * Different methods in this class has different functions and will get to more
 * detail once we get to the method
 * 
 * @author Sung Ho Park
 * @version 1.0
 * Class: CSS 143 B
 * Assignment: Classes and Privacy Leaks(Money, Date Bill)
 * 
 */
public class Money
{
	//Instance variables that we'll use in this class only.
	private int dollars;
	private int cents;
	
	/**
	 * This is the empty (no-args) constructor. This will initialize
	 * the instance variables to zero.
	 */
	public Money()
	{
		
	}
	
	/**
	 * Precondition: The values are integers
	 * 
	 * Postcondition: This will result in setting the parameter dol to 
	 * the classes dollar instance variable. Cents will be zero
	 * 
	 * @param dol
	 */
	public Money(int dol)
	{
		//Error check if int dol parameter is less than 0
		if(dol < 0)
		{
			System.out.println("Invalid money");
		}
		else
		{
			//Set the parameter to the instance variable
			this.dollars = dol;
			this.cents = 0;
		}
	}
	
	/**
	 * Precondition: The values are integers.
	 * 
	 * Postcondition: This will result in setting the parameter dol and cent
	 * to the instance variable dollars and cents.
	 * 
	 * @param dol
	 * @param cent
	 */
	public Money(int dol, int cent)
	{
		//Checks if either the parameters are less than zero.
		if(dol < 0 || cent < 0)
		{
			System.out.println("Invalid money");
		}
		
		//If cents is greater than 99, then loop through cents,
		//so that dollar is incremented each time the hundredth digit
		//is there in the cents. 
		if(cent > 99)
		{
			for(int i = cent; i > 99; i -= 100)
			{
				//Increment dollars and decrement cent by 100.
				dol += 1;
				cent -= 100;
			}
		}
		//Set it afterwards.
		this.dollars = dol;
		this.cents = cent;	
	}
	
	/**
	 * 
	 * Precondition: The Money other parameter is not null and the values 
	 * is not negative.
	 * 
	 * Postcondition: This will make a copy constructor that will make a 
	 * copy of the Money other parameter
	 * 
	 * @param other
	 */
	public Money(Money other)
	{
		this.dollars = other.dollars;
		this.cents = other.cents;
	}
	
	/**
	 * Precondition: The values are positive and it exists
	 * 
	 * Postcondition: Returns the int dollars.
	 * 
	 * @return int dollars
	 */
	public int getDollars()
	{
		return dollars;
	}

	/**
	 * Precondition: The values are positive and it exists
	 * 
	 * Postcondition: Returns the int cents.
	 * 
	 * @return int cents
	 */
	public int getCents() 
	{
		return cents;
	}

	/**
	 * Precondition: The values are positive and it exists
	 * 
	 * Postcondition: Does the same thing where if the cents is greater than 99
	 * it increments dollars and decrements cents by 100 each time the 
	 * hundredth digit is there in the cents. This will set the current money
	 * to the money in the parameters. 
	 * 
	 * @param dollars
	 * @param cents
	 */
	public void setMoney(int dollars, int cents) 
	{
		//if dollars or cents less than 0 then print this.
		if(dollars < 0 || cents < 0)
		{
			System.out.println("Invalid money");
		}
		
		//This will increment dollars and decrement cents each time the digit
		//in the hundredth digit.
		if(cents > 99)
		{
			for(int i = cents; i > 99; i -= 100)
			{
				dollars += 1;
				cents -= 100;
			}
		}
		this.dollars = dollars;
		this.cents = cents;
	}
	
	/**
	 * Precondition: The values are positive and it exists
	 * 
	 * Postcondition: This will return the value of both dollars and cents 
	 * together as a double. 
	 * 
	 * @return double total
	 */
	public double getMoney()
	{
		//Cast the int cent to a double to enable double multiplication 
		//instead of int multiplication.
		double cents = (double)this.cents;
		
		//Multiply by decimal for so that it becomes the cents
		double centDoub = cents * 0.01;
		
		//Add this to dollars then it'll produce both dollar and cents 
		//separated by a dot.
		double total = this.dollars + centDoub;
		return total;
	}
	
	/**
	 * Precondition: The parameter passed in is a positive number.
	 * 
	 * Postcondition: it will add the dollars to the current instance
	 * variable.
	 * @param dollars
	 * 
	 */
	public void add(int dollars)
	{
		//add the this class dollars to the parameter dollars if dollars
		//is more than 0.
		if(dollars < 0)
		{
			System.out.println("Dollar is a negative.");
		}
		else
		{
			this.dollars += dollars;
		}
	}
	
	/**
	 * Precondition: The parameters passed in is a positive number.
	 * 
	 * Postcondition: it will add the dollars and cents to the current instance
	 * variables.
	 * 
	 * @param dollars
	 * @param cents
	 */
	public void add(int dollars, int cents)
	{
		//Error check if negative values are passed
		if(dollars < 0 || cents < 0)
		{
			System.out.println("Dollar or cents is a negative.");
		}
		
		//Cents is over 99, then loop through the hundredth digit and 
		//increment dollars and decrement cents by 100
		if(cents > 99)
		{
			for(int i = cents; i > 99; i -= 100)
			{
				dollars += 1;
				cents -= 100;
			}
		}
		//Add the parameter and the current class instance variables 
		//together. 
		this.dollars += dollars;
		this.cents += cents;
	}
	
	/**
	 * Precondition: Class object parameter is not null.
	 * 
	 * Postcondition: it will add the dollars and cents to the current instance
	 * variables.
	 * 
	 * @param other
	 */
	public void add(Money other)
	{
		//Cents is over 99, then loop through the hundredth digit and 
		//increment dollars and decrement cents by 100
		if(cents > 99)
		{
			for(int i = cents; i > 99; i -= 100)
			{
				dollars += 1;
				cents -= 100;
			}
		}
		
		//Add current class instance variable and the other class instance
		//variables
		this.dollars += other.dollars;
		this.cents += other.cents;
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
	public boolean equals(Object o)
	{
		//If o is null then automatically false
		if(o == null)
		{
			return false;
		}
		
		//Type cast the Object class to Money class so that it can be used
		Money other = (Money) o;
		
		//Returns true if the instance variables for both this class and the 
		//other class are the same.
		if(this.dollars == other.dollars 
				&& this.cents == other.cents)
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
	  * In this case, it would print out the currency in USD
	  * 
	  * Ex. $23.43, $12.40, $09.09
	  * 
	  * @return String of the currency in USD
	  */
	public String toString()
	{
		//Returns the String format into dollars and cents.
		return String.format("$%d.%02d", this.dollars, this.cents);
	}
}
