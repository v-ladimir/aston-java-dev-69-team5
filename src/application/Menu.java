package application;

import application.services.*;
import fillingStrategies.manual.ConsoleUtil;

public class Menu {
    private final CollectionService collectionService;
    private final OutputService outputService;
    private final SortService sortService;
    private final SearchService searchService;
    private final SubMenuService subMenuService;

    public Menu() {
        this.collectionService = new CollectionService();
        this.outputService = new OutputService(collectionService);
        this.sortService = new SortService(collectionService, outputService);
        this.searchService = new SearchService(collectionService);
        this.subMenuService = new SubMenuService(collectionService);
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
            System.out.println("6. Запись в файл");
            System.out.println("7. Выход");
            System.out.print("Выберите пункт: ");

            int choice = ConsoleUtil.userIntInput(1, 7);

            switch (choice) {
                case 1 -> subMenuService.showSelectCollectionTypeMenu();
                case 2 -> subMenuService.showInputMenu();
                case 3 -> outputService.showCollection();
                case 4 -> sortService.sortCollection();
                case 5 -> searchService.searchInCollection();
                case 6 -> subMenuService.showFileWriterMenu();
                case 7 -> {
                    System.out.println("До свидания!");
                    return;
                }
            }
        }
    }
}