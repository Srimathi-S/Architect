package utility;

public interface Unit {
    double getConversionRate();
    Unit getStandardUnit();


    public enum UnitOfTemperature {
        Fahrenheit("fahrenheit"),
        Celsius("celsius"),
        Kelvin("kelvin");

        private final String unitType;

        UnitOfTemperature(String unitType) {
            this.unitType = unitType;
        }

        public String getUnitType() {
            return this.unitType;
        }
    }
}
