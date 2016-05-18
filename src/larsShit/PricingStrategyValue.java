package discount;

public class PricingStrategyValue {
	
	private String pricingStrategy;
	private double discountPercentage;
	private double absoluteDiscountTreshold;
	private double absoluteDiscountAmount;
	
	
	public PricingStrategyValue(String pricingStrategy, double discountPercentage, double absoluteDiscountTreshold,
			double absoluteDiscountAmount) {
		super();
		this.pricingStrategy = pricingStrategy;
		this.discountPercentage = discountPercentage;
		this.absoluteDiscountTreshold = absoluteDiscountTreshold;
		this.absoluteDiscountAmount = absoluteDiscountAmount;
	}

	public PricingStrategyValue(String pricingStrategy, double discountPercentage) {
		super();
		this.pricingStrategy = pricingStrategy;
		this.discountPercentage = discountPercentage;
	}

	public PricingStrategyValue(String pricingStrategy, double absoluteDiscountTreshold, double absoluteDiscountAmount) {
		this.pricingStrategy = pricingStrategy;
		this.absoluteDiscountTreshold = absoluteDiscountTreshold;
		this.absoluteDiscountAmount = absoluteDiscountAmount;
	}
	
	public String getPricingStrategy() {
		return pricingStrategy;
	}
	public void setPricingStrategy(String pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public double getAbsoluteDiscountTreshold() {
		return absoluteDiscountTreshold;
	}
	public void setAbsoluteDiscountTreshold(double absoluteDiscountTreshold) {
		this.absoluteDiscountTreshold = absoluteDiscountTreshold;
	}
	public double getAbsoluteDiscountAmount() {
		return absoluteDiscountAmount;
	}
	public void setAbsoluteDiscountAmount(double absoluteDiscountAmount) {
		this.absoluteDiscountAmount = absoluteDiscountAmount;
	}

	
	
}
//