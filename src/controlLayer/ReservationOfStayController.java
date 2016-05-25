package controlLayer;

import modelLayer.*;
import dbLayer.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReservationOfStayController {
	
	private LinkedList<ReservationOfStay> manyReservations = new LinkedList<ReservationOfStay>();
	
	private DbReservationOfStay dbReservationOfStay = new DbReservationOfStay();
	

	public ReservationOfStayController() {
		
	}

	public void createReservationOfStay( int durationOfStay, String arrivalDate, String departureDate, String paymentInfo, String paymentConfirmation, String dateOfReservation, double discount, double price, Staff staff, LinkedList<Customer> customers, Agency agency){
		//Staff & Agency have to be added also
		
		ReservationOfStay reservationOfStay = new ReservationOfStay(1 , durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price, staff, agency, customers);
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
