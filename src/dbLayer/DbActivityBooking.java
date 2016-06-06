package dbLayer;

import java.sql.*;
import modelLayer.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class DbActivityBooking {
	private Connection con;
	private ActivityBooking activity= new ActivityBooking();

	public DbActivityBooking() {
		con = DbConnection.getInstance().getDBcon();
	}

	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(activityID) as activityID "
				+ "FROM ActivityBooking";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("activityID");
			}
				stmt.close();
		} catch (SQLException ex) {
			System.out.println("ID not found: "+ex.getSQLState());
			
		}
		
		return rc;
		
	}

	public int insertActivity(ActivityBooking activityBooking){
	   	int rc = -1;
	   	String query= "";
	   	query = "INSERT INTO ActivityBooking(activityID, facilityID, staffID, startTime) VALUES ("
		+ activityBooking.getActivityID() + ","
		+ activityBooking.getFacility().getFacilityID() + ","
		+ activityBooking.getStaff().getStaffID() + ",'"
		+ activityBooking.getStartTime() + "')";


		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Activity not inserted: "+ex.getMessage());
		}
		
		query = "";
	   	query = "INSERT INTO ActivityConnectionTable(activityID, customerID, waitingOrder) VALUES ("
		+ activityBooking.getActivityID() + ","
		+ activityBooking.getCustomer().getCustomerID() + ","
		+ activityBooking.getWaitingListOrder() + ")";


		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Activity not inserted: "+ex.getMessage());
		}
		
		return rc;
		
	}

	public LinkedList<ActivityBooking> getAllActivities() {
		return miscWhere(""); 
	}
	
	public ActivityBooking findActivityByID(int activityID) {
		String wClause = " activityID = " + activityID;
		return singleWhere(wClause);
	}

	public int updateActivity(ActivityBooking activityBooking) {
		String q = "update ActivityBooking set activityID = ?, facilityID = ?, staff = ?, startTime = ? where activityID= " + activityBooking.getActivityID();
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, activityBooking.getActivityID());
			s.setInt(2, activityBooking.getFacility().getFacilityID());
			s.setInt(3, activityBooking.getStaff().getStaffID());
			s.setString(4, activityBooking.getStartTime());
			s.setInt(5, activityBooking.getCustomer().getCustomerID());
				
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}

	private LinkedList<ActivityBooking> miscWhere(String wClause) {
		ResultSet results;
		LinkedList<ActivityBooking> list = new LinkedList<ActivityBooking>();
		String query = buildQuery(wClause);
		System.out.println("INSERT: "+query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				ActivityBooking activityBookingObj = new ActivityBooking();
				activityBookingObj = buildActivity(results);
				list.add(activityBookingObj);
			}
			stmt.close();
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		System.out.println("Number of activities: "+list.size());
		return list;
	}
	

	private ActivityBooking singleWhere(String wClause) {
			ResultSet results;
			ActivityBooking activityBookingObj = new ActivityBooking();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					activityBookingObj = buildActivity(results);
					stmt.close();
				} else {
					activityBookingObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return activityBookingObj;
	}
		
	private String buildQuery(String wClause) {
			String query = "SELECT * FROM ActivityBooking ac, ActivityConnectionTable ct WHERE ac.ActivityID = ct.ActivityID ";

			if (wClause.length() > 0)
				query = query + " AND "+wClause;

			return query;
	}

	private ActivityBooking buildActivity(ResultSet results) {
			ActivityBooking activityBookingObj = new ActivityBooking();
			try {
				activityBookingObj.setActivityID(results.getInt("activityID"));
				activityBookingObj.setFacility(new Facility(results.getInt("facilityID")));
				activityBookingObj.setStaff(new Staff(results.getInt("staffID")));
				activityBookingObj.setStartTime(results.getString("startTime"));
				activityBookingObj.setCustomer(new Customer(results.getInt("customerID")));
				

			} catch (Exception e) {
				System.out.println("Error in building the activity: "+e.getMessage());
			}
			return activityBookingObj;
	}



	public LinkedList<ActivityBooking> getActivity(int activityID){
			int rc = -1;
			LinkedList<ActivityBooking> activities = new LinkedList<ActivityBooking>();
			
			String query = "";
			
			query = "SELECT o.activityID, o.facilities, o.staffID, o.startTime, o.customerID"
					+ "FROM ActivityBooking o "
					+ "WHERE activityID = " + activityID;
			System.out.println("insert : " + query);
			try {
				ResultSet results;
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				
				
				results = stmt.executeQuery(query);
				
				if (results.next()) {
					ActivityBooking activityBooking = new ActivityBooking();
					activityBooking.setActivityID(results.getInt("activityID"));
					activityBooking.setFacility(new Facility(results.getInt("facilityID")));
					activityBooking.setStaff(new Staff(results.getInt("staff")));
					activityBooking.setStartTime(results.getString("startTime"));
					activityBooking.setCustomer(new Customer(results.getInt("customer")));
					//activityBooking.setCustomer(DbCustomer.findCustomerByCustomerID (results.getInt("customer")));
					
					activityBooking.add(activity);
					
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("ID not found "+rc+" "+ex.getMessage());
				
			}
			return activities;
	}
		
	public int deleteActivity(int activityID, int customerID){
		int rc = -1;
		
		String query = "";
		
		query = "DELETE FROM ActivityConnectionTable "
				+ "WHERE activityID = " + activity.getActivityID()
				+ "AND customerID = " + activity.getCustomer().getCustomerID();
		
		
		System.out.println("insert : " + query);
		try {
			
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			rc = stmt.executeUpdate(query);
			
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Activity not deleted "+rc+" "+ex.getMessage());
			
		}
		
		query = "";
		
		
		
		query = "DELETE FROM ActivityBooking "
				+ "WHERE activityID = " + activity.getActivityID();
		System.out.println("insert : " + query);
		try {
			
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			rc = stmt.executeUpdate(query);
			
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Activity not deleted "+rc+" "+ex.getMessage());
			
		}
		
		return rc;
	}
	
}
