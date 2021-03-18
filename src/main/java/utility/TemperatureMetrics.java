package utility;

import java.util.Objects;

public class TemperatureMetrics {

    private double temperature;
    private Unit.UnitOfTemperature unitOfTemperature;

    public TemperatureMetrics(double temperature, Unit.UnitOfTemperature unitOfTemperature) {
        this.temperature=temperature;
        this.unitOfTemperature=unitOfTemperature;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TemperatureMetrics)) return false;
        TemperatureMetrics temperatureMetrics = (TemperatureMetrics) object;
        return temperatureInCelsius().temperature==temperatureMetrics.temperatureInCelsius().temperature;
    }

    private TemperatureMetrics temperatureInCelsius() {
        if(unitOfTemperature.getUnitType().equals("fahrenheit"))
            return new TemperatureMetrics((temperature-32)*(5/9), Unit.UnitOfTemperature.Celsius);
        else if(unitOfTemperature.getUnitType().equals("kelvin"))
            return new TemperatureMetrics((temperature-273.15), Unit.UnitOfTemperature.Celsius);
        return new TemperatureMetrics(temperature, Unit.UnitOfTemperature.Celsius);
    }

}
