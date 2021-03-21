package utility;

public class TemperatureMetrics {
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

    private double temperature;
    private UnitOfTemperature unitOfTemperature;

    public TemperatureMetrics(double temperature, UnitOfTemperature unitOfTemperature) {
        this.temperature = temperature;
        this.unitOfTemperature = unitOfTemperature;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TemperatureMetrics)) return false;
        TemperatureMetrics temperatureMetrics = (TemperatureMetrics) object;
        return temperatureInCelsius().temperature == temperatureMetrics.temperatureInCelsius().temperature;
    }

    private TemperatureMetrics temperatureInCelsius() {
        return new TemperatureMetrics((temperature - unitOfTemperature.getSubtractionFactor()) *
                unitOfTemperature.getMultiplicationFactor(), UnitOfTemperature.Celsius);
    }

}
