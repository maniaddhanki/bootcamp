package com.tw.step8.assignment1.rectangle;

public class Rectangle {
  private final double length;
  private final double breadth;

  protected Rectangle(double length, double breadth) {

    this.length = length;
    this.breadth = breadth;
  }

  public double area() {
    return length *breadth;
  }

  public double perimeter() {
    return 2*(length + breadth);
  }
}
