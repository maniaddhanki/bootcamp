package com.tw.step8.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
  @Test
  void ShouldGiveProbabilityOfGettingTail() {
    assertEquals(0.5,Coin.probabilityOfTail());
  }
}