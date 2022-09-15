package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldConvertFeetToInch() {
        assertEquals(12,Unit.FEET.standardize(1));
        assertEquals(16.8,Unit.FEET.standardize(1.4),0.01);
    }
    @Test
    void shouldConvertCmToInch() {
        assertEquals(2,Unit.CM.standardize(5));
        assertEquals(6,Unit.CM.standardize(15));
    }

    @Test
    void shouldConvertMmToInch() {
        assertEquals(4,Unit.MM.standardize(100));
        assertEquals(8.4,Unit.MM.standardize(210),0.01);
    }

    @Test
    void shouldConvertInchToInch() {
        assertEquals(1,Unit.INCH.standardize(1));
        assertEquals(15,Unit.INCH.standardize(15));
    }
}