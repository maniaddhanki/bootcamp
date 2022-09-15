package com.tw.step8.assignment3;

import java.util.Arrays;

public enum MeasuringQuantity {
    LENGTH(Unit.INCH,new Unit[]{Unit.INCH,Unit.CM,Unit.MM,Unit.FEET}),
    VOLUME(Unit.LITRE, new Unit[]{Unit.GALLON, Unit.LITRE}),
    TEMPERATURE(Unit.FAHRENHEIT,new Unit[]{Unit.CELSIUS, Unit.FAHRENHEIT});

    private Unit standardUnit;
    private Unit[] acceptableUnits;

    MeasuringQuantity(Unit standardUnit, Unit[] acceptableUnits) {
        this.standardUnit = standardUnit;
        this.acceptableUnits = acceptableUnits;
    }

    public Unit getStandardUnit() {
        return standardUnit;
    }

    public boolean isAcceptable(Unit unit) {
        return Arrays.asList(acceptableUnits).contains(unit);
    }
}
