package T08ExceptionsAndErrorHandling;

import java.util.Scanner;

public class L02SquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int num = Integer.parseInt(scan.nextLine());
            double sqrtNum = Math.sqrt(num);
            System.out.printf("%.02f%n", sqrtNum);
        } catch (NumberFormatException numberFormatException) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
