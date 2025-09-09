package tests.fillingFromFile;

import customClasses.*;
import fillingStrategies.file.parsers.*;
import util.ObjectFileReader;
import tests.Testing;

import java.nio.file.Path;

public class TestObjectFileReader implements Testing {

    public static void main(String[] args) {
        new TestObjectFileReader().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing ObjectFileReader");
        ObjectFileReader<Animal> animalReader = new ObjectFileReader<>(
                Path.of("src/tests/fillingFromFile/testFiles/animals.txt"), new AnimalParser());
        animalReader.read().forEach(System.out::println);
        System.out.println();

        ObjectFileReader<Barrel> barrelReader = new ObjectFileReader<>(
                Path.of("src/tests/fillingFromFile/testFiles/barrels.txt"), new BarrelParser());
        barrelReader.read().forEach(System.out::println);
        System.out.println();

        ObjectFileReader<Person> personReader = new ObjectFileReader<>(
                Path.of("src/tests/fillingFromFile/testFiles/persons.txt"), new PersonParser());
        personReader.read().forEach(System.out::println);
    }
}
