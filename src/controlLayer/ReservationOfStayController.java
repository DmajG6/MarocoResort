package controlLayer;

import modelLayer.*;
import dbLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ReservationOfStayController {
	
	private LinkedList<ReservationOfStay> manyReservations = new LinkedList<ReservationOfStay>();
	
	private DbReservationOfStay dbReservationOfStay = new DbReservationOfStay();
	
	private CustomerController cusCtr;

	public ReservationOfStayController() {
		
	}

	public void createReservationOfStay( int durationOfStay, String arrivalDate, String departureDate, String paymentInfo, String paymentConfirmation, String dateOfReservation, double discount, double price, Staff staff, LinkedList<Customer> customers, Agency agency){
		//Staff & Agency have to be added also
		
		ReservationOfStay reservationOfStay = new ReservationOfStay(1 , durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price, staff, agency, customers);
		
		reservationOfStay.setReservationID(DbReservationOfStay.getNewID()+1);
		
		//Transaction
		try{
			DbConnection.startTransaction();
			
			dbReservationOfStay.insertReservationOfStay(reservationOfStay);
		
			cusCtr = new CustomerController();
		
			int[] customerIDs = new int[(reservationOfStay.getCustomers().size())];
			
			for(int i = 0; i<reservationOfStay.getCustomers().size(); i++){
				Customer cus= reservationOfStay.getCustomers().get(i);
				customerIDs[i] = cusCtr.createCustomer(cus.getCustomerID(), cus.getPassword(), cus.getName(), cus.getCountry(), cus.getAddress(), cus.getPhoneNumber(), cus.getEmail(), cus.getIdType(), cus.getIdNumber(), cus.getSpecialService(), cus.getRoomID(), "no").getCustomerID();
			}
		
			dbReservationOfStay.updateReservationConnection(reservationOfStay.getReservationID(), customerIDs);
		
			DbConnection.commitTransaction();
			
		}catch(Exception ex){
			System.out.println("Transaction: "+ex.getMessage());

			DbConnection.rollbackTransaction();
		}
		
		//reservation connection table
		
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
