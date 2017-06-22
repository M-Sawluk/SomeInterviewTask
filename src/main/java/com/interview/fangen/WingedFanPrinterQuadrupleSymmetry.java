package com.interview.fangen;

public class WingedFanPrinterQuadrupleSymmetry extends WingedFanPrinter {

    WingedFanPrinterQuadrupleSymmetry(CharMap charMap){
        super.charMap=charMap;
    }

    @Override
    public void printFan(int length, FanDirection direction){
        StringBuilder stringBuilder = new StringBuilder();
        charMap.resizeMap(Math.abs(length)*2,Math.abs(length)*2);
        if(direction==FanDirection.ClockWise){
            constructFan(true);
        }else{
            constructFan(false);
        }

        for (int i = 0; i <charMap.length() ; i++) {
            for (int j = 0; j < charMap.length(); j++) {
                stringBuilder.append(charMap.get(i,j));
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());

    }

    void constructFan(boolean direction) {
        fillDiagonals(charMap,0,0,0,charMap.length()-1);
        generateFan(charMap,0,charMap.length()/2-1,direction);
    }

    private void generateFan(CharMap map, int corner,int counter,boolean direction){

        int cor=corner;
        int count=counter;
        char startingChar;
        char endingChar;

        if(direction==true) {
            startingChar = '.';
            endingChar = '*';
        }else{
            startingChar = '*';
            endingChar = '.';}

        for(int i=corner+1;i<map.length()-1-cor;i++) {
            if (count>0)
                map.insertChar(startingChar,cor,i);
            else
                map.insertChar(endingChar,cor,i);

            count--;
        }
        count=counter;

        for(int i=corner+1;i<map.length()-1-cor;i++) {
            if (count>0)
                map.insertChar(startingChar,i,map.length()-cor-1);
            else
                map.insertChar(endingChar,i,map.length()-cor-1);

            count--;
        }
        count=counter;

        for(int i=map.length()-2-cor;i>cor;i--) {
            if (count>0)
                map.insertChar(startingChar,map.length()-cor-1,i);
            else
                map.insertChar(endingChar,map.length()-cor-1,i);
            count--;
        }

        count=counter;

        for(int i=map.length()-2-cor;i>cor;i--) {
            if (count>0)
                map.insertChar(startingChar,i,cor);
            else
                map.insertChar(endingChar,i,cor);
            count--;
        }

        count=counter;

        if(cor<map.length()/2-2)
            generateFan(map,corner+1,counter-1,direction);

    }

    private void fillDiagonals(CharMap map,int y, int x, int nY,int nX){
        int yPos =y;
        int xPos = x;
        int nYPos=nY;
        int nXPos=nX;

        if(y<map.length()-1)
            fillDiagonals(map,y+1,x+1,nYPos+1,nXPos-1);

        map.insertChar('*',yPos,xPos);
        map.insertChar('*',nYPos,nXPos);

    }

}
