package discount;
import configuration.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PricingStrategyFactory {
	
	private static ISalePricingStrategy pricingStrategy;
    
    // an instance of the class is generated
    private static PricingStrategyFactory  instance = null;
    
    // Private constructor
    private PricingStrategyFactory() {
    	pricingStrategy = null;
		try {
			PricingProperties pricingProp = new PricingProperties();
			String pricingStrategyClassName = pricingProp.getPricingProperty("pricingstrategy");
					//new co this.getPricingStrategyClassName();
			System.out.println("pricingStrategyClassName" + pricingStrategyClassName);
			//pricingStrategy = (ISalePricingStrategy)Class.forName("discount.PercentDiscountPricingStrategy").newInstance();
			pricingStrategy = (ISalePricingStrategy)Class.forName(pricingStrategyClassName).newInstance();
		} catch(Exception ex) {
			//
		}
    }
    
    // returns the singleton instance of ISalePricingStrategy 
    public  ISalePricingStrategy getPricingStrategy() {
       return pricingStrategy;
    }
    // this method is used to get the instance
    public static PricingStrategyFactory getInstance() {
        if (instance == null) {
          instance = new PricingStrategyFactory();
        }
        return instance;
    }
    
//    private String getPricingStrategyClassName() {
//    	Properties prop = new Properties();
//    	InputStream input = null;
//    	String foundPricingStrategyClassName = null;
//
//    	try {
//
//    		input = new FileInputStream("config.properties");
//
//    		// load a properties file
//    		prop.load(input);
//
//    		// get the property value and print it out
//    		foundPricingStrategyClassName = prop.getProperty("pricingstrategy");
//    	} catch (IOException ex) {
//    		ex.printStackTrace();
//    	} finally {
//    		if (input != null) {
//    			try {
//    				input.close();
//    			} catch (IOException e) {
//    				e.printStackTrace();
//    			}
//    		}
//    	}
//    	return foundPricingStrategyClassName;
//    }
    
}
