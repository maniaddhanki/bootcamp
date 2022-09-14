package com.tw.step8.assignment.square;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
  @Test
  void shouldCalculateTheAreaOfSquare() {
    Square square = new Square(4);
    assertEquals(16.0,square.area());
  }
  @Test
  void shouldCalculatePerimeterOfSquare() {
    Square square = new Square(4);
    assertEquals(16.0,square.perimeter());
  }
}