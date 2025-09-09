package tests.WritingToFile;

import customClasses.Animal;
import fillingStrategies.file.parsers.AnimalParser;
import util.ObjectFileReader;
import util.ObjectFileWriter;
import fillingStrategies.random.RandomAnimalGenerator;
import tests.Testing;

import java.nio.file.Path;

public class TestObjectFileWriter implements Testing {

    public static void main(String[] args) {
        new TestObjectFileWriter().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing ObjectFileWriter");
        Path path = Path.of("src/tests/WritingToFile/data.txt");
        ObjectFileWriter writer = new ObjectFileWriter(path);
        writer.write(new RandomAnimalGenerator().createObject());
        ObjectFileReader<Animal> animalReader = new ObjectFileReader<>(path, new AnimalParser());
        animalReader.read().forEach(System.out::println);
        writer.clearFile();
    }
}
