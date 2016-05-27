package modelLayer;

import java.util.LinkedList;

/**
	May 20, 2016 - 1:49:32 PM
*/

public class WaitingList {

	private int waitingListID;
	private LinkedList<Integer> customerIDs;
	private int facilityID;
	private String time;
	
	public WaitingList() {
		
	}

	public WaitingList(int waitingListID, LinkedList<Integer> customerIDs, int facilityID, String time) {
		super();
		this.waitingListID = waitingListID;
		this.customerIDs = customerIDs;
		this.facilityID = facilityID;
		this.time = time;
	}

	public LinkedList<Integer> getCustomerIDs() {
		return customerIDs;
	}

	public void setCustomerIDs(LinkedList<Integer> customerID) {
		this.customerIDs = customerID;
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
