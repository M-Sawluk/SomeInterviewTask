package com.interview.ReplacingCharackters;

import org.springframework.stereotype.Component;

/**
 * Created by Mike on 2017-04-12.
 */

@Component
public class ReplacingCharactersInString {

    public String replaceChars(String x , Character y){

        if(x==null)
            return "";
        else
            return x.replaceAll(y.toString(),"*");
    }


}
