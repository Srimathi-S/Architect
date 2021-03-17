package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeightMetricsTest {
    @Test
    public void testEqualsIsTrueFor1GramEquals1Gram() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics firstWeightMetrics = new WeightMetrics(dimension, Unit.UnitOfWeight.Gram);
        WeightMetrics secondWeightMetrics = new WeightMetrics(dimension, Unit.UnitOfWeight.Gram);

        boolean actual = firstWeightMetrics.equals(secondWeightMetrics);

        assertTrue(actual);
    }

    @Test
    public void testEqualsIsTrueFor100GramEqualsOneTenthOfKilogram() throws InvalidMeasurementException {
        double dimensionInGrams = 100;
        double dimensionInKilograms = 0.1;
        WeightMetrics kilogramWeightMetrics = new WeightMetrics(dimensionInKilograms, Unit.UnitOfWeight.Kilogram);
        WeightMetrics gramWeightMetrics = new WeightMetrics(dimensionInGrams, Unit.UnitOfWeight.Gram);

        boolean actual = kilogramWeightMetrics.equals(gramWeightMetrics);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new WeightMetrics(dimension, Unit.UnitOfWeight.Gram));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new  WeightMetrics(dimension, Unit.UnitOfWeight.Gram));
    }

}
