package com.tw.step8.assignment2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class ChanceTest {
  @Test
  void shouldGiveChanceOfGettingATail() {
    Chance chance = new Chance(0.5);
    Chance expectedChance = new Chance(0.5);
    assertEquals(chance, expectedChance);
  }

  @Test
  void shouldGiveChanceOfNotGettingATail() {
    Chance chance = new Chance(0.5);
    Chance actualComplement = chance.complement();
    Chance expectedComplement = new Chance(0.5);
    assertEquals(actualComplement, expectedComplement);
  }

  @Test
  void shouldGiveChanceOfAllTailsInTwoCoins() {
    Chance chance1 = new Chance(0.5);
    Chance chance2 = new Chance(0.5);
    Chance actualChance = chance1.and(chance2);
    Chance expectedChance = new Chance(0.25);
    assertEquals(actualChance, expectedChance);
  }

  @Test
  void shouldGiveChanceOfAtLeastATailInTwoCoins() {
    Chance chance1 = new Chance(0.5);
    Chance chance2 = new Chance(0.5);
    Chance actualChance = chance1.or(chance2);
    Chance expectedChance = new Chance(0.75);
    assertEquals(actualChance, expectedChance);
  }

  @Test
  void shouldGiveChanceOfHeadAndASix() {
    Chance probabilityOfHead = new Chance(0.5);
    Chance probabilityOfSix = new Chance(0.167);
    Chance actualChance = probabilityOfHead.and(probabilityOfSix);
    Chance expectedChance = new Chance(0.083);
    assertEquals(actualChance, expectedChance);
  }
}