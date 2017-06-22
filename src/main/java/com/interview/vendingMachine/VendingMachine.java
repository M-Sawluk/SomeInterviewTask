package com.interview.vendingMachine;

import java.util.List;

/**
 * Created by Mike on 2017-04-13.
 */
public interface VendingMachine {

    double selectItemAndGetPrice(Item item);

    void insertCoin(Coin coin);

    List<Coin> refund();

    Bucket<Item,List<Coin>> collectItemAndChange();

    void reset();

    Inventory<Coin> getCoinInInventory();


}
