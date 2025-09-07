package tests.fillingFromFile;

import fillingStrategies.file.creators.FileAnimalCreator;
import fillingStrategies.file.creators.FileBarrelCreator;
import fillingStrategies.file.creators.FilePersonCreator;
import java.nio.file.Path;

public class TestFileCreators {
    public static void main(String[] args) {
        FileAnimalCreator animalCreator = new FileAnimalCreator(
                Path.of("src/tests/fillingFromFile/testFiles/animals.txt"));
        for (int i = 0; i < 10; i++) {
            System.out.println(animalCreator.createObject());
        }
        System.out.println();
        FileBarrelCreator barrelCreator = new FileBarrelCreator(
                Path.of("src/tests/fillingFromFile/testFiles/barrels.txt"));
        for (int i = 0; i < 10; i++) {
            System.out.println(barrelCreator.createObject());
        }
        System.out.println();
        FilePersonCreator personCreator = new FilePersonCreator(
                Path.of("src/tests/fillingFromFile/testFiles/persons.txt"));
        for (int i = 0; i < 10; i++) {
            System.out.println(personCreator.createObject());
        }
    }
}
