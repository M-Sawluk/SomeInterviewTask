package com.interview.Mailer;

/**
 * Created by Mike on 2017-04-14.
 */
public class NameMsgsPair<E1,E2> {
    private E1 name;

    private E2 list;

    public NameMsgsPair(E1 name, E2 list) {
        this.name = name;
        this.list = list;
    }

    public NameMsgsPair() {
    }

    public E1 getName() {
        return name;
    }

    public E2 getList() {
        return list;
    }

    public void setName(E1 name) {
        this.name = name;
    }

    public void setList(E2 list) {
        this.list = list;
    }
}
