package utility;

public class DistanceMetrics{

    private final double dimension;
    private final Unit.UnitOfDistance unitOfDistance;

    public DistanceMetrics(double dimension, Unit.UnitOfDistance unitOfDistance) throws InvalidMeasurementException {
        if(dimension<=0)throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfDistance = unitOfDistance;
    }

    public double dimensionInMeter() {
        if (this.unitOfDistance.getUnitType().equalsIgnoreCase("centimeter"))
            return dimension / 100;
        else if (this.unitOfDistance.getUnitType().equalsIgnoreCase("kilometer"))
            return dimension * 1000;
        return dimension;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof DistanceMetrics)) return false;

        DistanceMetrics distanceMetrics = (DistanceMetrics) object;
        return dimensionInMeter() == distanceMetrics.dimensionInMeter();
    }

    public DistanceMetrics add(DistanceMetrics distanceMetrics) throws InvalidMeasurementException {
        double sum = dimensionInMeter() + distanceMetrics.dimensionInMeter();
        return new DistanceMetrics(sum, Unit.UnitOfDistance.Meter);
    }


    public DistanceMetrics subtract(DistanceMetrics distanceMetrics) {
        double difference = dimensionInMeter() - distanceMetrics.dimensionInMeter();

        try {
            return new DistanceMetrics(difference, Unit.UnitOfDistance.Meter);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }
}