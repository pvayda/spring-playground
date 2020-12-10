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
        Person person1 = new Person("Jon", "Snow");
        Person person2 = new Person("Rob", "Stark");
        Ticket ticket1 = new Ticket(person1, 200);
        Ticket ticket2 = new Ticket(person2, 200);
        flight.setTickets(Arrays.asList(ticket1, ticket2));
        return flight;

    }
    @GetMapping("/flights")
    public List<Flight> getFlights(){
        Flight flight1 = new Flight();
        Date newDate = new Date(2017-1900, APRIL, 21, 14,34);
        flight1.setDeparts(newDate);
        Person person1 = new Person("Jon", "Snow");
        Person person2 = new Person("Rob", "Stark");
        Ticket ticket1 = new Ticket(person1, 200);
        Ticket ticket2 = new Ticket(person2, 200);
        flight1.setTickets(Arrays.asList(ticket1, ticket2));

        Flight flight2 = new Flight();
        Date newDate2 = new Date(2017-1900, Calendar.FEBRUARY, 21, 14,34);
        flight2.setDeparts(newDate2);
        Person person3 = new Person("Luke", "Skywalker");
        Person person4 = new Person("Han", "Solo");
        Ticket ticket3 = new Ticket(person3, 400);
        Ticket ticket4 = new Ticket(person4, 400);
        flight2.setTickets(Arrays.asList(ticket3, ticket4));
        return Arrays.asList(flight1, flight2);
    }
    @PostMapping("/flights/person")
    public Person getPerson(@RequestBody Person person) throws Exception {
        return person;
    }
    @PostMapping("/flights/ticket")
    public Ticket getTicket(@RequestBody Ticket ticket) throws Exception {
        return ticket;
    }
    //POST request to /flights/tickets/total
    @PostMapping("/flights/tickets/total")
    public String getTotalPrice(@RequestBody Flight flight) throws Exception{
        return flight.calcTicketTotal();

    }

}
