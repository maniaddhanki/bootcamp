package com.tw.step8.assignment5;

import java.util.HashMap;
import java.util.HashSet;

public class Bag {
	HashSet<Ball> balls;
	HashMap<BallColor, Integer> coloredBallCount;
	HashMap<BallColor, Integer> coloredBallLimit;
	private final int bagCapacity;
	private boolean isBluePresent;
	private boolean isBlackPresent;

	private Bag(int bagCapacity, HashMap<BallColor, Integer> coloredBallCount, HashMap<BallColor, Integer> coloredBallLimit) {
		this.balls = new HashSet<>(bagCapacity);
		this.bagCapacity = bagCapacity;
		this.coloredBallCount = coloredBallCount;
		this.coloredBallLimit = coloredBallLimit;
		this.isBluePresent = false;
		this.isBlackPresent = false;
	}

	public static Bag createBag(int limit, int greenBallLimit) {
		HashMap<BallColor, Integer> coloredBallCount = new HashMap<>();
		HashMap<BallColor, Integer> coloredBallLimit = new HashMap<>();

		coloredBallLimit.put(BallColor.GREEN, greenBallLimit);
		coloredBallLimit.put(BallColor.RED, 0);
		coloredBallLimit.put(BallColor.YELLOW, 0);
		coloredBallLimit.put(BallColor.BLUE, limit);
		coloredBallLimit.put(BallColor.BLACK, limit);

		return new Bag(limit, coloredBallCount, coloredBallLimit);
	}

	public void add(Ball ball) throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		if (this.balls.size() >= this.bagCapacity) {
			throw new ExceedingBagCapacityException();
		}

		validateAddition(ball);
		this.balls.add(ball);
		updateCountAndLimit(ball);
	}

	private void updateCountAndLimit(Ball ball) {
		if (ball.color == BallColor.BLUE) this.isBluePresent = true;
		if (ball.color == BallColor.BLACK) this.isBlackPresent = true;

		Integer currentCount = this.coloredBallCount.getOrDefault(ball.color,0) + 1;
		this.coloredBallCount.put(ball.color,currentCount);

		Integer currentGreenBalls = this.coloredBallCount.getOrDefault(BallColor.GREEN, 0);
		this.coloredBallLimit.replace(BallColor.RED, currentGreenBalls * 2);

		int currentOccupancy = this.balls.size() + 1;
		int yellowBallLimit = (40 * currentOccupancy) / 100;
		this.coloredBallLimit.replace(BallColor.YELLOW, yellowBallLimit);
	}

	private void validateAddition(Ball ball) throws ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Integer ballLimit = this.coloredBallLimit.get(ball.color);
		Integer ballCount = this.coloredBallCount.getOrDefault(ball.color,0);

		if (ball.color == BallColor.BLUE && isBlackPresent){
			throw new CanOnlyAddBlueOrBlackBallException(ball);
		}

		if (ball.color == BallColor.BLACK && isBluePresent){
			throw new CanOnlyAddBlueOrBlackBallException(ball);
		}

		if(ballLimit <= ballCount ) {
			throw new ExceedingColoredBallCapacityException(ball);
		}
	}

	public boolean contains(Ball ball) {
		return this.balls.contains(ball);
	}
}
