package com.interview.fangen;

import static com.interview.fangen.WingType.AsteriskTriangle;

public class WingPainterFactory {
    public static WingPainter getWingPainter(WingType type){

        if(type== AsteriskTriangle)
            return new WingPainterAsteriskTriangle();
        else
            throw new IllegalArgumentException("No such type + " + type);

    }
}
