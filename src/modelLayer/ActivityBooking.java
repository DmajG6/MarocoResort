package modelLayer;

import java.sql.Date;


public class ActivityBooking {
	
	private int activityID;
	private Facility facility;
	private String staff;
	private Date startTime;
	private double activityLength;
	private Customer customer;
	
	public ActivityBooking(int activityID, Facility facility, String staff, Date startTime, double activityLength, Customer customer) {
		super();
		this.activityID = activityID;
		this.facility = facility;
		this.staff = staff;
		this.startTime = startTime;
		this.activityLength = activityLength;
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


	public Facility getFacilities() {
		return facility;
	}


	public void setFacility(Facility facilities) {
		this.facility = facilities;
	}


	public String getStaff() {
		return staff;
	}


	public void setStaff(String staff) {
		this.staff = staff;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public double getActivityLength() {
		return activityLength;
	}


	public void setActivityLength(double activityLength) {
		this.activityLength = activityLength;
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
