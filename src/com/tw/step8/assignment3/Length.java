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

    public Relation compare(Length length) {
        double lengthInInch = this.toInch();
        double givenLengthInInch = length.toInch();

        if (lengthInInch == givenLengthInInch){
            return Relation.EQUAL;
         }
        return lengthInInch > givenLengthInInch ? Relation.GREATER: Relation.LESSER;
    }
}
