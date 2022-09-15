package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldCompareLengthsOfSameUnits() {
        Length length1 = new Length(4, Unit.INCH);
        Length length2 = new Length(4, Unit.INCH);
        assertEquals(0,length1.compare(length2));
    }

    @Test
    void shouldReturn1WhenGivenLengthIsSmallerAndOfSameUnits() {
        Length length1 = new Length(4, Unit.INCH);
        Length length2 = new Length(2, Unit.INCH);
        assertEquals(1,length1.compare(length2));
    }

    @Test
    void shouldGiveNegativeOneWhenGivenLengthIsGreaterAndOfSameUnits() {
        Length length1 = new Length(4, Unit.INCH);
        Length length2 = new Length(8, Unit.INCH);
        assertEquals(-1,length1.compare(length2));
    }

    @Test
    void shouldCompareLengthOfDifferentUnits() {
        Length feet = new Length(1, Unit.FEET);
        Length inch = new Length(12, Unit.INCH);
        assertEquals(0,feet.compare(inch));
    }

    @Test
    void shouldCompareLengthsInInchAndCentimeter() {
        Length cm = new Length(5, Unit.CM);
        Length inch = new Length(3, Unit.INCH);
        assertEquals(-1,cm.compare(inch));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndCentimeter() {
        Length cm = new Length(1, Unit.CM);
        Length mm = new Length(10, Unit.MM);
        assertEquals(0,cm.compare(mm));
    }
}