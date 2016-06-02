package controlLayer;

import modelLayer.*;
import dbLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ActivityBookingController {
	
	private LinkedList<ActivityBooking> manyActivities = new LinkedList<ActivityBooking>();
	
	private DbActivityBooking dbActivityBooking = new DbActivityBooking();
	
	private CustomerController cusCtr;

	public ActivityBookingController() {
		
	}

	public void createActivityBooking( int activityID, Facility facility, Staff staff, Date startTime, double activityLength, String Customer){
		//Staff & Agency have to be added also
		
		ActivityBooking activityBooking = new ActivityBooking();
		
		activityBooking.setActivityID(dbActivityBooking.getNewID()+1);
		
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
		
			dbActivityBooking.updateReservationConnection(activityBooking.getReservationID(), customerIDs);
		
			DbConnection.commitTransaction();
			
		}catch(Exception ex){
			System.out.println("Transaction: "+ex.getMessage());

			DbConnection.rollbackTransaction();
		}
		
		//reservation connection table
		
	}
	
	//Get All Reservations
	public LinkedList<ActivityBooking> getAllReservaions(){
		manyActivities = dbActivityBooking.getAllActivities();
			return manyActivities;
	}
	
	//Get ActivityBooking by reservationID
	public ActivityBooking findActivityBooking(int activityID){
			ActivityBooking reservation = dbActivityBooking.findActivities(activityID);
			return reservation;
	}

	// DUNNO HOW TO MAKE THIS v
	public void createActivityBooking(int parseInt, int parseInt2, String text, String text2, double parseDouble,
			double parseDouble2, String text3) {
		// TODO Auto-generated method stub
		
	}

}
