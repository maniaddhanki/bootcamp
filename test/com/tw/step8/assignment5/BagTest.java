package com.tw.step8.assignment5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {
	@Test
	void shouldAddABallToTheBag() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(12, 1);
		Ball ball = new Ball(BallColor.GREEN);
		bag.add(ball);

		assertTrue(bag.contains(ball));
	}

	@Test
	void shouldThrowExceptionWhenABallIsBeingAddedBeyondBagCapacity() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(1, 1);
		bag.add(new Ball(BallColor.GREEN));

		assertThrows(ExceedingBagCapacityException.class, () -> bag.add(new Ball(BallColor.GREEN)));
	}

	@Test
	void shouldThrowExceptionWhenGreenBallsAreAddedMoreThanLimit() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(2, 1);
		bag.add(new Ball(BallColor.GREEN));

		assertThrows(ExceedingColoredBallCapacityException.class, () -> bag.add(new Ball(BallColor.GREEN)));
	}

	@Test
	void shouldThrowExceptionWhenRedBallIsAddedWhenNoGreenStored() {
		Bag bag = Bag.createBag(2, 1);

		assertThrows(ExceedingColoredBallCapacityException.class, () -> bag.add(new Ball(BallColor.RED)));
	}

	@Test
	void shouldAddARedWhenAtleastAGreenBallIsPresent() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(2, 1);
		Ball redBall = new Ball(BallColor.RED);

		bag.add(new Ball(BallColor.GREEN));
		bag.add(redBall);

		assertTrue(bag.contains(redBall));
	}

	@Test
	void shouldAddAYellowBall() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(3, 2);
		Ball yellowBall = new Ball(BallColor.YELLOW);

		bag.add(new Ball(BallColor.GREEN));
		bag.add(new Ball(BallColor.GREEN));
		bag.add(yellowBall);

		assertTrue(bag.contains(yellowBall));
	}

	@Test
	void shouldThrowExceptionWhenAYellowBallIsAddedFirst() {
		Bag bag = Bag.createBag(2, 1);

		assertThrows(ExceedingColoredBallCapacityException.class, () -> bag.add(new Ball(BallColor.YELLOW)));
	}

	@Test
	void shouldThrowExceptionWhenAYellowBallOccupancyIsAboutToCrossFortyPercent() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(2, 1);
		bag.add(new Ball(BallColor.GREEN));

		assertThrows(ExceedingColoredBallCapacityException.class, () -> bag.add(new Ball(BallColor.YELLOW)));
	}

	@Test
	void shouldAddABlueBallIfBlackBallIsNotPresent() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(2, 2);
		Ball blueBall = new Ball(BallColor.BLUE);

		bag.add(blueBall);
		assertTrue(bag.contains(blueBall));
	}

	@Test
	void shouldAddABlackBallIfBlueBallIsNotPresent() throws ExceedingBagCapacityException, ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {
		Bag bag = Bag.createBag(2, 2);
		Ball blackBall = new Ball(BallColor.BLACK);

		bag.add(blackBall);
		assertTrue(bag.contains(blackBall));
	}

	@Test
	void shouldThrowExceptionWhenTryingToAddABlueBallWhileBlackIsPresent() throws
		ExceedingBagCapacityException,
		ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {

		Bag bag = Bag.createBag(2, 2);
		bag.add(new Ball(BallColor.BLACK));

		assertThrows(CanOnlyAddBlueOrBlackBallException.class, () -> bag.add(new Ball(BallColor.BLUE)));
	}

	@Test
	void shouldThrowExceptionWhenTryingToAddABlackBallWhileBlueIsPresent() throws
		ExceedingBagCapacityException,
		ExceedingColoredBallCapacityException, CanOnlyAddBlueOrBlackBallException {

		Bag bag = Bag.createBag(2, 2);
		bag.add(new Ball(BallColor.BLUE));

		assertThrows(CanOnlyAddBlueOrBlackBallException.class, () -> bag.add(new Ball(BallColor.BLACK)));
	}
}