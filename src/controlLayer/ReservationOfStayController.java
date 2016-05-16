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

	public void createReservationOfStay( int durationOfStay, Date arrivalDate, Date departureDate, String paymentInfo, String paymentConfirmation, Date dateOfReservation, double discount, double price, LinkedList<Customer> customers){
		//Staff & Agency have to be added also
		
		ReservationOfStay reservationOfStay = new ReservationOfStay(durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price, customers);
		reservationOfStay.setReservationID(DbReservationOfStay.getNewID());
		
		//Transaction
		
		dbReservationOfStay.insertReservationOfStay(reservationOfStay);
	}
	
	//Get All Reservations
	public LinkedList<ReservationOfStay> getAllReservaions(){
		manyReservations = dbReservationOfStay.getAllReservations();
			return manyReservations;
	}
	
	//Get ReservationOfStay by reservationID
	public ReservationOfStay findReservationOfStay(int ReservationID){
			ReservationOfStay reservation = dbReservationOfStay.findReservationOfStay(ReservationID);
			return reservation;
	}

	public void createReservationOfStay(int parseInt, int parseInt2, String text, String text2, double parseDouble,
			double parseDouble2, String text3) {
		// TODO Auto-generated method stub
		
	}

}
