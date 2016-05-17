package testData;

/**
	@author TomKuric<tomkuric@gmail.com>
	May 12, 2016 - 11:19:05 AM
*/

import controlLayer.*;

public class FillInTestDdata {

	private static ApartmentController apctr = new ApartmentController();
	
	
	public static void main(String[] args){
		
		for(int e = 0; e<10; e++){
			for(int i = 1; i<5; i++){
				apctr.createApartment(1+(100*i), "family", 60, i, "no");
			}
		
		}
	}
}