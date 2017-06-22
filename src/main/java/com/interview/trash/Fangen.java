//package com.interview.fangen;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created by Mike on 2017-04-25.
// */
//public class Fangen {
//
//    public static void main(String[] args) {
//        Fangen f = new Fangen();
//        f.collectData();
//    }
//
//    private void collectData() {
//
//        int fanSize;
//
//        List<Integer> listOfFans = new ArrayList<>();
//
//        Scanner scanner = new Scanner(System.in);
//
//        while(scanner.hasNextInt()) {
//            fanSize = scanner.nextInt();
//            if(fanSize!=0)
//                listOfFans.add(fanSize);
//            else
//                break;
//        }
//
//        createFan(listOfFans);
//    }
//
//    private void createFan(List<Integer> listOfFans) {
//
//        char[][] charMap;
//
//        for(int i=0;i<listOfFans.length();i++){
//
//            charMap= new char[Math.abs(listOfFans.get(i)*2)][Math.abs(listOfFans.get(i)*2)];
//            fillDiagonals(charMap,0,0,0,charMap.length-1);
//            if(listOfFans.get(i)>0) {
//                generateFan(charMap,0,charMap.length/2-1,true);
//            }else{
//                generateFan(charMap,0,charMap.length/2-1,false);
//            }
//            printFan(charMap);
//        }
//
//
//    }
//
//    private void generateFan(char[][] map, int corner,int counter,boolean direction){
//
//        int cor=corner;
//        int count=counter;
//        char startingChar;
//        char endingChar;
//
//        if(direction==true) {
//            startingChar = '.';
//            endingChar = '*';
//        }else{
//            startingChar = '*';
//            endingChar = '.';}
//
//        for(int i=corner+1;i<map.length-1-cor;i++) {
//            if (count>0)
//                map[cor][i]=startingChar;
//            else
//                map[cor][i]=endingChar;
//
//            count--;
//        }
//        count=counter;
//
//        for(int i=corner+1;i<map.length-1-cor;i++) {
//            if (count>0)
//                map[i][map.length-cor-1]=startingChar;
//            else
//                map[i][map.length-cor-1]=endingChar;
//
//            count--;
//        }
//        count=counter;
//
//        for(int i=map.length-2-cor;i>cor;i--) {
//            if (count>0)
//                map[map.length-cor-1][i]=startingChar;
//            else
//                map[map.length-cor-1][i]=endingChar;
//            count--;
//        }
//
//        count=counter;
//
//        for(int i=map.length-2-cor;i>cor;i--) {
//            if (count>0)
//                map[i][cor]=startingChar;
//            else
//                map[i][cor]=endingChar;
//            count--;
//        }
//
//        count=counter;
//
//        if(cor<map.length/2-2)
//        generateFan(map,corner+1,counter-1,direction);
//
//    }
//
//    private void fillDiagonals(char[][] map,int y, int x, int nY,int nX){
//        int yPos =y;
//        int xPos = x;
//        int nYPos=nY;
//        int nXPos=nX;
//
//        if(y<map.length-1)
//        fillDiagonals(map,y+1,x+1,nYPos+1,nXPos-1);
//
//        map[yPos][xPos]='*';
//        map[nYPos][nXPos]='*';
//
//    }
//
//
//    private void printFan(char[][] charMap){
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i <charMap.length ; i++) {
//            for (int j = 0; j < charMap[i].length; j++) {
//                stringBuilder.setText(charMap[i][j]);
//            }
//            stringBuilder.setText("\n");
//        }
//        System.out.println(stringBuilder.toString());
//    }
//
//
//
//}
