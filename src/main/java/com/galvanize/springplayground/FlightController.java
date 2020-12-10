package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.util.Calendar.APRIL;

@RestController
public class FlightController {
    @GetMapping("/flights/flight")
    public Flight getFlight(){
        Flight flight = new Flight();
        Date newDate = new Date(2017-1900, APRIL, 21, 14,34);
        flight.setDeparts(newDate);
        Flight.Ticket.Person person1 = new Flight.Ticket.Person("Jon", "Snow");
        Flight.Ticket.Person person2 = new Flight.Ticket.Person("Rob", "Stark");
        Flight.Ticket ticket1 = new Flight.Ticket(person1, 200);
        Flight.Ticket ticket2 = new Flight.Ticket(person2, 200);
        flight.setTickets(Arrays.asList(ticket1, ticket2));
        return flight;

    }
    @GetMapping("/flights")
    public List<Flight> getFlights(){
        Flight flight1 = new Flight();
        Date newDate = new Date(2017-1900, APRIL, 21, 14,34);
        flight1.setDeparts(newDate);
        Flight.Ticket.Person person1 = new Flight.Ticket.Person("Jon", "Snow");
        Flight.Ticket.Person person2 = new Flight.Ticket.Person("Rob", "Stark");
        Flight.Ticket ticket1 = new Flight.Ticket(person1, 200);
        Flight.Ticket ticket2 = new Flight.Ticket(person2, 200);
        flight1.setTickets(Arrays.asList(ticket1, ticket2));

        Flight flight2 = new Flight();
        Date newDate2 = new Date(2017-1900, Calendar.FEBRUARY, 21, 14,34);
        flight2.setDeparts(newDate2);
        Flight.Ticket.Person person3 = new Flight.Ticket.Person("Luke", "Skywalker");
        Flight.Ticket.Person person4 = new Flight.Ticket.Person("Han", "Solo");
        Flight.Ticket ticket3 = new Flight.Ticket(person3, 400);
        Flight.Ticket ticket4 = new Flight.Ticket(person4, 400);
        flight2.setTickets(Arrays.asList(ticket3, ticket4));
        return Arrays.asList(flight1, flight2);
    }
    //POST request to /flights/tickets/total
    @PostMapping("/flights/tickets/total")
    public String getTotalPrice(@RequestBody Flight flight) throws Exception{

        return flight.toString();

        //return "{ 'result': 350}";

    }

}
