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
			rc++;
		} catch (SQLException ex) {
			System.out.println("ID not found: "+ex.getSQLState());
			
		}
		
		return rc;
		
	}


   public int insertActivity(ActivityBooking activityBooking){
	   	int rc = -1;
	   	String query= "";
	   	query = "INSERT INTO ActivityBooking(activityID, facilities, staff, startTime, customer) VALUES ("
		+ getNewID() + ",'"
		+ activityBooking.getActivityID() + "','"
		+ activityBooking.getFacility().getFacilityID() + "',"
		+ activityBooking.getStaff().getStaffID() + ","
		+ activityBooking.getStartTime() + ",'"
		+ activityBooking.getCustomer().getCustomerID() + "','";


		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Activity not inserted");
		}
		
		return rc;
		
	}

		public LinkedList<ActivityBooking> getAllActivities() {
		return miscWhere(""); 
	}
	
	public ActivityBooking findActivities(int activityID) {
		String wClause = "  activityID = '" + activityID + "'";
		return singleWhere(wClause);
	}

public int updateActivity(int activityID , ActivityBooking activityBooking) {
		String q = "update Activity set activityID = ?, facilities = ?, staff = ?, startTime = ?, customer = ?,  where name='" + activityBooking.getActivityID()+"'";
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
			String query = "SELECT *  FROM ActivityBooking";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

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
//!


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
		public LinkedList<Customer> getCustomersInBooking(int facilityID, String startTime){
			LinkedList<Customer> activitiesInBooking = new LinkedList<Customer>();
			int rc= -1;
			String query = "";
			
			query = "" + facilityID +startTime;
			try {
				ResultSet results;
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				
				
				results = stmt.executeQuery(query);
				
				if (results.next()) {
					ActivityBooking activityBooking = new ActivityBooking();
					activityBooking.setActivityID(results.getInt("activityID"));
					activityBooking.setFacility(new Facility(results.getInt("facilityID")));
					activityBooking.setStartTime(results.getString("startTime"));
					activityBooking.setCustomer(new Customer(results.getInt("customer")));
					rc = results.getInt("facilityID");
					activityBooking.add(activity);
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("not found "+rc+" "+ex.getMessage());
				
			}
			return activitiesInBooking;
		}

}
