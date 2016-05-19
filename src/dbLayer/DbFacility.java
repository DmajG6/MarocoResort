package dbLayer;

import java.sql.*;
import java.util.LinkedList;
import java.util.LinkedList;
import modelLayer.*;

public class DbFacility {
	private DbCustomer dbCustomer;
	private Connection con;
	private Facility facility= new Facility();
	
	public DbFacility() {
		con = DbConnection.getInstance().getDBcon();
		dbCustomer = new DbCustomer();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(facilityID)  as facilityID "
				+ "FROM Facility";
				
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			/*
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
			*/
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("facilityID");
			}
			stmt.close();
			
			{
				rc++;
			}
			
		} catch (SQLException ex) {
			System.out.println("ID not found: "+ex.getMessage());
			
		}
		
		return rc;
		
	}
	
	public int insertFacility(Facility facility){
		this.facility = facility;
		this.facility.setFacilityID(getNewID());
		int rc = -1;
		String query = "";
		query = "INSERT INTO Facility (facilityID, type, price, instructorPrice) VALUES (" 
		+ this.facility.getFacilityID() + ",'"
		+ facility.getType() + "',"
		+ facility.getPrice() + ","
		+ facility.getInstructorPrice() + ")";
		
			
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Facility not inserted");
		}
		
		return rc;
		
	}
	
	public LinkedList<Facility> getAllFacilities() {
		return miscWhere(""); 
	}
	
	public Facility findFacility(int facilityID) {
		String wClause = "  facilityID = '" + facilityID + "'";
		return singleWhere(wClause);
	}
	
	
	
	public int updateFacility(int facilityID, Facility facility) {
		String q = "update Facility set facilityID = ?, type = ?, price = ?, instructorPrice = ? where facilityID=" + facilityID;
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, facility.getFacilityID());
			s.setString(2, facility.getType());
			s.setDouble(3, facility.getPrice());
			s.setDouble(4, facility.getInstructorPrice());
				
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}
	
    // misc where
	private LinkedList<Facility> miscWhere(String wClause) {
		ResultSet results;
		LinkedList<Facility> list = new LinkedList<Facility>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Facility facilityObj = new Facility();
				facilityObj = buildFacility(results);
				list.add(facilityObj);
			}
			stmt.close();
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	

		private Facility singleWhere(String wClause) {
			ResultSet results;
			Facility facilityObj = new Facility();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					facilityObj = buildFacility(results);
					stmt.close();
				} else {
					facilityObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return facilityObj;
		}
		
		private String buildQuery(String wClause) {
			String query = "SELECT *  FROM Facility";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

			return query;
		}
		
		
		private Facility buildFacility(ResultSet results) {
			Facility facilityObj = new Facility();
			try {
				facilityObj.setFacilityID(results.getInt("facilityID"));
				facilityObj.setType(results.getString("type"));
				facilityObj.setPrice(results.getDouble("price"));
				facilityObj.setInstructorPrice(results.getDouble("instructorPrice"));
				

			} catch (Exception e) {
				System.out.println("Error in building the facility object");
			}
			return facilityObj;
		}
		
		public LinkedList<Facility> getFacilities(int facilityID){
			int rc = -1;
			LinkedList<Facility> facilities = new LinkedList<Facility>();
			
			String query = "";
			
			query = "SELECT o.facilityID, o.type, o.price, o.instructorPrice"
					+ "FROM Facility o "
					+ "WHERE facilityID = " + facilityID ;
			System.out.println("insert : " + query);
			try {
				ResultSet results;
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				
				
				results = stmt.executeQuery(query);
				
				if (results.next()) {
					Facility facility = new Facility();
					facility.setFacilityID(results.getInt("facilityID"));
					facility.setType(results.getString("type"));
					facility.setPrice(results.getDouble("price"));
					facility.setInstructorPrice(results.getDouble("instructorPrice"));
					
					facilities.add(facility);
					
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("ID not found "+rc+" "+ex.getMessage());
				
			}
			return facilities;
		}


}
