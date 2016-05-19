package controlLayer;

import java.util.ArrayList;
import java.util.LinkedList;

import dbLayer.*;
import modelLayer.*;


public class ApartmentController {

	
	DbApartment dbApartment = new DbApartment();
	
	public ArrayList<Apartment> getAllApartments(){
		return dbApartment.getAllApartments();
	}
	
	public Apartment findApartmentByRoomID(int roomID){
		try {
			return dbApartment.findApartment(roomID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
		
	public Apartment createApartment(int roomID, String type, double price, int floor, String specialNeeds){
		Apartment apartment = new Apartment();
		apartment.setRoomID(0);
		apartment.setType(type);
		apartment.setPrice(price);
		apartment.setFloor(floor);
		apartment.setSpecialNeeds(specialNeeds);
		
		try {
			DbConnection.startTransaction();
			dbApartment.insertApartment(apartment);
			DbConnection.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DbConnection.rollbackTransaction();
			e.printStackTrace();
		}
		return apartment;
	}
	
	public int updateApartment(int roomID, Apartment apartment){
		return dbApartment.updateApartment(roomID, apartment);		
	}

}