package com.interview.vendingMachine;

/**
 * Created by Mike on 2017-04-13.
 */
public class NotFullyPaidException extends RuntimeException {

    private String msg;

    private double price;

    public NotFullyPaidException(String s, double remainingToPay) {
        this.msg=s;
        this.price=remainingToPay;
    }

    public String getMsg() {
        return msg+price;
    }

    public double getPrice() {
        return price;
    }
}
