package com.interview.formatedText.sources.types.restTools;

/**
 * Created by Mike on 2017-05-11.
 */
public class MyGistWithText implements TextFromJson {

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String returnText() {
        return this.text;
    }
}
