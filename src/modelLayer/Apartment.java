package modelLayer;

public class Apartment {

	private int roomID;
	private String type;
	private double price;
	private int floor;
	private Customer customer;
	private String specialNeeds;
	
	
	public Apartment(int roomID, String type, double price, int floor, Customer customer, String specialNeeds) {
		
		this.roomID = roomID;
		this.type = type;
		this.price = price;
		this.floor = floor;
		this.customer = customer;
		this.specialNeeds = specialNeeds;
	}


	public int getRoomID() {
		return roomID;
	}


	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getFloor() {
		return floor;
	}


	public void setFloor(int floor) {
		this.floor = floor;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String getSpecialNeeds() {
		return specialNeeds;
	}


	public void setSpecialNeeds(String specialNeeds) {
		this.specialNeeds = specialNeeds;
	}

}
