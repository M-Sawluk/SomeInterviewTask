package com.interview.formatedText.builders;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSplitter {

    public static List<String> splitWordOnSyllablesToOffset(String word, int offset){

        if(isSplittable(word) && word.length()>offset) {
            StringBuilder stringBuilder = new StringBuilder();
            String cuttedWord = consonantsGroupPattern(word);
            cuttedWord = vowelConsonantPattern(cuttedWord);
            String[] splitedWord = new String[2];

            int spaces = StringUtils.countOccurrencesOf(cuttedWord.substring(0,offset)," ");

            int last = cuttedWord.lastIndexOf(" ",offset+spaces-1);

            if(last>0){
                splitedWord[0]=cuttedWord.substring(0,last).trim().replaceAll(" ","")+"-";
                splitedWord[1]=cuttedWord.substring(last).trim().replaceAll(" ","");
                return new ArrayList<String>(Arrays.asList(splitedWord));
            }else
                return new ArrayList<String>(Arrays.asList(word));

        }

        return new ArrayList<String>(Arrays.asList(word));

    }

    public static boolean isSplittable(String word){

        if(word.length()-word.replaceAll("[aeyuioąęAEYUIOĄĘ]","").length()<2)
            return false;
        else
            return true;

    }

    public static String consonantsGroupPattern(String word){

        StringBuilder stringBuilder = new StringBuilder(word);
        List<Integer> potentialCuts= new ArrayList<>();
        int start=0;

        String voConConVon="[aeyuioóąę]{1}[qwrtpsdfghjklzxcvbnmłćżźś]{2,}[aeyuioóąę]{1}";

        Pattern p = Pattern.compile(voConConVon,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(word);

        while(m.find(start)) {
            start=m.end()-m.group().length()+2;
            potentialCuts.add(shitIfUnsplittableGroup(word,m.start()+2));
        }

        for (int i = 0; i <potentialCuts.size(); i++) {
            stringBuilder.insert(potentialCuts.get(i)+i," ");
        }
        return stringBuilder.toString();
    }

    public static String vowelConsonantPattern(String word){

        List<Integer> potentialCuts = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(word);

        String voConVo ="[aeyuioóąę][qwrtpsdfghjklzxcvbnmłćżźś]{1,}[aeyuioóąę]";
        Pattern vCv = Pattern.compile(voConVo, Pattern.CASE_INSENSITIVE);
        Matcher m = vCv.matcher(word);

        int start=0;

        while(m.find(start)) {
            potentialCuts.add(shitIfUnsplittableGroup(word,m.start()+1));
            start=m.end()-m.group().length()+2;
        }
        for (int i = 0; i <potentialCuts.size(); i++) {
            stringBuilder.insert(potentialCuts.get(i)+i," ");
        }
        return stringBuilder.toString();
    }

    public static int shitIfUnsplittableGroup(String word, int cuttingPoint) {

        String pattern="[c][h]|[c][i]|[c][z]|[n][i]|[s][i]|[s][z]|[z][i]|[d][z]|[d][ź]|[d][ż]";
        Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(word.substring(cuttingPoint-1,cuttingPoint+1));

        if(m.find()){
            String vowels = "[aeyuioóąę]";
            Pattern p2 = Pattern.compile(vowels,Pattern.CASE_INSENSITIVE);
            Matcher m2 = p2.matcher(word.substring(cuttingPoint+1,cuttingPoint+2));
            if(m2.find())
                return cuttingPoint-1;
            else
                return cuttingPoint+1;
        }

        return cuttingPoint;
    }

    public static List<String> forcedSplitToOffset(String word , int offset){

        if(word.length()<offset){
            return new ArrayList<>(Arrays.asList(word,""));
        }else
            return new ArrayList<>(Arrays.asList(word.substring(0,offset),
                                                word.substring(offset)));

    }

    public static List<String> splitSentenceWithTabs(String sentence){

        if(sentence.startsWith("    ") && sentence.lastIndexOf("    ")!=0 ){
            return new ArrayList<>(Arrays.asList(sentence.substring(0,sentence.lastIndexOf("    ")),
                    sentence.substring(sentence.lastIndexOf("    "))));
        }else if(sentence.startsWith("    ")){
            int last=sentence.lastIndexOf(" ");
            return new ArrayList<>(Arrays.asList(sentence.substring(0,last+1),sentence.substring(last+1)));
        }else{
            int a = sentence.indexOf("    ");
            return new ArrayList<>(Arrays.asList(sentence.substring(0,a).trim(),sentence.substring(a)));
        }
    }

    public static List<String> splitSentenceOnSyllablesToOffset(String sentence, int offset){

        int lastSpaceIndex = sentence.lastIndexOf(" ");
        List<String> splitted;

        if(sentence.length()<=offset){
            return new ArrayList<>(Arrays.asList(sentence,""));
        }else if(lastSpaceIndex==0 || lastSpaceIndex==-1){
            splitted=splitWordOnSyllablesToOffset(sentence.substring(lastSpaceIndex+1),offset);
            if(splitted.size()>1)
                return splitted;
            else
                return forcedSplitToOffset(sentence,offset);
        }else if(offset<lastSpaceIndex){
            int wordStart=sentence.lastIndexOf(" ",offset);
            int wordEnd=sentence.indexOf(" ",offset);
            if(wordStart==-1)
                wordStart++;
            splitted = splitWordOnSyllablesToOffset(sentence.substring(wordStart,wordEnd),offset-wordStart);
            if(splitted.size()>1)
                return new ArrayList<>(Arrays.asList(sentence.substring(0,wordStart)+" "+splitted.get(0),
                                                splitted.get(1)+sentence.substring(wordEnd)));
            else
                return new ArrayList<>(Arrays.asList(sentence.substring(0,wordStart),
                        sentence.substring(wordStart)));

        }else{
            int fixedOffset = offset-lastSpaceIndex-1;
            splitted=splitWordOnSyllablesToOffset(sentence.substring(lastSpaceIndex+1),fixedOffset);
            if(splitted.size()>1)
                return new ArrayList<>(Arrays.asList(sentence.substring(0,lastSpaceIndex)+" "+splitted.get(0),splitted.get(1)));
            else
                return new ArrayList<>(Arrays.asList(sentence.substring(0,lastSpaceIndex),sentence.substring(lastSpaceIndex+1)));
        }

    }
}
