package com.interview.trash;

import java.io.*;

import java.util.ArrayList;

import java.util.List;


/**
 * Created by Mike on 2017-04-26.
 */
public class Fangen3 {

    public static void main(String[] args) {
        Fangen3 f = new Fangen3();

        f.collectData();

    }

    private void collectData() {

        List<Integer> listOfFans = new ArrayList<>();
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            while ((line = x.readLine()) != null) {
                listOfFans.add(Integer.parseInt(line));
                if (Integer.parseInt(line) == 0)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int size;
        for (int i = 0; i < listOfFans.size(); i++) {
            if (listOfFans.get(i) < 0) {
                size = listOfFans.get(i) * (-1);
                makeWingsCounterClockwise(size);
            } else {
                size = listOfFans.get(i);
                makeWingsClockwise(size);
            }
        }
    }
    private void makeWingsCounterClockwise(int size) {
            int lastPos=size*2-1;
        StringBuilder stringBuilder = new StringBuilder();
            for(int y=0;y<=lastPos;y++){

                for (int x = 0; x <=lastPos ; x++) {
                    if(y<size){
                        if(x>=y && x<size || x>=lastPos-y && x<=lastPos)
                            stringBuilder.append('*');
                        else
                            stringBuilder.append('.');

                    }else{
                        if(x>=0 && x<=lastPos-y || x>=size && x<=y)
                            stringBuilder.append('*');
                        else
                            stringBuilder.append('.');

                    }
                }
                stringBuilder.append('\n');
            }
            System.out.println(stringBuilder.toString());
        }

    private void makeWingsClockwise(int size){
            int lastPos=size*2-1;
        StringBuilder stringBuilder = new StringBuilder();
            for(int y=0;y<=lastPos;y++){

                for (int x = 0; x <=lastPos ; x++) {

                    if(y<size){
                        if(x>=0 && x<=y || x>lastPos/2 && x<=lastPos-y )
                            stringBuilder.append('*');
                        else
                            stringBuilder.append('.');

                    }else{
                        if(x>=lastPos-y && x<size || x<size*2 && x>=y)
                            stringBuilder.append('*');
                        else
                            stringBuilder.append('.');

                    }

                }
                stringBuilder.append('\n');
            }
            System.out.println(stringBuilder.toString());
    }

}

