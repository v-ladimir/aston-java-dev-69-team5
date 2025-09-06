package fillingStrategies.file.creators;

import creators.ObjectCreator;
import customClasses.Barrel;
import fillingStrategies.file.ObjectFileReader;
import fillingStrategies.file.parsers.BarrelParser;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileBarrelCreator implements ObjectCreator<Barrel> {
    private Path path;
    private ObjectFileReader fileReader;
    private List<Barrel> listObjectsFromFile = new ArrayList<>();

    public FileBarrelCreator(Path path) {
        this.path = path;
        this.fileReader = new ObjectFileReader(path, new BarrelParser());
        initList();
    }

    public FileBarrelCreator() {
        this.path = Path.of("src/resources/data.txt");
        this.fileReader = new ObjectFileReader(path, new BarrelParser());
        initList();
    }

    @Override
    public Barrel createObject() {
        if (listObjectsFromFile.size()==0) {
            throw new RuntimeException("list objects is empty");
        }
        Barrel barrel = listObjectsFromFile.get(0);
        listObjectsFromFile.remove(0);
        return barrel;
    }

    private void initList() {
        listObjectsFromFile = fileReader.read();
    }
}
