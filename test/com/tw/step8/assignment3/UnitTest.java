package com.tw.step8.assignment3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void shouldConvertFeetToInch() {
        assertEquals(12,Unit.FEET.toInch(1));
        assertEquals(16.8,Unit.FEET.toInch(1.4),0.01);
    }
    @Test
    void shouldConvertCmToInch() {
        assertEquals(2,Unit.CM.toInch(5));
        assertEquals(6,Unit.CM.toInch(15));
    }

    @Test
    void shouldConvertMmToInch() {
        assertEquals(4,Unit.MM.toInch(100));
        assertEquals(8.4,Unit.MM.toInch(210),0.01);
    }

    @Test
    void shouldConvertInchToInch() {
        assertEquals(1,Unit.INCH.toInch(1));
        assertEquals(15,Unit.INCH.toInch(15));
    }
}