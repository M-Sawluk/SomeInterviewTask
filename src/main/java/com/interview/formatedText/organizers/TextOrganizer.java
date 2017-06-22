package com.interview.formatedText.organizers;

import java.util.List;

public abstract class TextOrganizer {

    protected int columns=1;

    public abstract String organizeText(List<String> lines);

}
