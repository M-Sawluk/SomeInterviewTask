package com.interview.vendingMachine;

/**
 * Created by Mike on 2017-04-13.
 */
public enum Coin {

    GROSZ(0.01),
    DWAGROSZE(0.02),
    PIECGROSZY(0.05),
    DZIESIECGROSZY(0.1),
    DWADZIESCIAGROSZY(0.2),
    PIEDZIESIATGROSZY(0.5),
    ZLOTOWKA(1.0),
    DWAZLOTE(2.0),
    PIECZLOTY(5.0);

    private double denomination;

    Coin(double denomination) {
        this.denomination = denomination;
    }

    public double getDenomination() {
        return denomination;
    }
}
