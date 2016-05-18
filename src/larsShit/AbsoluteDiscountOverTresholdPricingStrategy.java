package discount;

import databaseLayer.DBPricingStrategyValue;
import sale.Sale;

public class AbsoluteDiscountOverTresholdPricingStrategy implements ISalePricingStrategy {

	private double treshold;
	private double discount;
	
	@Override
	public double getTotal(Sale sale) {
		// Get current values from database
		DBPricingStrategyValue dbPriceStratVal = new DBPricingStrategyValue();
		String pricingStrategyName = "AbsoluteDiscountOverTresholdPricingStrategy";
		PricingStrategyValue actualPricingStrategyValue = dbPriceStratVal.getPricingStrategyValue(pricingStrategyName);
		treshold = actualPricingStrategyValue.getAbsoluteDiscountTreshold();
		discount = actualPricingStrategyValue.getAbsoluteDiscountAmount(); 
		
		// Calculate total
		double foundTotal = sale.getTotalBeforeDiscount();
		if (foundTotal > treshold) {
			foundTotal -= discount;
		}
		return foundTotal;
	}

}
