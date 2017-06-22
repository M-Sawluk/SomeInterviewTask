package com.interview.vendingMachine;

/**
 * Created by Mike on 2017-04-13.
 */
public enum Item {

    COKE("Coke", 2.5),
    PEPSI("Pepsi", 3.5),
    CHIPS("Lays", 4.0);

    private String name;

    private double price;

    Item(String name,double price){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
