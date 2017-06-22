package com.interview.inputStreams;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

public class Main{


    public static void main(String[] args) {
        Map<String,Integer> list = new LinkedHashMap<>();

        list.put("A",1);
        list.put("c",2);
        list.put("B",2);

        List<String> keys = new LinkedList<>(list.keySet());

        Double truncatedDouble = BigDecimal.valueOf(0.0134)
                .setScale(3, RoundingMode.HALF_UP)
                .doubleValue();

        System.out.println(String.format("%.40f",truncatedDouble));

        System.out.printf("now: %s%n", LocalDateTime.now());

        System.out.printf("Apr 15, 1994 @ 11:30am: %s%n ",
                LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

        System.out.printf("now (from Instant): %s%n ",
                LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

        System.out.printf("6 months from now: %s%n ",
                LocalDateTime.now().plusMonths(6));

        System.out.printf("6 months ago: %s%n",
                LocalDateTime.now().minusMonths(6));
    }

}
