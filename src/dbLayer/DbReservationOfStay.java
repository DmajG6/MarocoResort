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
		query = "SELECT *" + " FROM ReservationOfStay r, ReservationConnectionTable c WHERE r.reservationID = c.reservationID";
		System.out.println("insert : " + query);
		
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				ReservationOfStay newReservationOfStay = new ReservationOfStay(results.getInt("reservationID"));
				
				newReservationOfStay.setDurationOfStay(results.getInt("durationOfStay"));
				newReservationOfStay.setArrivalDate(results.getString("arrivalDate"));
				newReservationOfStay.setDepartureDate(results.getString("departureDate"));
				newReservationOfStay.setPaymentInfo(results.getString("paymentInfo"));
				newReservationOfStay.setPaymentConfirmation(results.getString("paymentConfirmation"));
				newReservationOfStay.setDateOfReservation(results.getString("dateOfReservation"));
				newReservationOfStay.setDiscount(results.getDouble("discount"));
				newReservationOfStay.setPrice(results.getDouble("price"));
				newReservationOfStay.setStaff(new Staff(results.getInt("staffID")));
				newReservationOfStay.setAgency(new Agency(results.getInt("agencyID")));
				LinkedList<Customer> customers = new LinkedList<Customer>();
				customers.add(new Customer(results.getInt("customerID")));
				newReservationOfStay.setCustomers(customers);
				reservations.add(newReservationOfStay);
			}
				stmt.close();
				
				for(ReservationOfStay res: reservations){
					for(ReservationOfStay res2: reservations){
						if(res.getReservationID() == res2.getReservationID()){
							res.getCustomers().add(res2.getCustomers().getFirst());
							reservations.remove(res2);
						}
					}
				}
				
		} catch (SQLException ex) {
			System.out.println("Building ReservationOfStay Object Failed: "+ex.getMessage());
		}
		
		return reservations;
	}
	
	public ReservationOfStay findReservationOfStay(int reservationID){
				
		ReservationOfStay reservationOfStay = new ReservationOfStay(reservationID);
		
		String query = "";
		query = "SELECT * "+ "FROM ReservationOfStay "
				+ "WHERE reservationID = " + reservationID;
		System.out.println("insert : " + query);
		
		try {
			
			ResultSet results;
			
			Statement stmt = con.createStatement();
			
			stmt.setQueryTimeout(5);						
			
			results = stmt.executeQuery(query);

			if (results.next()) {
				reservationOfStay.setReservationID(reservationID);
				reservationOfStay.setDurationOfStay(results.getInt("durationOfStay"));
				reservationOfStay.setArrivalDate(results.getString("arrivalDate"));
				reservationOfStay.setDepartureDate(results.getString("departureDate"));
				reservationOfStay.setPaymentInfo(results.getString("paymentInfo"));
				reservationOfStay.setPaymentConfirmation(results.getString("paymentConfirmation"));
				reservationOfStay.setDateOfReservation(results.getString("dateOfReservation"));
				reservationOfStay.setDiscount(results.getDouble("discount"));
				reservationOfStay.setPrice(results.getDouble("price"));
				reservationOfStay.setStaff(new Staff(results.getInt("staffID")));
				reservationOfStay.setAgency(new Agency(results.getInt("agencyID")));
				
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("Order not found "+ex.getMessage());
			
		}
		
		query = "";
		query = "SELECT * "+ "FROM ReservationConnectionTable "
				+ "WHERE reservationID = " + reservationID;
		System.out.println("insert : " + query);
		try{
			
			ResultSet results;
		
			Statement stmt = con.createStatement();
		
			stmt.setQueryTimeout(5);						
		
			results = stmt.executeQuery(query);

			LinkedList<Customer> customersInReservation = new LinkedList<Customer>();
			if (results.next()) {
				customersInReservation.add(new Customer(results.getInt("customerID")));
				}
			reservationOfStay.setCustomers(customersInReservation);
			stmt.close();
			
		
		} catch (SQLException ex) {
		System.out.println("Order not found "+ex.getMessage());
		
		}
		
		return reservationOfStay;
		
	}
		
	public int insertReservationOfStay(ReservationOfStay reservationOfStay){
		int rc = -1;
		String query = "";
		query = "INSERT INTO ReservationOfStay (reservationID, durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price, agencyID, staffID) VALUES (" 
		+ reservationOfStay.getReservationID() + ","
		+ reservationOfStay.getDurationOfStay() + ",'"
		+ reservationOfStay.getArrivalDate() + "','"
		+ reservationOfStay.getDepartureDate() + "','"
		+ reservationOfStay.getPaymentInfo() + "','"
		+ reservationOfStay.getPaymentConfirmation()+ "','"
		+ reservationOfStay.getDateOfReservation()+ "',"
		+ reservationOfStay.getDiscount()+ ","
		+ reservationOfStay.getPrice()+ ","
		+ reservationOfStay.getAgency().getAgencyID()+ ","
		+ reservationOfStay.getStaff().getStaffID()+")";
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ReservationOfStay not inserted: "+ex.getMessage());
		}
		return rc;
		
	}	
	
	public static int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(reservationID) as reservationID "
				+ "FROM ReservationOfStay";
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
	
	public void updateReservationConnection(int resID, int[] customerIDs){
		for(int cusID: customerIDs){
			
			int rc = -1;
			String query = "";
			query = "INSERT INTO ReservationConnectionTable (reservationID, customerID) VALUES ("
					+ resID + ","
					+ cusID + ")";
		
			System.out.println("insert : " + query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				rc = stmt.executeUpdate(query);
				stmt.close();
			} catch (SQLException ex) {
				System.out.println("ReservationConnection not inserted: "+ex.getMessage());

			}								
		}
	}
	
	public void deleteReservation(int reservationID){
		
		int rc = -1;
		String query = "";
		query = "DELETE FROM ReservationConnectionTable WHERE reservationID ="
				+ reservationID;
	
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ReservationConnection not inserted: "+ex.getMessage());
		}	
		
		query = "";
		query = "DELETE FROM ReservationOfStay WHERE reservationID = "
				+ reservationID;
	
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("ReservationConnection not inserted: "+ex.getMessage());
		}			
		
		
	}
		
}