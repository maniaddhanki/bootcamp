package com.tw.step8.assignment5;

import java.util.HashMap;
import java.util.HashSet;

public class Bag {
	HashSet<Ball> balls;
	HashMap<BallColor, Integer> coloredBallCount;
	HashMap<BallColor, Integer> coloredBallLimit;
	private final int bagCapacity;

	private Bag(int bagCapacity, HashMap<BallColor, Integer> coloredBallCount, HashMap<BallColor, Integer> coloredBallLimit) {
		this.balls = new HashSet<>(bagCapacity);
		this.bagCapacity = bagCapacity;
		this.coloredBallCount = coloredBallCount;
		this.coloredBallLimit = coloredBallLimit;
	}

	public static Bag createBag(int limit, int greenBallLimit) {
		HashMap<BallColor, Integer> coloredBallCount = new HashMap<>();
		HashMap<BallColor, Integer> coloredBallLimit = new HashMap<>();

		coloredBallLimit.put(BallColor.GREEN, greenBallLimit);
		coloredBallLimit.put(BallColor.RED, 0);

		return new Bag(limit, coloredBallCount, coloredBallLimit);
	}

	public void add(Ball ball) throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException {
		if (this.balls.size() >= this.bagCapacity) {
			throw new ExceedingBagCapacityException();
		}

		validateAddition(ball);
		this.balls.add(ball);
		Integer currentCount = this.coloredBallCount.getOrDefault(ball.color,0);
		this.coloredBallCount.put(ball.color,currentCount+1);
	}

	private void validateAddition(Ball ball) throws ExceedingColoredBallCapacityException {
		Integer ballLimit = this.coloredBallLimit.get(ball.color);
		Integer ballCount = this.coloredBallCount.getOrDefault(ball.color,0);

		if(ballLimit <= ballCount ){
			throw new ExceedingColoredBallCapacityException(ball);
		}
	}

	public boolean contains(Ball ball) {
		return this.balls.contains(ball);
	}
}
