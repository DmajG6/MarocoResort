package controlLayer;

import modelLayer.*;
import dbLayer.*;
import java.sql.Date;
import java.util.LinkedList;

public class ReservationOfStayController {
	
	private LinkedList<ReservationOfStay> manyReservations = new LinkedList<ReservationOfStay>();
	
	private DbReservationOfStay dbReservationOfStay = new DbReservationOfStay();
	
	private DbCustomer dbCustomer = new DbCustomer();
	
		
	public ReservationOfStayController() {
		
	}

	public void createReservationOfStay( int durationOfStay, Date arrivalDate, Date departureDate, String paymentInfo, String paymentConfirmation, Date dateOfReservation, double discount, double price, LinkedList<Customer> customers){
		//Staff & Agency have to be added also
		
		ReservationOfStay reservationOfStay = new ReservationOfStay(durationOfStay, arrivalDate, departureDate, paymentInfo, paymentConfirmation, dateOfReservation, discount, price, customers);
		reservationOfStay.setReservationID(DbReservationOfStay.getNewID());
		
		//Transaction
		
		dbReservationOfStay.insertReservationOfStay(reservationOfStay);
	}
	
	//Get All Reservations
	public LinkedList<ReservationOfStay> getAllReservaions(){
		manyReservations = dbReservationOfStay.getAllReservations();
			return manyReservations;
	}
	
	//Get ReservationOfStay by reservationID
	public ReservationOfStay findReservationOfStay(int ReservationID){
			ReservationOfStay reservation = dbReservationOfStay.findReservationOfStay(ReservationID);
			return reservation;
	}

	public void createReservationOfStay(int parseInt, int parseInt2, String text, String text2, double parseDouble,
			double parseDouble2, String text3) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkRoomAvailability(String arrivalDate, String departureDate){
		Room rooms[] = 
		
		LinkedList <String> allDays = getAllDays(arrivalDate, departureDate);
		
		
		
		
	}
	
	private LinkedList <String> getAllDays(String arrivalDate, String departureDate){
		LinkedList <String> allDays = new LinkedList<String>();
		
		int[] arrDate = new int[3];
		int[] depDate = new int[3];
		int[] dateInQuestion = new int[3];
		
		allDays.add(arrivalDate);
		
		arrDate[0] = Integer.parseInt(arrivalDate.substring(0, 1));
		arrDate[1] = Integer.parseInt(arrivalDate.substring(2, 3));
		arrDate[2] = Integer.parseInt(arrivalDate.substring(4, 7));
		
		depDate[0] = Integer.parseInt(departureDate.substring(0, 1));
		depDate[1] = Integer.parseInt(departureDate.substring(2, 3));
		depDate[2] = Integer.parseInt(departureDate.substring(4, 7));
		
		dateInQuestion[0] = Integer.parseInt(arrivalDate.substring(0, 1));
		dateInQuestion[1] = Integer.parseInt(arrivalDate.substring(2, 3));
		dateInQuestion[2] = Integer.parseInt(arrivalDate.substring(4, 7));
		
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		while((depDate[0]!=dateInQuestion[0])&&(depDate[1]!=dateInQuestion[1])&&(depDate[2]!=dateInQuestion[2])){
			
			allDays.add(dateInQuestion[0]+""+dateInQuestion[1]+""+dateInQuestion[2]);
			
			
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
