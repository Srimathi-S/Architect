package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


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


}
