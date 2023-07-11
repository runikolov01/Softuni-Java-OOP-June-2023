package T05Polymorphism.E02VehiclesExtension;

public class Bus extends Vehicle {
    public final static double ADDITIONAL_FULL_BUS_CONSUMPTION = 1.4;

    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        if (!isEmpty && empty) {
            this.fuelConsumption -= ADDITIONAL_FULL_BUS_CONSUMPTION;
        }

        if (isEmpty && !empty) {
            this.fuelConsumption += ADDITIONAL_FULL_BUS_CONSUMPTION;

        }
    }
}
