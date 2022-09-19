package com.tw.step8.assignment5;

import java.util.HashSet;

public class Bag {
	HashSet<Ball> balls;
	public Bag() {
		this.balls = new HashSet<>();
	}

	public void add(Ball ball) {
		this.balls.add(ball);
	}

	public boolean contains(Ball ball) {
		return this.balls.contains(ball);
	}
}
