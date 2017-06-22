package com.interview.formatedText.builders.types;


import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.builders.WordSplitter;
import com.interview.formatedText.organizers.TextOrganizer;

import java.util.ArrayList;
import java.util.List;

public class NoSyllableTextBuilder extends TextBuilder {

    public NoSyllableTextBuilder(int columnLength, TextOrganizer textOrganizer){
        this.colLen =columnLength;
        this.textOrganizer=textOrganizer;
    }

    @Override
    public List<String> splitText(String text) {

        StringBuilder sb = new StringBuilder(text);

        List<String> listOfLines = new ArrayList<>();

        List<String> splitted;

        while(sb.length()>0){

            if(sb.length()<=colLen){
                listOfLines.add(addPadding(sb.toString()));
                break;
            }else{
                int endOfLine = sb.lastIndexOf(" ",colLen);

                if(endOfLine>0){
                    while(sb.charAt(endOfLine-1)==' ' && endOfLine>4)
                        endOfLine--;
                    if(sb.substring(0,endOfLine).indexOf("    ")>0){
                        splitted = WordSplitter.splitSentenceWithTabs(sb.substring(0,endOfLine));
                        listOfLines.add(addPadding(splitted.get(0)));
                        sb.delete(0,endOfLine);
                        sb.insert(0,splitted.get(1));
                    }else{
                        listOfLines.add(addPadding(sb.substring(0, endOfLine)));
                        sb.delete(0, endOfLine);
                    }
                }else if(endOfLine==0) {
                    sb.deleteCharAt(0);
                }else{
                    splitted = WordSplitter.forcedSplitToOffset(sb.substring(0,colLen),colLen);
                    listOfLines.add(addPadding(splitted.get(0)));
                    sb.delete(0,colLen);
                    sb.insert(0,splitted.get(1));
                }
            }
        }
        return listOfLines;
    }
}
