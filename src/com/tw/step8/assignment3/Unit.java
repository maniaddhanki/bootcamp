package com.tw.step8.assignment3;

public enum Unit {
    FEET(12),INCH(1),CM(0.4),MM(0.04);

    private double inInch;

    Unit(double inInch) {
        this.inInch = inInch;
    }

    public double toInch(double value) {
        return this.inInch * value;
    }
}
