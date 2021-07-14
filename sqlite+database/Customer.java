package com.company;

import lombok.ToString;

@ToString

//pojo
public class Customer {
    public int id;
    public String firstname;
    public String lastname;
    public int numberoforders;
    public double height;

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname, int numberoforders, double height) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.numberoforders = numberoforders;
        this.height = height;
    }
}
