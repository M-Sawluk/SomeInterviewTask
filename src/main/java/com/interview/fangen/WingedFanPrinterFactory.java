package com.interview.fangen;

public class WingedFanPrinterFactory {
    public static WingedFanPrinter getWingedFanPrinter(FanPrinterType type){
        WingPainter painter = WingPainterFactory.getWingPainter(WingType.AsteriskTriangle);
        CharMap wingMap = painter.getWingMap();
        if(type == FanPrinterType.QuadrupleSymmetry)
            return new WingedFanPrinterQuadrupleSymmetry(wingMap);
        else
            throw new IllegalArgumentException("Illegal FanPrinter: " + type);

    }
}
