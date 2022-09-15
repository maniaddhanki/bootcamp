package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidMeasurementException;
import com.tw.step8.assignment3.exception.MeasurementMismatchedException;
import com.tw.step8.assignment3.exception.UnacceptableUnitException;

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

    private void validateQuantity(Measurement measurement) throws MeasurementMismatchedException {
        if(measurement.quantity != this.quantity){
            throw new MeasurementMismatchedException(measurement.quantity,this.quantity);
        }
    }

    public Relation compare(Measurement measurement) throws MeasurementMismatchedException {
        validateQuantity(measurement);

        double standardized = this.standardize();
        double givenStandardized = measurement.standardize();

        if (standardized == givenStandardized){
            return Relation.EQUAL;
        }
        return standardized > givenStandardized ? Relation.GREATER : Relation.LESSER;
    }

    public Measurement add(Measurement measurement) throws InvalidMeasurementException, MeasurementMismatchedException, UnacceptableUnitException {
        validateQuantity(measurement);

        double resultantValue = this.standardize() + measurement.standardize();
        return createMeasurement(this.quantity,resultantValue,this.quantity.getStandardUnit());
    }

    public boolean isEqual(Measurement measurement, double threshold) {
        double delta = Math.abs(this.value - measurement.value);
        return delta <= threshold && this.quantity == measurement.quantity && this.unit == measurement.unit;
    }

    private static void validateMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidMeasurementException, UnacceptableUnitException {
        int leastPossibleValue = 0;
        if (value < leastPossibleValue){
            throw new InvalidMeasurementException(value);
        }
        if(!quantity.isAcceptable(unit)){
            throw new UnacceptableUnitException(unit,quantity);
        }
    }

    public static Measurement createMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidMeasurementException, UnacceptableUnitException {
        validateMeasurement(quantity,value,unit);
        return new Measurement(quantity,value, unit);
    }
}
