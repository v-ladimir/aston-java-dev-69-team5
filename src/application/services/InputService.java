package application.services;

import creators.ListConstructor;
import creators.ObjectCreatorProvider;
import fillingStrategies.ObjectCreator;
import fillingStrategies.file.ObjectFileReader;
import fillingStrategies.file.parsers.*;
import fillingStrategies.manual.ConsoleUtil;

import java.util.Scanner;

// Сервис для работы с вводом данных
public class InputService {
    private final CollectionService collectionService;
    private final ObjectCreator objectCreator = new ObjectCreator();

    public InputService(CollectionService collectionService, Scanner scanner) {
        this.collectionService = collectionService;
    }

    // Метод по ручному заполнению коллекции
    public void manualInput() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        System.out.print("Введите количество элементов, которые будут занесены вручную: ");
        int count = ConsoleUtil.userIntInput(1, 100);
        collectionService.clearCollection();
        collectionService.setCollection(new ListConstructor<>(new ObjectCreatorProvider(objectCreator.getCreators()
                .get(collectionService.getCollectionType() + ", " + elements[1].getMethodName()))).getList(count));
        System.out.println("Сгенерировано элементов: " + collectionService.getSize());
    }

    // метод для заполнения коллекции из файла
    public void fileInput() {
        System.out.println("Вызов метода наполнения коллекции из файла");
        collectionService.clearCollection();
        switch (collectionService.getCollectionType()) {
            case "Животное" -> {
                try {
                    collectionService.setCollection(
                            new ObjectFileReader<>(new AnimalParser()).read());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    System.out.println("Некорректные значения в файле для заполнения коллекции типа Животное");
                }
            }
            case "Бочка" -> {
                try {
                    collectionService.setCollection(
                            new ObjectFileReader<>(new BarrelParser()).read());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    System.out.println("Некорректные значения в файле для заполнения коллекции типа Бочка");
                }
            }
            case "Человек" -> {
                try {
                    collectionService.setCollection(
                            new ObjectFileReader<>(new PersonParser()).read());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка при чтении файла: " + e.getMessage());
                    System.out.println("Некорректные значения в файле для заполнения коллекции типа Человек");
                }
            }
        }
        System.out.println("Сгенерировано элементов: " + collectionService.getSize());
    }

    // Метод по рандомному заполнению коллекции
    public void randomInput() {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        System.out.print("Сколько элементов сгенерировать? ");
        int count = ConsoleUtil.userIntInput(1, 1000);
        collectionService.clearCollection();
        collectionService.setCollection(new ListConstructor<>(new ObjectCreatorProvider(objectCreator.getCreators()
                .get(collectionService.getCollectionType() + ", " + elements[1].getMethodName()))).getList(count));

        System.out.println("Сгенерировано элементов: " + collectionService.getSize());
    }
}
