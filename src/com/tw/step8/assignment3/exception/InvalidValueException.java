package com.tw.step8.assignment3.exception;

public class InvalidValueException extends Throwable {
    public InvalidValueException(double value) {
        super(String.format("Invalid length value %s",value));
    }
}
