package controlLayer;

import modelLayer.*;
import dbLayer.*;

import java.sql.Date;
import java.util.LinkedList;

public class ReservationOfStayController {
	
	private LinkedList<ReservationOfStay> manyReservations = new LinkedList<ReservationOfStay>();
	
	private DbReservationOfStay dbReservationOfStay = new DbReservationOfStay();
	
	private DbCustomer dbCustomer = new DbCustomer();
	
		
	public ReservationOfStayController() {
		
	}

	public void createReservationOfStay(Customer customer, int durationOfStay, Date arrivalDate, Date departureDate, String paymentInfo, String paymentConfirmation, Date dateOfReservation, double discount, double price, LinkedList<Customer> customers){
		//Staff & Agency have to be added also
		
		ReservationOfStay reservaionOfStay = new ReservationOfStay(customer, durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price, customers);
		reservaionOfStay.setReservationID(DbReservationOfStay.getNewID());
		
		//Transaction
		
		dbReservationOfStay.insertReservationOfStay(reservaionOfStay);
		insertCustomer(reservaionOfStay.getReservationID(), reservaionOfStay.getListOfItems());
	}
	
	//Get All Reservations
	public LinkedList<ReservationOfStay> getAllReservaions(){
		manyReservations = dbReservationOfStay.getAll();
			return manyReservations;
	}
	
	//Get ReservationOfStay by reervationID
	public ReservationOfStay findReservationOfStay(int ReservationID){
			ReservationOfStay reservation = dbReservationOfStay.findReservationOfStay(ReservationID);
			return reservation;
	}
	
	//Insert Customer into a ReservationOfStay
	private void insertCustomer(int reservationID, LinkedList<Customer> customers){
		dbCustomer.insertCustomer(customers, reservationID);
	}
}
