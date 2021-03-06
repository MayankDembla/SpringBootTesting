package com.dembla.UnitTesting.integration;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    // Class Allow us to make calls
    @Autowired
    private TestRestTemplate restTemplate ;

   @Test
    public void contextLoads() throws JSONException {
       String response = this.restTemplate.getForObject("/all-items", String.class);
       JSONAssert.assertEquals("[{id:1000},{id:1002},{id:1003},{id:1004}]",response,false) ;
   }

}
