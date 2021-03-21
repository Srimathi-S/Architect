package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistanceMetricsTest {

    @Test
    public void testIsTrueFor1CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double dimension = 1;
        DistanceMetrics firstDistanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics secondDistanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Centimeter);

        boolean actual = firstDistanceMetrics.equals(secondDistanceMetrics);

        assertTrue(actual);
    }

    @Test
    public void testIsFalseFor2CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double firstDimension = 2;
        double secondDimension = 1;
        DistanceMetrics firstDistanceMetrics = new DistanceMetrics(firstDimension, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics secondDistanceMetrics = new DistanceMetrics(secondDimension, DistanceMetrics.UnitOfDistance.Centimeter);

        boolean actual = firstDistanceMetrics.equals(secondDistanceMetrics);

        assertFalse(actual);
    }

    @Test
    public void testIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        DistanceMetrics firstDistanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Centimeter);
        Integer distance = 1;

        boolean actual = firstDistanceMetrics.equals(distance);

        assertFalse(actual);
    }

    @Test
    public void testIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        DistanceMetrics distanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Centimeter);

        boolean actual = distanceMetrics.equals(distanceMetrics);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Centimeter));
    }

    @Test
    public void testIsTrueFor1MeterEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);

        boolean actual = distanceMetricsInCentimeter.equals(distanceMetricsInMeter);

        assertTrue(actual);
    }

    @Test
    public void testIsTrueFor100CentimeterEquals1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);

        boolean actual = distanceMetricsInMeter.equals(distanceMetricsInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInKilometer = new DistanceMetrics(dimensionInKilometer, DistanceMetrics.UnitOfDistance.Kilometer);

        boolean actual = distanceMetricsInCentimeter.equals(distanceMetricsInKilometer);

        assertTrue(actual);
    }

    @Test
    public void testIsTrueForOneThousandthKilometerEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInKilometer = new DistanceMetrics(dimensionInKilometer, DistanceMetrics.UnitOfDistance.Kilometer);

        boolean actual = distanceMetricsInKilometer.equals(distanceMetricsInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        ScalarMetrics<DistanceMetrics> distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(2, DistanceMetrics.UnitOfDistance.Meter);

        DistanceMetrics actual = (DistanceMetrics) distanceMetricsInMeter.add(distanceMetricsInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        DistanceMetrics measurementInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics measurementInKilometer = new DistanceMetrics(dimensionInKilometer, DistanceMetrics.UnitOfDistance.Kilometer);
        DistanceMetrics expected = new DistanceMetrics(100200, DistanceMetrics.UnitOfDistance.Centimeter);

        DistanceMetrics actual = (DistanceMetrics) measurementInKilometer.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(2, DistanceMetrics.UnitOfDistance.Kilometer);

        DistanceMetrics actual = (DistanceMetrics) distanceMetricsInMeter.add(distanceMetricsInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(0.5, DistanceMetrics.UnitOfDistance.Meter);

        DistanceMetrics actual = (DistanceMetrics) distanceMetricsInMeter.subtract(distanceMetricsInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(1900, DistanceMetrics.UnitOfDistance.Centimeter);

        DistanceMetrics actual = (DistanceMetrics) distanceMetricsInCentimeter.subtract(distanceMetricsInMeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, DistanceMetrics.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);

        assertThrows(IllegalArgumentException.class, () -> distanceMetricsInCentimeter.subtract(distanceMetricsInMeter));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, DistanceMetrics.UnitOfDistance.Meter);

        assertThrows(IllegalArgumentException.class, () -> distanceMetricsInMeter.subtract(distanceMetricsInMeter));
    }

}
