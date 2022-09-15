package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exception.InvalidChanceException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ChanceTest {
  @Test
  void shouldThrowExceptionForInvalidChance() {
    assertThrows(InvalidChanceException.class,()->Chance.createChance(5));
    assertThrows(InvalidChanceException.class,()->Chance.createChance(-0.5));
  }

  @Test
  void shouldGiveChanceOfGettingATail() throws InvalidChanceException {
    Chance chance = Chance.createChance(0.5);
    Chance expectedChance = Chance.createChance(0.5);
    assertEquals(chance, expectedChance);
  }

  @Test
  void shouldGiveChanceOfNotGettingATail() throws InvalidChanceException {
    Chance chance = Chance.createChance(0.5);
    Chance actualComplement = chance.complement();
    Chance expectedComplement = Chance.createChance(0.5);
    assertEquals(actualComplement, expectedComplement);
  }

  @Test
  void shouldGiveChanceOfAllTailsInTwoCoins() throws InvalidChanceException {
    Chance chance1 = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.5);
    Chance actualChance = chance1.and(chance2);
    Chance expectedChance = Chance.createChance(0.25);
    assertEquals(actualChance, expectedChance);
  }

  @Test
  void shouldGiveChanceOfAtLeastATailInTwoCoins() throws InvalidChanceException {
    Chance chance1 = Chance.createChance(0.5);
    Chance chance2 = Chance.createChance(0.5);
    Chance actualChance = chance1.or(chance2);
    Chance expectedChance = Chance.createChance(0.75);
    assertEquals(actualChance, expectedChance);
  }

  @Test
  void shouldGiveChanceOfHeadAndASix() throws InvalidChanceException {
    Chance probabilityOfHead = Chance.createChance(0.5);
    Chance probabilityOfSix = Chance.createChance(0.167);
    Chance actualChance = probabilityOfHead.and(probabilityOfSix);
    Chance expectedChance = Chance.createChance(0.083);
    assertEquals(actualChance, expectedChance);
  }
}