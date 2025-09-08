package tests.manual;

import fillingStrategies.manual.ConsoleUtil;
import tests.Testing;

public class TestConsoleUtil implements Testing {

    public static void main(String[] args) {
        new TestConsoleUtil().testFunction();
    }

    public void testFunction() {
        System.out.println("Testing ConsoleUtil");
        System.out.println("Введите число от 1 до 3");
        System.out.println(ConsoleUtil.userIntInput(1, 3));
    }
}
