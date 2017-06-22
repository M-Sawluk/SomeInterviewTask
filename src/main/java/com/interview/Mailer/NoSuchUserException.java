package com.interview.Mailer;

/**
 * Created by Mike on 2017-04-14.
 */
public class NoSuchUserException extends RuntimeException {

    private String msg;

    public NoSuchUserException(String s) {
        this.msg=s;
    }

    public String getMsg() {
        return msg;
    }
}
