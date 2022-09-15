package com.tw.step8.assignment3;

public enum MeasuringQuantity {
    LENGTH(Unit.INCH),VOLUME(Unit.LITRE);

    private Unit standardUnit;

    MeasuringQuantity(Unit standardUnit) {
        this.standardUnit = standardUnit;
    }

    public Unit getStandardUnit() {
        return standardUnit;
    }
}
