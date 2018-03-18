package simple.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import simple.hystrix.model.Address;
import simple.hystrix.restclient.RestTemplateClient;

@Service
public class ServiceWithHystrix {
	
    @Autowired
    RestTemplateClient  restTemplateClient;
    
    
    @HystrixCommand(
            commandProperties={
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
//                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="10000")
            	}
    		)
    public Address getAddressWithCircuitBreaker(String name, long sleepSecs){
    	return restTemplateClient.getAddress(name, sleepSecs);
    }

    @HystrixCommand( fallbackMethod = "fallingBack" )
    public Address getAddressWithFallback(String name, long sleepSecs){
        return restTemplateClient.getAddress(name, sleepSecs);
    }

    private Address fallingBack(String name, long sleepSecs){
    	return new Address().withName("Fallback Fake Address")
    			.withLine1("address line 1")
    			.withLine2("Address line 2");
    }

}
