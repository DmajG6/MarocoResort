package dbLayer;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import modelLayer.*;

public class DbApartment {
	private DbCustomer dbCustomer;
	private Connection con;
	
	public DbApartment() {
		con = DbConnection.getInstance().getDBcon();
		dbCustomer = new DbCustomer();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(roomID)"
				+ "FROM [Apartment Table]";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("RoomID");
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found");
			
		}
		
		return rc;
		
	}
	
	public int insertApartment(Apartment apartment){
		int rc = -1;
		String query = "";
		query = "INSERT INTO [Apartment Table] (roomID, type, price, floor, customer, specialNeeds) VALUES (" 
		+ apartment.getRoomID() + ",'"
		+ apartment.getType() + ","
		+ apartment.getPrice() + ","
		+ apartment.getFloor() + ","
		+ apartment.getCustomer() + ","
		+ apartment.getSpecialNeeds() + "',";
		
			
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Apartment not inserted");
		}
		
		return rc;
		
	}
	
	public ArrayList<Apartment> getAllApartments() {
		return miscWhere(""); 
	}
	
	public Apartment findApartment(int roomID) {
		String wClause = "  roomID = '" + roomID + "'";
		return singleWhere(wClause);
	}
	
	public Apartment findApartmentByPrice(double price) {
		String wClause = "  roomID = '" + price + "'";
		return singleWhere(wClause);
	}
	
	public int updateApartment(double price, Apartment apartment) {
		String q = "update [Apartment Table] set roomID = ?, type = ?, price = ?, floor = ?, customer = ?, specialNeeds = ? where name='" + apartment.getPrice()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, apartment.getRoomID());
			s.setString(2, apartment.getType());
			s.setDouble(3, apartment.getPrice());
			s.setInt(4, apartment.getFloor());
			s.setInt(5, apartment.getCustomer().getCustomerID());
			s.setString(6, apartment.getSpecialNeeds());
				
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}
	
    // misc where
	private ArrayList<Apartment> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Apartment> list = new ArrayList<Apartment>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Apartment apartmentObj = new Apartment();
				apartmentObj = buildApartment(results);
				list.add(apartmentObj);
			}
			stmt.close();
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	

		private Apartment singleWhere(String wClause) {
			ResultSet results;
			Apartment apartmentObj = new Apartment();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					apartmentObj = buildApartment(results);
					stmt.close();
				} else {
					apartmentObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return apartmentObj;
		}
		
		private String buildQuery(String wClause) {
			String query = "SELECT *  FROM [Apartment Table]";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

			return query;
		}
		
		
		private Apartment buildApartment(ResultSet results) {
			Apartment apartmentObj = new Apartment();
			try {
				apartmentObj.setRoomID(results.getInt("roomID"));
				apartmentObj.setType(results.getString("type"));
				apartmentObj.setPrice(results.getDouble("price"));
				apartmentObj.setFloor(results.getInt("floor"));
				apartmentObj.setCustomer(dbCustomer.findCustomerByCustomerID (results.getInt("customer")));
				apartmentObj.setSpecialNeeds(results.getString("specialNeeds"));
				

			} catch (Exception e) {
				System.out.println("Error in building the apartment object");
			}
			return apartmentObj;
		}
		
		public LinkedList<Apartment> getApartments(int reservationID){
			int rc = -1;
			LinkedList<Apartment> apartments = new LinkedList<Apartment>();
			
			String query = "";
			
			query = "SELECT o.reservationID, o.durationOfStay, o.arrivalDate, o.departureDate, o.paymentInfo, o.paymentConfirmation, o.dateOfReservation, o.discount, o.price, c.customerID, c.password, c.name, c.country, c.address, c.phoneNo, c.email, c.idType, c.idNumber, c.specialService, c.active, c.reservationID, c.roomID "
					+ "FROM ReservationOfStay o, Customer c "
					+ "WHERE reservationOfStayID = " + reservationID + " AND "
							+ " o.customerID = c.reservationID";
			System.out.println("insert : " + query);
			try {
				ResultSet results;
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				
				
				results = stmt.executeQuery(query);
				
				if (results.next()) {
					Apartment apartment = new Apartment();
					apartment.setRoomID(results.getInt("roomID"));
					apartment.setType(results.getString("type"));
					apartment.setPrice(results.getDouble("price"));
					apartment.setFloor(results.getInt("floor"));
					apartment.setCustomer(dbCustomer.findCustomerByCustomerID (results.getInt("customer")));
					apartment.setSpecialNeeds(results.getString("specialNeeds"));
					
					apartments.add(apartment);
					
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("ID not found "+rc+" "+ex.getMessage());
				
			}
			return apartments;
		}


}