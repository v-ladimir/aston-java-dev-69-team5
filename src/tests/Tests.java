package tests;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    private static List<Testing> tests = new ArrayList<>();

    static {
        //tests.add(new TestBinarySearch());
        //tests.add(new TestPersonBuilder());
        //tests.add(new TestFileWriter());
        tests.add(new TestFileReader());
    }

    public static void main(String[] args) {
        int i = 1;
        for (Testing test : tests) {
            System.out.println(i++ + ": " + test.testFunction() + "\n");
        }
    }
}
