package tests.fillingFromFile;

import fillingStrategies.file.creators.*;
import tests.Testing;

import java.nio.file.Path;

public class TestFileCreators implements Testing {

    public static void main(String[] args) {
        new TestFileCreators().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing FileCreators");
        FileAnimalCreator animalCreator =
                new FileAnimalCreator(Path.of("src/tests/fillingFromFile/testFiles/animals.txt"));
        for (int i = 0; i < 10; i++) {
            System.out.println(animalCreator.createObject());
        }
        System.out.println();
        FileBarrelCreator barrelCreator =
                new FileBarrelCreator(Path.of("src/tests/fillingFromFile/testFiles/barrels.txt"));
        for (int i = 0; i < 10; i++) {
            System.out.println(barrelCreator.createObject());
        }
        System.out.println();
        FilePersonCreator personCreator =
                new FilePersonCreator(Path.of("src/tests/fillingFromFile/testFiles/persons.txt"));
        for (int i = 0; i < 10; i++) {
            System.out.println(personCreator.createObject());
        }
    }
}
