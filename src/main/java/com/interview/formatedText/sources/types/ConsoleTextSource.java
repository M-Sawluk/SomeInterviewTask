package com.interview.formatedText.sources.types;


import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.sources.TextSourceDecorator;

import java.util.List;
import java.util.Scanner;

public class ConsoleTextSource extends TextSourceDecorator {

    public ConsoleTextSource(TextBuilder textBuilder){
        this.textBuilder = textBuilder;
    }

    @Override
    public String obtainText() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Specify number of copied rows: ");
        StringBuilder stringBuilder = new StringBuilder();
        int i =scanner.nextInt();
        i=i*2;
        for (int j = 0; j <i; j++) {
            stringBuilder.append(scanner.nextLine());
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
