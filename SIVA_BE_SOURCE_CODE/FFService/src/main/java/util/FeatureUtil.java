package util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonMappingException;

import controller.FF_FeaturesController;
import pojo.Feature;

public class FeatureUtil {
	
	@Autowired
	FF_FeaturesController ffController;
	
	public void getValue() throws JsonMappingException, IOException {
		 Feature[] features = ffController.getFeatures();
		 for(Feature feature : features) {
			 String name = feature.getName(); 
			 String value = Integer.toBinaryString(feature.getValue());
			 System.out.println("Name = "+name);
			 System.out.println("Value = "+value);
		 }
	}

}
