package com.interview.skarbfi;

import java.util.Scanner;

public class Skarbfi {

    int numberOfMovements=0;

    public static void main(String[] args) {

        Skarbfi skarbfi = new Skarbfi();
        skarbfi.printMovement();
    }

    public void printMovement(){

        int[][] movements= collectData();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<movements.length;i+=2){
            if(movements[i][1]==0 && movements[i+1][1]==0){
                stringBuilder.append("studnia\n");
            }else{
                if(movements[i][1]>0){
                    stringBuilder.append(movements[i][0]+" "+movements[i][1]).append("\n");
                }
                if(movements[i+1][1]>0){
                    stringBuilder.append(movements[i+1][0]+" "+movements[i+1][1]).append("\n");
                }

            }

        }
        System.out.println(stringBuilder.toString());
    }

    public int[][] collectData(){

        int[][] movement;
        int[][] tempComands;

        int guides;
        int commands;

        Scanner scanner = new Scanner(System.in);

        guides=scanner.nextInt();

        movement = new int[guides*2][2];

        for(int i=0;i<guides;i++){
            commands = scanner.nextInt();
            tempComands=new int[commands][2];
            for(int j=0;j<commands;j++){
                tempComands[j][0]=scanner.nextInt();
                tempComands[j][1]=scanner.nextInt();
            }
            calculatePortions(movement,tempComands);
        }

        return movement;
    }

    private void calculatePortions(int[][] movement, int[][] tempComands) {

        int horizontal=0;
        int vertical=0;

        for(int i=0;i<tempComands.length;i++){
            if(tempComands[i][0]==0)
                vertical+=tempComands[i][1];
            else if(tempComands[i][0]==1)
                vertical-=tempComands[i][1];
            else if(tempComands[i][0]==2)
                horizontal-=tempComands[i][1];
            else
                horizontal+=tempComands[i][1];
        }

        if(vertical>0){
            movement[numberOfMovements][0]=0;
            movement[numberOfMovements][1]=vertical;
            numberOfMovements++;
        }else{
            movement[numberOfMovements][0]=1;
            movement[numberOfMovements][1]=vertical*(-1);
            numberOfMovements++;
        }

        if(horizontal>0){
            movement[numberOfMovements][0]=3;
            movement[numberOfMovements][1]=horizontal;
            numberOfMovements++;
        }else{
            movement[numberOfMovements][0]=2;
            movement[numberOfMovements][1]=horizontal*(-1);
            numberOfMovements++;
        }
    }

}
