package T05Polymorphism.E02VehiclesExtension;

public class Car extends Vehicle {
    private final static double ADDITIONAL_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption += ADDITIONAL_AC_CONSUMPTION;
    }
}