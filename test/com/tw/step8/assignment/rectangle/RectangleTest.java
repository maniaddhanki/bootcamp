package com.tw.step8.assignment.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCalculateArea() {
    Rectangle rectangle = new Rectangle(2, 2);
    assertEquals(4.0,rectangle.area());
  }

  @Test
  void shouldCalculateAreaOfRectangleWithSidesInPoints() {
    Rectangle rectangle = new Rectangle(3.5, 2);
    assertEquals(7.0,rectangle.area());
  }

  @Test
  void shouldCalculatePerimeter() {
    Rectangle rectangle = new Rectangle(2, 2);
    assertEquals(8.0,rectangle.perimeter());
  }
}