package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import modelLayer.Staff;

public class StaffTest {

@Test 
public void staffTest() {
Staff staff= new Staff();
staff.setStaffID(1);
staff.setPassword("1337x");
staff.setName("Legolas");
staff.setWorkPhoneNumber("111321");
staff.setPersonalPhoneNumber("121321");
staff.setStaffType("Manager");
staff.setEmail("mayday@drum.dk");
assertEquals(1, staff.getStaffID(), 0);
assertEquals("Legolas", staff.getName());
assertEquals("121321", staff.getPersonalPhoneNumber());
assertEquals("111321", staff.getWorkPhoneNumber());
assertEquals("mayday@drum.dk", staff.getEmail());
assertEquals("Manager", staff.getStaffType());
assertEquals("1337x", staff.getPassword());
}

@Test
public void testGetPass() {
	Staff staff1 = new Staff();
	staff1.setPassword("1337x");
	assertEquals("1337x", staff1.getPassword());
}
}