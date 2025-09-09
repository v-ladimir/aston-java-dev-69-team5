package fillingStrategies.file.util;

import customClasses.CustomArrayListImpl;
import fillingStrategies.file.parsers.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ObjectFileReader<T> {
    private Path path;
    private final Parser<T> parser;

    public ObjectFileReader(Path path, Parser<T> parser) {
        this.path = path;
        this.parser = parser;
    }

    public List<T> read() {
        List<T> listObjects = new CustomArrayListImpl<>();
        try {
            List<String> data = Files.readAllLines(path);
            for (String s : data) {
                listObjects.add(parser.getObjectFromString(s));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listObjects;
    }
}
