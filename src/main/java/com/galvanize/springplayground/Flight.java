package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.List;

public class Flight {
    private Date departs;
    private List<Ticket> tickets;
    public Flight() {};
    //@JsonProperty("Departs")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "PST")
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }
    //@JsonProperty("Tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    public String calcTicketTotal(){
        int ticketTotal = 0;
        for(Ticket each: tickets){
            ticketTotal += each.getPrice();
        }
        return String.format("{\"result\": %d}", ticketTotal);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "\"departs\":" + departs +
                ", \"tickets\":" + tickets +
                '}';
    }



}
