package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidMeasurementException;
import com.tw.step8.assignment3.exception.MeasurementMismatchedException;

import java.util.Objects;

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

    private static Relation getRelation(double value1, double value2) {
        if (value1 == value2){
            return Relation.EQUAL;
        }
        return value1 > value2 ? Relation.GREATER : Relation.LESSER;
    }

    public Relation compare(Measurement measurement) throws MeasurementMismatchedException {
        if(measurement.quantity != this.quantity){
            throw new MeasurementMismatchedException(measurement.quantity,this.quantity);
        }
        double standardized = this.standardize();
        double givenStandardized = measurement.standardize();

        return getRelation(standardized, givenStandardized);
    }

    public Measurement add(Measurement measurement) throws InvalidMeasurementException {
        double resultantValue = this.value + measurement.value;
        return createMeasurement(this.quantity,resultantValue,this.unit);
    }

    public boolean isEqual(Measurement measurement, double threshold) {
        double delta = Math.abs(this.value - measurement.value);
        return delta <= threshold && this.quantity == measurement.quantity && this.unit == measurement.unit;
    }

    public static Measurement createMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidMeasurementException {
        if (value < 0){
            throw new InvalidMeasurementException(value);
        }
        return new Measurement(quantity,value, unit);
    }
}
