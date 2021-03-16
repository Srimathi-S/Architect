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
        return this.getDimensionInMeter() == measurement.getDimensionInMeter();

    }

    private double getDimensionInMeter() {
        if (this.unit.getName().equalsIgnoreCase("centimeter"))
            return this.dimension / 100;
        else if (this.unit.getName().equalsIgnoreCase("kilometer"))
            return this.dimension * 10;
        return this.dimension;
    }


}
