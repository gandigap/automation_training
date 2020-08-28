package Cars;

import carTypesAndMarksEnum.CarMark;
import java.util.Objects;

abstract public class Car {
    private static int totalCars = 0;
    private int id = totalCars++;

    private CarMark mark;
    private String model;
    private double fuelConsumption;
    private int maxSpeed;
    private double price;
    private boolean hasInternet;

    public Car(CarMark mark, String model, double fuelConsumption, int maxSpeed, double price) {
        this.mark = mark;
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public CarMark getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public boolean isHasInternet() {
        return hasInternet;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id = " + id +
                ", mark = " + mark +
                ", model = '" + model + '\'' +
                ", fuelConsumption = " + fuelConsumption +
                ", maxSpeed = " + maxSpeed +
                ", price = " + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Double.compare(car.fuelConsumption, fuelConsumption) == 0 &&
                maxSpeed == car.maxSpeed &&
                Double.compare(car.price, price) == 0 &&
                mark == car.mark &&
                Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, model, fuelConsumption, maxSpeed, price);
    }
}
