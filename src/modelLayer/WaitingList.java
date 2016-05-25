package modelLayer;

/**
	May 20, 2016 - 1:49:32 PM
*/

public class WaitingList {

	private int waitingListID;
	private int customerID;
	private int facilityID;
	private String time;
	
	public WaitingList() {
		
	}

	public WaitingList(int waitingListID, int customerID, int facilityID, String time) {
		super();
		this.waitingListID = waitingListID;
		this.customerID = customerID;
		this.facilityID = facilityID;
		this.time = time;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getWaitingListID() {
		return waitingListID;
	}

	public void setWaitingListID(int waitingListID) {
		this.waitingListID = waitingListID;
	}

	public int getFacilityID() {
		return facilityID;
	}

	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	
}
