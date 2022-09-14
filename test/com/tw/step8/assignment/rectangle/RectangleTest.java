package com.tw.step8.assignment.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCalculateArea() {
    Rectangle rectangle = Shape.createRectangle(2, 2);
    assertEquals(4.0,rectangle.area());
  }

  @Test
  void shouldCalculateAreaOfRectangleWithSidesInPoints() {
    Rectangle rectangle = Shape.createRectangle(3.5, 2);
    assertEquals(7.0,rectangle.area());
  }

  @Test
  void shouldCalculatePerimeter() {
    Rectangle rectangle = Shape.createRectangle(2, 2);
    assertEquals(8.0,rectangle.perimeter());
  }

  @Test
  void shouldCalculateAreaOfSquare() {
    Rectangle square = Shape.createSquare(2);
    assertEquals(4.0,square.area());
  }
}