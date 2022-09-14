package com.tw.step8.rectangle;

public class Rectangle {
  private final int lenght;
  private final int breadth;

  public Rectangle(int length, int breadth) {

    this.lenght = length;
    this.breadth = breadth;
  }

  public int area() {
    return lenght*breadth;
  }

  public int perimeter() {
    return 2*(lenght + breadth);
  }
}
