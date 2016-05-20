package dbLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import modelLayer.WaitingList;

/**
	May 20, 2016 - 1:57:08 PM
*/

public class DbWaitingList {

private Connection con;
	
	public DbWaitingList() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(waitingListID) as waitingListID "
				+ "FROM WaitingList";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("waitingListID");
			}
			rc++;
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found");
			
		}
		return rc;
		
	}
	
	public int insertAgency(WaitingList waitingList){
		int rc = -1;
		String query = "";
		
		
		query = "INSERT INTO waitingList (waitingListID, customerID, facilityID, date) VALUES (" 
		+ getNewID() + ","
		+ waitingList.getCustomerID() + ","
		+ waitingList.getFacilityID()+ ",'"
		+ waitingList.getTime() + "')";
		
		
			
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("WaitingList not inserted: "+ex.getMessage());
		}
		
		return rc;
		
	}
	

	public LinkedList<WaitingList> getAllWaitingLists() {
		return miscWhere(""); 
	}
	
	
	public WaitingList findWaitingListByID(int waitingListID) {
		String wClause = "  waitingListID = " + waitingListID;
		return singleWhere(wClause);
	}
	
	public int updateAgency(String name, Agency agency) {
		String q = "update Agency set agencyID = ?, name = ?, country = ?, address = ?, phoneNo = ?, email = ?, cvrNo = ?, extraInfo = ?, discount = ? where name='" + agency.getName()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, agency.getAgencyID());
			s.setString(3, agency.getName());
			s.setString(4, agency.getCountry());
			s.setString(5, agency.getAddress());
			s.setString(6, agency.getPhoneNumber());
			s.setString(7, agency.getEmail());
			s.setInt(8, agency.getCvrNumber());
			s.setString(9, agency.getExtraInfo());
			s.setDouble(10, agency.getDiscount());
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}
	
    // misc where
	private LinkedList<WaitingList> miscWhere(String wClause) {
		ResultSet results;
		LinkedList<Agency> list = new LinkedList<Agency>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Agency agencyObj = new Agency();
				agencyObj = buildAgency(results);
				list.add(agencyObj);
			}
			stmt.close();
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	

		private WaitingList singleWhere(String wClause) {
			ResultSet results;
			Agency agencyObj = new Agency();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					agencyObj = buildAgency(results);
					stmt.close();
				} else {
					agencyObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return agencyObj;
		}
		
		private String buildQuery(String wClause) {
			String query = "SELECT *  FROM Agency";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

			return query;
		}
		
		
		private WaitingList buildWaitingList(ResultSet results) {
			WaitingList waitingListObj = new WaitingList();
			try {
				waitingListObj.setWaitingListID(results.getInt("waitingListObjID"));
				waitingListObj.setCustomerID(results.getInt("customerID"));
				waitingListObj.setFacilityID(results.getInt("facilityID"));
				waitingListObj.setTime(results.getString("time"));
				

			} catch (Exception e) {
				System.out.println("Error in building the agency object");
			}
			return waitingListObj;
		}
		
		public LinkedList<WaitingList> getAgencys(int reservationID){
			int rc = -1;
			LinkedList<WaitingList> waitingLists = new LinkedList<WaitingList>();
			
			String query = "";
			
			query = "SELECT o.reservationID, o.durationOfStay, o.arrivalDate, o.departureDate, o.paymentInfo, o.paymentConfirmation, o.dateOfReservation, o.discount, o.price, c.agencyID, c.password, c.name, c.country, c.address, c.phoneNo, c.email, c.idType, c.idNumber, c.specialService, c.active, c.reservationID, c.roomID "
					+ "FROM ReservationOfStay o, Agency c "
					+ "WHERE reservationOfStayID = " + reservationID + " AND "
							+ " o.agencyID = c.reservationID";
			System.out.println("insert : " + query);
			try {
				ResultSet results;
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				
				
				results = stmt.executeQuery(query);
				
				if (results.next()) {
					Agency agency = new Agency();
					
					agency.setAgencyID(results.getInt("agencyID"));
					agency.setName(results.getString("name"));
					agency.setCountry(results.getString("country"));
					agency.setAddress(results.getString("address"));
					agency.setPhoneNumber(results.getString("phoneNo"));
					agency.setEmail(results.getString("email"));
					agency.setExtraInfo(results.getString("extraInfo"));
					agency.setDiscount(results.getDouble("discount"));
					
					agencies.add(agency);
					
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("ID not found "+rc+" "+ex.getMessage());
				
			}
			return agencies;
		}

}