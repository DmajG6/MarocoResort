package controlLayer;

import java.util.ArrayList;
import dbLayer.*;
import modelLayer.*;


public class CustomerController {

	
	DbCustomer dbCustomer = new DbCustomer();
	
	public ArrayList<Customer> getAllCustomers(){
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

	
	public Customer createCustomer(int customerID, String password, String name, String country, String address, String phoneNumber, String email, String idType, int idNumber, String specialService, int roomID, String active){
		Customer customer = new Customer();
		customer.setCustomerID(0);
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
	
	public int updateCustomer(String name, Customer customer){
		return dbCustomer.updateCustomer(name, customer);		
	}

	public Customer findCustomerByID(String input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
