package modelLayer;

public class Agency {
	
	private int agencyID;
	private String name;
	private String address;
	private int cvrNumber;
	private String country;
	private String email;
	private String phoneNumber;
	private String extraInfo;
	private double discount;

	
	public Agency(int agencyID, String name, String address, int cvrNumber, String country, String email, String phoneNumber, String extraInfo, double discount){
		
		this.agencyID = agencyID;
		this.name = name;
		this.address = address;
		this.cvrNumber = cvrNumber;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.extraInfo = extraInfo;
		this.discount = discount;
	}

        public Agency() {
		// TODO Auto-generated constructor stub
	}


	public Agency(int agencyID) {
			this.agencyID = agencyID;
		}

	public int getAgencyID() {
		return agencyID;
	}


	public void setAgencyID(int agencyID) {
		this.agencyID = agencyID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getCvrNumber() {
		return cvrNumber;
	}


	public void setCvrNumber(int cvrNumber) {
		this.cvrNumber = cvrNumber;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getExtraInfo() {
		return extraInfo;
	}


	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	
  
}
