package E01Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carData = scanner.nextLine().split("\\s+");
        String[] truckData = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carData[1]), Double.parseDouble(carData[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckData[1]), Double.parseDouble(truckData[2]));
        Map<String, Vehicle> vehicles = new LinkedHashMap<>() {{
            put("Car", car);
            put("Truck", truck);
        }};

        int commands = Integer.parseInt(scanner.nextLine());
        while (commands-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            if (command.equals("Drive")) {
                vehicles.get(tokens[1]).drive(Double.parseDouble(tokens[2]));
            } else if (command.equals("Refuel")) {
                vehicles.get(tokens[1]).refuel(Double.parseDouble(tokens[2]));
            }
        }

        vehicles.forEach((key, value) -> System.out.printf("%s: %.2f\n", key, value.getFuelQuantity()));
    }
}