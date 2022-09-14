package com.tw.step8.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {
  @Test
  void ShouldGiveProbabilityOfGettingTail() {
    Coin coin = new Coin(new CoinFace[]{CoinFace.HEAD, CoinFace.TAIL});
    assertEquals(0.5,coin.probabilityOfTail());
  }

  @Test
  void ShouldGiveProbabilityOfNotGettingTail() {
    Coin coin = new Coin(new CoinFace[]{CoinFace.HEAD, CoinFace.TAIL});
    assertEquals(0.5,coin.probabilityOfNotGettingTail());
  }
}