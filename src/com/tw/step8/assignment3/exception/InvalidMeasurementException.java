package com.tw.step8.assignment3.exception;

public class InvalidMeasurementException extends Throwable {
    public InvalidMeasurementException(double value) {
        super(String.format("Invalid length value %s",value));
    }
}
