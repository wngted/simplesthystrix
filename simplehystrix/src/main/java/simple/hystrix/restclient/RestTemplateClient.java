package simple.hystrix.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import simple.hystrix.model.Address;


@Component
public class RestTemplateClient {

	@Autowired
    RestTemplate restTemplate;
    
    private static String localServiceUrl = "http://localhost:8080";
    
    public Address getAddress(String name, long sleepSecs){
//		  RestTemplate restTemplate = new RestTemplate();

		  Address addr = restTemplate.getForObject( localServiceUrl + "/" + name + "/" + sleepSecs, Address.class);
		  return addr;
    }

}
