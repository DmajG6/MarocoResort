package discount;
import sale.Sale;

public interface ISalePricingStrategy {
	
	public double getTotal(Sale sale);
	
}
