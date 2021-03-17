package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MeasurementTest {

    @Test
    public void testEqualsIsTrueFor1CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double dimension = 1;
        Measurement firstMeasurement = new Measurement(dimension, Unit.Centimeter);
        Measurement secondMeasurement = new Measurement(dimension, Unit.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseFor2CentimeterEquals1Centimeter() throws InvalidMeasurementException {
        double firstDimension = 2;
        double secondDimension = 1;
        Measurement firstMeasurement = new Measurement(firstDimension, Unit.Centimeter);
        Measurement secondMeasurement = new Measurement(secondDimension, Unit.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        Measurement firstMeasurement = new Measurement(dimension, Unit.Centimeter);
        Integer secondMeasurement = 1;

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        double dimension = 1;
        Measurement measurement = new Measurement(dimension, Unit.Centimeter);

        boolean actual = measurement.equals(measurement);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new Measurement(dimension, Unit.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new Measurement(dimension, Unit.Centimeter));
    }

    @Test
    public void testEqualsIsTrueFor1MeterEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);

        boolean actual = measurementInCentimeter.equals(measurementInMeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEquals1Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);

        boolean actual = measurementInMeter.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100CentimeterEqualsOneThousandthKilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInKilometer = new Measurement(dimensionInKilometer, Unit.Kilometer);

        boolean actual = measurementInCentimeter.equals(measurementInKilometer);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueForOneThousandthKilometerEquals100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInKilometer = 0.001;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInKilometer = new Measurement(dimensionInKilometer, Unit.Kilometer);

        boolean actual = measurementInKilometer.equals(measurementInCentimeter);

        assertTrue(actual);
    }

    @Test
    public void testAddIs2MeterFor1MeterAnd100Centimeter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100;
        double dimensionInMeter = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);
        Measurement expected = new Measurement(2, Unit.Meter);

        Measurement actual = measurementInMeter.add(measurementInCentimeter, Unit.Meter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs100200CentimeterFor200CentimeterAnd1Kilometer() throws InvalidMeasurementException {
        double dimensionInCentimeter = 200;
        double dimensionInKilometer = 1;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInKilometer = new Measurement(dimensionInKilometer, Unit.Kilometer);
        Measurement expected = new Measurement(100200, Unit.Centimeter);

        Measurement actual = measurementInKilometer.add(measurementInCentimeter, Unit.Centimeter);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs2KilometerFor100000CentimeterAnd1000Meter() throws InvalidMeasurementException {
        double dimensionInCentimeter = 100000;
        double dimensionInMeter = 1000;
        Measurement measurementInCentimeter = new Measurement(dimensionInCentimeter, Unit.Centimeter);
        Measurement measurementInMeter = new Measurement(dimensionInMeter, Unit.Meter);
        Measurement expected = new Measurement(2, Unit.Kilometer);

        Measurement actual = measurementInMeter.add(measurementInCentimeter, Unit.Kilometer);

        assertEquals(expected, actual);
    }


}
