package utility;

abstract class ScalarMetrics <T extends ScalarMetrics> extends Metrics<ScalarMetrics> {


    public ScalarMetrics(double dimension, Unit unit) throws InvalidMeasurementException {
        super(checkForValidDimension(dimension), unit);
    }

    private static double checkForValidDimension(double dimension) throws InvalidMeasurementException {
        if(dimension<=0)throw new InvalidMeasurementException();
        return dimension;
    }


    public T add(T metrics) throws InvalidMeasurementException {
        double sum = this.dimensionInStandardUnit().dimension + metrics.dimensionInStandardUnit().dimension;
        return  (T)createMetric(sum, unit.standardUnit());
    }

    public T subtract(T metrics) {
        try {
            double difference = dimensionInStandardUnit().dimension - metrics.dimensionInStandardUnit().dimension;
            return (T) createMetric(difference, unit.standardUnit());
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }




}
