package com.dembla.UnitTesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\n" +
            "    \"name\": \"Ball\",\n" +
            "    \"id\": 10,\n" +
            "    \"price\": 100\n" +
            "}" ;

    @Test
    public void jsonAssert_StrictTrue_EaxctmathcerSpaces() throws JSONException {

        // JSON need to have all attributes if Strict flag is true
        String expectedResult = "{\"name\": \"Ball\",\n" + "\"id\": 10,\n" + "\"price\": 100}" ;
        JSONAssert.assertEquals(expectedResult,actualResponse, true);

    }

    @Test
    public void jsonAssert_StrictFalse_ExactmatcherSpaces() throws Exception {
        String expectedResult = "{\"name\": \"Ball\",\n" + "\"id\": 10}" ;
        JSONAssert.assertEquals(expectedResult,actualResponse, false);
    }

}
