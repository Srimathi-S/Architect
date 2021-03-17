package utility;

public enum Unit {
    Centimeter("centimeter"),
    Meter("meter"),
    Kilometer("kilometer");

    private final String name;

    private Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double givenDimensionInMeterConvertToSpecificUnit(double dimensionValue) {
        if (this.name.equalsIgnoreCase("centimeter"))
            return dimensionValue * 100;
        else if (this.name.equalsIgnoreCase("kilometer"))
            return dimensionValue / 1000;
        return dimensionValue;
    }

    public double dimensionInMeter(double dimensionValue) {
        if (this.name.equalsIgnoreCase("centimeter"))
            return dimensionValue / 100;
        else if (this.name.equalsIgnoreCase("kilometer"))
            return dimensionValue * 1000;
        return dimensionValue;
    }
}
