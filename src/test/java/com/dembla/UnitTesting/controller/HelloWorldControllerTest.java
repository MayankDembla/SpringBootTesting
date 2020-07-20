package com.dembla.UnitTesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @Test
    void helloWorld_basic() throws Exception {

        // call URI "/hello"
        RequestBuilder request = MockMvcRequestBuilders
                                    .get("/hello")
                                    .accept(MediaType.APPLICATION_JSON) ;

         MvcResult result = mockMvc.perform(request)
                                   .andExpect(status().isOk())
                                   .andExpect(content().string("Hello World"))
                                   .andReturn() ;

        // verify "Hello-World"
//        assertEquals("Hello World", result.getResponse().getContentAsString());
    }
}