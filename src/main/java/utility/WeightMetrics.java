package utility;

public class WeightMetrics extends ScalarMetrics {
    public enum UnitOfWeight implements Unit {
        Gram(1),
        Kilogram(1000);

        private final double multiplicationFactor;

        UnitOfWeight(double multiplicationFactor) {
            this.multiplicationFactor = multiplicationFactor;
        }

        @Override
        public double getMultiplicationFactor() {
            return multiplicationFactor;
        }

        @Override
        public Unit standardUnit() {
            return Gram;
        }
    }

    public WeightMetrics(double dimension, UnitOfWeight unitOfWeight) throws InvalidMeasurementException {
        super(dimension, unitOfWeight);
    }

    @Override
    WeightMetrics createMetric(double dimension, Unit unit) throws InvalidMeasurementException {
        return new WeightMetrics(dimension, (UnitOfWeight) unit);
    }

}
