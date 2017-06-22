package com.interview.fangen;

public class CharMap {

    private char[][] map;

    public CharMap() {
        map = new char[0][0];
    }

    public void insertChar(char c,int yPos,int xPos){
        map[yPos][xPos]=c;
    }

    public void resizeMap(int ylength, int xlength){
        map = new char[ylength][xlength];
    }

    public int length(){
        return map.length;
    }

    public char get(int yPos, int xPos){
        return map[yPos][xPos];
    }

    public void fill(char c){
        for (int i = 0; i <map.length ; i++) {
            for (int j = 0; j <map[i].length ; j++) {
                map[i][j]=c;
            }
        }
    }

}
