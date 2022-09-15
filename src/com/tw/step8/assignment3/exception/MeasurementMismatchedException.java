package com.tw.step8.assignment3.exception;

import com.tw.step8.assignment3.MeasuringQuantity;

public class MeasurementMismatchedException extends Throwable {
    public MeasurementMismatchedException(MeasuringQuantity quantity1, MeasuringQuantity quantity2) {
        super(String.format("Can not compare %s and %s",quantity2,quantity1));
    }
}
