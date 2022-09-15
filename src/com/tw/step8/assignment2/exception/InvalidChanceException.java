package com.tw.step8.assignment2.exception;

public class InvalidChanceException extends Throwable {
    public InvalidChanceException(double chance) {
        super(String.format("Invalid chance %s",chance));
    }
}
