package com.aston.edu.util;

import java.util.Scanner;

public class ConsoleUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void print(String message) {
        System.out.print(message);
    }

    public static String userStringInput() {
        String input = scanner.nextLine();
        return input;
    }

    public static int userIntInput(int minLimit, int maxLimit) {
        boolean validInput = false;
        int input = 0;
        while (!validInput) {
            if (!scanner.hasNextInt()) {
                ConsoleUtil.print("Input must be number between %d and %d".formatted(minLimit, maxLimit));
                scanner.nextLine();
                continue;
            }

            input = scanner.nextInt();
            scanner.nextLine();

            if (input < minLimit || input > maxLimit) {
                ConsoleUtil.print("Input must be number between %d and %d".formatted(minLimit, maxLimit));
                continue;
            }
            validInput = true;
        }
        return input;
    }
}
