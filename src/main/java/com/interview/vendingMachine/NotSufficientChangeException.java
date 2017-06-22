package com.interview.vendingMachine;

/**
 * Created by Mike on 2017-04-13.
 */
public class NotSufficientChangeException extends RuntimeException {

    private String msg;

    public NotSufficientChangeException(String s) {
        this.msg=s;
    }

    public String getMsg() {
        return msg;
    }
}
