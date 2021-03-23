package utility;

import java.util.Objects;

public class Metrics <T extends Metrics>{
    double dimension;
    Unit unit;

    public interface Unit {
        double getMultiplicationFactor();

        Unit standardUnit();

        double getSubtractionFactor();
    }

    public Metrics(double dimension ,Unit unit) {
        this.dimension=dimension;
        this.unit=unit;
    }

    protected double convertToStandardUnit() {
        return (dimension-unit.getSubtractionFactor()) * unit.getMultiplicationFactor();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object.getClass()!=this.getClass()) return false;
        T metrics = (T) object;
        return convertToStandardUnit()== metrics.convertToStandardUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(dimension, unit);
    }




}
