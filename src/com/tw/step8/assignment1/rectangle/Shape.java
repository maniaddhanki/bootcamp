package com.tw.step8.assignment1.rectangle;

public class Shape {

  public static Rectangle createRectangle(double length, double breadth) {
    return new Rectangle(length, breadth);
  }

  public static Rectangle createSquare(double side) {
    return new Rectangle(side,side);
  }
}
