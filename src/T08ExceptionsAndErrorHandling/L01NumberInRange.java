package T08ExceptionsAndErrorHandling;

import java.util.Scanner;

public class L01NumberInRange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int startNum = Integer.parseInt(input[0]);
        int endNum = Integer.parseInt(input[1]);

        System.out.printf("Range: [%d...%d]%n", startNum, endNum);

        while (true) {
            String num = scan.nextLine();
            try {
                int realNum = Integer.parseInt(num);
                if (realNum >= startNum && realNum <= endNum) {
                    System.out.println("Valid number: " + realNum);
                    break;
                } else {
                    System.out.println("Invalid number: " + realNum);
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Invalid number: " + num);
            }
        }
    }
}
