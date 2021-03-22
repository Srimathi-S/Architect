package utility;

public abstract class Metrics <T extends Metrics>{
    double dimension;
    Unit unit;

    public Metrics(double dimension ,Unit unit) {
        this.dimension=dimension;
        this.unit=unit;
    }

    protected double convertToStandardUnit() {
        return (dimension-unit.getSubtractionFactor()) * unit.getMultiplicationFactor();
    }

    T dimensionInStandardUnit() throws InvalidMeasurementException {
        return createMetric(convertToStandardUnit(), unit.standardUnit());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object.getClass()==this.getClass())) return false;
        T metrics = (T) object;
        try {
            return dimensionInStandardUnit().dimension== metrics.dimensionInStandardUnit().dimension;
        } catch (InvalidMeasurementException e) {
            return false;
        }
    }

    abstract T createMetric(double dimension, Unit unit) throws InvalidMeasurementException;
}
