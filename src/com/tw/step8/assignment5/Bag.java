package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
	HashSet<Ball> balls;
	private final int limit;
	private final int greenBallLimit;

	public Bag(int limit, int greenBallLimit) {
		this.balls = new HashSet<>(limit);
		this.limit = limit;
		this.greenBallLimit = greenBallLimit;
	}

	public void add(Ball ball) throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException {
		if (this.balls.size() >= this.limit) {
			throw new ExceedingBagCapacityException();
		}

		long greenBallCount = this.getColoredBallCount(BallColor.GREEN);
		if (ball.color == BallColor.GREEN && greenBallCount == this.greenBallLimit) {
			throw new ExceedingColoredBallCapacityException(ball);
		}

		this.balls.add(ball);
	}

	private long getColoredBallCount(BallColor color) {
		return this.balls.stream()
			.filter(ball -> ball.color == color)
			.count();
	}

	public boolean contains(Ball ball) {
		return this.balls.contains(ball);
	}
}
