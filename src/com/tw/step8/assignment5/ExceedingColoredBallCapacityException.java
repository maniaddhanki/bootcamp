package com.tw.step8.assignment5;

public class ExceedingColoredBallCapacityException extends Throwable {

	public ExceedingColoredBallCapacityException(Ball ball) {
		super("Exceeding " + ball.color + " balls capacity");
	}
}
