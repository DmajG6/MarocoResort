package dbLayer;

import java.sql.*;
import modelLayer.*;
import java.util.LinkedList;

public class DbActivityBooking {
private Connection con;

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
query = "INSERT INTO ActivityBooking(activityID, facilities, staff, startTime, activityLength, customer) VALUES ("
		+ getNewID() + ",'"
		+ activityBooking.getActivityID() + "','"
		+ activityBooking.getFacilities() + "',"
		+ activityBooking.getStaff() + ","
		+ activityBooking.getStartTime() + ",'"
		+ activityBooking.getActivityLength() + "','"
		+ activityBooking.getCustomer() + "','";


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
		String q = "update Activity set activityID = ?, facilities = ?, staff = ?, startTime = ?, activityLength = ?, customer = ?,  where name='" + activityBooking.getActivityID()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, activityBooking.getActivityID());
			s.setFacility(2, activityBooking.getFacilities());
			s.setString(3, activityBooking.getStaff());
			s.setDate(4, activityBooking.getStartTime());
			s.setDouble(5, activityBooking.getActivityLength());
			s.setString(6, activityBooking.getCustomer());
				
			
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
				activityBookingObj.setFacility(results.getFacility("facilities"));
				activityBookingObj.setStaff(results.getString("staff"));
				activityBookingObj.setStartTime(results.getDate("startTime"));
				activityBookingObj.setActivityLength(results.getDouble("activityLength"));
				activityBookingObj.setCustomer(results.getString("customer"));
				

			} catch (Exception e) {
				System.out.println("Error in building the activity: "+e.getMessage());
			}
			return activityBookingObj;
		}
		
		public LinkedList<ActivityBooking> getActivity(int activityID){
			int rc = -1;
			LinkedList<ActivityBooking> activities = new LinkedList<ActivityBooking>();
			
			String query = "";
			
			query = "SELECT o.activityID, o.facilities, o.staffID, o.startTime, o.activityLength, o.customerID"
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
					activityBooking.setFacility(results.getFacility("facilities"));
					activityBooking.setStaff(results.getString("staff"));
					activityBooking.setStartTime(results.getDate("startTime"));
					activityBooking.setActivityLength(results.getDouble("activityLength"));
					activityBooking.setCustomer(results.getString("customer"));
					//activityBooking.setCustomer(DbCustomer.findCustomerByCustomerID (results.getInt("customer")));
					
					activityBooking.add(activity);
					
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("ID not found "+rc+" "+ex.getMessage());
				
			}
			return activities;
		}


}