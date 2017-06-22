package com.interview.formatedText.organizers.types;

import com.interview.formatedText.organizers.TextOrganizer;

import java.util.List;

public class VerticalTextOrganizer extends TextOrganizer {

    @Override
    public String organizeText(List<String> lines) {
        StringBuilder stringBuilder = new StringBuilder();
        int rowsOnPage;

        if(lines.size()%columns==0)
            rowsOnPage=lines.size()/columns;
        else
            rowsOnPage=(lines.size()/columns)+1;

        for (int i = 0; i <rowsOnPage ; i++) {

            for (int j = 0; j <columns ; j++) {
                if(i+j*rowsOnPage<lines.size())
                    stringBuilder.append(lines.get(i+j*rowsOnPage));
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
