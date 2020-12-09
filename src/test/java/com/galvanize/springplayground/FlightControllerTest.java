package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {
    @Autowired
    MockMvc mvc;

//    {
//        "departs": "2017-04-21 14:34",
//            "tickets": [
//        {
//            "passenger": {
//            "firstName": "Some name",
//                    "lastName": "Some other name"
//        },
//            "price": 200
//        }
//  ]
//    }
    @Test
    public void testGetSingleFlight() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/flights/flight")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$.tickets.[0].passengers.[0].firstName", is("Jon")))
                .andExpect(jsonPath("$.tickets.[0].passengers.[0].lastName", is("Snow")))
                .andExpect(jsonPath("$.tickets.[0].price", is(200)));

    }
     //'/flights'
     @Test
     public void testGetFlights() throws Exception{
         RequestBuilder request = MockMvcRequestBuilders.get("/flights")
                 .accept(MediaType.APPLICATION_JSON_UTF8)
                 .contentType(MediaType.APPLICATION_JSON_UTF8);
         this.mvc.perform(request)
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[0].departs", is("2017-04-21 14:34")))
                 .andExpect(jsonPath("$[0].tickets.[0].passengers.[0].firstName", is("Jon")))
                 .andExpect(jsonPath("$[0].tickets.[0].passengers.[0].lastName", is("Snow")))
                 .andExpect(jsonPath("$[0].tickets.[0].price", is(200)))
                 .andExpect(jsonPath("$[1].departs", is("2017-02-21 14:34")))
                 .andExpect(jsonPath("$[1].tickets.[0].passengers.[0].firstName", is("Luke")))
                 .andExpect(jsonPath("$[1].tickets.[0].passengers.[0].lastName", is("Skywalker")))
                 .andExpect(jsonPath("$[1].tickets.[0].price", is(400)));


     }

}
