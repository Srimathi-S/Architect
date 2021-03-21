package utility;

public class DistanceMetrics extends ScalarMetrics {
    public enum UnitOfDistance implements Unit{
        Centimeter(0.01),
        Meter(1),
        Kilometer(1000);

        private final double conversionRate;

        UnitOfDistance(double conversionRate) {
            this.conversionRate = conversionRate;
        }

        public double getConversionRate() {
            return conversionRate;
        }

        @Override
        public Unit getStandardUnit() {
            return Meter;
        }
    }
    private final double dimension;
    private final UnitOfDistance unitOfDistance;
    public DistanceMetrics(double dimension, UnitOfDistance unitOfDistance) throws InvalidMeasurementException {
        super(dimension,unitOfDistance);
        if (dimension <= 0) throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfDistance = unitOfDistance;
    }

    @Override
    DistanceMetrics createMetric(double dimension, Unit unit) throws InvalidMeasurementException {
        return new DistanceMetrics(dimension, (UnitOfDistance) unit) ;
    }


}