package utility;

public class TemperatureMetrics extends Metrics<TemperatureMetrics>{

    public enum UnitOfTemperature implements Unit {
        Fahrenheit(32, 0.56),
        Celsius(0, 1),
        Kelvin(273.15, 1);

        private final double subtractionFactor;
        private final double multiplicationFactor;

        UnitOfTemperature(double subtractionFactor, double multiplicationFactor) {
            this.subtractionFactor = subtractionFactor;
            this.multiplicationFactor = multiplicationFactor;
        }

        @Override
        public double getSubtractionFactor() {
            return subtractionFactor;
        }

        @Override
        public double getMultiplicationFactor() {
            return multiplicationFactor;
        }

        @Override
        public Unit standardUnit() {
            return Celsius;
        }
    }

    public TemperatureMetrics(double dimension, UnitOfTemperature unitOfTemperature) {
        super(dimension,unitOfTemperature);
    }

    @Override
    TemperatureMetrics createMetric(double dimension, Unit unit) throws InvalidMeasurementException {
        return new TemperatureMetrics(dimension,(UnitOfTemperature)unit);
    }

}
