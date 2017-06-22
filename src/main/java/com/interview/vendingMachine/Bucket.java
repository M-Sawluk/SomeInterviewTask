package com.interview.vendingMachine;

/**
 * Created by Mike on 2017-04-13.
 */
public class Bucket<E1,E2> {

    private E1 item;
    private E2 coins;

    public Bucket(E1 item, E2 coins) {
        this.item = item;
        this.coins = coins;
    }

    public E1 getItem() {
        return item;
    }

    public E2 getCoins() {
        return coins;
    }
}
