package application.services;

import util.ConsoleUtil;
import util.ObjectFileWriter;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

// Сервис для записи отсортированной коллекции в файл и записи значения полученного бинарным поиском в файл.
public class FileWriterService {
    private final CollectionService collectionService;
    private Path path;

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
        ObjectFileWriter testWriter = new ObjectFileWriter(path);
        for (int i = 0; i < collectionService.getSize(); i++) {
            testWriter.write(collectionService.getCollection().get(i));
        }
        System.out.println("Коллекция записана в файл: " + path);
    }

    public void saveSearchResultToFile() {
        if (collectionService.getSearchIndex() == -1) {
            System.out.println("Отсутствует значение для записи в файл.");
            return;
        }
        path = chooseFilePath();
        ObjectFileWriter testWriter = new ObjectFileWriter(path);
        testWriter.write(collectionService.getCollection().get(collectionService.getSearchIndex()));
        System.out.println("Найденное значение записано в файл: " + path);
        collectionService.searchIndexReset();
    }

    public void clearFile() {
        try {
            path = chooseFilePath();
            new ObjectFileWriter(path).clearFile();
            System.out.println("Очищено содержимое файла: \n" + path);
        } catch (Exception e) {
            System.out.println("Указан неверный путь к файлу.");
        }
    }

    public static Path chooseFilePath() {
        System.out.println("Введите полный путь к файлу: ");
        Path path;
        while (true) {
            try {
                path = Path.of(ConsoleUtil.userStringInput());
                break;
            } catch (InvalidPathException e) {
                System.out.println("Задан некорректный путь к файлу. Повторите ввод: ");
            }
        }
        return path;
    }
}
