package creators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListConstructor<T> {
    private ObjectCreatorProvider<T> objectCreator;

    public ListConstructor() {
    }

    public ListConstructor(ObjectCreatorProvider<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public ObjectCreatorProvider<T> getObjectCreator() {
        return objectCreator;
    }

    public void setObjectCreator(ObjectCreatorProvider<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public List<T> getList(int size) {
        if (objectCreator == null) {
            throw new IllegalStateException("Object creator not set");
        }
        if (size == 0) {
            throw new IllegalArgumentException("Size must be > 0");
        }

        return Stream
                .generate(() -> objectCreator.createObject())
                .limit(size)
                .collect(Collectors.toList());
    }
}
