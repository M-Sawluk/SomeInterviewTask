package com.interview.fangen;

/**
 * Created by Mike on 2017-04-28.
 */
public class Fangen {

    public static void main(String[] args) {
        WingedFanPrinter fanPrinter = WingedFanPrinterFactory.getWingedFanPrinter(FanPrinterType.QuadrupleSymmetry);
        fanPrinter.printFan(20,FanDirection.ClockWise);

    }
}
