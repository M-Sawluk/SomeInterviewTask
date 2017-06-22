package com.interview.cwanyLutek;


import java.util.Scanner;

public class CwanyLutek2 {

    public static void main(String[] args){
        collectData();
    }

    private static void collectData() {

        int numberOfSets;
        StringBuilder stringBuilder = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        numberOfSets=scanner.nextInt();

        for (int i = 0; i < numberOfSets; i++) {
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            stringBuilder.append(getAnswer(n,k)).append("\n");

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

        int i;
        int number=n;

        for (i=0;number>1 ;i++){
            number=number>>1;
        }

        return i;
    }

}
