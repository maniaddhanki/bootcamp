package com.tw.step8.assignment2;

public class Coin {
  private CoinFace[] faces;

  public Coin(CoinFace[] faces) {
    this.faces = faces;
  }

  public double probabilityOfTail(){
    double tails = this.getCount(CoinFace.TAIL);
    return tails / faces.length;
  }

  private int getCount(CoinFace coinFace) {
    int count = 0;
    for (CoinFace face : faces) {
      if(face == coinFace){
        count++;
      }
    }
    return count;
  }

  public double probabilityOfNotGettingTail() {
    return 1 - probabilityOfTail();
  }
}
