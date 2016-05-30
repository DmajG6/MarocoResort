package modelLayer;

import java.sql.Date;


public class ActivityBooking {
	
	private int activityID;
	private Facility facilities;
	private String staff;
	private Date startTime;
	private double activityLength;
	private String customer;
	
	public ActivityBooking(int activityID, Facility facilities, String staff, Date startTime, double activityLength, String customer) {
		super();
		this.activityID = activityID;
		this.facilities = facilities;
		this.staff = staff;
		this.startTime = startTime;
		this.activityLength = activityLength;
		this customer = customer;
	}


	public int getActivityID() {
		return activityID;
	}


	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}


	public Facility getFacilities() {
		return facilities;
	}


	public void setFacilities(Facility facilities) {
		this.facilities = facilities;
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


	public String getCustomer() {
		return customer;
	}


	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	

}
