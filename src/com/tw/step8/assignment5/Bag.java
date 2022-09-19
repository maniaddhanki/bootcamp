package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
	HashSet<Ball> balls;
	private final int limit;

	public Bag(int limit) {
		this.balls = new HashSet<>(limit);
		this.limit = limit;
	}

	public void add(Ball ball) throws ExceedingBagCapacityException {
		if (this.balls.size() >= this.limit) {
			throw new ExceedingBagCapacityException();
		}

		this.balls.add(ball);
	}

	public boolean contains(Ball ball) {
		return this.balls.contains(ball);
	}
}
