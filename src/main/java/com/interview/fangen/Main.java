package com.interview.fangen;

public class Main {

    public static void main(String[] args) {
        WingedFanPrinter fanPrinter = WingedFanPrinterFactory.getWingedFanPrinter(FanPrinterType.QuadrupleSymmetry);
        fanPrinter.printFan(3,FanDirection.ClockWise);

    }


}
