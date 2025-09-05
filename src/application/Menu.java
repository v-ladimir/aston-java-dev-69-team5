package application;

import application.services.*;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final CollectionService collectionService;
    private final InputService inputService;
    private final OutputService outputService;
    private final SortService sortService;
    private final SearchService searchService;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.collectionService = new CollectionService();
        this.inputService = new InputService(collectionService, scanner);
        this.outputService = new OutputService(collectionService);
        this.sortService = new SortService(collectionService, outputService);
        this.searchService = new SearchService(collectionService);
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("Текущий тип коллекции: " + collectionService.getCollectionType());
            System.out.println("1. Выбор типа класса");
            System.out.println("2. Ввод/заполнение данных");
            System.out.println("3. Вывод коллекции");
            System.out.println("4. Сортировка");
            System.out.println("5. Поиск");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт: ");

            int choice = readIntInput(1, 6);

            switch (choice) {
                case 1 -> selectCollectionType();
                case 2 -> showInputMenu();
                case 3 -> outputService.showCollection();
                case 4 -> sortService.sortCollection();
                case 5 -> searchService.searchInCollection();
                case 6 -> {
                    System.out.println("До свидания!");
                    return;
                }
            }
        }
    }

    private void selectCollectionType() {
        System.out.println("\n=== ВЫБОР ТИПА КОЛЛЕКЦИИ ===");
        System.out.println("1. Животное");
        System.out.println("2. Бочка");
        System.out.println("3. Человек");
        System.out.print("Выберите тип: ");

        int choice = readIntInput(1, 3);

        switch (choice) {
            case 1 -> collectionService.setCollectionType("Животное");
            case 2 -> collectionService.setCollectionType("Бочка");
            case 3 -> collectionService.setCollectionType("Человек");
        }
        System.out.println("Тип коллекции установлен: " + collectionService.getCollectionType());
    }

    private void showInputMenu() {
        if (collectionService.getCollectionType().equals("Не выбрана")) {
            System.out.println("Сначала выберите тип коллекции!");
            return;
        }

        System.out.println("\n=== ВВОД ДАННЫХ ===");
        System.out.println("1. Вручную");
        System.out.println("2. Из файла");
        System.out.println("3. Случайные значения");
        System.out.print("Выберите способ: ");

        int choice = readIntInput(1, 3);

        switch (choice) {
            case 1 -> inputService.manualInput();
            case 2 -> inputService.fileInput();
            case 3 -> inputService.randomInput();
        }
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