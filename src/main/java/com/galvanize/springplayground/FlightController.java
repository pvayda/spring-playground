package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

import static java.util.Calendar.APRIL;

@RestController
public class FlightController {
    @GetMapping("/flights/flight")
    public Flight getFlight(){ {
        Flight flight = new Flight();
        Date newDate = new Date(2017-1900, APRIL, 21, 14,34);
        flight.setDeparts(newDate);
        Flight.Person person1 = new Flight.Person("Jon", "Snow");
        Flight.Person person2 = new Flight.Person("Rob", "Stark");
        Flight.Ticket ticket = new Flight.Ticket(Arrays.asList(person1,person2), 200);
        flight.setTickets(Arrays.asList(ticket));
        return flight;
        }
    }

}
