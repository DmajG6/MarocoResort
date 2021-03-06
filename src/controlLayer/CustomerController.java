package controlLayer;

import java.util.LinkedList;
import dbLayer.*;
import modelLayer.*;


public class CustomerController {

	
	DbCustomer dbCustomer = new DbCustomer();
	
	public LinkedList<Customer> getAllCustomers(){
		return dbCustomer.getAllCustomers();
	}
	
	public Customer findCustomerByName(String name){
		try {
			return dbCustomer.findCustomer(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Customer findCustomerByID(int customerID){
		try {
			return dbCustomer.findCustomerByCustomerID(customerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Customer createCustomer(int customerID, String password, String name, String country, String address, String phoneNumber, String email, String idType, String idNumber, String specialService, int roomID, String active){
		Customer customer = new Customer();
		customer.setCustomerID(dbCustomer.getNewID()+1);
		customer.setPassword(password);
		customer.setName(name);
		customer.setCountry(country);
		customer.setAddress(address);
		customer.setPhoneNumber(phoneNumber);
		customer.setEmail(email);
		customer.setIdType(idType);
		customer.setIdNumber(idNumber);
		customer.setSpecialService(specialService);
		customer.setRoomID(roomID);
		customer.setActive(active);

		try {
			DbConnection.startTransaction();
			dbCustomer.insertCustomer(customer);
			DbConnection.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DbConnection.rollbackTransaction();
			e.printStackTrace();
		}
		return customer;
	}
	
	public int updateCustomer(Customer customer){
		return dbCustomer.updateCustomer(customer);		
	}


	public boolean customerLogIn(String iD, String password){
		
		Customer logInCustomer = dbCustomer.findCustomerByCustomerID(Integer.parseInt(iD));
		
		return (logInCustomer.getPassword().equals(password))&&(logInCustomer.getActive().equals("yes"));
	}
	
	public void checkInOut(int customerID, boolean outIn){
		if(outIn){
			dbCustomer.checkInOut(customerID, "yes");

		}else{
			dbCustomer.checkInOut(customerID, "no");
		}
	}
	
	public void setNewPassword(String newPassword, Customer customer){
		customer.setPassword(newPassword);
		dbCustomer.updateCustomer(customer);
	}
	
}
