package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightMetricsTest {
    @Test
    public void testIsTrueFor1GramEquals1Gram() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics firstWeightMetrics = new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics secondWeightMetrics = new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram);

        boolean actual = firstWeightMetrics.equals(secondWeightMetrics);

        assertTrue(actual);
    }

    @Test
    public void testIsTrueFor100GramEqualsOneTenthOfKilogram() throws InvalidMeasurementException {
        double dimensionInGrams = 100;
        double dimensionInKilograms = 0.1;
        WeightMetrics kilogramWeightMetrics = new WeightMetrics(dimensionInKilograms, WeightMetrics.UnitOfWeight.Kilogram);
        WeightMetrics gramWeightMetrics = new WeightMetrics(dimensionInGrams, WeightMetrics.UnitOfWeight.Gram);

        boolean actual = kilogramWeightMetrics.equals(gramWeightMetrics);

        assertTrue(actual);
    }

    @Test
    public void testThrowsExceptionForNegativeValuedDimension() {
        double dimension = -1;

        assertThrows(InvalidMeasurementException.class, () -> new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram));
    }

    @Test
    public void testThrowsExceptionForZeroValuedDimension() {
        double dimension = 0;

        assertThrows(InvalidMeasurementException.class, () -> new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram));
    }

    @Test
    public void testIsFalseForNonWeightMetricsInstance() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics firstDistanceMetrics = new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram);
        Integer distance = 1;

        boolean actual = firstDistanceMetrics.equals(distance);

        assertFalse(actual);
    }

    @Test
    public void testAddIs2KilogramFor1000GramAnd1000Gram() throws InvalidMeasurementException {
        double dimensionInGram = 1000;
        WeightMetrics firstWeightMetricsInGram = new WeightMetrics(dimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics secondWeightMetricsInGram = new WeightMetrics(dimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics expected = new WeightMetrics(2, WeightMetrics.UnitOfWeight.Kilogram);

        WeightMetrics actual = (WeightMetrics) firstWeightMetricsInGram.add(secondWeightMetricsInGram);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws InvalidMeasurementException {
        double dimensionInGram = 10;
        double dimensionInKilogram = 1;
        WeightMetrics weightMetricsInGram = new WeightMetrics(dimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics weightMetricsInKilogram = new WeightMetrics(dimensionInKilogram, WeightMetrics.UnitOfWeight.Kilogram);
        WeightMetrics expected = new WeightMetrics(1010, WeightMetrics.UnitOfWeight.Gram);

        WeightMetrics actual = (WeightMetrics) weightMetricsInGram.add(weightMetricsInKilogram);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs2KilogramForDifferenceOf1000GramFrom3000Gram() throws InvalidMeasurementException {
        double firstDimensionInGram = 3000;
        double secondDimensionInGram = 1000;
        WeightMetrics firstWeightMetricsInGram = new WeightMetrics(firstDimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics secondWeightMetricsInGram = new WeightMetrics(secondDimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics expected = new WeightMetrics(2, WeightMetrics.UnitOfWeight.Kilogram);

        WeightMetrics actual = (WeightMetrics) firstWeightMetricsInGram.subtract(secondWeightMetricsInGram);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1KilogramForDifferenceOf500GramFromOneAndHalfKiloGram() throws InvalidMeasurementException {
        double dimensionInGram = 500;
        double dimensionInKilogram = 1.5;
        WeightMetrics weightMetricsInGram = new WeightMetrics(dimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics weightMetricsInKilogram = new WeightMetrics(dimensionInKilogram, WeightMetrics.UnitOfWeight.Kilogram);
        WeightMetrics expected = new WeightMetrics(1, WeightMetrics.UnitOfWeight.Kilogram);

        WeightMetrics actual = (WeightMetrics) weightMetricsInKilogram.subtract(weightMetricsInGram);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForDifferenceOfOneAndHalfKiloGramFrom500Gram() throws InvalidMeasurementException {
        double dimensionInGram = 500;
        double dimensionInKilogram = 1.5;
        WeightMetrics weightMetricsInGram = new WeightMetrics(dimensionInGram, WeightMetrics.UnitOfWeight.Gram);
        WeightMetrics weightMetricsInKilogram = new WeightMetrics(dimensionInKilogram, WeightMetrics.UnitOfWeight.Kilogram);
        WeightMetrics expected = new WeightMetrics(1, WeightMetrics.UnitOfWeight.Kilogram);

        assertThrows(IllegalArgumentException.class, () -> weightMetricsInGram.subtract(weightMetricsInKilogram));
    }

    @Test
    public void testIsFalseFor1GramEquals1Meter() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics weightMetrics = new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram);
        DistanceMetrics distanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Meter);

        boolean actual = weightMetrics.equals(distanceMetrics);

        assertFalse(actual);
    }

    @Test
    public void testAddThrowsExceptionFor1GramAnd1Meter() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics weightMetrics = new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram);
        DistanceMetrics distanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Meter);

        assertThrows(IllegalArgumentException.class, () -> weightMetrics.add(distanceMetrics));
    }

    @Test
    public void testSubtractThrowsExceptionFor1GramAnd1Meter() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics weightMetrics = new WeightMetrics(dimension, WeightMetrics.UnitOfWeight.Gram);
        DistanceMetrics distanceMetrics = new DistanceMetrics(dimension, DistanceMetrics.UnitOfDistance.Meter);

        assertThrows(IllegalArgumentException.class, () -> weightMetrics.subtract(distanceMetrics));
    }
}
