import Cars.*;
import TaxiStation.TaxiStation;
import carTypesAndMarksEnum.*;
import java.util.Arrays;
import java.util.List;

public class Runner {
    static List<Car> cars = Arrays.asList(
            new BusinessCar(CarMark.BMW, "ALPINA B7", BusinessType.SEDAN, 14.5, 280, 45000.0),
            new BusinessCar(CarMark.BMW, "X7", BusinessType.SUV, 16, 250, 52015.10),
            new StandardCar(CarMark.HONDA, "Accord", StandardType.SEDAN, 8.7, 220, 16540),
            new PremiumCar(CarMark.FERRARI, "Gran Turismo", PremiumType.SPORTCAR, 19, 320, 124000),
            new StandardCar(CarMark.RENAULT, "Captur", StandardType.HATCHBACK, 9, 200, 15700.8),
            new StandardCar(CarMark.FORD, "Mondeo", StandardType.SEDAN, 8.5, 210, 21000),
            new BusinessCar(CarMark.MERCEDES, "BENZ", BusinessType.VAN, 15, 240, 38000),
            new StandardCar(CarMark.SUZUKI, "Alto", StandardType.MICRO, 5.4, 160, 12350.50),
            new PremiumCar(CarMark.HUMMER, "H3", PremiumType.LIMOUSINE, 21.5, 220, 8000)
    );

    public static void main(String[] args) {
        TaxiStation taxiStation = new TaxiStation("Rocket", cars);
        System.out.println("Taxi station - " + taxiStation.getTitle());
        taxiStation.print(cars);
        taxiStation.getTotalPriceAllCars();
        taxiStation.print(taxiStation.getListCarsMaximumSpeedRange(270, 370));
        taxiStation.print(taxiStation.getSortCarsFuelConsumption());
    }
}
