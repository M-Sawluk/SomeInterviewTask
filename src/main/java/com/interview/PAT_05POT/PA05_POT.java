package com.interview.PAT_05POT;

import java.util.Scanner;

public class PA05_POT {

    public static void main(String[] args) {
        PA05_POT papot = new PA05_POT();
        papot.printEndingNumber();
    }

    public void printEndingNumber(){

        StringBuilder stringBuilder = new StringBuilder();
        int[][] tableOfCases = collectData();
        int endingNumber;
        for (int i = 0; i <tableOfCases.length ; i++) {
            endingNumber=getEndingNumbers(tableOfCases[i][0],tableOfCases[i][1]);
            stringBuilder.append(endingNumber).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public int[][] collectData(){

        int[][] cases;
        int numberOfCases;
        Scanner scanner = new Scanner(System.in);

        numberOfCases=scanner.nextInt();

        cases = new int[numberOfCases][2];

        for(int y=0;y<numberOfCases;y++){
            cases[y][0] = scanner.nextInt();
            cases[y][1] = scanner.nextInt();
        }

        return cases;
    }

    public int getEndingNumbers(int a , int b){

        int yPosition;
        int xPosition;

        int[][] tableOfDistinctEndingNumbers={
                {0},
                {1},
                {2,4,8,16},
                {3,9,7,1},
                {4,16},
                {5},
                {6},
                {7,9,3,1},
                {8,4,2,6},
                {9,1}};

        String base = new Integer(a).toString();

        yPosition = Integer.parseInt(base.substring(base.length()-1));

        xPosition= (b-1)%tableOfDistinctEndingNumbers[yPosition].length;

        return tableOfDistinctEndingNumbers[yPosition][xPosition];
    }

}
