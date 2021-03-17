package utility;

public class Measurement {

    private final double dimension;
    private final Unit unit;

    public Measurement(double dimension, Unit unit) throws InvalidMeasurementException {
        if (dimension <= 0)
            throw new InvalidMeasurementException();
        this.dimension = dimension;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Measurement)) return false;

        Measurement measurement = (Measurement) object;
        return this.unit.getDimensionInMeter(dimension) == measurement.unit.getDimensionInMeter(measurement.dimension);
    }

    public Measurement add(Measurement measurement, Unit unit) throws InvalidMeasurementException {
        double sum = this.unit.getDimensionInMeter(dimension) + measurement.unit.getDimensionInMeter(measurement.dimension);
        double sumInSpecifiedUnit = unit.givenDimensionInMeterConvertToSpecificUnit(sum);

        return new Measurement(sumInSpecifiedUnit, unit);
    }
}
