package com.interview.formatedText.sources.types;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.sources.types.restTools.TextFromJson;
import com.interview.formatedText.sources.TextSourceDecorator;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RestTextSource extends TextSourceDecorator {

    private TextFromJson getTextFromJson;
    private String url;

    public RestTextSource(TextBuilder textBuilder, TextFromJson getTextFromJson, String url){
        this.textBuilder = textBuilder;
        this.getTextFromJson=getTextFromJson;
        this.url=url;
    }

    @Override
    public String obtainText() {

        TextFromJson restWithText = getTextFromJson;

        try {
            URL jsonUrl = new URL(url);

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                restWithText = objectMapper.readValue(jsonUrl,restWithText.getClass());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return restWithText.returnText();
    }

    @Override
    public List<String> splitText(String text) {
        return textBuilder.splitText(text);
    }

    @Override
    public String getFormattedText(){
        textBuilder.setText(obtainText());
        return this.buildText();
    }

    @Override
    public String buildText(){
        System.out.println();
        return textBuilder.buildText();
    }
}
