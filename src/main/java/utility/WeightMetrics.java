package utility;

public class WeightMetrics extends ScalarMetrics <WeightMetrics>{
    public enum UnitOfWeight implements Unit {
        Gram(0,1),
        Kilogram(0,1000);

        private final double subtractionFactor;
        private final double multiplicationFactor;

        UnitOfWeight(double subtractionFactor, double multiplicationFactor) {
            this.multiplicationFactor = multiplicationFactor;
            this.subtractionFactor = subtractionFactor;
        }

        @Override
        public double getMultiplicationFactor() {
            return multiplicationFactor;
        }

        @Override
        public Unit standardUnit() {
            return Gram;
        }

        @Override
        public double getSubtractionFactor() {
            return subtractionFactor;
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
