package testData;

/**
	@author TomKuric<tomkuric@gmail.com>
	May 12, 2016 - 11:19:05 AM
*/

import controlLayer.*;

public class FillInTestDdata {

	private static ApartmentController apctr = new ApartmentController();
	
	public static void main(String[] args){
		
		apctr.createApartment(101, "single", 60, 1, null, "no");
		
		
	}

}
