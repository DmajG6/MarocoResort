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
		+ waitingList.getCustomerIDs().getFirst() + ","
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
	
	public int deleteWaitingList(int waitingListID) {
		int rc = -1;
		String query = "DELETE FROM Agency WHERE waitingListID="+waitingListID;
		System.out.println("insert: "+query);
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (Exception ex) {
			System.out.println("waiting list not deleted: "+ex.getMessage());
		}
		return rc;
	}
	
	private LinkedList<WaitingList> miscWhere(String wClause) {
		ResultSet results;
		LinkedList<WaitingList> lists = new LinkedList<WaitingList>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				WaitingList agencyObj = new WaitingList();
				agencyObj = buildWaitingList(results);
				lists.add(agencyObj);
			}
			stmt.close();
			
			
			for(int i = 0; i<lists.size(); i++){
				
				LinkedList<Integer> customerIDs = new LinkedList<Integer>();
				LinkedList<Integer> topList = lists.get(i).getCustomerIDs();
				
				for(int e = 0; e<lists.size(); e++){
					LinkedList<Integer> secondList = lists.get(e).getCustomerIDs();
					
					for(int data: secondList){

						if(!topList.contains(data)){
							customerIDs.add(data);
						}
					}
				}
				lists.get(i).setCustomerIDs(customerIDs);
			}
		}
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return lists;
	}
	
	private WaitingList singleWhere(String wClause) {
			ResultSet results;
			WaitingList agencyObj = new WaitingList();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					agencyObj = buildWaitingList(results);
					stmt.close();
				} else {
					agencyObj = null;
				}
			}
			catch (Exception e) {
				System.out.println("Query exception: " + e.getMessage());
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
				LinkedList<Integer> link = new LinkedList<Integer>();
				link.add(results.getInt("customerID"));
				waitingListObj.setCustomerIDs(link);
				waitingListObj.setFacilityID(results.getInt("facilityID"));
				waitingListObj.setTime(results.getString("time"));
			} catch (Exception e) {
				System.out.println("Error in building the agency object");
			}
			return waitingListObj;
		}
		
		
}