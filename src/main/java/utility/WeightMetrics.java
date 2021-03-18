package utility;


public class WeightMetrics {
    private double dimension;
    private Unit.UnitOfWeight unitOfWeight;

    public WeightMetrics(double dimension, Unit.UnitOfWeight unitOfWeight) throws InvalidMeasurementException {
        if(dimension<=0)throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfWeight = unitOfWeight;
    }

    public double getDimensionInGram() {
        if (this.unitOfWeight.getUnitType().equalsIgnoreCase("kilogram"))
            return dimension*1000;
        return dimension;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        WeightMetrics weight = (WeightMetrics) object;
        return getDimensionInGram()==weight.getDimensionInGram();
    }

    public WeightMetrics add(WeightMetrics weightMetrics) throws InvalidMeasurementException {
        double sum=getDimensionInGram()+ weightMetrics.getDimensionInGram();
        return new WeightMetrics(sum,Unit.UnitOfWeight.Gram);
    }

    public WeightMetrics subtract(WeightMetrics weightMetrics) {
        double difference=getDimensionInGram()-weightMetrics.getDimensionInGram();
        try {
            return new WeightMetrics(difference,Unit.UnitOfWeight.Gram);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }
    }
}
