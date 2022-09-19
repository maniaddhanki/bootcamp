package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
	@Test
	void shouldAddABallToTheBag() throws ExceedingBagCapacityException {
		Bag bag = new Bag(12);
		Ball ball = new Ball();
		bag.add(ball);

		assertTrue(bag.contains(ball));
	}

	@Test
	void shouldThrowExceptionWhenABallIsBeingAddedBeyondBagCapacity() throws ExceedingBagCapacityException {
		Bag bag = new Bag(1);
		bag.add(new Ball());

		assertThrows(ExceedingBagCapacityException.class,()-> bag.add(new Ball()));
	}
}