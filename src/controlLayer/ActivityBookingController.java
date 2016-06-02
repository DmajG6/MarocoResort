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

	public void createActivityBooking(ActivityBooking activityBooking){
		
		

		activityBooking.setActivityID(dbActivityBooking.getNewID()+1);

		//Transaction
		try{
			DbConnection.startTransaction();
			
			dbActivityBooking.insertActivity(activityBooking);
			
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

	public LinkedList<Customer> getCustomersInBooking(int facilityID, String startTime) {
		
		return null; //new method incoming here
		
		
		
	}
		// TODO Auto-generated method stub
		
	}
