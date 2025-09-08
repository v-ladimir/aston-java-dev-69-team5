package fillingStrategies.file.creators;

import application.services.FileWriterService;
import fillingStrategies.ObjectCreator;
import customClasses.Animal;
import fillingStrategies.file.util.ObjectFileReader;
import fillingStrategies.file.parsers.AnimalParser;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileAnimalCreator implements ObjectCreator<Animal> {
    private Path path;
    private ObjectFileReader fileReader;
    private List<Animal> listObjectsFromFile = new ArrayList<>();

    public FileAnimalCreator(Path path) {
        this.path = path;
        this.fileReader = new ObjectFileReader(path, new AnimalParser());
        initList();
    }

    public FileAnimalCreator() {
        this.path = Path.of(FileWriterService.chooseFilePath());
        this.fileReader = new ObjectFileReader(path, new AnimalParser());
        initList();
    }

    @Override
    public Animal createObject() {
        if (listObjectsFromFile.size()==0) {
            throw new RuntimeException("list objects is empty");
        }
        Animal animal = listObjectsFromFile.get(0);
        listObjectsFromFile.remove(0);
        return animal;
    }

    private void initList() {
        listObjectsFromFile = fileReader.read();
    }
}
