package modelLayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReservationOfStay {
	
    private int reservationID;
	private int durationOfStay;
	private Customer customer ;
	private Date arrivalDate;
	private Date departureDate;
	private String paymentInfo;
	private String paymentConfirmation;
	private Date dateOfReservation;
	private double discount;
	private double price;
	private Staff staff;
	private Agency agency;
	private LinkedList<Customer> customers;
	

	public ReservationOfStay(int reservationID, int durationOfStay, Customer customer, Date arrivalDate,
			Date departureDate, String paymentInfo, String paymentConfirmation, Date dateOfReservation, double discount,
			double price, Staff staff, Agency agency) {
		
		this.reservationID = reservationID;
		this.durationOfStay = durationOfStay;
		this.customer = customer;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.paymentInfo = paymentInfo;
		this.paymentConfirmation = paymentConfirmation;
		this.dateOfReservation = dateOfReservation;
		this.discount = discount;
		this.price = price;
		this.staff = staff;
		this.agency = agency;
	
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


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
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


	public Date getDateOfReservation() {
		return dateOfReservation;
	}


	public void setDateOfReservation(Date dateOfReservation) {
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
	
	public void setCustomers(LinkedList<Customer> customerss) {
		this.customers = customers;
	}
	
	public void setListOfItems(LinkedList<Customer> customers) {
		this.customers = customers;
	}
		
	
}