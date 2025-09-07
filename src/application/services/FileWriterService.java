package application.services;

import fillingStrategies.file.util.ObjectFileWriter;
import fillingStrategies.manual.ConsoleUtil;

import java.nio.file.Path;

// Сервис для записи отсортированной коллекции в файл и записи значения полученного бинарным поиском в файл.
public class FileWriterService {
    private final CollectionService collectionService;
    private String path;

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
        path = chooseFilePath();
        ObjectFileWriter testWriter = new ObjectFileWriter(Path.of(path));
        for (int i = 0; i < collectionService.getSize(); i++) {
            testWriter.write(collectionService.getCollection().get(i));
        }
        System.out.println("Коллекция записана в файл: " + path);
    }

    public void saveSearchResultToFile() {
        if (collectionService.getSearchIndex() == -1) {
            System.out.println("Отсутствует значение для записи в файл");
            return;
        }
        path = chooseFilePath();
        ObjectFileWriter testWriter = new ObjectFileWriter(Path.of(path));
        testWriter.write(collectionService.getCollection().get(collectionService.getSearchIndex()));
        System.out.println("Найденное значение записано в файл: " + path);
        collectionService.searchIndexReset();
    }

    public void clearFile() {
        path = chooseFilePath();
        new ObjectFileWriter(Path.of(path)).clearFile();
        System.out.println("Очищено содержимое файла: \n" + path);

    }

    public static String chooseFilePath() {
        System.out.println("Введите полный путь к файлу:");
        return ConsoleUtil.userStringInput();
    }
}
