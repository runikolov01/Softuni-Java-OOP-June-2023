package T02Encapsulation.E04PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] firstInputArr = scan.nextLine().split("\\s+");
        String pizzaName = firstInputArr[1];
        int numberOfToppings = Integer.parseInt(firstInputArr[2]);
        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String[] secondInputArr = scan.nextLine().split("\\s+");
        String doughType = secondInputArr[1];
        String bakingTechnique = secondInputArr[2];
        double doughWeightGrams = Double.parseDouble(secondInputArr[3]);
        Dough dough = new Dough(doughType, bakingTechnique, doughWeightGrams);
        pizza.setDough(dough);

        String[] thirdInputArr = scan.nextLine().split("\\s+");
        String topping = thirdInputArr[0];
        while (!topping.equals("END")) {
            String typeTopping = thirdInputArr[1];
            double toppingWeightGrams = Double.parseDouble(thirdInputArr[2]);
            Topping top = new Topping(typeTopping, toppingWeightGrams);


            thirdInputArr = scan.nextLine().split("\\s+");
            topping = thirdInputArr[0];
        }

        // пица -> тесто -> списък с топинги
        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
