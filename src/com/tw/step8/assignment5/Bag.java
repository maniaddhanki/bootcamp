package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
	HashSet<Ball> balls;
	public Bag(int limit) {
		this.balls = new HashSet<>(limit);
	}

	public void add(Ball ball) {
		this.balls.add(ball);
	}

	public boolean contains(Ball ball) {
		return this.balls.contains(ball);
	}
}
