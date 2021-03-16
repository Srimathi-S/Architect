package utility;

public enum Unit {
    Centimeter("centimeter"),
    Meter("meter"),
    Kilometer("kilometer");

    private String name;

    private Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
