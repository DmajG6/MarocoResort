package controlLayer;

import java.util.LinkedList;
import dbLayer.*;
import modelLayer.*;


public class FacilityController {

	
	DbFacility dbFacility = new DbFacility();
	
	public LinkedList<Facility> getAllFacilities(){
		return dbFacility.getAllFacilities();
	}
	
	public Facility findFacilityByFacilityID(int facilityID){
		try {
			return dbFacility.findFacility(facilityID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
		
	public Facility createFacility(int facilityID, String type, double price, double instructorPrice){
		Facility facility = new Facility();
		facility.setFacilityID(0);
		facility.setType(type);
		facility.setPrice(price);
		facility.setInstructorPrice(instructorPrice);
		
		try {
			DbConnection.startTransaction();
			dbFacility.insertFacility(facility);
			DbConnection.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DbConnection.rollbackTransaction();
			e.printStackTrace();
		}
		return facility;
	}
	
	public int updateFacility(int facilityID, Facility facility){
		return dbFacility.updateFacility(facilityID, facility);		
	}

	public void deleteFacility(int facilityID) {
		//dbFacility.    to be continued...
		
	}
		
}