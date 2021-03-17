package utility;

import java.util.Objects;

public class WeightMetrics {
    private double dimension;
    private Unit.UnitOfWeight unitOfWeight;

    public WeightMetrics(double dimension, Unit.UnitOfWeight unitOfWeight) throws InvalidMeasurementException {
        if (dimension <= 0)
            throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unitOfWeight = unitOfWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightMetrics weight = (WeightMetrics) o;
        return getDimensionInGram()==weight.getDimensionInGram();
    }

    public double getDimensionInGram() {
        if (this.unitOfWeight.getUnitType().equalsIgnoreCase("kilogram"))
            return dimension*1000;
        return dimension;
    }

}
