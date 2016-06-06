package controlLayer;

import modelLayer.*;
import dbLayer.*;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

public class ActivityBookingController {
	
	private LinkedList<ActivityBooking> manyActivities = new LinkedList<ActivityBooking>();
	
	private DbActivityBooking dbActivityBooking = new DbActivityBooking();
	
	private CustomerController cusCtr;

	public ActivityBookingController() {
		
	}

	public void createActivityBooking(ActivityBooking activityBooking){
		
		if(!checkNumberOfBookingsForCustomer(activityBooking.getCustomer(), activityBooking.getStartTime())){
			
		}else{

			activityBooking.setActivityID(dbActivityBooking.getNewID()+1);

			//Transaction
			//try{
			//	DbConnection.startTransaction();
			
				dbActivityBooking.insertActivity(activityBooking);
			
				//	DbConnection.commitTransaction();
			
				//}catch(Exception ex){
				//	System.out.println("Transaction: "+ex.toString());

				//	DbConnection.rollbackTransaction();
				//}
		
		}
		
	}
	
	//Get All Activities
	public LinkedList<ActivityBooking> getAllActivities(){
		manyActivities = dbActivityBooking.getAllActivities();
		return manyActivities;
	}
	
	public ActivityBooking findActivityBooking(int activityID){
			ActivityBooking activity = dbActivityBooking.findActivityByID(activityID);
			return activity;
	}

	public LinkedList<Customer> getCustomersInBooking(int facilityID, String startTime) {
		
		cusCtr = new CustomerController();
		
		LinkedList<ActivityBooking> activities = new LinkedList<ActivityBooking>();
		activities = getAllActivities();
		
		LinkedList<Customer> customers = new LinkedList<Customer>();
		
		
		Iterator<ActivityBooking> iter = activities.iterator();

		while (iter.hasNext()) {
		    ActivityBooking act = iter.next();

		    if((act.getFacility().getFacilityID() == facilityID)&&(act.getStartTime().equals(startTime))){
				customers.add(cusCtr.findCustomerByID(act.getCustomer().getCustomerID()));
			}else{
				iter.remove();
				//activities.remove(act);
			}
		}
		
		
		return customers;
	}
	
	public int removeBooking(int activityID, int customerID){
		return dbActivityBooking.deleteActivity(activityID, customerID);
	}
	
	private boolean checkNumberOfBookingsForCustomer(Customer customer, String date){
		
		LinkedList<ActivityBooking> activities = getAllActivities();
		
		int counter = 0;
		
		for(ActivityBooking act: activities){
			if((act.getCustomer().getCustomerID() == customer.getCustomerID())){
				if(act.getStartTime().substring(0, 11).equals(date.substring(0, 11))){
					counter++;
				}
			}
		}
		
		return (counter < 4);
		
	}
		
}