package modelLayer;

public class Facility {
	
	private int facilityID;
	private String type;
	private double price;
	private double instructorPrice;
	
	
	public Facility(int facilityID, String type, double price, double instructorPrice) {
		super();
		this.facilityID = facilityID;
		this.type = type;
		this.price = price;
		this.instructorPrice = instructorPrice;
	}
         public Facility() {
		// TODO Auto-generated constructor stub
	}
         
         public Facility(int facilityID) {
     		this.facilityID = facilityID;
     	}
	
	public int getFacilityID() {
		return facilityID;
	}


	public void setFacilityID(int facilityID) {
		this.facilityID = facilityID;
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


	public double getInstructorPrice() {
		return instructorPrice;
	}


	public void setInstructorPrice(double instructorPrice) {
		this.instructorPrice = instructorPrice;
	}
	
	
	
	
	

}
