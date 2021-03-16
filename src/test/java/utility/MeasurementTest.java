package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MeasurementTest {

    @Test
    public void testEqualsIsTrueIfDimensionsAreEqual() throws InvalidMeasurementException {
        int dimension = 1;
        Measurement firstMeasurement = new Measurement(dimension, Unit.Centimeter);
        Measurement secondMeasurement = new Measurement(dimension, Unit.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsFalseIfDimensionsAreNotEqual() throws InvalidMeasurementException {
        int firstDimension = 2;
        int secondDimension = 1;
        Measurement firstMeasurement = new Measurement(firstDimension, Unit.Centimeter);
        Measurement secondMeasurement = new Measurement(secondDimension, Unit.Centimeter);

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsFalseForNonMeasurementInstance() throws InvalidMeasurementException {
        int dimension = 1;
        Measurement firstMeasurement = new Measurement(dimension, Unit.Centimeter);
        Integer secondMeasurement = 1;

        boolean actual = firstMeasurement.equals(secondMeasurement);

        assertFalse(actual);
    }

    @Test
    public void testEqualsIsTrueForSameMeasurementInstance() throws InvalidMeasurementException {
        int dimension = 1;
        Measurement measurement = new Measurement(dimension, Unit.Centimeter);

        boolean actual = measurement.equals(measurement);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        int dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new Measurement(dimension, Unit.Centimeter));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        int dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new Measurement(dimension, Unit.Centimeter));
    }


}
