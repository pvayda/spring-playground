package com.galvanize.springplayground;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

        private String firstName;
        private String lastName;
        public Person(){};
        public Person(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        //@JsonProperty("FirstName")
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        //@JsonIgnore
        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName:'" + firstName + '\'' +
                    ", lastName:'" + lastName + '\'' +
                    '}';
        }
}
