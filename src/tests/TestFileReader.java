package tests;

import creators.ObjectCreatorProvider;
import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.file.ObjectFileReader;
import fillingStrategies.file.ObjectFileWriter;
import fillingStrategies.file.parsers.AnimalParser;
import fillingStrategies.file.parsers.BarrelParser;
import fillingStrategies.file.parsers.PersonParser;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TestFileReader implements Testing {
    @Override
    public boolean testFunction() {
        //удаляю и очищаю файлы после предущих запусков теста
        try {
            Files.deleteIfExists(Path.of("src/tests/testRead.txt"));
            Files.createFile(Path.of("src/tests/testRead.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectCreatorProvider<Person> personCreator = new ObjectCreatorProvider<>(new RandomPersonGenerator());
        ObjectCreatorProvider<Barrel> barrelCreator = new ObjectCreatorProvider<>(new RandomBarrelGenerator());
        ObjectCreatorProvider<Animal> animalCreator = new ObjectCreatorProvider<>(new RandomAnimalGenerator());

        ObjectFileWriter testWriter = new ObjectFileWriter(Path.of("src/tests/testRead.txt"));

        testWriter.write(personCreator.createObject());
        testWriter.write(personCreator.createObject());
        testWriter.write(personCreator.createObject());

        ObjectFileReader testReaderPerson = new ObjectFileReader(Path.of("src/tests/testRead.txt"), new PersonParser());
        List<Person> personList = testReaderPerson.read();
        personList.forEach(System.out::println);
        testWriter.clearFile();
        System.out.println();

        testWriter.write(barrelCreator.createObject());
        testWriter.write(barrelCreator.createObject());
        testWriter.write(barrelCreator.createObject());

        ObjectFileReader testReaderBarrel = new ObjectFileReader(Path.of("src/tests/testRead.txt"), new BarrelParser());
        List<Barrel> barrelList = testReaderBarrel.read();
        barrelList.forEach(System.out::println);
        testWriter.clearFile();
        System.out.println();

        testWriter.write(animalCreator.createObject());
        testWriter.write(animalCreator.createObject());
        testWriter.write(animalCreator.createObject());

        ObjectFileReader testReaderAnimal = new ObjectFileReader(Path.of("src/tests/testRead.txt"), new AnimalParser());
        List<Animal> animalList = testReaderAnimal.read();
        animalList.forEach(System.out::println);
        System.out.println();

        return true;
    }
}
