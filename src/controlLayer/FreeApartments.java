package controlLayer;

import java.util.LinkedList;

import modelLayer.Apartment;
import modelLayer.ReservationOfStay;
import modelLayer.Customer;

/**
	May 19, 2016 - 12:18:50 PM
*/

public class FreeApartments {

	private ApartmentController apCtr = new ApartmentController();
	private ReservationOfStayController resCtr = new ReservationOfStayController();
	private CustomerController cusCtr = new CustomerController();
	
	public FreeApartments() {

	}
	
	public LinkedList<Apartment> getAllFreeApartmentsForPeriod(String arrivalDate, String departureDate){
		LinkedList<Apartment> allFreeApartments = new LinkedList<Apartment>();
		
		LinkedList<Apartment> apartments = new LinkedList<Apartment>();
		apartments = apCtr.getAllApartments();
		
		LinkedList<ReservationOfStay> reservations= new LinkedList<ReservationOfStay>();
		reservations = resCtr.getAllReservaions();
		
		LinkedList<String> allDays = new LinkedList<String>();
		allDays = getAllDays(arrivalDate, departureDate);
		
		for(ReservationOfStay res: reservations){
			LinkedList<String> allDaysInReservation = new LinkedList<String>();
			allDaysInReservation = getAllDays(arrivalDate, departureDate);
			for(int i = 0; i<allDays.size();i++){
				for(int e = 0; e<allDaysInReservation.size();e++){
					if(!allDaysInReservation.get(e).equals(allDays.get(i))){
						reservations.remove(res);
					}
				}
			}
		}
		
		LinkedList<Customer> customers = new LinkedList<Customer>();
		customers = cusCtr.getAllCustomers();
		
		for(ReservationOfStay res: reservations){
			for(Customer cusInRes: res.getCustomers()){
				for(Customer cus: customers){
					if(cusInRes.getCustomerID() == cus.getCustomerID()){
						customers.remove(cus);
					}
				}
			}
		}
		
		for(Apartment apa: apartments){
			for(Customer cus: customers){
				if(apa.getRoomID() == cus.getRoomID()){
					allFreeApartments.add(apa);
				}
			}
		}
		return allFreeApartments;
		
	}
	
	private LinkedList <String> getAllDays(String arrivalDate, String departureDate){
		LinkedList <String> allDays = new LinkedList<String>();
		
		int[] arrDate = new int[3];
		int[] depDate = new int[3];
		int[] dateInQuestion = new int[3];
		
		arrDate[0] = Integer.parseInt(arrivalDate.substring(0, 1));
		arrDate[1] = Integer.parseInt(arrivalDate.substring(3, 4));
		arrDate[2] = Integer.parseInt(arrivalDate.substring(6, 9));
		
		depDate[0] = Integer.parseInt(departureDate.substring(0, 1));
		depDate[1] = Integer.parseInt(departureDate.substring(3, 4));
		depDate[2] = Integer.parseInt(departureDate.substring(6, 9));
		
		dateInQuestion[0] = arrDate[0];
		dateInQuestion[1] = arrDate[1];
		dateInQuestion[2] = arrDate[2];
		
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		while((depDate[0]!=dateInQuestion[0])&&(depDate[1]!=dateInQuestion[1])&&(depDate[2]!=dateInQuestion[2])){
			
			allDays.add(dateInQuestion[0]+"-"+dateInQuestion[1]+"-"+dateInQuestion[2]);
			
			
			if((depDate[2]!=dateInQuestion[2])&&(dateInQuestion[0]>=31)&&(dateInQuestion[1]>=12)){	//New Year
				dateInQuestion[2]++;
				dateInQuestion[1] = 1;
				dateInQuestion[0] = 1;
			}else if(((dateInQuestion[2]%4)==0)&&(dateInQuestion[1] == 2)&&(dateInQuestion[0]==28)){	//Leap Year
				dateInQuestion[0] = 29;
			}else if(months[dateInQuestion[1]-1] >= dateInQuestion[0]){		//New Month
				dateInQuestion[1]++;
				dateInQuestion[0] = 1;
			}else{
				dateInQuestion[0]++;
			}
		}
		
		allDays.add(departureDate);
		
		return allDays;
	}
	
}