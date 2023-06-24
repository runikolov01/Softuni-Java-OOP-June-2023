package T01WorkingWithAbstraction.E04TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] colors = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(scan.nextLine());

        List<Light> trafficLight = new ArrayList<>();

        for (String color : colors) {
            Light light = new Light(Color.valueOf(color));
            trafficLight.add(light);
        }

        for (int i = 0; i < n; i++) {
            trafficLight.forEach(light -> {
                //сменям цвета
                light.changeColor();
                //отпечатвам цвета
                System.out.print(light.getColor() + " ");
            });
            System.out.println();
        }

    }
}
