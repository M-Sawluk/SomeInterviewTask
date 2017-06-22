package com.interview.formatedText.organizers.types;

import com.interview.formatedText.organizers.TextOrganizer;

import java.util.List;


public class HorizontalTextOrganizer extends TextOrganizer {
    @Override
    public String organizeText(List<String> lines) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<lines.size();i++){
            stringBuilder.append(lines.get(i));
            if((i+1)%columns==0){
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
