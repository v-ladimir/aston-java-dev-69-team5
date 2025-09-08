package fillingStrategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListConstructor<T> {
    private ObjectCreator<T> objectCreator;

    public ListConstructor() {
    }

    public ListConstructor(ObjectCreator<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public ObjectCreator<T> getObjectCreator() {
        return objectCreator;
    }

    public void setObjectCreator(ObjectCreator<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public List<T> getListSingleThread(int size) {
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

    public List<T> getListMultyThread(int size) {
        if (objectCreator == null) {
            throw new IllegalStateException("Object creator not set");
        }
        if (size == 0) {
            throw new IllegalArgumentException("Size must be > 0");
        }

        List<T> list = Collections.synchronizedList(new ArrayList<>(size));

        int availableProcessors = Runtime.getRuntime().availableProcessors();

        ExecutorService pool = Executors.newFixedThreadPool(availableProcessors + 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            pool.execute(() -> list.add(objectCreator.createObject()));
        }

        pool.shutdown();

        try {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        return list;
    }
}
