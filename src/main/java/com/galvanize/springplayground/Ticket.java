package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticket {
    private Person passenger;
    private int price;
    public Ticket(){};
    public Ticket(Person person, int price) {
        this.passenger = person;
        this.price = price;
    }
    //@JsonProperty("Passenger")
    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger;
    }
    //@JsonProperty("Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "\"passenger\":" + passenger +
                ", \"price\":" + price +
                '}';
    }



}
