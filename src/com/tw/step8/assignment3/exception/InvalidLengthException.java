package com.tw.step8.assignment3.exception;

public class InvalidLengthException extends Throwable {
    public InvalidLengthException(double value) {
        super(String.format("Invalid length value %s",value));
    }
}
