package com.interview.vendingMachine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mike on 2017-04-13.
 */
public class Inventory<T> {

    private Map<T,Integer> inventory = new HashMap<T,Integer>();

    public int getQuantity(T item){
        Integer value = inventory.get(item);
        return value == null? 0:value;
    }

    public void add(T item){
        int count = inventory.get(item);
        inventory.put(item,count+1);
    }

    public void deduct(T item) {
        if (inventory.containsKey(item)) {
            int count = inventory.get(item);
            if (count == 0)
                inventory.remove(item);
            else
                inventory.put(item, count - 1);
        }
    }
    public boolean hasItem(T item){
            if(inventory.get(item)!=null && inventory.get(item)>0)
                return true;
            else
                return false;
    }

    public void clear(){
        inventory.clear();
    }

    public void putNewItem(T item,int quantity){
        inventory.put(item,quantity);
    }

    public Set<T> getItems(){
        return inventory.keySet();
    }
}
