package simple.boot;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTest {

	  @Autowired
	  WebApplicationContext webContext;
	  private MockMvc mockMvc;

	  @Before
	  public void setupMockMvc() {
	    mockMvc = MockMvcBuilders
	        .webAppContextSetup(webContext)
	        .build();
	  }

	  @Test
	  public void accessRoot() throws Exception {
	    mockMvc.perform(get("/a"))
	        .andExpect(status().is2xxSuccessful())
	        .andExpect(content().string(startsWith("{\"name\":\"a\""))) // {"name":"a","line1":"la1","line2":"la2"}
;
	  }
	  
}
