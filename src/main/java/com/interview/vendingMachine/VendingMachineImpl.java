package com.interview.vendingMachine;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Mike on 2017-04-13.
 */

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Item> itemsInInventory = new Inventory<Item>();
    private Inventory<Coin> coinInInventory = new Inventory<Coin>();
    private long totalSales;
    private Item currentItem;
    private double currentBalance;

    private static final Logger log = LoggerFactory.getLogger(VendingMachineImpl.class);

    public VendingMachineImpl() {
        init();
    }

    private void init(){
        for(Coin c: Coin.values()){
            coinInInventory.putNewItem(c,3);
        }

        for(Item c: Item.values()){
            itemsInInventory.putNewItem(c,3);
        }

    }

    @Override
    public double selectItemAndGetPrice(Item item) {
       if(itemsInInventory.hasItem(item)){
           currentItem = item;
           return item.getPrice();
       }
       throw new SoldOutException("Sold Out, select another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        coinInInventory.add(coin);
        currentBalance+=coin.getDenomination();
    }

    @Override
    public List<Coin> refund() {
        double balanceToRefund = this.currentBalance;
        this.currentBalance=0;
        currentItem=null;
        return getChange(balanceToRefund);
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {

        List<Coin> change = getChange(this.currentBalance-currentItem.getPrice());

        Item item = collectItem();

        this.totalSales+=currentItem.getPrice();

        return new Bucket(item,change);

    }

    @Override
    public void reset() {
        this.coinInInventory.clear();
        this.itemsInInventory.clear();
        this.totalSales=0;
        this.currentItem=null;
        this.currentBalance=0;
    }

    private Item collectItem(){

        if(this.currentBalance>=currentItem.getPrice()){
                itemsInInventory.deduct(currentItem);
                return currentItem;
        }
        double remainingToPay = currentItem.getPrice()-this.currentBalance;

        throw new NotFullyPaidException("Price not full paid, remaining: " , remainingToPay);
    }

    private List<Coin> getChange(double x)  throws NotSufficientChangeException{

        double change = x;

        Inventory<Coin> copyCoinsInInventory = new Inventory<>();

        for(Coin c: Coin.values()){
            if(coinInInventory.hasItem(c)){
                copyCoinsInInventory.putNewItem(c,coinInInventory.getQuantity(c));
            }
        }

        List<Coin> listOfCoins = new ArrayList<>();

        Coin[] coin = Coin.values();

        for(int i=coin.length-1;i>=0;i--){
            if(copyCoinsInInventory.hasItem(coin[i]) && coin[i].getDenomination()<=change ){
                listOfCoins.add(coin[i]);
                change-=coin[i].getDenomination();
                copyCoinsInInventory.deduct(coin[i]);
                i++;
            }
        }


        if(change<0.001) {

            for (Coin coin1 : listOfCoins) {
                coinInInventory.deduct(coin1);
            }

            return listOfCoins;

        }else{
            throw new NotSufficientChangeException("Not Sufficient change in inventory");}

    }

    public Inventory<Coin> getCoinInInventory(){
        return coinInInventory;
    }

}
