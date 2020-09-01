import carMarks.CarMark;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Администратор on 25.08.20.
 */

public class Runner {
    static List<Car> cars = Arrays.asList(
            new Car(CarMark.BMW, "X5", 1992, "blue", 5423.23 ,"2344 AB-7"),
            new Car(CarMark.VOLVO, "XC90", 2002, "red", 15000 ,"2344 ВА-5"),
            new Car(CarMark.VOLVO, "XC60", 2018, "green", 9087.8 ,"2344 ЕЕ-4"),
            new Car(CarMark.SUBARU, "Forester", 2010, "red", 17432.7 ,"2344 МП-2"),
            new Car(CarMark.SUZUKI, "Grand Vitara", 1990, "blue", 2000 ,"2344 ЫВ-4"),
            new Car(CarMark.FORD, "Mondeo", 2015, "yellow", 14235.96 ,"2344 НЕ-1"),
            new Car(CarMark.RENAULT, "Logan", 2013, "black", 10549.8 ,"2344 ВА-2"),
            new Car(CarMark.HONDA, "CR-V", 1997, "white", 7468 ,"2344 АК-1"),
            new Car(CarMark.BMW, "X6", 2005, "green", 6500 ,"2344 AB-4"),
            new Car(CarMark.SUZUKI, "Jimmy", 2005, "brown", 4789.1 ,"2344 AB-7")
    );


    public static void main(String[] args) {
        CarSaloon carSaloon = new CarSaloon(cars);

        carSaloon.print(cars);
        carSaloon.print(carSaloon.getListCarsRequiredMark(CarMark.VOLVO));
        carSaloon.print(carSaloon.getListCarsOfAGivenModelThatHaveBeenInOperationForMoreThanYears("MONDEO", 16));
        carSaloon.print(carSaloon.getListCarsOfAGivenYearOfManufactureThePriceOfWhichIsHigherThanTheSpecified(2005, 6000));


    }
}
