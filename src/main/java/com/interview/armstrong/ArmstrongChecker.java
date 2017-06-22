package com.interview.armstrong;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ArmstrongChecker {

    public boolean checkIfArmstrong(int x){

        if(x==doMath(disambleNumber(x)))
            return true;
        else
            return false;

    }

    public List<Integer> disambleNumber(Integer numberToDisamble){

        String number = numberToDisamble.toString();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<number.length();i++){

            list.add(Integer.parseInt(number.substring(i,i+1)));

        }
        return list;
    }

    public Integer doMath(List<Integer> listOfNumbers){

        int number=0;

        for (Integer listOfNumber : listOfNumbers) {

            number+=Math.pow(listOfNumber,listOfNumbers.size());
        }

        return number;
    }

    public boolean checkIfArm(BigInteger numberToCheck){

        if(numberToCheck.equals(doMathForBig(disambleBigDecimal(numberToCheck))))
            return true;
        else
            return false;

    }

    public List<Integer> disambleBigDecimal(BigInteger decimalToDisamble){

        String number = decimalToDisamble.toString();

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<number.length();i++){

            list.add(Integer.parseInt(number.substring(i,i+1)));

        }
        return list;
    }

    public BigInteger doMathForBig(List<Integer> listOfNumbers){

        BigInteger number = new BigInteger("0");

        for (Integer listOfNumber : listOfNumbers) {
            BigInteger x = new BigInteger(listOfNumber.toString());
            number=number.add(x.pow(listOfNumbers.size()));
        }

        return number;

    }



}
