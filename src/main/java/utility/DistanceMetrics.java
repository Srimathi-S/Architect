package utility;

public class DistanceMetrics extends ScalarMetrics<DistanceMetrics> {
    public enum UnitOfDistance implements Unit {
        Centimeter(0, 0.01),
        Meter(0, 1),
        Kilometer(0, 1000);

        private final double subtractionFactor;
        private final double multiplicationFactor;

        UnitOfDistance(double subtractionFactor, double multiplicationFactor) {
            this.multiplicationFactor = multiplicationFactor;
            this.subtractionFactor = subtractionFactor;
        }

        @Override
        public double getMultiplicationFactor() {
            return multiplicationFactor;
        }

        @Override
        public Unit standardUnit() {
            return Meter;
        }

        @Override
        public double getSubtractionFactor() {
            return subtractionFactor;
        }
    }

    public DistanceMetrics(double dimension, UnitOfDistance unitOfDistance) throws InvalidMeasurementException {
        super(dimension, unitOfDistance);
    }

    @Override
    DistanceMetrics createMetric(double dimension, Unit unit) throws InvalidMeasurementException {
        return new DistanceMetrics(dimension, (UnitOfDistance) unit);
    }


}