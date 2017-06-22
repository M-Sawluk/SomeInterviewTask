package com.interview.trash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mike on 2017-04-24.
 */
public class Main {

    private static int length;

    public static void main(String[] args) {

//        printText(5,
//
//                "AAAAAAAAAAAA What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
//                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
//                        "printer took a galley of type and scrambled it to make a type specimen book. It has survived " +
//                        "not only five centuries, but also the leap into electronic typesetting, remaining essentially" +
//                        " unchanged. It was popularised in the 1960s with the release of Letraset sheets containing" +
//                        " Lorem Ipsum passages, and more recently with desktop publishing software like" +
//                        " Aldus PageMaker including versions of Lorem Ipsum."+
//                        "Where does it come from? Contrary to popular belief, Lorem Ipsum is not simply random text. " +
//                        "It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years " +
//                        "old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked " +
//                        "up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going " +
//                        "through the cites of the word in classical literature, discovered the undoubtable source. " +
//                        "Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of " +"de Finibus Bonorum et Malorum" +
//                        "(The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the" +
//                        " theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, " +
//                        "Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32. "+
//                        "The standard chunk of Lorem Ipsum used since the 1500s is reproduced "+
//                        "below for those interested. Sections 1.10.32 and 1.10.33 from de Finibus Bonorum et Malorum " +
//                        "by Cicero are also reproduced in their exact original form, accompanied by English versions " +
//                        "from the 1914 translation by H. Rackham. AAAAAAAAAAAAA AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA " +
//                        "AAAAAAAAAAAAAAAaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");
        System.out.println(Math.ceil(11/2.0));

        List<String> list = new ArrayList<>(Arrays.asList("AA", " AA"));

        addPadding(list);

        System.out.println(list.get(1)+"|");
    }

    public static void printText(int columns , String text){

        String[] words = text.split(" ");

        length=100/columns;

        List<String> formatedLines= setLinesAndAlign(new ArrayList<>(Arrays.asList(words)));

        for(int i=0;i<formatedLines.size();i++){
            System.out.print(formatedLines.get(i));
            if((i+1)%columns==0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println();

        formatedLines = setBookFormat(formatedLines,columns);

        for (String formatedLine : formatedLines) {
            System.out.println(formatedLine);

        }

    }


    private static List<String> setLinesAndAlign(List<String> words) {

        List<String> formatedLines = new ArrayList<>();

        String formatStyle="%1$-"+(length+1)+"s";

        StringBuffer line=new StringBuffer();

        for(int i=0;i<words.size();i++){

            if(line.length()+words.get(i).length()<length)
                line.append(words.get(i)).append(" ");
            else if(words.get(i).length()>=length){
                words.add(i+1,words.get(i).substring(length-line.length()));
                line.append(words.get(i).substring(0,length-line.length()));
                formatedLines.add(String.format(formatStyle,line));
                line.setLength(0);
            }
            else {

                formatedLines.add(String.format(formatStyle, line));
                line.setLength(0);
                line.append(words.get(i)).append(" ");
            }

        }

        if(line.length()>0)
            formatedLines.add(line.toString());


        return formatedLines;
    }

    private static List<String> setBookFormat(List<String> list, int columns){

        int rowsOnPage=0;
        String line="";
        List<String> bookPage=new ArrayList<>();

        if(list.size()%columns==0)
            rowsOnPage=list.size()/columns;
        else
            rowsOnPage=(list.size()/columns)+1;

        for(int i=0;i<rowsOnPage;i++){

            int pageNumber=0;

            for(int j=0;j<columns;j++){
                if(i+pageNumber*rowsOnPage<list.size())
                line+=list.get(i+pageNumber*rowsOnPage);
                pageNumber++;
            }
            bookPage.add(line);
            line="";
        }

        return bookPage;

    }

    private static void addPadding(List<String> lines){

        int columnLength =5;
        int padding=1;
        String formatStyle="%1$-"+(columnLength+padding)+"s";




    }

}
