package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Flight {
    private Date departs;
    private List<Ticket> tickets;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "PST")
    public Date getDeparts() {
        return departs;
    }

    public void setDeparts(Date departs) {
        this.departs = departs;
    }

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

        public List<Person> getPassengers() {
            return passengers;
        }

        public void setPassengers(List<Person> passengers) {
            this.passengers = passengers;
        }

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

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

    }
}
