package com.tw.step8.assignment2;

import java.util.Objects;

public class Chance {

  private final double probability;

  public Chance(double probability) {
    this.probability = probability;
  }

  public Chance complement() {
    return new Chance(1 - this.probability);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Chance chance = (Chance) o;
    double delta = chance.probability - probability;
    return delta <= 0.001 && delta >= -0.001;
  }

  @Override
  public int hashCode() {
    return Objects.hash(probability);
  }

  private double combinedProbability(Chance chance2) {
    return probability * chance2.probability;
  }

  public Chance and(Chance chance2) {
    return new Chance(combinedProbability(chance2));
  }

  public Chance or(Chance chance2) {
    double newProbability = (probability + chance2.probability) - combinedProbability(chance2);
    return new Chance(newProbability);
  }
}
