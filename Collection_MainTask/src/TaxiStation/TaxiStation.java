package TaxiStation;

import Cars.Car;
import java.util.*;
import static Constants.Constants.*;

public class TaxiStation {
    private String title;

    private List<? extends Car> cars;

    public TaxiStation(String title, List<? extends Car> cars) {
        this.title = title;
        this.cars = cars;
    }

    public String getTitle() {
        return title;
    }

    public List<? extends Car> getCars() {
        return cars;
    }

    public void print(Collection<? extends Car> collection) {
        Iterator<? extends Car> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            System.out.println(car);
        }
    }

    public void getTotalPriceAllCars(){
        double totalPrice = 0;
        for (Car car: cars) {
            totalPrice += car.getPrice();
        }
        System.out.println(NEW_LINE + TOTAL_PRICE + totalPrice + USD);

    }

    public List<Car> getListCarsMaximumSpeedRange(int speedMin, int speedMax){
        List<Car> carSRequiredMark = new ArrayList<>();
        boolean hasRequaredCars = false;
        for (Car car:cars) {
            if (car.getMaxSpeed() > speedMin && car.getMaxSpeed() < speedMax ) {
                carSRequiredMark.add(car);
                hasRequaredCars = true;
            }
        }

        String result = (hasRequaredCars)
                ? CARS_RANGE + speedMin + SPEED_TO + speedMax + SPEED + COLON
                : CARS_RANGE  + speedMin + SPEED_TO + speedMax + SPEED_HAS_NOT;
        System.out.println(NEW_LINE + result);
        return carSRequiredMark;
    }

    public List<? extends Car> getSortCarsFuelConsumption() {
        System.out.println(NEW_LINE + SORT_CAR_FUEL);
        Collections.sort(cars, new CarComparator());
        return cars;
    }
}
