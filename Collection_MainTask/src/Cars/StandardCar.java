package Cars;

import carTypesAndMarksEnum.CarMark;
import carTypesAndMarksEnum.StandardType;

public class StandardCar extends Car {
    private StandardType type;
    private boolean hasBigBaggage = false;

    public StandardCar(CarMark mark, String model, StandardType type, double fuelConsumption,
                       int maxSpeed, double price) {
        super(mark, model, fuelConsumption, maxSpeed, price);
        this.type = type;
    }

    public StandardType getType() {
        return type;
    }

    public boolean isHasBigBaggage() {
        return type.equals(StandardType.MINIVAN) ? !hasBigBaggage : hasBigBaggage;
    }

    @Override
    public boolean isHasInternet() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type = " + type +
                        '}');
    }
}
