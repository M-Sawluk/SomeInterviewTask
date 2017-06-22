package com.interview.comparators;

import com.interview.Fibonnacci.FibonacciNumbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Mike on 2017-04-13.
 */
@Component
public class Comparators {

    private static final Logger log = LoggerFactory.getLogger(FibonacciNumbers.class);

    public void sorts(){

        List<Employee> list = new ArrayList<>(Arrays
                .asList(new Employee("Michal","CywilEnginering" , 23),
                        new Employee("Karol","IT",20)));

        log.info(list.toString());

        Collections.sort(list);

        log.info(list.toString());

        list.sort(((Employee x ,Employee y) -> x.getDepartment().compareTo(y.getDepartment())));

        log.info(list.toString());

        list.sort(((Employee x ,Employee y) -> x.getAge()-y.getAge()));

        log.info(list.toString());
    }

}
