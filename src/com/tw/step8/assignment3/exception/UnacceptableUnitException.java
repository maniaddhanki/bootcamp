package com.tw.step8.assignment3.exception;

import com.tw.step8.assignment3.MeasuringQuantity;
import com.tw.step8.assignment3.Unit;

public class UnacceptableUnitException extends Throwable {
    public UnacceptableUnitException(Unit unit, MeasuringQuantity quantity) {
        super(String.format("%s unit does not belong to %s",unit,quantity));
    }
}
