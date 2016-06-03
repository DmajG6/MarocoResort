package modelLayer;

import java.sql.Date;


public class ActivityBooking {
	
	private int activityID;
	private Facility facility;
	private Staff staff;
	private String startTime;
	private Customer customer;
	
	public ActivityBooking(int activityID, Facility facility, Staff staff, String startTime, Customer customer) {
		super();
		this.activityID = activityID;
		this.facility = facility;
		this.staff = staff;
		this.startTime = startTime;
		this.customer = customer;
	}
	
	public ActivityBooking(Facility facility, Staff staff, String startTime, Customer customer) {
		super();
		this.facility = facility;
		this.staff = staff;
		this.startTime = startTime;
		this.customer = customer;
		
	}
	
	public ActivityBooking(){
		
	}


	public int getActivityID() {
		return activityID;
	}


	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}


	public Facility getFacility() {
		return facility;
	}


	public void setFacility(Facility facilities) {
		this.facility = facilities;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	public String getStartTime() {
		return startTime;
	}


	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}



	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
		public void add(ActivityBooking activity) {
		// TODO Auto-generated method stub
		
	}
	

}
