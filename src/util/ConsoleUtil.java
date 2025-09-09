package util;

import java.util.Scanner;

public class ConsoleUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int userIntInput(int minLimit, int maxLimit) {
        boolean validInput = false;
        int input = 0;
        while (!validInput) {
            if (!scanner.hasNextInt()) {
                System.out.printf("Введите число от %d до %d: ", minLimit, maxLimit);
                scanner.nextLine();
                continue;
            }

            input = scanner.nextInt();
            scanner.nextLine();

            if (input < minLimit || input > maxLimit) {
                System.out.printf("Введите число от %d до %d: ", minLimit, maxLimit);
                continue;
            }
            validInput = true;
        }
        return input;
    }

    public static String userStringInput() {
        return scanner.nextLine();
    }
}
