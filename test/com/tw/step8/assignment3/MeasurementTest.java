package com.tw.step8.assignment3;

import com.tw.step8.assignment3.exception.InvalidValueException;
import com.tw.step8.assignment3.exception.QuantityMismatchedException;
import com.tw.step8.assignment3.exception.UnacceptableUnitException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Test
    void shouldThrowAnExceptionForNegativeLength() {
        assertThrows(InvalidValueException.class, () -> Measurement.createMeasurement(MeasuringQuantity.LENGTH, -1, Unit.INCH));
    }

    @Test
    void shouldRelateSameLengthsAsEqual() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        assertEquals(Relation.EQUAL,length1.compare(length2));
        assertEquals(Relation.EQUAL,length2.compare(length1));
    }

    @Test
    void shouldRelateGreaterIfGivenLengthIsSmaller() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,2, Unit.INCH);

        assertEquals(Relation.GREATER,length1.compare(length2));
    }

    @Test
    void shouldRelateLesserIfGivenLengthIsLarger() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH,8, Unit.INCH);

        assertEquals(Relation.LESSER,length1.compare(length2));
    }

    @Test
    void shouldCompareLengthsInFeetAndInch() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement feet = Measurement.createMeasurement(MeasuringQuantity.LENGTH,1, Unit.FEET);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,12, Unit.INCH);

        assertEquals(Relation.EQUAL,feet.compare(inch));
        assertEquals(Relation.EQUAL,inch.compare(feet));
    }

    @Test
    void shouldCompareLengthsInInchAndCentimeter() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement cm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,5, Unit.CM);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,3, Unit.INCH);

        assertEquals(Relation.LESSER,cm.compare(inch));
        assertEquals(Relation.GREATER,inch.compare(cm));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndCentimeter() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement cm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,1, Unit.CM);
        Measurement mm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,10, Unit.MM);

        assertEquals(Relation.EQUAL,cm.compare(mm));
        assertEquals(Relation.EQUAL,mm.compare(cm));
    }

    @Test
    void shouldCompareLengthsInMillimeterAndInch() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement mm = Measurement.createMeasurement(MeasuringQuantity.LENGTH,100, Unit.MM);
        Measurement inch = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4, Unit.INCH);

        assertEquals(Relation.EQUAL,inch.compare(mm));
        assertEquals(Relation.EQUAL,mm.compare(inch));
    }

    @Test
    void shouldCompareVolumesInLitreAndGallons() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement litre = Measurement.createMeasurement(MeasuringQuantity.VOLUME,3.78, Unit.LITRE);
        Measurement gallon = Measurement.createMeasurement(MeasuringQuantity.VOLUME,1, Unit.GALLON);

        assertEquals(Relation.EQUAL,gallon.compare(litre));
    }

    @Test
    void shouldThrowAnExceptionForComparingDifferentQuantities() throws InvalidValueException, UnacceptableUnitException {
        Measurement volume = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.LITRE);
        Measurement length = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 1, Unit.CM);

        assertThrows(QuantityMismatchedException.class, () -> volume.compare(length));
    }

    @Test
    void shouldAddTwoMeasurementsOfSameUnit() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2, Unit.INCH);

        Measurement actualLength = length1.add(length2);
        Measurement expectedLength = Measurement.createMeasurement(MeasuringQuantity.LENGTH,4,Unit.INCH);

        assertTrue(actualLength.isEqual(expectedLength,0.01));
    }

    @Test
    void shouldAddTwoLengthsOfDifferentUnitsAndGiveResultInInch() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement length1 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2, Unit.INCH);
        Measurement length2 = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 2.5, Unit.CM);

        Measurement actualLength = length1.add(length2);
        Measurement expectedLength = Measurement.createMeasurement(MeasuringQuantity.LENGTH,3,Unit.INCH);

        assertTrue(actualLength.isEqual(expectedLength,0.01));
    }
    @Test
    void shouldAddTwoVolumesOfDifferentUnitsAndGiveResultInLitres() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement gallon = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.GALLON);
        Measurement litre = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.LITRE);

        Measurement actualVolume = gallon.add(litre);
        Measurement expectedVolume = Measurement.createMeasurement(MeasuringQuantity.VOLUME,4.78,Unit.LITRE);

        assertTrue(actualVolume.isEqual(expectedVolume,0.01));
    }

    @Test
    void shouldThrowAnExceptionForAddingDifferentQuantities() throws InvalidValueException, UnacceptableUnitException {
        Measurement volume = Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.LITRE);
        Measurement length = Measurement.createMeasurement(MeasuringQuantity.LENGTH, 1, Unit.CM);

        assertThrows(QuantityMismatchedException.class, () -> volume.add(length));
    }

    @Test
    void shouldCompareTemperaturesInCelsiusAndFahrenheit() throws InvalidValueException, QuantityMismatchedException, UnacceptableUnitException {
        Measurement celsius = Measurement.createMeasurement(MeasuringQuantity.TEMPERATURE,100, Unit.CELSIUS);
        Measurement fahrenheit = Measurement.createMeasurement(MeasuringQuantity.TEMPERATURE,212, Unit.FAHRENHEIT);

        assertEquals(Relation.EQUAL,celsius.compare(fahrenheit));
    }

    @Test
    void shouldThrowAnExceptionForInvalidUnitOfAQuantity() {
        assertThrows(UnacceptableUnitException.class, () -> {
            Measurement.createMeasurement(MeasuringQuantity.VOLUME, 1, Unit.INCH);
        });
    }
}