package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
	@Test
	void shouldAddABallToTheBag() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException {
		Bag bag = new Bag(12, 1);
		Ball ball = new Ball(BallColor.GREEN);
		bag.add(ball);

		assertTrue(bag.contains(ball));
	}

	@Test
	void shouldThrowExceptionWhenABallIsBeingAddedBeyondBagCapacity() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException {
		Bag bag = new Bag(1, 1);
		bag.add(new Ball(BallColor.GREEN));

		assertThrows(ExceedingBagCapacityException.class,()-> bag.add(new Ball(BallColor.GREEN)));
	}

	@Test
	void shouldThrowExceptionWhenGreenBallsAreAddedMoreThanLimit() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException {
		Bag bag = new Bag(2, 1);
		bag.add(new Ball(BallColor.GREEN));

		assertThrows(ExceedingColoredBallCapacityException.class,()->bag.add(new Ball(BallColor.GREEN)));
	}
}