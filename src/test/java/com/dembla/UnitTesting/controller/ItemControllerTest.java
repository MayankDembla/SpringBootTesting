package com.dembla.UnitTesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc ;


    @Test
    void helloWorld() throws Exception {

        // Create the Request

        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON) ;
        MvcResult result = mockMvc.perform(request)
                                  .andExpect(status().isOk())
                                   // We can also Check the Half or partial json as well.
                                  .andExpect(content().json("{\n" +
                                          "    \"name\": \"Ball\",\n" +
                                          "    \"id\": 10,\n" +
                                          "    \"price\": 100\n" +
                                          "}"))
                                  .andReturn();

    }


    @Test
    void helloWorld_partialJsonCheck() throws Exception {

        // Create the Request

        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON) ;
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                // Only Check ID
                .andExpect(content().json("{\n" +
                        "    \"id\": 10" +
                        "}"))
                .andReturn();

    }
}