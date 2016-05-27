package dbLayer;

//
import java.util.LinkedList;
import java.sql.*;
import modelLayer.*;

public class DbCustomer {
	
	private Connection con;
	
	public DbCustomer() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(customerID) as customerID "
				+ "FROM Customer";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("customerID");
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found");
			
		}
		
		return rc++;
		
	}
	
	public int insertCustomer(Customer customer){
		int rc = -1;
		String query = "";
		
		
		query = "INSERT INTO Customer (customerID, password, name, country, address, phoneNo, email, idType, idNumber, specialService, roomID, active) VALUES (" 
		+ customer.getCustomerID() + ",'"
		+ customer.getPassword() + "','"
		+ customer.getName() + "','"
		+ customer.getCountry() + "','"
		+ customer.getAddress() + "','"
		+ customer.getPhoneNumber() + "','"
		+ customer.getEmail() + "','"
		+ customer.getIdType() + "','"
		+ customer.getIdNumber() + "','"
		+ customer.getSpecialService() + "',"
		+ customer.getRoomID() + ",'"
		+ customer.getActive() + "')";
		
			
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Customer not inserted: "+ex.getMessage());
		}
		
		return rc;
		
	}
	
/*
	private int getCustomerID(Customer customer) {
		
		int rc = -1;
		
		String query = "";
		
		query = "SELECT CustomerID"
				+ "FROM Customer"
				+ "WHERE Name = '" + customer.getName()+"'"
				+ " CustomerID = " + customer.getCustomerID()
				+ " Password = " + customer.getPassword()
				+ " Country = " + customer.getCountry()
				+ " PhoneNumber = " + customer.getPhoneNumber()
				+ " Email = " + customer.getEmail()
				+ " IdType = " + customer.getIdType()
				+ " IdNumber = " + customer.getIdNumber()
				+ " SpecialService = " + customer.getSpecialService()
				+ " RoomID = " + customer.getRoomID()
				+ " Active = " + customer.getActive()
				+ " Address = '" + customer.getAddress()+"'";
		
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("CustomerID");
			}
				stmt.close();
		} catch (SQLException ex) {
			System.out.println("ID not found "+ex.getSQLState());
			
		}
		
		return rc;
	}
*/
	public LinkedList<Customer> getAllCustomers() {
		return miscWhere(""); 
	}
	
	public Customer findCustomer(String name) {
		String wClause = "  name = '" + name + "'";
		return singleWhere(wClause);
	}
	
	public Customer findCustomerByCustomerID(int customerID) {
		String wClause = "  customerID = '" + customerID + "'";
		return singleWhere(wClause);
	}
	
	public int updateCustomer(String name, Customer customer) {
		String q = "update Customer set customerID = ?, password = ?, name = ?, country = ?, address = ?, phoneNumber = ?, email = ?, idType = ?, idNumber = ?, specialService = ?, roomID = ?, active = ? where name='" + customer.getName()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, customer.getCustomerID());
			s.setString(2, customer.getPassword());
			s.setString(3, customer.getName());
			s.setString(4, customer.getCountry());
			s.setString(5, customer.getAddress());
			s.setString(6, customer.getPhoneNumber());
			s.setString(7, customer.getEmail());
			s.setString(8, customer.getIdType());
			s.setInt(9, Integer.parseInt(customer.getIdNumber()));
			s.setString(10, customer.getSpecialService());
			s.setInt(11, customer.getRoomID());
			s.setString(12, customer.getActive());			
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}
	
    // misc where
	private LinkedList<Customer> miscWhere(String wClause) {
		ResultSet results;
		LinkedList<Customer> list = new LinkedList<Customer>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Customer customerObj = new Customer();
				customerObj = buildCustomer(results);
				list.add(customerObj);
			}
			stmt.close();
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	

		private Customer singleWhere(String wClause) {
			ResultSet results;
			Customer customerObj = new Customer();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					customerObj = buildCustomer(results);
					stmt.close();
				} else {
					customerObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return customerObj;
		}
		
		private String buildQuery(String wClause) {
			String query = "SELECT *  FROM Customer";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

			return query;
		}
		
		
		private Customer buildCustomer(ResultSet results) {
			Customer customerObj = new Customer();
			try {
				customerObj.setCustomerID(results.getInt("customerID"));
				customerObj.setPassword(results.getString("password"));
				customerObj.setName(results.getString("name"));
				customerObj.setCountry(results.getString("country"));
				customerObj.setAddress(results.getString("address"));
				customerObj.setPhoneNumber(results.getString("phoneNo"));
				customerObj.setEmail(results.getString("email"));
				customerObj.setIdType(results.getString("idType"));
				customerObj.setIdNumber(results.getString("idNumber"));
				customerObj.setSpecialService(results.getString("specialService"));
				customerObj.setRoomID(results.getInt("roomID"));
				customerObj.setActive(results.getString("active"));
				

			} catch (Exception e) {
				System.out.println("Error in building the customer object: "+e.getMessage());
			}
			return customerObj;
		}
		
		public LinkedList<Customer> getCustomers(int customerID){
			int rc = -1;
			LinkedList<Customer> customers = new LinkedList<Customer>();
			
			String query = "";
			
			query = "SELECT c.customerID, c.password, c.name, c.country, c.address, c.phoneNo, c.email, c.idType, c.idNumber, c.specialService, c.active, o.reservationID"
					+ "FROM Customer c , ReservationOfStay o"
					+ "WHERE customerID = " + customerID + " AND "
							+ " c.customerID = o.reservationID";
			System.out.println("insert : " + query);
			try {
				ResultSet results;
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				
				
				results = stmt.executeQuery(query);
				
				if (results.next()) {
					Customer customer = new Customer();
					customer.setCustomerID(results.getInt("customerID"));
					customer.setPassword(results.getString("password"));
					customer.setName(results.getString("name"));
					customer.setCountry(results.getString("country"));
					customer.setAddress(results.getString("address"));
					customer.setPhoneNumber(results.getString("phoneNumber"));
					customer.setEmail(results.getString("email"));
					customer.setIdType(results.getString("idType"));
					customer.setIdNumber(results.getString("idNumber"));
					customer.setSpecialService(results.getString("specialService"));
					customer.setRoomID(results.getInt("roomID"));
					customer.setActive(results.getString("active"));
					
					customers.add(customer);
					
				}
				
				
					stmt.close();
			} catch (SQLException ex) {
				System.out.println("ID not found "+rc+" "+ex.getMessage());
				
			}
			return customers;
		}

		public int checkInOut(int customerID, String active) {
			
			String q = "update Customer set active = ? where customerID=" + customerID;
			int res = 0;
			try (PreparedStatement s = DbConnection.getInstance().getDBcon()
					.prepareStatement(q)) {
				s.setString(1, active);			
				
				res = s.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NullPointerException npe) {

			}
			return res;
			
		}
		
		public void updateActivityConnection(int actID, LinkedList<Integer> customerIDs){
			for(int cusID: customerIDs){
				
				int rc = -1;
				String query = "";
				query = "INSERT INTO ActivityConnectionTable (activityID, customerID) VALUES ("
						+ actID + ","
						+ cusID + ")";
				
				System.out.println("insert : " + query);
				try {
					Statement stmt = con.createStatement();
					stmt.setQueryTimeout(5);
					rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
					stmt.close();
				} catch (SQLException ex) {
					System.out.println("ActivityConnection not inserted");
			}
		}

	}
}
