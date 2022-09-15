package com.tw.step8.assignment3;

public enum Unit {
    FEET(12),
    INCH(1),
    CM(0.4),
    MM(0.04),
    LITRE(1),
    GALLON(3.78),
    CELSIUS(0){
        @Override
        public double standardize(double value) {
            return (value * 1.8) + 32;
        }
    },
    FAHRENHEIT(1);

    private final double inStandardUnit;

    Unit(double inStandardUnit) {
        this.inStandardUnit = inStandardUnit;
    }

    public double standardize(double value) {
        return this.inStandardUnit * value;
    }
}
