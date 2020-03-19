package ClassAndPrivacyLeaks;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * This is the Junit. Its only purpose is to test the methods in 
 * the classes Bill, Date, Money class. 
 * 
 * 
 * @author Sung Ho Park
 * @version 1.0
 * Class: CSS 143 B
 * Assignment: Classes and Privacy Leaks(Money, Date Bill)
 */

public class DateMoneyBillJUnit {

	@Test
	public void ConstructMoneyTest() {
		Money money1 = new Money(10);
		
		assertEquals(10, money1.getDollars());		
	}
	
	@Test
	public void SetMoneyTest()
	{
		Money money1 = new Money();
		
		money1.setMoney(30,50);
        assertEquals(30, money1.getDollars());      
        assertEquals(50, money1.getCents());
	}
	
	@Test
	public void ConstructMoneyCopyTest() {
		Money money1 = new Money();
		money1.setMoney(10,40);		
		
        Money money2 = new Money(money1);
        
        assertEquals(10, money1.getDollars());       
        assertEquals(40, money2.getCents());
	}
	
	@Test
	public void PrintMoneyTest()
	{
		Money money1 = new Money(10);

        money1.setMoney(30,50);
        assertEquals("$30.50", money1.toString());
		
	}
	@Test
	public void testMoney()
	{
		//Test the constructors and the getMoney method
		Money money1 = new Money(122);
		assertEquals(122, money1.getMoney());
		
		Money money2 = new Money(50, 12);
		assertEquals(50.12, money2.getMoney());
		
		//Tests the add methods and the set methods
		money1.add(2, 900);
		money1.add(400);
		assertEquals(533, money1.getMoney());
		
		money1.add(money2);
		assertEquals(583.12, money1.getMoney());
		assertEquals(583, money1.getDollars());
		assertEquals(12, money1.getCents());
		
		money1.setMoney(200, 90);
		assertEquals(200.90, money1.getMoney());
		
		//Tests the equals
		Money money3 = new Money(money2);
		money2.equals(money3);
		
		assertEquals(true, money2.equals(money3));
		assertEquals(false, money1.equals(money2));
	}
	
	@Test
	public void testDate()
	{
		//Make constructors
		Date date1 = new Date(12, 20, 2017);
		
		//Test the getters
		assertEquals(12, date1.getMonth());
		assertEquals(20, date1.getDay());
		assertEquals(2017, date1.getYear());

		//Test the equals
		Date date2 = new Date(date1);
		assertEquals(true, date1.equals(date2));
		
		//Test the setters
		date2.setMonth(3);
		date2.setDay(24);
		date2.setYear(2020);
		
		//Test the isAfter
		assertEquals(false, date2.isAfter(date1));
		assertEquals(true, date1.isAfter(date2));
		
	}
	
	@Test
	public void testBill()
	{
		//Make the constructors
		Money a1 = new Money(120, 89);
		Date d1 = new Date(4, 15, 2018);
		Bill b1 = new Bill(a1, d1, "Company");
		
		//Test the getters for bill
		assertEquals(a1, b1.getAmount());
		assertEquals(d1, b1.getDueDate());
		assertEquals("Company", b1.getOriginator());
		
		//Tests the equals method
		Bill b2 = new Bill(b1);
		assertEquals(true, b1.equals(b2));
		
		//Test the isPaid Method and setPaid
		Money m2 = new Money(720, 20);
		Money setMoney = new Money(900, 20);
		Date d2 = new Date(4, 20, 2017);
	    Date paidD = new Date(4, 12, 2017);
	    Date setDate = new Date(5, 12, 2017);
		Bill b3 = new Bill(m2, d2, "Some Company");
		
		b3.setPaid(paidD);
		assertEquals(true, b3.isPaid());
		
		//Tests a case where isPaid is not paid
		Bill b4 = new Bill(m2, d2, "Another Company");
	    Date notPaid = new Date(5, 1, 2017);
		b4.setPaid(notPaid);
		assertEquals(false, b4.isPaid());
		
		//Tests the setDueDate Method
		b3.setDueDate(setDate);
		assertEquals(setDate, b3.getDueDate());
	
		//Test the setAmount. Returns false because b3 was already paid
		assertEquals(false, b3.setAmount(setMoney));
		
		//Tests the setAmount. Returns true because b4 was not paid.
		Bill b5 = new Bill(m2, d2, "Another Company");
		Money amount = new Money(1000, 190);
		assertEquals(true, b5.setAmount(amount));
	}

}

