package com.interview.formatedText.builders;

import com.interview.formatedText.builders.types.NoSyllableTextBuilder;
import com.interview.formatedText.builders.types.PolishSyllableTextBuilder;
import com.interview.formatedText.builders.types.WordSplitType;
import com.interview.formatedText.organizers.TextOrganizer;

public class TextBuilderFactory {

    public static TextBuilder getTextBuilder(int columnLength, TextOrganizer textOrganizer, WordSplitType type){
        if(columnLength>0) {
            if (type == WordSplitType.PolishSyllable)
                return new PolishSyllableTextBuilder(columnLength, textOrganizer);
            else
                return new NoSyllableTextBuilder(columnLength, textOrganizer);
        }else
            throw new IllegalArgumentException("Can not format text for column length: " + columnLength);


    }


}
