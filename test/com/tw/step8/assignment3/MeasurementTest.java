package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidMeasurementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Test
    void shouldThrowAnExceptionForNegativeLength() {
        assertThrows(InvalidMeasurementException.class,()-> Measurement.createMeasurement(MeasuringQuantity.LENGTH,-1,Unit.INCH));
    }

    @Test
    void shouldRelateSameLengthsAsEqual() throws InvalidMeasurementException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        assertEquals(Relation.EQUAL,length1.compare(length2));
    }

    @Test
    void shouldRelateGreaterIfGivenLengthIsSmaller() throws InvalidMeasurementException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,2, Unit.INCH);
        assertEquals(Relation.GREATER,length1.compare(length2));
    }

    @Test
    void shouldRelateLesserIfGivenLengthIsLarger() throws InvalidMeasurementException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,8, Unit.INCH);
        assertEquals(Relation.LESSER,length1.compare(length2));
    }

    @Test
    void shouldCompareLengthsInFeetAndInch() throws InvalidMeasurementException {
        Measurement feet = Measurement.createMeasurement(MeasuringQuantity.LENGTH,1, Unit.FEET);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,12, Unit.INCH);
        assertEquals(Relation.EQUAL,feet.compare(inch));
    }

    @Test
    void shouldCompareLengthsInInchAndCentimeter() throws InvalidMeasurementException {
        Measurement cm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,5, Unit.CM);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,3, Unit.INCH);
        assertEquals(Relation.LESSER,cm.compare(inch));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndCentimeter() throws InvalidMeasurementException {
        Measurement cm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,1, Unit.CM);
        Measurement mm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,10, Unit.MM);
        assertEquals(Relation.EQUAL,cm.compare(mm));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndInch() throws InvalidMeasurementException {
        Measurement mm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,100, Unit.MM);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        assertEquals(Relation.EQUAL,inch.compare(mm));
    }

    @Test
    void shouldCompareVolumesInLitreAndGallons() throws InvalidMeasurementException {
        Measurement litre = Measurement.createMeasurement(MeasuringQuantity.VOLUME,3.78, Unit.LITRE);
        Measurement gallon = Measurement.createMeasurement(MeasuringQuantity.VOLUME,1, Unit.GALLON);
        assertEquals(Relation.EQUAL,gallon.compare(litre));
    }
}