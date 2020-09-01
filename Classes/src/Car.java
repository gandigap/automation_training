import carMarks.CarMark;

/**
 * Created by Администратор on 25.08.20.
 */
public class Car {
    private static int totalCars = 0;
    private int id = totalCars++;

    private CarMark carMark;
    private String carModel;
    private int yearOfIssue;
    private String carColor;
    private double carPrice;
    private String carRegistrationNumber;

    public Car() {
    }

    public Car(CarMark carMark, String carModel, int yearOfIssue, String carColor, double carPrice, String carRegistrationNumber) {
        this.carMark = carMark;
        this.carModel = carModel;
        this.yearOfIssue = yearOfIssue;
        this.carColor = carColor;
        this.carPrice = carPrice;
        this.carRegistrationNumber = carRegistrationNumber;
    }

    public CarMark getCarMark() {
        return carMark;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getCarColor() {
        return carColor;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public String getCarRegistrationNumber() {
        return carRegistrationNumber;
    }

    @Override
    public String toString() {
        return "Car {" +
                "id= " + id +
                ", Mark= " + carMark +
                ", Model= '" + carModel + '\'' +
                ", year Of Issue= " + yearOfIssue +
                ", Color= '" + carColor + '\'' +
                ", Price= " + carPrice +
                ", Registration Number= '" + carRegistrationNumber + '\'' +
                '}' ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (yearOfIssue != car.yearOfIssue) return false;
        if (Double.compare(car.carPrice, carPrice) != 0) return false;
        if (carMark != car.carMark) return false;
        if (carModel != null ? !carModel.equals(car.carModel) : car.carModel != null) return false;
        if (carColor != null ? !carColor.equals(car.carColor) : car.carColor != null) return false;
        return carRegistrationNumber != null ? carRegistrationNumber.equals(car.carRegistrationNumber) : car.carRegistrationNumber == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (carMark != null ? carMark.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + yearOfIssue;
        result = 31 * result + (carColor != null ? carColor.hashCode() : 0);
        temp = Double.doubleToLongBits(carPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (carRegistrationNumber != null ? carRegistrationNumber.hashCode() : 0);
        return result;
    }
}
