package simple.boot;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import simple.boot.model.Address;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoApplicationRestTemplateTest {

	  @Test
	  public void restTemplateDo(){
		  RestTemplate restTemplate = new RestTemplate();
		  ResponseEntity<String> response  = restTemplate.getForEntity(
//				  "http://172.31.224.1:8080/a/", String.class);
		  		"http://localhost:8080/a/", String.class);
		  System.out.println(response.getBody());
		  
		  assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		  assertThat(response.getBody(), startsWith("{\"name\":\"a\""));
	  }

	  @Test
	  public void restTemplateDo2(){
		  RestTemplate restTemplate = new RestTemplate();

		  Address addr = restTemplate.getForObject("http://localhost:8080/a/", Address.class);
		  assertNotNull(addr);
		  assertEquals(addr.getName(), "a");
	  }

}
