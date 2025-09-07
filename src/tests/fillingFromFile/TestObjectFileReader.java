package tests.fillingFromFile;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.file.parsers.AnimalParser;
import fillingStrategies.file.parsers.BarrelParser;
import fillingStrategies.file.parsers.PersonParser;
import fillingStrategies.file.util.ObjectFileReader;
import java.nio.file.Path;

public class TestObjectFileReader {
    public static void main(String[] args) {
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
