package utility;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TemperatureMetricsTest {
    @Test
    public void testIsTrueFor0CelsiusEquals32Fahrenheit() {
        double temperatureInCelsius = 0;
        double temperatureInFahrenheit = 32;
        TemperatureMetrics temperatureMetricsInCelsius = new TemperatureMetrics(temperatureInCelsius, TemperatureMetrics.UnitOfTemperature.Celsius);
        TemperatureMetrics temperatureMetricsInFahrenheit = new TemperatureMetrics(temperatureInFahrenheit, TemperatureMetrics.UnitOfTemperature.Fahrenheit);

        assertEquals(temperatureMetricsInCelsius, temperatureMetricsInFahrenheit);
    }

    @Test
    public void testIsFalseForNonTemperatureMeasurementInstance() {
        double temperatureInCelsius = 1;
        TemperatureMetrics temperatureMetricsInCelsius = new TemperatureMetrics(temperatureInCelsius, TemperatureMetrics.UnitOfTemperature.Celsius);
        Integer distance = 1;

        assertNotEquals(temperatureMetricsInCelsius, distance);
    }

    @Test
    public void testIsFalseFor0KelvinEqualsNegative274Celsius() {
        double temperatureInCelsius = -274;
        double temperatureInKelvin = 0;
        TemperatureMetrics temperatureMetricsInCelsius = new TemperatureMetrics(temperatureInCelsius, TemperatureMetrics.UnitOfTemperature.Celsius);
        TemperatureMetrics temperatureMetricsInFahrenheit = new TemperatureMetrics(temperatureInKelvin, TemperatureMetrics.UnitOfTemperature.Kelvin);

        assertNotEquals(temperatureMetricsInCelsius, temperatureMetricsInFahrenheit);
    }

    @Test
    public void testIsTrueFor0KelvinEqualsNegative273Celsius() {
        double temperatureInCelsius = -273.15;
        double temperatureInKelvin = 0;
        TemperatureMetrics temperatureMetricsInCelsius = new TemperatureMetrics(temperatureInCelsius, TemperatureMetrics.UnitOfTemperature.Celsius);
        TemperatureMetrics temperatureMetricsInFahrenheit = new TemperatureMetrics(temperatureInKelvin, TemperatureMetrics.UnitOfTemperature.Kelvin);

        assertEquals(temperatureMetricsInCelsius, temperatureMetricsInFahrenheit);
    }
}
