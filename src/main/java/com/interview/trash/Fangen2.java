package com.interview.trash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Mike on 2017-04-25.
 */
public class Fangen2 {

    public static void main(String[] args) {

        Fangen2 fang = new Fangen2();
        fang.collectData();
    }

    private void collectData() {

        int fanSize;

        List<Integer> listOfFans = new ArrayList<>();

        while(true) {
            Scanner scanner = new Scanner(System.in);
            fanSize = scanner.nextInt();
            if(fanSize!=0)
                listOfFans.add(fanSize);
            else
                break;
        }

        createFan(listOfFans);
    }

    private void createFan(List<Integer> listOfFans) {

        char[][] charMap;

        for(Integer length: listOfFans){
            int size = Math.abs(length);
            charMap= new char[size*2][size*2];
            if(length>0)
                makeWingsClockwise(charMap,0,0);
            else
                makeWingsCounterClockwise(charMap,charMap.length-1,charMap.length-1);

            printFan(charMap,charMap.length-1,charMap.length-1);
            System.out.println();
        }

    }

    private void makeWingsCounterClockwise(char[][] charMap, int y, int x) {
        int yPos=y;
        int xPos=x;
        int lastPos=charMap.length-1;


        if(xPos>0){
            makeWingsCounterClockwise(charMap,yPos,xPos-1);
        } else if(yPos>0) {
            makeWingsCounterClockwise(charMap, yPos-1, lastPos);
        }

        if(yPos<charMap.length/2){
            if(xPos>=yPos && xPos<charMap.length/2 || xPos>=lastPos-yPos && xPos<charMap.length )
                charMap[yPos][xPos]='*';
            else
                charMap[yPos][xPos]='.';

        }else{
            if(xPos>=0 && xPos<charMap.length-yPos || xPos>=charMap.length/2 && xPos<=yPos)
                charMap[yPos][xPos]='*';
            else
                charMap[yPos][xPos]='.';

        }

    }

    private void makeWingsClockwise(char[][] charMap, int y, int x) {
        int yPos=y;
        int xPos=x;
        int lastPos=charMap.length-1;


        if(xPos+1<charMap.length){
            makeWingsClockwise(charMap,yPos,xPos+1);
        } else if(yPos+1<charMap.length) {
            makeWingsClockwise(charMap, yPos+1, 0);
        }

        if(yPos<charMap.length/2){
            if(xPos>=0 && xPos<=yPos || xPos>=charMap.length/2 && xPos<charMap.length-yPos )
                charMap[yPos][xPos]='*';
            else
                charMap[yPos][xPos]='.';

        }else{
            if(xPos>=lastPos-yPos && xPos<charMap.length/2 || xPos<=charMap.length && xPos>=yPos)
                charMap[yPos][xPos]='*';
            else
                charMap[yPos][xPos]='.';

        }

    }

    private void printFan(char[][] charMap,int y,int x){
        int yPos=y;
        int xPos=x;

        if(xPos>0){
            printFan(charMap,yPos,xPos-1);
        } else if(yPos>0) {
            printFan(charMap, yPos-1, charMap.length-1);
        }

        if(xPos==0){
            System.out.println();
        }
        System.out.print(charMap[yPos][xPos]);

    }



}
