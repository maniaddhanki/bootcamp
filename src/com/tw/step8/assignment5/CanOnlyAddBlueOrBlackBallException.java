package com.tw.step8.assignment5;

public class CanOnlyAddBlueOrBlackBallException extends Throwable {
	public CanOnlyAddBlueOrBlackBallException(Ball ball) {
		super("Ball: " + ball.color + ", Can only add blue or black ball");
	}
}
