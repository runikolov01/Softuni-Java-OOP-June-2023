package T01WorkingWithAbstraction.PointInRectangle_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int bottomLeftX = coordinates[0];
        int bottolLeftY = coordinates[1];
        int topRightX = coordinates[2];
        int topRightY = coordinates[3];

        Point bottomLeft = new Point(bottomLeftX, bottolLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 1; i <= n; i++) {
            int[] checkPointCoordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int x = checkPointCoordinates[0];
            int y = checkPointCoordinates[1];
            Point searchedPoint = new Point(x, y);
            System.out.println(rectangle.contains(searchedPoint));
        }


    }
}
