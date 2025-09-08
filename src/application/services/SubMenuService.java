package application.services;

import fillingStrategies.manual.ConsoleUtil;

import java.util.Scanner;

public class SubMenuService {
    private final Scanner scanner;
    private final CollectionService collectionService;
    private final FillingService fillingService;
    private final FileWriterService fileWriterService;

    public SubMenuService(CollectionService collectionService) {
        this.scanner = new Scanner(System.in);
        this.collectionService = collectionService;
        this.fillingService = new FillingService(collectionService, scanner);
        this.fileWriterService = new FileWriterService(collectionService);
    }

    // Подменю для выбора типа коллекции:
    // 1. Животное
    // 2. Бочка
    // 3. Человек
    public void showSelectCollectionTypeMenu() {
        System.out.println("\n=== ВЫБОР ТИПА КОЛЛЕКЦИИ ===");
        System.out.println("0. Выйти в главное меню");
        System.out.println("1. Животное");
        System.out.println("2. Бочка");
        System.out.println("3. Человек");
        System.out.print("Выберите тип: ");

        int choice = ConsoleUtil.userIntInput(0,3);

        switch (choice) {
            case 1 -> collectionService.setCollectionType("Животное");
            case 2 -> collectionService.setCollectionType("Бочка");
            case 3 -> collectionService.setCollectionType("Человек");
            case 0 -> {
                return;
            }
        }
        System.out.println("Тип коллекции установлен: " + collectionService.getCollectionType());
    }

    // Подменю для выбора способа заполнения коллекции
    // 1. Вручную
    // 2. Из файла
    // 3. Рандомно
    public void showInputMenu() {
        if (collectionService.getCollectionType().equals("Не выбрана")) {
            System.out.println("Сначала выберите тип коллекции!");
            return;
        }

        System.out.println("\n=== ВВОД ДАННЫХ ===");
        System.out.println("0. Выйти в главное меню");
        System.out.println("1. Вручную");
        System.out.println("2. Из файла");
        System.out.println("3. Случайные значения");
        System.out.print("Выберите способ: ");

        int choice = ConsoleUtil.userIntInput(0, 3);
        String fillingType;
        switch (choice) {
            case 1 -> fillingType = "Manual";
            case 2 -> fillingType = "File";
            case 3 -> fillingType = "Random";
            case 0 -> {
                return;
            }
            default -> throw new IllegalStateException("Неверный выбор: " + choice);
        };
        fillingService.setFillingType(fillingType);

        fillingService.initCollection();
    }

    // Подменю для записи отсортированной коллекции или найденного бинарным поиском значения
    // в файл
    public void showFileWriterMenu() {
        System.out.println("\n=== ЗАПИСЬ В ФАЙЛ ===");
        System.out.println("0. Выйти в главное меню");
        System.out.println("1. Очистка файла");
        System.out.println("2. Записать в файл отсортированную коллекцию");
        System.out.println("3. Записать в файл найденное бинарным поиском значение коллекции");
        System.out.print("Выберите пункт меню: ");

        int choice = ConsoleUtil.userIntInput(0, 3);

        switch (choice) {
            case 1 -> fileWriterService.clearFile();
            case 2 -> fileWriterService.saveSortedCollectionToFile();
            case 3 -> fileWriterService.saveSearchResultToFile();
            case 0 -> {
                return;
            }
        }
    }
}
