package com.interview.formatedText.builders.types;

import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.builders.WordSplitter;
import com.interview.formatedText.organizers.TextOrganizer;

import java.util.ArrayList;
import java.util.List;

public class PolishSyllableTextBuilder extends TextBuilder {

    public PolishSyllableTextBuilder(int columnLength, TextOrganizer textOrganizer){
        this.colLen =columnLength;
        this.textOrganizer=textOrganizer;
    }

    @Override
    public List<String> splitText(String text) {

        StringBuilder sb = new StringBuilder(text);
        List<String> listOfLines = new ArrayList<>();
        List<String> splitted;

        while(sb.length()>0) {

            if (sb.length() <= colLen) {
                listOfLines.add(addPadding(sb.toString()));
                break;
            }else{
                int endOfLine = sb.indexOf(" ",colLen);

                if(endOfLine>0){
                    while(sb.charAt(endOfLine-1)==' ' && endOfLine>4)
                        endOfLine--;

                    if(sb.substring(0,endOfLine).contains("    ")){
                        splitted = WordSplitter.splitSentenceWithTabs(sb.substring(0,endOfLine));
                        listOfLines.add(addPadding(splitted.get(0)));
                        sb.delete(0,endOfLine);
                        sb.insert(0,splitted.get(1));
                    }else{
                        splitted = WordSplitter.splitSentenceOnSyllablesToOffset(sb.substring(0,endOfLine), colLen);
                        listOfLines.add(addPadding(splitted.get(0)));
                        sb.delete(0,endOfLine);
                        sb.insert(0,splitted.get(1));}
                }else{
                    splitted = WordSplitter.splitSentenceOnSyllablesToOffset(sb.toString().trim(), colLen);
                    listOfLines.add(addPadding(splitted.get(0)));
                    sb.setLength(0);
                    sb.insert(0,splitted.get(1));
                }
            }
        }

        return listOfLines;
    }
}
