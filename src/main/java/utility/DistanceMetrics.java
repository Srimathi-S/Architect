package utility;

public class DistanceMetrics {

    private final double dimension;
    private final Unit.UnitOfDistance unitOfDistance;

    public DistanceMetrics(double dimension, Unit.UnitOfDistance unitOfDistance) throws InvalidMeasurementException {
        if (dimension <= 0) throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfDistance = unitOfDistance;
    }

    public DistanceMetrics dimensionInMeter() throws InvalidMeasurementException {
        if (this.unitOfDistance.getUnitType().equalsIgnoreCase("centimeter"))
            return new DistanceMetrics(dimension / 100, Unit.UnitOfDistance.Meter);
        else if (this.unitOfDistance.getUnitType().equalsIgnoreCase("kilometer"))
            return new DistanceMetrics(dimension * 1000, Unit.UnitOfDistance.Meter);
        return new DistanceMetrics(dimension, Unit.UnitOfDistance.Meter);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof DistanceMetrics)) return false;

        DistanceMetrics distanceMetrics = (DistanceMetrics) object;
        try {
            return dimensionInMeter().dimension == distanceMetrics.dimensionInMeter().dimension;
        } catch (InvalidMeasurementException e) {
            return false;
        }
    }

    public DistanceMetrics add(DistanceMetrics distanceMetrics) throws InvalidMeasurementException {
        double sum = dimensionInMeter().dimension + distanceMetrics.dimensionInMeter().dimension;
        return new DistanceMetrics(sum, Unit.UnitOfDistance.Meter);
    }


    public DistanceMetrics subtract(DistanceMetrics distanceMetrics) {
        try {
            double difference = dimensionInMeter().dimension - distanceMetrics.dimensionInMeter().dimension;
            return new DistanceMetrics(difference, Unit.UnitOfDistance.Meter);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }
}