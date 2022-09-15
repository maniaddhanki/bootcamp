package com.tw.step8.assignment3.exception;

import com.tw.step8.assignment3.MeasuringQuantity;

public class QuantityMismatchedException extends Throwable {
    public QuantityMismatchedException(MeasuringQuantity quantity1, MeasuringQuantity quantity2) {
        super(String.format("Can not compare %s and %s",quantity2,quantity1));
    }
}
