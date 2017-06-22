package com.interview.formatedText.sources.types;

import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.sources.TextSourceDecorator;

import java.io.*;
import java.util.List;

/**
 * Created by Mike on 2017-05-11.
 */
public class FileTextSource extends TextSourceDecorator {

    private String filePath;

    public FileTextSource(TextBuilder textBuilder, String filePath){
        this.textBuilder = textBuilder;
        this.filePath= filePath;
    }

    @Override
    public String obtainText() {

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bf = new BufferedReader(fileReader);

            while((line=bf.readLine())!=null){
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
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
