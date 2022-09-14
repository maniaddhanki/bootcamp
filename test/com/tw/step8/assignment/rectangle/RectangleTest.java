package com.tw.step8.assignment.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCalculateArea() {
    Rectangle rectangle = new Rectangle(2, 2);
    assertEquals(rectangle.area(),4);
  }

  @Test
  void shouldCalculateAreaOfRectangleWithSidesInPoints() {
    Rectangle rectangle = new Rectangle(3.5, 2);
    assertEquals(rectangle.area(),7);
  }

  @Test
  void shouldCalculatePerimeter() {
    Rectangle rectangle = new Rectangle(2, 2);
    assertEquals(rectangle.perimeter(),8);
  }
}