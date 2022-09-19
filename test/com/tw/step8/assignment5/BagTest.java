package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
	@Test
	void shouldAddABallToTheBag() {
		Bag bag = new Bag(12);
		Ball ball = new Ball();
		bag.add(ball);

		assertTrue(bag.contains(ball));
	}
}