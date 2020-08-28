import carMarks.CarMark;

import java.time.Year;
import java.util.*;

/**
 * Created by Администратор on 25.08.20.
 */
public class CarSaloon {
    private List<? extends Car> cars;

    public CarSaloon() {
    }

    public CarSaloon(List<? extends Car> cars) {
        this.cars = cars;
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

    public List<Car> getListCarsRequiredMark(CarMark carMark){
        List<Car> carsRequiredMark = new ArrayList<>();
        boolean hasRequaredCars = false;
        for (Car car:cars) {
            if (car.getCarMark() == carMark) {
                carsRequiredMark.add(car);
                hasRequaredCars = true;
            }
        }

        String result = (hasRequaredCars)?
                "List cars reqired mark " + carMark + " : "  :
               "Cars with required mark " + carMark + " has not!";
        System.out.println("\n" + result);
        return carsRequiredMark;
    }

    public List<Car> getListCarsOfAGivenModelThatHaveBeenInOperationForMoreThanYears(String carModel, int usedMoreYears){
        List<Car> carsRequiredModelAndUsedMoreYears = new ArrayList<>();
        boolean hasRequaredCars = false;
        int year = Year.now().getValue();
        for (Car car:cars) {
            if (car.getCarModel().equals(carModel) && ((year - car.getYearOfIssue()) > usedMoreYears)) {
                    carsRequiredModelAndUsedMoreYears.add(car);
                hasRequaredCars = true;
            }
        }
        String result = (hasRequaredCars)? "List cars reqired model " + carModel + " and used more "+ usedMoreYears + " years!"
                : "Cars with required model " + carModel + " and used more "+ usedMoreYears + " years has not!";
        System.out.println("\n" + result);
        return carsRequiredModelAndUsedMoreYears;
    }

    public List<Car> getListCarsOfAGivenYearOfManufactureThePriceOfWhichIsHigherThanTheSpecified(int yearRequest, int priceRequest){
        List<Car> carsRequiredModelAndUsedMoreYears = new ArrayList<>();
        boolean hasRequaredCars = false;
        for (Car car:cars) {
            if ( car.getYearOfIssue() == yearRequest && car.getCarPrice() > priceRequest ) {
                carsRequiredModelAndUsedMoreYears.add(car);
                hasRequaredCars = true;
            }
        }
        String result = (hasRequaredCars)? "List cars reqired year " + yearRequest + " and price more than "+ priceRequest + "!"
                : "Cars with required year " + yearRequest + " and price more than "+ priceRequest + " has not!";
        System.out.println("\n" + result);
        return carsRequiredModelAndUsedMoreYears;
    }

    public ArrayList<Car> getSortList(){
        ArrayList<Car> listCarsSortModel = new ArrayList<>(cars);
        Collections.sort(listCarsSortModel, new Comparator<Car>() {
            @Override
            public int compare(Car cust1, Car cust2) {
                return cust1.getCarModel().compareToIgnoreCase(cust2.getCarModel());
            }
        });
        return listCarsSortModel;
    }
}
