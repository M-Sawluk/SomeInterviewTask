package com.interview.FZI_Stef;

import java.math.BigInteger;
import java.util.Scanner;

public class Fzi_Stef {

    public static void main(String[] args) {
        Fzi_Stef fzi_stef = new Fzi_Stef();
        fzi_stef.printMaximumIncome();
    }

    private void printMaximumIncome() {

        String[] income=collectExpectedIncome();

        BigInteger sum = BigInteger.ZERO;
        BigInteger tempSum = BigInteger.ZERO;

        for (int i = 0; i <income.length ; i++) {
            tempSum=tempSum.add(new BigInteger(income[i]));
            if(tempSum.compareTo(sum)==1){
                sum=new BigInteger(tempSum.toString());
            }
            if(tempSum.compareTo(BigInteger.ZERO)==-1){
                tempSum= BigInteger.ZERO;
            }
        }

        System.out.println(sum.toString());
    }


    public String[] collectExpectedIncome(){

        int cities;
        String[] expectedIncome;
        int i=0;
        String tempString;

        Scanner scanner = new Scanner(System.in);
        cities=Integer.parseInt(scanner.nextLine());
        expectedIncome=new String[cities];


        while(i<cities) {
            tempString = scanner.nextLine().trim();
            if(tempString.length()>0){
                expectedIncome[i] = tempString;
                i++;}

        }
        return expectedIncome;
    }
}
