package controlLayer;

import java.util.LinkedList;

import dbLayer.*;
import modelLayer.*;


public class AgencyController {

	
	DbAgency dbAgency = new DbAgency();
	
	public LinkedList<Agency> getAllAgencys(){
		return dbAgency.getAllAgencys();
	}
	
	public Agency findAgencyByName(String name){
		try {
			return dbAgency.findAgency(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Agency findAgencyByAgencyID(int agencyID){
		try {
			return dbAgency.findAgencyByAgencyID(agencyID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Agency createAgency(int agencyID, String name, String address, int cvrNumber, String country, String email, String phoneNumber, String extraInfo, double discount){
		Agency agency = new Agency();
		agency.setAgencyID(0);
		agency.setName(name);
		agency.setCountry(country);
		agency.setAddress(address);
		agency.setPhoneNumber(phoneNumber);
		agency.setEmail(email);
		agency.setCvrNumber(cvrNumber);
		agency.setExtraInfo(extraInfo);
		agency.setDiscount(discount);
		
		try {
			DbConnection.startTransaction();
			dbAgency.insertAgency(agency);
			DbConnection.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DbConnection.rollbackTransaction();
			e.printStackTrace();
		}
		return agency;
	}
	
	public int updateAgency(String name, Agency agency){
		return dbAgency.updateAgency(name, agency);		
	}



}