package T01WorkingWithAbstraction;

import java.util.Scanner;

public class L01RhombusOfStars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        printTopPart(n);

        printMiddle(n);

        printBottomPart(n);


    }

    private static void printBottomPart(int n) {
        for (int row = n - 1; row >= 1; row--) {
            printRow(n, row);
        }
    }

    private static void printMiddle(int n) {
        for (int star = 1; star <= n; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void printTopPart(int n) {
        for (int row = 1; row <= n - 1; row++) {
            printRow(n, row);
        }
    }

    private static void printRow(int n, int row) {
        for (int space = 1; space <= n - row; space++) {
            System.out.printf(" ");
        }
       printMiddle(row);
    }


}
