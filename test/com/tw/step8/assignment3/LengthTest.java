package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldRelateSameLengthsAsEqual() {
        Length length1 = new Length(4, Unit.INCH);
        Length length2 = new Length(4, Unit.INCH);
        assertEquals(Relation.EQUAL,length1.compare(length2));
    }

    @Test
    void shouldRelateGreaterIfGivenLengthIsSmaller() {
        Length length1 = new Length(4, Unit.INCH);
        Length length2 = new Length(2, Unit.INCH);
        assertEquals(Relation.GREATER,length1.compare(length2));
    }

    @Test
    void shouldRelateLesserIfGivenLengthIsLarger() {
        Length length1 = new Length(4, Unit.INCH);
        Length length2 = new Length(8, Unit.INCH);
        assertEquals(Relation.LESSER,length1.compare(length2));
    }

    @Test
    void shouldCompareLengthsInFeetAndInch() {
        Length feet = new Length(1, Unit.FEET);
        Length inch = new Length(12, Unit.INCH);
        assertEquals(Relation.EQUAL,feet.compare(inch));
    }

    @Test
    void shouldCompareLengthsInInchAndCentimeter() {
        Length cm = new Length(5, Unit.CM);
        Length inch = new Length(3, Unit.INCH);
        assertEquals(Relation.LESSER,cm.compare(inch));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndCentimeter() {
        Length cm = new Length(1, Unit.CM);
        Length mm = new Length(10, Unit.MM);
        assertEquals(Relation.EQUAL,cm.compare(mm));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndInch() {
        Length mm = new Length(100, Unit.MM);
        Length inch = new Length(4, Unit.INCH);
        assertEquals(Relation.EQUAL,inch.compare(mm));
    }
}