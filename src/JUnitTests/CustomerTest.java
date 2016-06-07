package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelLayer.Customer;

public class CustomerTest {

	@Test 
	public void customerTest() {
		Customer customer= new Customer();
		customer.setCustomerID(1);
		customer.setPassword("1337");
		customer.setName("Benc");
		customer.setCountry("Denmark");
		customer.setAddress("Rungsvej");
		customer.setPhoneNumber("11321");
		customer.setEmail("benc@talk.com");
		assertEquals(1, customer.getCustomerID(), 0);
		assertEquals("Benc", customer.getName());
		assertEquals("Rungsvej", customer.getAddress());
		assertEquals("11321", customer.getPhoneNumber());
		assertEquals("benc@talk.com", customer.getEmail());
		assertEquals("Denmark", customer.getCountry());
		assertEquals("1337", customer.getPassword());
	}

	@Test
	public void testGetName() {
		Customer customer1 = new Customer();
		customer1.setName("Benc");
		assertEquals("Benc", customer1.getName());
	}
}