package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistanceMetricsTest {

    @Test
    public void testEqualsIsTrueFor1CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double dimension = 1;
        DistanceMetrics firstDistanceMetrics = new DistanceMetrics(dimension, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics secondDistanceMetrics = new DistanceMetrics(dimension, Unit.UnitOfDistance.Centimeter);

        boolean actual = firstDistanceMetrics.equals(secondDistanceMetrics);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double firstDimension = 2;
        double secondDimension = 1;
        DistanceMetrics firstDistanceMetrics = new DistanceMetrics(firstDimension, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics secondDistanceMetrics = new DistanceMetrics(secondDimension, Unit.UnitOfDistance.Centimeter);

        boolean actual = firstDistanceMetrics.equals(secondDistanceMetrics);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        DistanceMetrics firstDistanceMetrics = new DistanceMetrics(dimension, Unit.UnitOfDistance.Centimeter);
        Integer distance = 1;

        boolean actual = firstDistanceMetrics.equals(distance);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        DistanceMetrics distanceMetrics = new DistanceMetrics(dimension, Unit.UnitOfDistance.Centimeter);

        boolean actual = distanceMetrics.equals(distanceMetrics);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new DistanceMetrics(dimension, Unit.UnitOfDistance.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new DistanceMetrics(dimension, Unit.UnitOfDistance.Centimeter));
    }

    @Test
    public void testEqualsIsTrueFor1MeterEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);

        boolean actual = distanceMetricsInCentimeter.equals(distanceMetricsInMeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEquals1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);

        boolean actual = distanceMetricsInMeter.equals(distanceMetricsInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInKilometer = new DistanceMetrics(dimensionInKilometer, Unit.UnitOfDistance.Kilometer);

        boolean actual = distanceMetricsInCentimeter.equals(distanceMetricsInKilometer);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInKilometer = new DistanceMetrics(dimensionInKilometer, Unit.UnitOfDistance.Kilometer);

        boolean actual = distanceMetricsInKilometer.equals(distanceMetricsInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(2, Unit.UnitOfDistance.Meter);

        DistanceMetrics actual = distanceMetricsInMeter.add(distanceMetricsInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        DistanceMetrics measurementInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics measurementInKilometer = new DistanceMetrics(dimensionInKilometer, Unit.UnitOfDistance.Kilometer);
        DistanceMetrics expected = new DistanceMetrics(100200, Unit.UnitOfDistance.Centimeter);

        DistanceMetrics actual = measurementInKilometer.add(measurementInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(2, Unit.UnitOfDistance.Kilometer);

        DistanceMetrics actual = distanceMetricsInMeter.add(distanceMetricsInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIsHalfMeterForRemoving50CentimeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(0.5, Unit.UnitOfDistance.Meter);

        DistanceMetrics actual = distanceMetricsInMeter.subtract(distanceMetricsInCentimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1900CentimeterForRemoving1MeterFrom2000Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 2000;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);
        DistanceMetrics expected = new DistanceMetrics(1900, Unit.UnitOfDistance.Centimeter);

        DistanceMetrics actual = distanceMetricsInCentimeter.subtract(distanceMetricsInMeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom50Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 50;
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInCentimeter = new DistanceMetrics(dimensionInCentimeter, Unit.UnitOfDistance.Centimeter);
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);

        assertThrows(IllegalArgumentException.class, () -> distanceMetricsInCentimeter.subtract(distanceMetricsInMeter));
    }

    @Test
    public void testSubtractThrowsExceptionForRemoving1MeterFrom1Meter() throws InvalidMeasurementException {
        double dimensionInMeter = 1;
        DistanceMetrics distanceMetricsInMeter = new DistanceMetrics(dimensionInMeter, Unit.UnitOfDistance.Meter);

        assertThrows(IllegalArgumentException.class, () -> distanceMetricsInMeter.subtract(distanceMetricsInMeter));
    }

}
