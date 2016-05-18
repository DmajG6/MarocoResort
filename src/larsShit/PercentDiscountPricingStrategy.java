package discount;

import sale.Sale;
import databaseLayer.*;

public class PercentDiscountPricingStrategy implements ISalePricingStrategy {

	private double percentage;
	

	@Override
	public double getTotal(Sale sale) {
		// Get current value from database
		DBPricingStrategyValue dbPriceStratVal = new DBPricingStrategyValue();
		String pricingStrategyName = "PercentDiscountPricingStrategy";
		PricingStrategyValue actualPricingStrategyValue = dbPriceStratVal.getPricingStrategyValue(pricingStrategyName);
		percentage = actualPricingStrategyValue.getDiscountPercentage();
		
		double discount = sale.getTotalBeforeDiscount() * (percentage / 100);
		return (sale.getTotalBeforeDiscount() - discount);
	}

}
