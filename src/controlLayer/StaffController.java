package controlLayer;

import java.util.ArrayList;
import dbLayer.*;
import modelLayer.*;

public class StaffController {

DbStaff dbStaff = new DbStaff();
	
	public ArrayList<Staff> getAllStaffs(){
		return dbStaff.getAllStaffs();
	}
	
	public Staff findStaffByName(String name){
		try {
			return dbStaff.findStaff(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Staff findStaffByID(int staffID){
		try {
			return dbStaff.findStaffByStaffID(staffID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Staff createCustomer(String name, int staffID, String staffType, String password, String email, int workPhoneNumber, int personalPhoneNumber){
		Staff staff = new Staff();
		staff.setName(name);
		staff.setStaffID(0);
		staff.setPassword(password);
		staff.setEmail(email);
		staff.setStaffType(staffType);
		staff.setWorkPhoneNumber(workPhoneNumber);
		staff.setPersonalPhoneNumber(personalPhoneNumber);
	

		try {
			DbConnection.startTransaction();
			dbStaff.insertStaff(staff);
			DbConnection.commitTransaction();
		} catch (Exception e) {
			DbConnection.rollbackTransaction();
			e.printStackTrace();
		}
		return staff;
	}
	
	public int updateStaff(String name, Staff staff){
		return dbStaff.updateStaff(name, staff);		
	}
	
}
