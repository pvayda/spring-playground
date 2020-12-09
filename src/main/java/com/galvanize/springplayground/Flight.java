package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class Flight {
    private Date departs;
    private List<Ticket> tickets;

    @JsonProperty("Departs")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "PST")
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }
    @JsonProperty("Tickets")
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static class Ticket{
        private List<Person> passengers;
        private int price;

        public Ticket(List<Person> personList, int price) {
            this.passengers = personList;
            this.price = price;
        }
        @JsonProperty("Passengers")
        public List<Person> getPassengers() {
            return passengers;
        }

        public void setPassengers(List<Person> passengers) {
            this.passengers = passengers;
        }
        @JsonProperty("Price")
        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
    public static class Person {
        private String firstName;
        private String lastName;
        Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        @JsonProperty("FirstName")
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        @JsonIgnore
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    }
}
