package com.interview.vendingMachine;

/**
 * Created by Mike on 2017-04-13.
 */
public class SoldOutException extends RuntimeException {

    private String msg;

    public SoldOutException(String s) {
        this.msg=s;
    }

    public String getMsg() {
        return msg;
    }
}
