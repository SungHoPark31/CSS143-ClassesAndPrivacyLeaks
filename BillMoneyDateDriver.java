package ClassAndPrivacyLeaks;
/**
 * This class is the driver class. The point of the driver class is to test 
 * the methods of each class. 
 * 
 * @author Sung Ho Park
 * @version 1.0
 * Class: CSS 143 B
 * Assignment: Classes and Privacy Leaks(Money, Date Bill)
*/
public class BillMoneyDateDriver
{

   /**
    * This is the main method and it will do most of the calling.
    * @param args
    */
   public static void main(String[] args)
   {
       //Construct money objects.
       Money money1 = new Money(10);
       Money money2 = new Money(money1);
       
       //sets money1
       money1.setMoney(30,50);
       
       //Create and set money3 and then create money4 and 5.
       Money money3 = new Money();
       money3.setMoney(20, 525);
       
       Money money4 = new Money();
       Money money5 = new Money(2, 203);
       
       System.out.println("Money objects output:");
       
       //This just outputs money1
       System.out.println("Here is money 1: " + money1);
       
       //Test the getters
       System.out.println("Here are the dollars: " + money1.getDollars());
       System.out.println("Here are the cents: " + money1.getCents());
       
       //Returns a copy of money1 which was made in money2.
       System.out.println("Here is the copy of money 1 before money 1 was "
    		   						+ "changed: " + money2);
       
       //Initially money3 was set. Now it is testing the add to make sure
       //that it is adding whatever the parameter is. 
       System.out.println("Here is money 3: " + money3);
       money3.add(5);
       System.out.println("Here is money 3 using the dollar add method: " 
    		   													+ money3);
       money3.add(20, 169);
       System.out.println("Here is money 3 using the dollar and cent add "
       											+ "method: " + money3);
  
       //This adds another object.
       money3.add(money2);
       System.out.println("Here is money 3 and money 2 added together: " 
    		   													+ money3);
       
       //Test the getMoney method.
       System.out.println("This is the getMoney method for money 3: "
    		   											+ money3.getMoney());
       
       //Test the empty constructor
       System.out.println("Here is the call to an empty constructor: " 
    		   												+ money4);
       //This tests in case the cents go over 99.
       System.out.println("Here is money 5: " + money5);
       

       //Prints out errors
       Money money7 = new Money(-6, -12);
       
       //Sets money 7 to the correct money.
       money7.setMoney(6, 12);
       System.out.println("Here is the correct money 7: " + money7);
       
       //Create new objects and compare them to test the equals method.
       Money money8 = new Money(5, 5);
       Money money9 = new Money(5, 5);
       Money money10 = new Money(5, 6);
       System.out.println("Comparing money 8 and money 9, they are: " 
    		   										+ money8.equals(money9));
       System.out.println("Comparing money 8 and money 10, they are: "
    		   										+ money8.equals(money10));
	   
       
	   //Output is an error because the year should be in between 2016 and 2026
	   //Date date = new Date(1, 26, 2015);
	   
	   //Output is an error because the month should be in between 1 and 12
	   //Date date = new Date(0, 2, 2016);
	   
	   //Output is an error because the day should be in between 1 and 31
	   //Date date = new Date(1, 0, 2017);
	   
	   //Wasn't needed but here just in case.
	   //Date date = new Date(-1, -1, -2016);
	   
       //Date is created
	   Date date1 = new Date(2, 6, 2019);
	   System.out.println("\nDate objects output:");
	   System.out.println("The Date for date1 is: " + date1);
	   
	   //Tests the getters
	   System.out.println(date1.getMonth() + " " +  date1.getDay() + " " 
			   		+ date1.getYear());
	   
	   //Create another object and test the setter methods
	   Date date2 = new Date(date1);
	   System.out.println("Date 2 is a copy of Date 1: " + date2);
	   date2.setMonth(3);
	   date2.setDay(21);
	   date2.setYear(2020);
	   System.out.println("Date 2 is now: " + date2);
	   
	   //This tests the isAfter method. If a date is after another, it should 
	   //return true. False otherwise.
	   System.out.println("Is date 2 after date 1? " + date1.isAfter(date2));
	   System.out.println("Is date 1 after date 2? " + date2.isAfter(date1));
	   
	   //Create new objects and test out the equals method.
	   Date date3 = new Date(11, 12, 2022);
	   Date date4 = new Date(11, 12, 2022);
	   Date date5 = new Date(11, 13, 2022);

	   System.out.println("Is date 3 the same as date 4? " + 
			   										date3.equals(date4));
	   System.out.println("Is date 4 the same as date 5? " + 
					date4.equals(date5));
	   
	   Date date6 = new Date(12, 12, 2019);
	   Date date7 = new Date(11, 12, 2020); 
	   Date date8 = new Date(10, 11, 2018);
	   
	   //The method says Return true if the compareTodate is after the date. 
	   System.out.println("Date 7 after date 6: " + date6.isAfter(date7));
	   System.out.println("Date 8 after date 7: " + date7.isAfter(date8));
 
	   //Construct bills
       Money amount = new Money(20);
       Date dueDate = new Date(4, 30, 2017);
       Date paidDate = new Date(3, 15, 2016);
       Bill bill1 = new Bill(amount, dueDate, "The phone company");
      
       //Copy the information in bill1 to bill2
       Bill bill2 = new Bill(bill1);
       //This time, set the dueDate to a new date
       bill2.setDueDate(new Date(5, 30, 2017));
       
       //Set the amount money declared in the top to this money and set
       //the day to a different day.
       amount.setMoney(31, 99);
       dueDate.setDay(29);
       
       Money amount1 = new Money(80, 120);
       Bill bill3 = new Bill(amount, dueDate, "The record company");
       
       //Set the bill3 paid date so that the bill is paid on this day.
       bill3.setPaid(paidDate);
       
       //Tests toString method to print out the bill, the due date, 
       //the company, if it is paid, and the date of pay if paid.
       System.out.println("\nBill objects output:");
       System.out.println(bill1 + "\n");
       System.out.println(bill2+ "\n");
       System.out.println(bill3);
       
       //tests the setAmount method
       System.out.println("Can the Bill3 be changed? " +
    		   						bill3.setAmount(amount1) + "\n");
       
       //Test the getters
       System.out.println("Bill 3 has: " + bill3.getAmount() + ", " 
    		   				+ bill3.getDueDate() + ", " + bill3.getOriginator()
    		   				+ " inside the object class\n");
       
       //Tests the equals method in the Bill class.
       System.out.println("Is bill1 the same as bill2? " 
    		   				+ bill1.equals(bill2));
       System.out.println("Is bill2 the same as bill3? "
    		   				+ bill2.equals(bill3));
   }
}