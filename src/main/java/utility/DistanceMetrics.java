package utility;

public class DistanceMetrics extends ScalarMetrics {
    public enum UnitOfDistance implements Unit {
        Centimeter(0.01),
        Meter(1),
        Kilometer(1000);

        private final double multiplicationFactor;

        UnitOfDistance(double multiplicationFactor) {
            this.multiplicationFactor = multiplicationFactor;
        }

        @Override
        public double getMultiplicationFactor() {
            return multiplicationFactor;
        }

        @Override
        public Unit standardUnit() {
            return Meter;
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