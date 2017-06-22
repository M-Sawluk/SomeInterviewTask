package com.interview.cwanyLutek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CwanyLutek {

    public static void main(String[] args) throws IOException {
        collectData();
    }

    private static void collectData() throws IOException {

        int numberOfSets;
        int i=0;
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));

        String[] nums;

        numberOfSets=Integer.parseInt(x.readLine());

            while(i<numberOfSets){
                nums=x.readLine().split(" ");
                if(nums.length>1){
                stringBuilder.append(getAnswer(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]))).append("\n");}
                i++;
            }

        System.out.println(stringBuilder.toString());

    }

    private static char getAnswer(int n, int k) {

        if(n<k)
            return 'P';
        if(n==Integer.MAX_VALUE)
            return 'N';
        if(n+1%2==0)
            return 'N';

        int numberOfElements = n;
        int numberOfEleInSet = k;

        while(numberOfElements>3) {

            double power = Math.pow(2,getHighestPowerOfTwo(numberOfElements));
            if (numberOfEleInSet > power && numberOfElements > power) {
                numberOfElements -= power;
                numberOfEleInSet -= power;
            }else if(numberOfElements-power<numberOfEleInSet && numberOfEleInSet<power){
                return 'P';
            }else
                numberOfElements-=power;

        }

        if(numberOfElements==2 && numberOfEleInSet==1){
            return 'P';
        }else
            return 'N';

    }

    public static int getHighestPowerOfTwo(int n){

        int power;


        if(n>Math.pow(2,15)-1)
            power=15;
        else
            power=1;

        while(n>Math.pow(2,power+1)-1){
            power++;
        }

        return power;
    }



}
