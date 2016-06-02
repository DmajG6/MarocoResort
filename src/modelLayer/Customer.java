package modelLayer;

public class Customer {
	
	private int customerID;
	private String password;
	private String name;
	private String country;
	private String address;
	private String phoneNumber;
	private String email;
	private String idType;
	private String idNumber;
	private String specialService;
	private int roomID;
	private String active;
	
	public Customer(int ID){
		this.customerID = ID;
	}
	
	public Customer(int customerID, String password, String name, String country, String address, String phoneNumber, String email, String idType, String idNumber, String specialService, int roomID, String active){
		
		this.customerID = customerID;
		this.password = password;
		this.name = name;
		this.country = country;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.idType = idType;
		this.idNumber = idNumber;
		this.specialService = specialService;
		this.roomID = roomID;
		this.active = active;
		
	}
	

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getSpecialService() {
		return specialService;
	}
	public void setSpecialService(String specialService) {
		this.specialService = specialService;
	}
	public int getRoomID() {
		return roomID;
	}
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	

}
