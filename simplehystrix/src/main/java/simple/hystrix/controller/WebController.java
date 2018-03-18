package simple.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import simple.hystrix.model.Address;
import simple.hystrix.service.ServiceWithHystrix;

@RestController
public class WebController {

	@Autowired
	ServiceWithHystrix serviceWithHystrix;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String help() {
    	
        return "docircuitbreak or dofallback";
    }

    @RequestMapping(value="/docircuitbreak/{name}/{sleep}",method = RequestMethod.GET)
    public Address getWithCircuitBreaker( @PathVariable("name") String name, @PathVariable("sleep") long sleep ) {
    	
        return serviceWithHystrix.getAddressWithCircuitBreaker(name, sleep);
    }

    @RequestMapping(value="/dofallback/{name}/{sleep}",method = RequestMethod.GET)
    public Address getLicensesByOrgWithFallback( @PathVariable("name") String name, @PathVariable("sleep") long sleep ) {
    	
        return serviceWithHystrix.getAddressWithFallback(name, sleep);
    }
    

}
