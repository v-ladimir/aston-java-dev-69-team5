package application.services;

import fillingStrategies.file.util.ObjectFileWriter;

import java.nio.file.Path;

// Сервис для записи отсортированной коллекции в файл и записи значения полученного бинарным поиском в файл.
public class FileWriterService {
    private final CollectionService collectionService;

    public FileWriterService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void saveSortedCollectionToFile() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        if (!collectionService.isSorted()) {
            System.out.println("Коллекция не отсортирована! Сначала отсортируйте её.");
            return;
        }
        ObjectFileWriter testWriter = new ObjectFileWriter(Path.of("src/resources/testWriterFile.txt"));
        for (int i = 0; i < collectionService.getSize(); i++) {
            System.out.println((i + 1) + ". " + collectionService.getCollection().get(i));
            testWriter.write(collectionService.getCollection().get(i));
        }
        System.out.println("Коллекция записана в файл: src/resources/testWriterFile.txt");
    }

    public void saveSearchResultToFile() {
        if (collectionService.getSearchIndex() == -1) {
            System.out.println("Отсутствует значение для записи в файл");
            return;
        }
        ObjectFileWriter testWriter = new ObjectFileWriter(Path.of("src/resources/testWriterFile.txt"));
        testWriter.write(collectionService.getCollection().get(collectionService.getSearchIndex()));
        System.out.println("Найденное значение записано в файл: src/resources/testWriterFile.txt");
        collectionService.searchIndexReset();
    }
}
