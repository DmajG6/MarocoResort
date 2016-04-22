package modelLayer;

public class Staff {
	
	private String name;
	private int staffID;
	private String staffType;
	private String password;
	private String email;
	private int workPhoneNumber;
	private int personalPhoneNumber;
	
	public Staff (String name, int staffID, String staffType, String password, String email, int workPhoneNumber, int personalPhoneNumber){
		
		this.name = name;
		this.staffID = staffID;
		this.staffType = staffType;
		this.password = password;
		this.email = email;
		this.workPhoneNumber = workPhoneNumber;
		this.personalPhoneNumber = personalPhoneNumber;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(int workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public int getPersonalPhoneNumber() {
		return personalPhoneNumber;
	}

	public void setPersonalPhoneNumber(int personalPhoneNumber) {
		this.personalPhoneNumber = personalPhoneNumber;
	}

}
