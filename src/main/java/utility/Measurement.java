package utility;

public class Measurement {

    private final int dimension;
    private final Unit unit;

    public Measurement(int dimension, Unit unit) throws InvalidMeasurementException {
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
        return dimension == measurement.dimension && unit == measurement.unit;
    }

}
