package com.interview.formatedText.organizers;

import java.util.List;

public class SplitOn2Cols extends ColumnDecorator {

    TextOrganizer textOrganizer;

    public SplitOn2Cols(TextOrganizer textOrganizer) {
        this.textOrganizer=textOrganizer;
        textOrganizer.columns=2;
    }

    @Override
    public String organizeText(List<String> lines) {
        return textOrganizer.organizeText(lines);
    }
}
