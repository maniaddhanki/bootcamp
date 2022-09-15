package com.tw.step8.assignment2;

import com.tw.step8.assignment2.exception.InvalidChanceException;

import java.util.Objects;

public class Chance {

  private final double chance;

  private Chance(double chance) {
    this.chance = chance;
  }

  public static Chance createChance(double chance) throws InvalidChanceException {
    if (!isWithinRange(chance)){
      throw new InvalidChanceException(chance);
    }
    return new Chance(chance);
  }

  private static boolean isWithinRange(double chance) {
    int certainty = 1;
    int impossibility = 0;

    return impossibility <= chance && chance <= certainty;
  }

  public Chance complement() throws InvalidChanceException {
    return createChance(1 - this.chance);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Chance chance = (Chance) o;
    double delta = chance.chance - this.chance;
    return Math.abs(delta) <= 0.001 ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(chance);
  }

  private double combinedProbability(Chance chance2) {
    return chance * chance2.chance;
  }

  public Chance and(Chance chance2) throws InvalidChanceException {
    return createChance(combinedProbability(chance2));
  }

  public Chance or(Chance chance2) throws InvalidChanceException {
    double newProbability = (chance + chance2.chance) - combinedProbability(chance2);
    return createChance(newProbability);
  }
}
