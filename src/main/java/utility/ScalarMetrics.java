package utility;

abstract class ScalarMetrics< T extends ScalarMetrics> {
    double dimension;
    private Unit unit;
    public ScalarMetrics(double dimension, Unit unit) {
        this.dimension = dimension;
        this.unit=unit;
    }

    protected double convert(double conversionRate) {
        return this.dimension*conversionRate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof ScalarMetrics)) return false;

        ScalarMetrics scalarMetrics = (ScalarMetrics) object;
        try {
            return dimensionInStandardUnit().dimension == scalarMetrics.dimensionInStandardUnit().dimension
                    && isSameInstance(scalarMetrics);
        } catch (InvalidMeasurementException e) {
            return false;
        }
    }

    private boolean isSameInstance(ScalarMetrics scalarMetrics) {
        return unit.getStandardUnit()== scalarMetrics.unit.getStandardUnit();
    }

    public T add(T metrics) throws InvalidMeasurementException {
        if(!isSameInstance((ScalarMetrics) metrics))throw new IllegalArgumentException("Cannot add two different metrics");
        double sum = this.dimensionInStandardUnit().dimension +metrics.dimensionInStandardUnit().dimension;
        return createMetric(sum, unit.getStandardUnit());
    }

    public T subtract(T metrics) {
        if(!isSameInstance((ScalarMetrics) metrics))throw new IllegalArgumentException("Cannot add two different metrics");
        try {
            double difference = dimensionInStandardUnit().dimension - metrics.dimensionInStandardUnit().dimension;
            return createMetric(difference, unit.getStandardUnit());
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }

    abstract T createMetric(double sum, Unit gram) throws InvalidMeasurementException;

    T dimensionInStandardUnit() throws InvalidMeasurementException {
        return createMetric(convert(unit.getConversionRate()), unit.getStandardUnit());
    }

}
