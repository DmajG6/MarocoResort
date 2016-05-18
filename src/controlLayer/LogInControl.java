package controlLayer;

/**
	May 18, 2016 - 12:50:30 PM
*/

import controlLayer.StaffController;
import controlLayer.CustomerController;

public class LogInControl {

	CustomerController custcontr = new CustomerController();
	StaffController staffctr = new StaffController();
	
	
	public LogInControl() {
		
	}
	
	public byte checkLogIn(String iD, String password){
		byte user = -1;
		
		if(custcontr.customerLogIn(iD, password)){
			user = 2;
		}else if(staffctr.logInStaff(iD, password)){
			user = 1;
		}
		return user;
	}

}
