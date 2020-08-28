package Cars;

import carTypesAndMarksEnum.CarMark;
import carTypesAndMarksEnum.PremiumType;

public class PremiumCar extends Car {
    private PremiumType type;
    private boolean hasOpenRoof = false;
    private boolean hasMiniBar = false;
    private boolean hasMusicalSet = false;

    public PremiumCar(CarMark mark, String model, PremiumType type, double fuelConsumption,
                      int maxSpeed, double price) {
        super(mark, model, fuelConsumption, maxSpeed, price);
        this.type = type;
    }

    public PremiumType getType() {
        return type;
    }

    public boolean isHasOpenRoof() {
        return type.equals(PremiumType.CABRIOLET) ? !hasOpenRoof : hasOpenRoof;
    }

    public boolean isHasMiniBar() {
        return type.equals(PremiumType.LIMOUSINE) ? !hasMiniBar : hasMiniBar;
    }

    public boolean isHasMusicalSet() {
        return type.equals(PremiumType.LIMOUSINE) ? !hasMusicalSet : hasMusicalSet;
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
