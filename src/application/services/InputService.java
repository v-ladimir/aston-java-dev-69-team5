package application.services;

import creators.ListConstructor;
import creators.ObjectCreatorProvider;
import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.manual.ManualAnimalCreator;
import fillingStrategies.manual.ManualBarrelCreator;
import fillingStrategies.manual.ManualPersonCreator;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;

import java.util.Scanner;

// Сервис для работы с вводом данных
public class InputService {
    private final CollectionService collectionService;
    private final Scanner scanner;

    public InputService(CollectionService collectionService, Scanner scanner) {
        this.collectionService = collectionService;
        this.scanner = scanner;
    }

    public void manualInput() {
        System.out.print("Введите количество элементов, которые будут занесены вручную: ");
        int count = readIntInput(1, 1000);

        collectionService.clearCollection();

        switch (collectionService.getCollectionType()) {
            case "Животное" ->
                    collectionService.setCollection(
                            new ListConstructor<>(new ObjectCreatorProvider(new ManualAnimalCreator())).getList(count)
                    );
            case "Бочка" ->
                    collectionService.setCollection(
                            new ListConstructor<>(new ObjectCreatorProvider(new ManualBarrelCreator())).getList(count)
                    );
            case "Человек" ->
                    collectionService.setCollection(
                            new ListConstructor<>(new ObjectCreatorProvider(new ManualPersonCreator())).getList(count)
                    );
        }
        System.out.println("Сгенерировано элементов: " + collectionService.getSize());
    }

    public void fileInput() {
        System.out.println("Вызов метода наполнения коллекции из файла");
        // Реализация чтения из файла
    }

    public void randomInput() {
        System.out.print("Сколько элементов сгенерировать? ");
        int count = readIntInput(1, 1000);

        collectionService.clearCollection();

        switch (collectionService.getCollectionType()) {
            case "Животное" ->
                    collectionService.setCollection(
                            new ListConstructor<>(new ObjectCreatorProvider(new RandomAnimalGenerator())).getList(count)
                    );
            case "Бочка" ->
                    collectionService.setCollection(
                            new ListConstructor<>(new ObjectCreatorProvider(new RandomBarrelGenerator())).getList(count)
                    );
            case "Человек" ->
                    collectionService.setCollection(
                            new ListConstructor<>(new ObjectCreatorProvider(new RandomPersonGenerator())).getList(count)
                    );
        }
        System.out.println("Сгенерировано элементов: " + collectionService.getSize());
    }

    private int readIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Введите число от " + min + " до " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }
}
