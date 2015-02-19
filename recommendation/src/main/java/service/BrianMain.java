package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import parser.Constants;

public class BrianMain {

	public static void main(String[] args) {
		BrianMain main = new BrianMain();
		main.loadThresholdValues();
	}
	
	private void loadThresholdValues()
	{

		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "threshold.properties";
			input = BrianMain.class.getClassLoader().getResourceAsStream(filename);
			if(input==null){
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			//load a properties file from class path, inside static method
			prop.load(input);

			//get the property value and print it out
		
			Constants.CPM_THRESHOLD =Integer.parseInt(prop.getProperty("cpm_threshold"));
			Constants.CATEGORIES_THRESHOLD =Integer.parseInt(prop.getProperty("categories_threshold"));
			Constants.SITES_THRESHOLD =Integer.parseInt(prop.getProperty("sites_threshold"));
			Constants.ADTAGS_THRESHOLD =Integer.parseInt(prop.getProperty("adtags_threshold"));
			Constants.GEOS_THRESHOLD =Integer.parseInt(prop.getProperty("geos_threshold"));
			Constants.OFFER_THRESHOLD =Integer.parseInt(prop.getProperty("offer_threshold"));
			
			Constants.WEIGHT_CPM =Integer.parseInt(prop.getProperty("weight_cpm"));
			Constants.WEIGHT_CATEGORIES =Integer.parseInt(prop.getProperty("weight_categories"));
			Constants.WEIGHT_SITES =Integer.parseInt(prop.getProperty("weight_sites"));
			Constants.WEIGHT_ADTAGS =Integer.parseInt(prop.getProperty("weight_adtags"));
			Constants.WEIGHT_GEOS =Integer.parseInt(prop.getProperty("weight_geos"));
			Constants.WEIGHT_ADCODETYPES =Integer.parseInt(prop.getProperty("weight_adCodeTypes"));
			Constants.WEIGHT_PLATFORMS =Integer.parseInt(prop.getProperty("weight_platforms"));


		} catch (IOException ex) {
			ex.printStackTrace();
		} finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	
		
	}


}
