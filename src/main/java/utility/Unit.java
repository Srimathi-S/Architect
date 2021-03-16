package utility;

public enum Unit {
    Centimeter("centimeter"),
    Meter("meter");

    private String name;

    private Unit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
