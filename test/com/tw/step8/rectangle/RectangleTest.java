package com.tw.step8.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

  @Test
  void shouldCalculateArea() {
    Rectangle rectangle = new Rectangle(2, 2);
    assertEquals(rectangle.area(),4);
  }
}