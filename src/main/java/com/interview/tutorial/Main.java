package com.interview.tutorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mike on 2017-04-25.
 */
public class Main {

    public static void main(String[] args) {

        procesInput();

    }

    private static void procesInput() {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();

        while(scanner.hasNextInt()){
            int temp=scanner.nextInt();
            if(temp!=42)
                numbers.add(temp);
            else

                break;

        }
        System.out.println();
        for (Integer number : numbers) {
            System.out.println(number);
        }

    }


}
