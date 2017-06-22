package com.interview.Fibonnacci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mike on 2017-04-13.
 */
@Component
public class FibonacciNumbers {

    private static final Logger log = LoggerFactory.getLogger(FibonacciNumbers.class);

    public void printFibonacci(){

        int x=1;
        int y=1;

        List<Integer> numbers = new ArrayList<>(Arrays.asList(x,y));

        while(x<100 && y<100){
            x+=y;
            y+=x;

            if(x<100)
                numbers.add(x);
            if(y<100)
                numbers.add(y);
        }

        log.info(numbers.toString());
    }


}
