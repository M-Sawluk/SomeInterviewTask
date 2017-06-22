//package com.interview;
//
//import com.interview.formatedText.TextBuilder;
//import com.interview.formatedText.TextOrganizer;
//import com.interview.formatedText.WordSplitter;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Mike on 2017-05-09.
// */
//public class PolishSyllableTextPrinter extends TextBuilder {
//
//    PolishSyllableTextPrinter(int columnLength, TextOrganizer textOrganizer){
//        this.colLen =colLen;
//        this.textOrganizer=textOrganizer;
//    }
//
//    @Override
//    List<String> splitText(String text) {
//
//        StringBuilder sb = new StringBuilder(text);
//        List<String> listOfLines = new ArrayList<>();
//        List<String> splited;
//
//        while(sb.length()>0) {
//
//            if (sb.length() <= columnLength) {
//                listOfLines.add(addPadding(sb.toString()));
//                break;
//            }else if (sb.length() > colLen && sb.charAt(colLen) == ' ') {
//                listOfLines.add(addPadding(sb.substring(0, columnLength)));
//                sb.delete(0, columnLength + 1);
//            }else{
//                int endOfLine = sb.indexOf(" ", this.columnLength);
//
//                if(endOfLine>-1){
//                    splited = WordSplitter.splitSentenceOnSyllablesToOffset(sb.substring(0,endOfLine).trim(), this.columnLength);
//                    listOfLines.add(addPadding(splited.get(0)));
//                    sb.delete(0,endOfLine);
//                    sb.insert(0,splited.get(1));
//                }else{
//                    splited = WordSplitter.splitSentenceOnSyllablesToOffset(sb.toString().trim(), this.columnLength);
//                    listOfLines.add(addPadding(splited.get(0)));
//                    sb.setLength(0);
//                    sb.insert(0,splited.get(1));
//                }
//            }
//        }
//
//        return listOfLines;
//    }
//}
