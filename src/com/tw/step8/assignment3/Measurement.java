package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidValueException;
import com.tw.step8.assignment3.exception.QuantityMismatchedException;
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

    private static void validateMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidValueException, UnacceptableUnitException {
        int leastPossibleValue = 0;
        if (value < leastPossibleValue) {
            throw new InvalidValueException(value);
        }
        if (!quantity.isAcceptable(unit)) {
            throw new UnacceptableUnitException(unit, quantity);
        }
    }

    public static Measurement createMeasurement(MeasuringQuantity quantity, double value, Unit unit) throws InvalidValueException, UnacceptableUnitException {
        validateMeasurement(quantity, value, unit);
        return new Measurement(quantity, value, unit);
    }

    private double standardize() {
        return this.unit.standardize(this.value);
    }

    private void validateQuantity(Measurement measurement) throws QuantityMismatchedException {
        if (measurement.quantity != this.quantity) {
            throw new QuantityMismatchedException(measurement.quantity, this.quantity);
        }
    }

    public Relation compare(Measurement measurement) throws QuantityMismatchedException {
        validateQuantity(measurement);

        double standardized = this.standardize();
        double givenStandardized = measurement.standardize();

        if (standardized == givenStandardized) {
            return Relation.EQUAL;
        }
        return standardized > givenStandardized ? Relation.GREATER : Relation.LESSER;
    }

    public Measurement add(Measurement measurement) throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        validateQuantity(measurement);

        double resultantValue = this.standardize() + measurement.standardize();
        return createMeasurement(this.quantity, resultantValue, this.quantity.getStandardUnit());
    }

    public boolean isEqual(Measurement measurement, double threshold) {
        double delta = Math.abs(this.value - measurement.value);
        return delta <= threshold && this.quantity == measurement.quantity && this.unit == measurement.unit;
    }
}
