package utility;

public class InvalidMeasurementException extends Exception{

    public InvalidMeasurementException(){
        super("Dimensions do not support zero or negative values");
    }
}
