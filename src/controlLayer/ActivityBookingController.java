package controlLayer;

import modelLayer.*;
import dbLayer.*;

import java.sql.*;
import java.util.LinkedList;

public class ActivityBookingController {
	
	private LinkedList<ActivityBooking> manyActivities = new LinkedList<ActivityBooking>();
	
	private DbActivityBooking dbActivityBooking = new DbActivityBooking();
	
	private CustomerController cusCtr;

	public ActivityBookingController() {
		
	}

	public void createActivityBooking(Facility facility, Staff staff, Date startTime, double activityLength, String customers){
		
		ActivityBooking activityBooking = new ActivityBooking(facility, staff, startTime, activityLength, customers);
		
<<<<<<< HEAD
		activityBooking.setActivityID(dbActivityBooking.getNewID()+1);
=======
		activityBooking.setActivityID(DbActivityBooking.getNewID()+1);
>>>>>>> branch 'master' of https://github.com/DmajG6/MarocoResort.git
		
		//Transaction
		try{
			DbConnection.startTransaction();
			
			dbActivityBooking.insertActivity(activityBooking);
		
			cusCtr = new CustomerController();
		
			int[] customerIDs = new int[(activityBooking.getFacilities().size())];
			// This needs to call for an activity instead of creating it v
			for(int i = 0; i<activityBooking.getFacilities().size(); i++){
				Customer cus= activityBooking.getFacilities().get(i);
				customerIDs[i] = cusCtr.createCustomer(cus.getCustomerID(), cus.getPassword(), cus.getName(), cus.getCountry(), cus.getAddress(), cus.getPhoneNumber(), cus.getEmail(), cus.getIdType(), cus.getIdNumber(), cus.getSpecialService(), cus.getRoomID(), "no").getCustomerID();
			}
		
			dbActivityBooking.updateActivity(activityBooking.getActivityID(), customerIDs);
		
			DbConnection.commitTransaction();
			
		}catch(Exception ex){
			System.out.println("Transaction: "+ex.getMessage());

			DbConnection.rollbackTransaction();
		}
		

		
	}
	
	//Get All Reservations
	public LinkedList<ActivityBooking> getAllActivities(){
		manyActivities = dbActivityBooking.getAllActivities();
			return manyActivities;
	}
	
	public ActivityBooking findActivityBooking(int activityID){
			ActivityBooking activity = dbActivityBooking.findActivities(activityID);
			return activity;
	}

public ActivityBooking getCustomersInBooking(int facilityID, String startTime) {
	return null; //new method incoming here
}
		// TODO Auto-generated method stub
		
	}
