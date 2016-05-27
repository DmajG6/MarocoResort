package dbLayer;


import java.util.ArrayList;
import java.sql.*;
import modelLayer.*;

public class DbStaff {
	
	private Connection con;
	
	public DbStaff() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(staffID) as staffID "
				+ "FROM Staff";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("staffID");
			}
				stmt.close();
			rc++;
		} catch (SQLException ex) {
			System.out.println("ID not found: "+ex.getSQLState());
			
		}
		
		return rc;
		
	}
	
	public int insertStaff(Staff staff){
		int rc = -1;
		String query = "";
		query = "INSERT INTO Staff (staffID, name, password, workPhoneNo, personalPhoneNo, staffType, email) VALUES (" 
		+ getNewID() + ",'"
		+ staff.getName() + "','"
		+ staff.getPassword() + "',"
		+ staff.getWorkPhoneNumber() + ","
		+ staff.getPersonalPhoneNumber() + ",'"
		+ staff.getStaffType() + "','"
		+ staff.getEmail() + "')";
	
			
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Staff not inserted: "+ex.getMessage());
		}
		
		return rc;
		
	}
	
	public ArrayList<Staff> getAllStaffs() {
		return miscWhere(""); 
	}
	
	public Staff findStaffByName(String name) {
		String wClause = "  name = '" + name + "'";
		return singleWhere(wClause);
	}
	
	public Staff findStaffByID(int staffID) {
		String wClause = " staffID = " + staffID;
		return singleWhere(wClause);
	}
	
	public int updateStaff(String name, Staff staff) {
		String q = "update Staff set staffID = ?, name = ?, password = ?, workPhoneNo = ?, personalPhoneNo = ?, staffType = ?, email = ? where name='" + staff.getName()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, staff.getStaffID());
			s.setString(2, staff.getName());
			s.setString(3, staff.getPassword());
			s.setString(4, staff.getWorkPhoneNumber());
			s.setString(5, staff.getPersonalPhoneNumber());
			s.setString(6, staff.getStaffType());
			s.setString(7, staff.getEmail());
	
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}
	
    // misc where
	private ArrayList<Staff> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Staff> list = new ArrayList<Staff>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Staff staffObj = new Staff();
				staffObj = buildStaff(results);
				list.add(staffObj);
			}
			stmt.close();
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	

		private Staff singleWhere(String wClause) {
			ResultSet results;
			Staff staffObj = new Staff();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					staffObj = buildStaff(results);
					stmt.close();
				} else {
					staffObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return staffObj;
		}
		
		private String buildQuery(String wClause) {
			String query = "SELECT *  FROM Staff";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

			return query;
		}
		
		
		private Staff buildStaff(ResultSet results) {
			Staff staffObj = new Staff();
			try {
				staffObj.setStaffID(results.getInt("staffID"));
				staffObj.setPassword(results.getString("password"));
				staffObj.setName(results.getString("name"));
				staffObj.setWorkPhoneNumber(results.getString("workPhoneNo"));
				staffObj.setPersonalPhoneNumber(results.getString("personalPhoneNo"));
				staffObj.setEmail(results.getString("email"));
				staffObj.setStaffType(results.getString("staffType"));
				

			} catch (Exception e) {
				System.out.println("Error in building the staff object");
			}
			return staffObj;
		}

		public Staff findStaffByStaffID(int staffID) {
			// TODO Auto-generated method stub
			return null;
		}
		

}
