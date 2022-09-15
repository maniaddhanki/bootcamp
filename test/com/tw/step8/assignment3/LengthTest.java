package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthTest {
    @Test
    void shouldThrowAnExceptionForNegativeLength() {
        assertThrows(InvalidLengthException.class,()->Length.createLength(-1,Unit.INCH));
    }

    @Test
    void shouldRelateSameLengthsAsEqual() throws InvalidLengthException {
        Length length1 = Length.createLength(4, Unit.INCH);
        Length length2 = Length.createLength(4, Unit.INCH);
        assertEquals(Relation.EQUAL,length1.compare(length2));
    }

    @Test
    void shouldRelateGreaterIfGivenLengthIsSmaller() throws InvalidLengthException {
        Length length1 = Length.createLength(4, Unit.INCH);
        Length length2 = Length.createLength(2, Unit.INCH);
        assertEquals(Relation.GREATER,length1.compare(length2));
    }

    @Test
    void shouldRelateLesserIfGivenLengthIsLarger() throws InvalidLengthException {
        Length length1 = Length.createLength(4, Unit.INCH);
        Length length2 = Length.createLength(8, Unit.INCH);
        assertEquals(Relation.LESSER,length1.compare(length2));
    }

    @Test
    void shouldCompareLengthsInFeetAndInch() throws InvalidLengthException {
        Length feet = Length.createLength(1, Unit.FEET);
        Length inch = Length.createLength(12, Unit.INCH);
        assertEquals(Relation.EQUAL,feet.compare(inch));
    }

    @Test
    void shouldCompareLengthsInInchAndCentimeter() throws InvalidLengthException {
        Length cm = Length.createLength(5, Unit.CM);
        Length inch = Length.createLength(3, Unit.INCH);
        assertEquals(Relation.LESSER,cm.compare(inch));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndCentimeter() throws InvalidLengthException {
        Length cm = Length.createLength(1, Unit.CM);
        Length mm = Length.createLength(10, Unit.MM);
        assertEquals(Relation.EQUAL,cm.compare(mm));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndInch() throws InvalidLengthException {
        Length mm = Length.createLength(100, Unit.MM);
        Length inch = Length.createLength(4, Unit.INCH);
        assertEquals(Relation.EQUAL,inch.compare(mm));
    }
}