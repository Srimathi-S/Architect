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
        return this.unit.dimensionInMeter(dimension) == measurement.unit.dimensionInMeter(measurement.dimension);
    }


    public Measurement add(Measurement measurement, Unit unit) throws InvalidMeasurementException {
        double sum = this.unit.dimensionInMeter(dimension) + measurement.unit.dimensionInMeter(measurement.dimension);
        double sumInSpecifiedUnit = unit.givenDimensionInMeterConvertToSpecificUnit(sum);

        return new Measurement(sumInSpecifiedUnit, unit);
    }


    public Measurement subtract(Measurement measurement, Unit unit) {

        double difference = this.unit.dimensionInMeter(dimension) - measurement.unit.dimensionInMeter(measurement.dimension);
        double differenceInSpecifiedUnit = unit.givenDimensionInMeterConvertToSpecificUnit(difference);

        try {
            return new Measurement(differenceInSpecifiedUnit, unit);
        } catch (InvalidMeasurementException e) {
            throw new IllegalArgumentException("Cannot Subtract larger dimension from smaller dimension");
        }

    }
}