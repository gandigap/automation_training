package Cars;

import carTypesAndMarksEnum.BusinessType;
import carTypesAndMarksEnum.CarMark;

public class BusinessCar extends Car {
    private BusinessType type;
    private boolean hasTable = false;

    public BusinessCar(CarMark mark, String model, BusinessType type, double fuelConsumption,
                       int maxSpeed, double price) {
        super(mark, model, fuelConsumption, maxSpeed, price);
        this.type = type;
    }

    public BusinessType getType() {
        return type;
    }

    public boolean isHasTable() {
        return type.equals(BusinessType.SEDAN) ? hasTable: !hasTable;
    }

    @Override
    public boolean isHasInternet() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type = " + type +
                        '}');
    }
}
