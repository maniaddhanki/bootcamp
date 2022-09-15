package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidMeasurementException;

public class Measurement {
    private final double value;
    private final Unit unit;
    private final MeasuringQuantity quantity;

    private Measurement(MeasuringQuantity quantity, double value, Unit unit) {
        this.quantity = quantity;
        this.value = value;
        this.unit = unit;
    }

    private double standardize() {
        return this.unit.standardize(this.value);
    }

    public Relation compare(Measurement measurement) {
        double standardizedMeasurement = this.standardize();
        double givenStandardizedMeasurement = measurement.standardize();

        if (standardizedMeasurement == givenStandardizedMeasurement){
            return Relation.EQUAL;
         }
        return standardizedMeasurement > givenStandardizedMeasurement ? Relation.GREATER: Relation.LESSER;
    }

    public static Measurement createMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidMeasurementException {
        if (value < 0){
            throw new InvalidMeasurementException(value);
        }
        return new Measurement(quantity,value, unit);
    }
}
