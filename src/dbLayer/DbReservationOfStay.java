package dbLayer;

import java.sql.*;
import java.util.LinkedList;

import modelLayer.*;

public class DbReservationOfStay {
	
	private static Connection con;
	private DbCustomer dbcp = new DbCustomer();
	
	
	public DbReservationOfStay(){
		con = DbConnection.getInstance().getDBcon();
	}
	
	public LinkedList<ReservationOfStay> getAllReservations(){
		int rc = -1;
		LinkedList<ReservationOfStay> reservations = new LinkedList<>();
		
		String query = "";
		query = "SELECT *" + " FROM ReservationOfStay";
		System.out.println("insert : " + query);
		
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				ReservationOfStay newReservationOfStay = new ReservationOfStay(results.getInt("reservationID"));
				
				newReservationOfStay.setDurationOfStay(results.getInt("durationOfStay"));
				newReservationOfStay.setCustomer(new Customer(results.getInt("customer")));
				newReservationOfStay.setArrivalDate(results.getDate("arrivalDate"));
				newReservationOfStay.setDepartureDate(results.getDate("departureDate"));
				newReservationOfStay.setPaymentInfo(results.getString("paymentInfo"));
				newReservationOfStay.setPaymentConfirmation(results.getString("paymentConfirmation"));
				newReservationOfStay.setDateOfReservation(results.getDate("dateOfReservation"));
				newReservationOfStay.setDiscount(results.getDouble("discount"));
				newReservationOfStay.setPrice(results.getDouble("price"));
				newReservationOfStay.setStaff(new Staff(results.getInt("staffID")));
				newReservationOfStay.setAgency(new Agency(results.getInt("agencyID")));
				
				reservations.add(newReservationOfStay);
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("Building ReservationOfStay Object Failed: "+ex.getMessage());
		}
		
		return reservations;
	}
	
	public ReservationOfStay findReservationOfStay(int reservationID){
				
		ReservationOfStay reservationOfStay = new ReservationOfStay(reservationID);
		
		String query = "";
		query = "SELECT * "+ "FROM ReservationOfStay"
				+ "WHERE reservationID = " + reservationID;
		System.out.println("insert : " + query);
		
		try {
			
			ResultSet results;
			
			Statement stmt = con.createStatement();
			
			stmt.setQueryTimeout(5);						
			
			results = stmt.executeQuery(query);

			if (results.next()) {
				reservationOfStay.setDurationOfStay(results.getInt("durationOfStay"));
				reservationOfStay.setCustomer(new Customer(results.getInt("customerID")));
				reservationOfStay.setArrivalDate(results.getDate("arrivalDate"));
				reservationOfStay.setDepartureDate(results.getDate("departureDate"));
				reservationOfStay.setPaymentInfo(results.getString("paymentInfo"));
				reservationOfStay.setPaymentConfirmation(results.getString("paymentConfirmation"));
				reservationOfStay.setDateOfReservation(results.getDate("dateOfReservation"));
				reservationOfStay.setDiscount(results.getDouble("discount"));
				reservationOfStay.setPrice(results.getDouble("price"));
				reservationOfStay.setStaff(new Staff(results.getInt("staffID")));
				reservationOfStay.setAgency(new Agency(results.getInt("agencyID")));
				
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("Order not found "+ex.getMessage());
			
		}
		
		return reservationOfStay;
		
	}
		
	public int insertReservationOfStay(ReservationOfStay reservationOfStay){
		int rc = -1;
		String query = "";
		query = "INSERT INTO ReservationOfStay (reservationID, customer, durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price) VALUES (" 
		+ reservationOfStay.getReservationID() + ",'"
		+ reservationOfStay.getCustomer().getCustomerID() + "',"
		+ reservationOfStay.getDurationOfStay() + ","
		+ reservationOfStay.getArrivalDate() + ","
		+ reservationOfStay.getDepartureDate() + ",'"
		+ reservationOfStay.getPaymentInfo() + "','"
		+ reservationOfStay.getPaymentConfirmation()+ "',"
		+ reservationOfStay.getDateOfReservation()+ ","
		+ reservationOfStay.getDiscount()+ ","
		+ reservationOfStay.getPrice()+ ")";
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ReservationOfStay not inserted");
		}
		return rc;
		
	}	
	
	public static int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(reservationID) "
				+ "FROM ReservaionOfStay";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("reservationID");
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found"+ex.getMessage());
			
		}
		
		return rc;
		
	}
		
}

