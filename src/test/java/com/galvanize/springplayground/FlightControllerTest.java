package com.galvanize.springplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$.Tickets.[0].Passenger.FirstName", is("Jon")))
                //.andExpect(jsonPath("$.Tickets.[0].Passengers.[0].lastName", is("Snow")))
                .andExpect(jsonPath("$.Tickets.[0].Price", is(200)));

    }
     //'/flights'
     @Test
     public void testGetFlights() throws Exception{
         RequestBuilder request = MockMvcRequestBuilders.get("/flights")
                 .accept(MediaType.APPLICATION_JSON)
                 .contentType(MediaType.APPLICATION_JSON);
         this.mvc.perform(request)
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$[0].Departs", is("2017-04-21 14:34")))
                 .andExpect(jsonPath("$[0].Tickets.[0].Passenger.FirstName", is("Jon")))
                 //.andExpect(jsonPath("$[0].Tickets.[0].Passengers.[0].lastName", is("Snow")))
                 .andExpect(jsonPath("$[0].Tickets.[0].Price", is(200)))
                 .andExpect(jsonPath("$[1].Departs", is("2017-02-21 14:34")))
                 .andExpect(jsonPath("$[1].Tickets.[0].Passenger.FirstName", is("Luke")))
                 //.andExpect(jsonPath("$[1].Tickets.[0].Passengers.[0].lastName", is("Skywalker")))
                 .andExpect(jsonPath("$[1].Tickets.[0].Price", is(400)));


     }
    @Test
    public void testGetTotalPrice() throws Exception {
//        RequestBuilder request = post("/flights/tickets/total")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"tickets\": [{\"passenger\": {\"firstName\": \"Some name\",\"lastName\": \"Some other name\"" +
//                        "}\"price\": 200" +
//                        "}," +
//                        "{" +
//                        "\"passenger\": {" +
//                        "\"firstName\": \"Name B\"," +
//                        "\"lastName\": \"Name C\"" +
//                        "}," +
//                        "\"price\": 150" +
//                        "}" +
//                        "]" +
//                        "}");
        this.mvc.perform(post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"tickets\": [{\"passenger\": {\"firstName\": \"Some name\",\"lastName\": \"Some other name\"" +
                        "}\"price\": 200" +
                        "}," +
                        "{" +
                        "\"passenger\": {" +
                        "\"firstName\": \"Name B\"," +
                        "\"lastName\": \"Name C\"" +
                        "}," +
                        "\"price\": 150" +
                        "}" +
                        "]" +
                        "}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));

    }
}
