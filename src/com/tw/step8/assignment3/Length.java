package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;

public class Length {
    private final double value;
    private final Unit unit;

    private Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double toInch() {
        return this.unit.toInch(this.value);
    }

    public Relation compare(Length length) {
        double lengthInInch = this.toInch();
        double givenLengthInInch = length.toInch();

        if (lengthInInch == givenLengthInInch){
            return Relation.EQUAL;
         }
        return lengthInInch > givenLengthInInch ? Relation.GREATER: Relation.LESSER;
    }

    public static Length createLength(double value, Unit unit) throws InvalidLengthException {
        if (value < 0){
            throw new InvalidLengthException(value);
        }
        return new Length(value, unit);
    }
}
