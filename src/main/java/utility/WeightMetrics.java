package utility;


public class WeightMetrics {
    private double dimension;
    private Unit.UnitOfWeight unitOfWeight;

    public WeightMetrics(double dimension, Unit.UnitOfWeight unitOfWeight) throws InvalidMeasurementException {
        if (dimension <= 0) throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfWeight = unitOfWeight;
    }

    public WeightMetrics dimensionInGram() throws InvalidMeasurementException {
        if (this.unitOfWeight.getUnitType().equalsIgnoreCase("kilogram"))
            return new WeightMetrics(dimension * 1000, Unit.UnitOfWeight.Gram);
        return new WeightMetrics(dimension, Unit.UnitOfWeight.Gram);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WeightMetrics weight = (WeightMetrics) object;
        try {
            return dimensionInGram().dimension == weight.dimensionInGram().dimension;
        } catch (InvalidMeasurementException e) {
            return false;
        }
    }

    public WeightMetrics add(WeightMetrics weightMetrics) throws InvalidMeasurementException {
        double sum = dimensionInGram().dimension + weightMetrics.dimensionInGram().dimension;
        return new WeightMetrics(sum, Unit.UnitOfWeight.Gram);
    }

    public WeightMetrics subtract(WeightMetrics weightMetrics) {
        try {
            double difference = dimensionInGram().dimension - weightMetrics.dimensionInGram().dimension;
            return new WeightMetrics(difference, Unit.UnitOfWeight.Gram);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }
    }
}
