package com.galvanize.springplayground;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
                //.andExpect(content().string("Hello"))
                .andExpect(jsonPath("$.departs", is("2017-04-21 14:34")))
                .andExpect(jsonPath("$.tickets.[0].passenger.firstName", is("Jon")))
                //.andExpect(jsonPath("$.Tickets.[0].Passengers.[0].lastName", is("Snow")))
                .andExpect(jsonPath("$.tickets.[0].price", is(200)));

    }
     //'/flights'
     @Test
     public void testGetFlights() throws Exception{
         RequestBuilder request = MockMvcRequestBuilders.get("/flights")
                 .accept(MediaType.APPLICATION_JSON)
                 .contentType(MediaType.APPLICATION_JSON);
         this.mvc.perform(request)
                 .andExpect(status().isOk())
                 //.andExpect(content().string("Hello"))
                 .andExpect(jsonPath("$.[0].departs", is("2017-04-21 14:34")))
                 .andExpect(jsonPath("$.[0].tickets.[0].passenger.firstName", is("Jon")))
                 //.andExpect(jsonPath("$[0].Tickets.[0].Passengers.[0].lastName", is("Snow")))
                 .andExpect(jsonPath("$.[0].tickets.[0].price", is(200)))
                 .andExpect(jsonPath("$.[1].departs", is("2017-02-21 14:34")))
                 .andExpect(jsonPath("$.[1].tickets.[0].passenger.firstName", is("Luke")))
                 //.andExpect(jsonPath("$[1].Tickets.[0].Passengers.[0].lastName", is("Skywalker")))
                 .andExpect(jsonPath("$.[1].tickets.[0].price", is(400)));


     }
     @Test
    public void testPostPerson() throws Exception {
         this.mvc.perform(post("/flights/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"Jon\", \"lastName\": \"Snow\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"firstName\":\"Jon\",\"lastName\":\"Snow\"}"));
    }
    @Test public void testPostTicket() throws Exception {
        this.mvc.perform(post("/flights/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"passenger\": {\"firstName\": \"Jon\",\"lastName\": \"Snow\"}, \"price\": 200}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"passenger\":{\"firstName\":\"Jon\",\"lastName\":\"Snow\"},\"price\":200}"));
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
//        FileReader reader = new FileReader("jsonTest.json");
//        JSONParser json = new JSONParser();

        this.mvc.perform(post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"tickets\": [{\"passenger\": {\"firstName\": \"Some name\",\"lastName\": \"Some other name\"" +
                        "},\"price\": 200" +
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
                //.andExpect(content().string("Hello"));
                .andExpect(jsonPath("$.result", is(350)));

    }
    @Test
    public void getTotalPriceFromFile() throws Exception {
        FileReader reader = new FileReader("jsonTest.json");
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) obj;
        this.mvc.perform(post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonObject.toJSONString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));

    }
}
