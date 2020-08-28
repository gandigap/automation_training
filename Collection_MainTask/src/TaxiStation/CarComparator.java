package TaxiStation;

import Cars.Car;
import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    public int compare(Car car1, Car car2) {
        if (car1.getFuelConsumption() > car2.getFuelConsumption()) {
            return 1;
        } else if (car1.getFuelConsumption() < car2.getFuelConsumption()) {
            return -1;
        } else {
            return 0;
        }
    }
}
