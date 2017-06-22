package com.interview.primeNumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mike on 2017-04-20.
 */
public class Primes {

    public static void main(String args[]){

        System.out.println(getPrimes(2000));


    }


    public static List<Integer> getPrimes(int x){

        List<Integer> primes = new LinkedList<>();
        int multiplier =2;
        int nextValue=0;

        for (int i=2;i<=x;i++){
            primes.add(i);
        }

        while(primes.indexOf(primes.get(nextValue))!=primes.size()-1) {

            int primeNumber = primes.get(nextValue);

            while (primeNumber*multiplier<=x){
                if(primes.contains(primeNumber*multiplier)){
                primes.remove(primes.indexOf(primeNumber * multiplier));
                }
                multiplier++;
            }
            multiplier=2;
            nextValue++;
        }


        return primes;
    }


}
