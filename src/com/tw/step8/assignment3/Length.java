package com.tw.step8.assignment3;

public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public int compare(Length length) {
        double convertedLength = this.toInch();
        double convertedGivenLength = length.toInch();

        return compareLength(convertedLength,convertedGivenLength);
    }

    private double toInch() {
        return this.unit.toInch(this.value);
    }

    private int compareLength(double value, double givenValue) {
        if(givenValue == value){
            return 0;
        }
        return givenValue > value ? -1 : 1;
    }
}
