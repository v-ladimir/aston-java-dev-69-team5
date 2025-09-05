package tests;

import creators.ObjectCreatorProvider;
import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.file.ObjectFileWriter;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestFileWriter implements Testing {
    @Override
    public boolean testFunction() {
        //удаляю и очищаю файлы после предущих запусков теста
        try {
            Files.deleteIfExists(Path.of("src/tests/testCreateAndWrite.txt"));
            Files.deleteIfExists(Path.of("src/tests/testCreateWriteClean.txt"));
            Files.deleteIfExists(Path.of("src/tests/presentFile.txt"));
            Files.createFile(Path.of("src/tests/presentFile.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectCreatorProvider<Person> personCreator = new ObjectCreatorProvider<>(new RandomPersonGenerator());
        ObjectCreatorProvider<Barrel> barrelCreator = new ObjectCreatorProvider<>(new RandomBarrelGenerator());
        ObjectCreatorProvider<Animal> animalCreator = new ObjectCreatorProvider<>(new RandomAnimalGenerator());

        ObjectFileWriter testWriter = new ObjectFileWriter(Path.of("src/tests/testCreateAndWrite.txt"));
        testWriter.write(personCreator.createObject());
        testWriter.write(personCreator.createObject());
        testWriter.write(barrelCreator.createObject());
        testWriter.write(animalCreator.createObject());
        testWriter.write(animalCreator.createObject());
        testWriter.write(barrelCreator.createObject());

        testWriter = new ObjectFileWriter(Path.of("src/tests/testCreateWriteClean.txt"));
        testWriter.write(personCreator.createObject());
        testWriter.clearFile();

        testWriter = new ObjectFileWriter(Path.of("src/tests/presentFile.txt"));
        testWriter.write(personCreator.createObject());
        testWriter.write(personCreator.createObject());
        testWriter.write(animalCreator.createObject());
        testWriter.write(animalCreator.createObject());

        return true;
    }
}
