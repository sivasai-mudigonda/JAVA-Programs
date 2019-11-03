package controller;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.Feature;

@RestController
public class FF_FeaturesController {
    
	// GET Method to return status of features 
    public Feature[] getFeatures() throws JsonMappingException, IOException {
    	final String uri = "http://localhost:12300/featureflags";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        String body = result.getBody();
        ObjectMapper mapper = new ObjectMapper();
        Feature[] features = mapper.readValue(body, Feature[].class);
        return features;
    }
    
    // Method to update feature. 
    @RequestMapping(value="/updateValue/{value}/{name}", method = RequestMethod.POST)
    public void updateFeature(@PathVariable(value = "value") Integer value,
    		           @PathVariable(value = "name") String name) throws JsonProcessingException {
    	final String uri = "http://localhost:12300/featureflags";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Feature feature = new Feature(value, name);
        restTemplate.postForEntity( uri, feature, Feature[].class);
        System.out.println("End of updateFeature() ");
    }
    
    @Test
    public void getFeatureTest() throws JsonMappingException, IOException {
    	getFeatures();
    }
}
