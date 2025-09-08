package fillingStrategies.file.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ObjectFileWriter {
    private final Path path;

    public ObjectFileWriter(Path path) {
        this.path = path;
    }

    public void write(Object object) {
        String objectData = object.toString() + "\n";
        try {
            Files.writeString(path, objectData, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile() {
        try {
            Files.writeString(path, "", StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
