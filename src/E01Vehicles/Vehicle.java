package E01Vehicles;

import java.text.DecimalFormat;

public class Vehicle implements VehicleInterface {
    private double fuelQuantity;
    private double litersPerKM;

    public Vehicle(double fuelQuantity, double litersPerKM) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKM = litersPerKM;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKM() {
        return litersPerKM;
    }


    @Override
    public void drive(double distance) {
        DecimalFormat df = new DecimalFormat("0.##");
        double distanceCalc = distance * getLitersPerKM();
        if (distanceCalc > getFuelQuantity()) {
            System.out.printf("%s needs refueling\n", this.getClass().getSimpleName());
        } else if (distanceCalc <= getFuelQuantity()){
            System.out.printf("%s travelled %s km\n", this.getClass().getSimpleName(), df.format(distance));
            setFuelQuantity(getFuelQuantity() - distanceCalc);
        }

    }

    @Override
    public void refuel(double liters) {
        double refuelCalc = liters;
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }

        if (this.getClass() == Car.class){
            setFuelQuantity(getFuelQuantity() + liters);
        } else if (this.getClass() == Truck.class) {
            refuelCalc = liters - (liters * ((Truck) this).getTINY_WHOLE_LOSES());
            setFuelQuantity(getFuelQuantity() + refuelCalc);
        }
    }
}