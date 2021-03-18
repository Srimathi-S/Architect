package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testEqualsIsFalseForNonWeightMetricsInstance() throws InvalidMeasurementException {
        double dimension = 1;
        WeightMetrics firstDistanceMetrics = new WeightMetrics(dimension, Unit.UnitOfWeight.Gram);
        Integer distance= 1;

        boolean actual = firstDistanceMetrics.equals(distance);

        assertFalse(actual);
    }

    @Test
    public void testAddIs2KilogramFor1000GramAnd1000Gram() throws InvalidMeasurementException {
        double dimensionInGram = 1000;
        WeightMetrics firstWeightMetricsInGram = new WeightMetrics(dimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics secondWeightMetricsInGram = new WeightMetrics(dimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics expected = new WeightMetrics(2, Unit.UnitOfWeight.Kilogram);

        WeightMetrics actual = firstWeightMetricsInGram.add(secondWeightMetricsInGram);

        assertEquals(expected, actual);
    }

    @Test
    public void testAddIs1010GramFor10GramAnd1Kilogram() throws InvalidMeasurementException {
        double dimensionInGram = 10;
        double dimensionInKilogram = 1;
        WeightMetrics weightMetricsInGram = new WeightMetrics(dimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics weightMetricsInKilogram = new WeightMetrics(dimensionInKilogram, Unit.UnitOfWeight.Kilogram);
        WeightMetrics expected = new WeightMetrics(1010, Unit.UnitOfWeight.Gram);

        WeightMetrics actual = weightMetricsInGram.add(weightMetricsInKilogram);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs2KilogramForDifferenceOf1000GramFrom3000Gram() throws InvalidMeasurementException {
        double firstDimensionInGram = 3000;
        double secondDimensionInGram = 1000;
        WeightMetrics firstWeightMetricsInGram = new WeightMetrics(firstDimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics secondWeightMetricsInGram = new WeightMetrics(secondDimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics expected = new WeightMetrics(2, Unit.UnitOfWeight.Kilogram);

        WeightMetrics actual = firstWeightMetricsInGram.subtract(secondWeightMetricsInGram);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractIs1KilogramForDifferenceOf500GramFromOneAndHalfKiloGram() throws InvalidMeasurementException {
        double dimensionInGram = 500;
        double dimensionInKilogram = 1.5;
        WeightMetrics weightMetricsInGram = new WeightMetrics(dimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics weightMetricsInKilogram = new WeightMetrics(dimensionInKilogram, Unit.UnitOfWeight.Kilogram);
        WeightMetrics expected = new WeightMetrics(1 ,Unit.UnitOfWeight.Kilogram);

        WeightMetrics actual = weightMetricsInKilogram.subtract(weightMetricsInGram);

        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractThrowsExceptionForDifferenceOfOneAndHalfKiloGramFrom500Gram() throws InvalidMeasurementException {
        double dimensionInGram = 500;
        double dimensionInKilogram = 1.5;
        WeightMetrics weightMetricsInGram = new WeightMetrics(dimensionInGram, Unit.UnitOfWeight.Gram);
        WeightMetrics weightMetricsInKilogram = new WeightMetrics(dimensionInKilogram, Unit.UnitOfWeight.Kilogram);
        WeightMetrics expected = new WeightMetrics(1 ,Unit.UnitOfWeight.Kilogram);

        assertThrows(IllegalArgumentException.class, ()->weightMetricsInGram.subtract(weightMetricsInKilogram));
    }
}
