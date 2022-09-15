package com.tw.step8.assignment3;

public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toInch() {
        return this.unit.toInch(this.value);
    }

    public int compare(Length length) {
        double convertedLength = this.toInch();
        double convertedGivenLength = length.toInch();

        return Double.compare(convertedLength,convertedGivenLength);
    }
}
