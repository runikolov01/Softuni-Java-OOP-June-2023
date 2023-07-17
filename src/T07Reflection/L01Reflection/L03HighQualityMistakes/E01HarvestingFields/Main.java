package T07Reflection.L01Reflection.L03HighQualityMistakes.E01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] allFields = clazz.getDeclaredFields();


        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        //Consumer<type> void - активира се чрез accept метода
        Consumer<Field> fieldPrinter = field -> System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()),
                field.getType().getSimpleName(),
                field.getName()
        );

        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    Arrays.stream(allFields)
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(fieldPrinter);
                    break;
                case "protected":
                    Arrays.stream(allFields)
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(fieldPrinter);
                    break;
                case "public":
                    Arrays.stream(allFields)
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(fieldPrinter);
                    break;
                case "all":
                    Arrays.stream(allFields).forEach(fieldPrinter);
                    break;
            }
            command = scan.nextLine();
        }
    }
}
