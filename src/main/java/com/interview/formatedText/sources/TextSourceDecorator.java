package com.interview.formatedText.sources;

import com.interview.formatedText.builders.TextBuilder;

/**
 * Created by Mike on 2017-05-11.
 */
public abstract class TextSourceDecorator extends TextBuilder {

    protected TextBuilder textBuilder;

    public abstract String obtainText();

}
