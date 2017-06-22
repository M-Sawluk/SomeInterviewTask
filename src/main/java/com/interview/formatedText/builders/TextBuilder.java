package com.interview.formatedText.builders;

import com.interview.formatedText.organizers.TextOrganizer;

import java.util.List;

public abstract class TextBuilder {

    protected int colLen;
    protected String text;
    protected TextOrganizer textOrganizer;
    protected int padding =1;

    public abstract List<String> splitText(String text);

    public String buildText(){
        if(text!=null && textOrganizer!=null){
          return textOrganizer.organizeText(splitText(this.text));
        }else{
            return null;
        }
    }

    public String addPadding(String lines){

        String formatStyle="%1$-"+(colLen +padding)+"s";

        if(lines.startsWith("    "))
            return String.format(formatStyle,lines);

        else
            return String.format(formatStyle,lines.trim());
    }

    public TextBuilder setText(String text){
        this.text=text;
        return this;
    }

    public void setPadding(int padding){
        this.padding=padding;
    }

    public String getFormattedText(){
        return buildText();
    }

}
