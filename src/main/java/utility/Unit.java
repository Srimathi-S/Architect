package utility;

public class Unit {


    public enum UnitOfDistance {
        Centimeter("centimeter"),
        Meter("meter"),
        Kilometer("kilometer");

        private final String unitType;

        UnitOfDistance(String unitType) {
            this.unitType = unitType;
        }

        public String getUnitType() {
            return unitType;
        }
    }

    public enum UnitOfWeight {
        Gram("gram"),
        Kilogram("kilogram");

        private final String unitType;

        UnitOfWeight(String unitType) {
            this.unitType = unitType;
        }

        public String getUnitType() {
            return this.unitType;
        }
    }

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
