package fillingStrategies.file.creators;

import application.services.FileWriterService;
import customClasses.CustomArrayListImpl;
import fillingStrategies.ObjectCreator;
import customClasses.Person;
import fillingStrategies.file.util.ObjectFileReader;
import fillingStrategies.file.parsers.PersonParser;

import java.nio.file.Path;
import java.util.List;

public class FilePersonCreator implements ObjectCreator<Person> {
    private Path path;
    private ObjectFileReader fileReader;
    private List<Person> listObjectsFromFile = new CustomArrayListImpl<>();

    public FilePersonCreator(Path path) {
        this.path = path;
        this.fileReader = new ObjectFileReader(path, new PersonParser());
        initList();
    }

    public FilePersonCreator() {
        this.path = Path.of(FileWriterService.chooseFilePath());
        this.fileReader = new ObjectFileReader(path, new PersonParser());
        initList();
    }

    @Override
    public Person createObject() {
        if (listObjectsFromFile.size()==0) {
            throw new RuntimeException("list objects is empty");
        }
        Person person = listObjectsFromFile.get(0);
        listObjectsFromFile.remove(0);
        return person;
    }

    private void initList() {
        listObjectsFromFile = fileReader.read();
    }
}
