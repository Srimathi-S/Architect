package utility;

public class WeightMetrics extends ScalarMetrics {
    public enum UnitOfWeight implements Unit{
        Gram(1),
        Kilogram(1000);

        private final double conversionRate;

        UnitOfWeight(double conversionRate) {
            this.conversionRate = conversionRate;
        }

        public double getConversionRate() {
            return conversionRate;
        }

        @Override
        public Unit getStandardUnit() {
            return Gram;
        }
    }
    private double dimension;
    private UnitOfWeight unitOfWeight;
    public WeightMetrics(double dimension, UnitOfWeight unitOfWeight) throws InvalidMeasurementException {
        super(dimension,unitOfWeight);
        if (dimension <= 0) throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfWeight = unitOfWeight;
    }

    @Override
    ScalarMetrics createMetric(double dimension, Unit unit) throws InvalidMeasurementException {
        return new WeightMetrics(dimension,(UnitOfWeight) unit);
    }

}
