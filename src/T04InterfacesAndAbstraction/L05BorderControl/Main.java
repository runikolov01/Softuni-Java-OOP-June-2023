package T04InterfacesAndAbstraction.L05BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        String first = input[0];

        List<Identifiable> identifiableListList = new ArrayList<>();

        while (!first.equals("End")) {
            if (first.contains("-")) {
                String model = input[0];
                String id = input[1];
                Robot robot = new Robot(model, id);
                identifiableListList.add(robot);
            } else {
                String name = input[0];
                int age = Integer.parseInt(input[1]);
                String id = input[2];
                Citizen citizen = new Citizen(name, age, id);
                identifiableListList.add(citizen);
            }
            input = scan.nextLine().split("\\s+");
            first = input[0];
        }

        String num = scan.nextLine();
        List<String> idList = new ArrayList<>();

        for (Identifiable item : identifiableListList) {
            if (item.getId().endsWith(num)) {
                idList.add(item.getId());
            }
        }

        for (String id : idList) {
            System.out.println(id);
        }
    }
}
