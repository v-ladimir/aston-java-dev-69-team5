package tests.manual;

import fillingStrategies.manual.ConsoleUtil;

public class TestConsoleUtil {
    public static void main(String[] args) {
        System.out.println(ConsoleUtil.userStringInput());
        System.out.println(ConsoleUtil.userIntInput(1, 3));
    }
}
