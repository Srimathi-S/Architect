package utility;

public class Measurement {
    
    private final int dimension;
    public Measurement(int dimension, Unit unit) throws InvalidMeasurementException {
        if(dimension <= 0)
            throw new InvalidMeasurementException();
        this.dimension = dimension;
    }

    public boolean equals( Measurement measurement){
        return this.dimension==measurement.dimension;
    }
}
