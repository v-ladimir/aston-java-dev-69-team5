package tests;

import tests.WritingToFile.TestObjectFileWriter;
import tests.customClasses.*;
import tests.fillingFromFile.*;
import tests.manual.*;
import tests.random.TestRandomGenerators;
import tests.search.TestBinarySearch;
import tests.sort.TestTimSort;

import java.util.ArrayList;
import java.util.List;

public class AllTests {
    private static List<Testing> tests = new ArrayList<>();

    static {
        tests.add(new TestAnimal());
        tests.add(new TestBarrel());
        tests.add(new TestPerson());

        tests.add(new TestFileCreators());
        tests.add(new TestObjectFileReader());
        tests.add(new TestParsers());

        tests.add(new TestConsoleUtil());
        tests.add(new TestManualCreators());
        tests.add(new TestRandomGenerators());

        tests.add(new TestTimSort());
        tests.add(new TestBinarySearch());
        tests.add(new TestObjectFileWriter());
    }

    public static void main(String[] args) {
        for (Testing test : tests) {
            test.testFunction();
            System.out.println();
        }
    }
}
