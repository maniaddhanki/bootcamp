package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidMeasurementException;
import com.tw.step8.assignment3.exception.MeasurementMismatchedException;

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

    public Relation compare(Measurement measurement) throws MeasurementMismatchedException {
        if(measurement.quantity != this.quantity){
            throw new MeasurementMismatchedException(measurement.quantity,this.quantity);
        }
        double standardized = this.standardize();
        double givenStandardized = measurement.standardize();

        if (standardized == givenStandardized){
            return Relation.EQUAL;
         }
        return standardized > givenStandardized ? Relation.GREATER: Relation.LESSER;
    }

    public static Measurement createMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidMeasurementException {
        if (value < 0){
            throw new InvalidMeasurementException(value);
        }
        return new Measurement(quantity,value, unit);
    }
}
