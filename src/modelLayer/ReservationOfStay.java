package modelLayer;

import java.util.LinkedList;

public class ReservationOfStay {
	
    private int reservationID;
	private int durationOfStay;
	private String arrivalDate;
	private String departureDate;
	private String paymentInfo;
	private String paymentConfirmation;
	private String dateOfReservation;
	private double discount;
	private double price;
	private Staff staff;
	private Agency agency;
	private LinkedList<Customer> customers;

	public ReservationOfStay(int reservationID, int durationOfStay, String arrivalDate,
			String departureDate, String paymentInfo, String paymentConfirmation, String dateOfReservation, double discount,
			double price, Staff staff, Agency agency, LinkedList<Customer> customers) {
		
		this.reservationID = reservationID;
		this.durationOfStay = durationOfStay;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.paymentInfo = paymentInfo;
		this.paymentConfirmation = paymentConfirmation;
		this.dateOfReservation = dateOfReservation;
		this.discount = discount;
		this.price = price;
		this.staff = staff;
		this.agency = agency;
		this.customers = customers;
	
	}
	



	public ReservationOfStay(int int1) {
		// TODO Auto-generated constructor stub
	}

	public int getReservationID() {
		return reservationID;
	}


	public void setReservationID(int reservationID) {
		this.reservationID = reservationID;
	}


	public int getDurationOfStay() {
		return durationOfStay;
	}


	public void setDurationOfStay(int durationOfStay) {
		this.durationOfStay = durationOfStay;
	}



	public String getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}


	public String getPaymentInfo() {
		return paymentInfo;
	}


	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}


	public String getPaymentConfirmation() {
		return paymentConfirmation;
	}


	public void setPaymentConfirmation(String paymentConfirmation) {
		this.paymentConfirmation = paymentConfirmation;
	}


	public String getDateOfReservation() {
		return dateOfReservation;
	}


	public void setDateOfReservation(String dateOfReservation) {
		this.dateOfReservation = dateOfReservation;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Staff getStaff() {
		return staff;
	}


	public void setStaff(Staff staff) {
		this.staff = staff;
	}


	public Agency getAgency() {
		return agency;
	}


	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	
	public LinkedList<Customer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(LinkedList<Customer> customers) {
		this.customers = customers;
	}


	public void setCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}


	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}
	
		
}